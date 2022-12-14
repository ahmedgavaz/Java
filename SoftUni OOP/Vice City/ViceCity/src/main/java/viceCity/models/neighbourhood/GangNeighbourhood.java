package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;
import java.util.List;


public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        int killed =0;
        List list = List.of(mainPlayer.getGunRepository().getModels().toArray());
        List<Player> player = (List<Player>) civilPlayers;
        if (list.size()>0){
            for (int i = 0; i < list.size() && civilPlayers.size()>0; i++) {
                Gun gun = (Gun) list.get(i);
                while (gun.getTotalBullets()>0 || gun.getBulletsPerBarrel()>0){
                    if (killed<civilPlayers.size()){
                    ((List<Player>) civilPlayers).get(killed).takeLifePoints(gun.fire());
                    if (((List<Player>) civilPlayers).get(killed).getLifePoints()<=0){
                        killed++;
                    }}else{
                        break;
                    }
                }
                mainPlayer.getGunRepository().remove((Gun) list.get(0));
            }
        }
        for (int i = 0; i < killed; i++) {
            ((List<Player>) civilPlayers).remove(0);
        }
        if (civilPlayers.size()>0){
            for (int i = 0; i < civilPlayers.size() && mainPlayer.getLifePoints()>0; i++) {
                Player player1= ((List<Player>) civilPlayers).get(i);
                List guns = List.of(player1.getGunRepository().getModels().toArray());
                for (int j = 0; j < player.get(i).getGunRepository().getModels().size(); j++) {
                    Gun gun = (Gun) guns.get(j);
                    while (gun.getTotalBullets()>0 || gun.getBulletsPerBarrel()>0){
                        mainPlayer.takeLifePoints(gun.fire());
                        if (mainPlayer.getLifePoints()<=0){
                            return;
                        }
                    }
                    ((List<Player>) civilPlayers).get(i).getGunRepository().remove(gun);
                    i--;
                }
            }
        }
    }
}
