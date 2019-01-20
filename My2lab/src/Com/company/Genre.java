package Com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Genre {
    String NameOfGenre;
    Scanner sca = new Scanner(System.in);
    private boolean flag3 = true;
    private boolean flagforwhile = true;

    public ArrayList<Music> tracks = new ArrayList<>();
    Genre(String k)
    {
        NameOfGenre = k;
    }
    Compilation current = new Compilation("Stars");

    public void addMusics() {

        while (flag3) {
            System.out.println("Write 1, if you have any music");
            if (sca.nextInt() != 1) {
                flag3 = false;
                break;
            }
            System.out.println("Write month, when music create");
            int tempMonth = 0;
            boolean flagforwhile = true;
            while (flagforwhile) {
                tempMonth = sca.nextInt();
                if (tempMonth < 0 || tempMonth > 12) {
                    System.out.println("Write correct month!");
                } else {
                    flagforwhile = false;
                }
            }
            String tempsub = "";
            flagforwhile = true;
            System.out.println("Write year, when music create");
            int tempYear = 0;
            while (flagforwhile) {
                tempYear = sca.nextInt();
                if (tempYear < 1900 || tempYear > 2018) {
                    System.out.println("Write correct year!");
                } else {
                    flagforwhile = false;
                }
            }
            System.out.println("Write name of music");
            String tempMusic = sca.next();
            System.out.println("Write 1, if you have any subgeneres");
            if (sca.nextInt() == 1)
            {
                tempsub = sca.next();
            }
            Music tempMus = new Music(tempMonth, tempYear, tempMusic, tempsub);
            tracks.add(tempMus);
            System.out.println("Write 1, if you want to add this music in compilation");
            if (sca.nextInt() == 1)
            {
                current.addMusInPack(tempMus);
            }
        }
    }

    public void findMusicFromArtist() {
        for (int i = 0; i < tracks.size(); i++)
        {
            System.out.println(tracks.get(i).getNameOfMusic());
        }
    }

    public void findMusic()
    {
        System.out.println("write year for find music");
        int yearForFind = sca.nextInt();
        for (int i = 0; i < tracks.size(); i++)
        {
            if (tracks.get(i).getYear() == yearForFind) {
                System.out.println(tracks.get(i).getNameOfMusic());
            }


        }
    }
}
