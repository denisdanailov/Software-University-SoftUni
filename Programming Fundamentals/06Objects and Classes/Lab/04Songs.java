package ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {

   static class Song {
     String typeList;
     String name;
     String time;

    String getName() {
         return name;
     }
     String getTypeList() {
        return typeList;
     }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         
        int n = Integer.parseInt(scan.nextLine());

        List<Song> mp3 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();

            String[] tokens = input.split("_");

            Song newSong = new Song();

            newSong.typeList = tokens[0];
            newSong.name = tokens[1];
            newSong.time = tokens[2];

            mp3.add(newSong);
        }

        String listType = scan.nextLine();

        if (listType.equals("all")) {
            for (Song newSong:
                 mp3) {
                System.out.println(newSong.getName());
            }
        } else {
            for (Song newSong:
                    mp3) {
                if (listType.equals(newSong.getTypeList())) {
                    System.out.println(newSong.getName());
                }
            }
        }

    }
}
