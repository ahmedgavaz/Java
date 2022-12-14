import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    public static class Song {
        String typeList;
        String name;
        String time;

        /*public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }*/

        public void setName(String name) {
            this.name = name;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Song> listSongs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] song = scanner.nextLine().split("_");
            String types = song[0];
            String names = song[1];
            String times = song[2];
            Song objSong = new Song();
            objSong.setName(names);
            objSong.setTime(times);
            objSong.setTypeList(types);
            listSongs.add(objSong);
        }
        String sort = scanner.nextLine();
        for (Song name : listSongs) {
            if (sort.equals("all")) {
                System.out.println(name.getName());
            } else if (name.getTypeList().equals(sort)) {
                System.out.println(name.getName());
            }
        }
    }
}
