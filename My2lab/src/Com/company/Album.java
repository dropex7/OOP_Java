package Com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Album {
    public String NameOfAlbum;
    public ArrayList<Genre> genres = new ArrayList<>();
    Scanner sca = new Scanner(System.in);

    Album(String name)
    {
        NameOfAlbum = name;
    }

    public void writeGen()
    {
        String tempGen = "";
        System.out.println("Write album genre for find");
        tempGen = sca.next();
        Genre gen = new Genre(tempGen);
        gen.addMusics();
        genres.add(gen);
    }

    public void findMusicFromArtist() {
        for (int i = 0; i < genres.size(); i++) {
            genres.get(i).findMusicFromArtist();
        }
    }
    public void findMusic() {
        for (int i = 0; i < genres.size(); i++) {
            genres.get(i).findMusic();
        }
    }
    public void findMusicFromGenre() {
        System.out.println("Write album genre for find music");
        String name = sca.next();
        for (int i = 0; i < genres.size(); i++) {
            if (genres.get(i).NameOfGenre.equals(name))
            {
                genres.get(i).findMusicFromArtist();
            }
        }
    }
}
