package viceCity.core.interfaces;

import viceCity.common.ConstantMessages;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.List;

public class ControllerImp implements Controller {
    private MainPlayer mainPlayer;
    private List<CivilPlayer> listPlayers;
    private List<Gun> listGuns;

    public ControllerImp() {
        mainPlayer = new MainPlayer();
        listPlayers = new ArrayList<>();
        listGuns = new ArrayList<>();
    }

    @Override
    public String addPlayer(String name) {
        CivilPlayer civilPlayer = new CivilPlayer(name);
        listPlayers.add(civilPlayer);
        String str = String.format(ConstantMessages.PLAYER_ADDED, name);
        return str;
    }

    @Override
    public String addGun(String type, String name) {
        if (type.equals("Pistol")) {
            Pistol pistol = new Pistol(name);
            listGuns.add(pistol);
        } else if (type.equals("Rifle")) {
            Rifle rifle = new Rifle(name);
            listGuns.add(rifle);
        } else {
            return ConstantMessages.GUN_TYPE_INVALID;
        }
        String str = String.format(ConstantMessages.GUN_ADDED, name, type);
        return str;
    }

    @Override
    public String addGunToPlayer(String name) {
        int index=-1;
        if (listGuns.size() <= 0) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(listGuns.get(0));
            String str = String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, listGuns.get(0).getName(), "Tommy Vercetti");
            listGuns.remove(0);
            return str;
        }
        boolean bol = false;
        for (Player player : listPlayers) {
            if (player.getName().equals(name)) {
                bol = true;
                index=listPlayers.indexOf(player);
            }
        }
        if (!bol) {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        if (bol) {
            listPlayers.get(index).getGunRepository().add(listGuns.get(0));
            String str = String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, listGuns.get(0).getName(), name);
            listGuns.remove(0);
            return str;
        }
        return null;
    }

    @Override
    public String fight() {
        int civil = listPlayers.size();
        GangNeighbourhood gangNeighbourhood = new GangNeighbourhood();
        gangNeighbourhood.action(mainPlayer, (List) listPlayers);
        boolean bol = true;
        if (mainPlayer.getLifePoints() == 100) {
            if (civil > listPlayers.size()) {
                bol = false;
            }
            for (CivilPlayer player : listPlayers) {
                if (player.getLifePoints() != 50) {
                    bol = false;
                }
            }
        } else if (civil > listPlayers.size()) {
            bol = false;
        } else {
            bol = false;
        }
        if (bol) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ConstantMessages.FIGHT_HAPPENED).append(System.lineSeparator());
            stringBuilder.append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append(System.lineSeparator());
            stringBuilder.append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, civil - listPlayers.size())).append(System.lineSeparator());
            stringBuilder.append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, listPlayers.size()));
            return stringBuilder.toString();
        }
    }
}
