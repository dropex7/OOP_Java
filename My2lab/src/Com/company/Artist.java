package Com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Artist {
    public String NameOfArtist;
    public String Nickname;
    public ArrayList<Album> albums = new ArrayList<>();
    public boolean flag2 = true;
    public static boolean flagForFind = false;
    Scanner sc = new Scanner(System.in);

    Artist(String n, String nick)
    {
        NameOfArtist = n;
        Nickname = nick;
    }



    public void funcWithAlbum()
    {
        String TempNameAl = "";
        while(flag2)
        {
            System.out.println("Enter 1, if you add album");
            if(sc.nextInt() != 1)
            {
                flag2 = false;
                break;
            }
            System.out.println("Write name of album for adding");
            TempNameAl = sc.next();
            Album tempAl = new Album(TempNameAl);
            tempAl.writeGen();
            albums.add(tempAl);
        }
    }

    public void findAlbum(String nameA)
        {
            for(int i = 0;i < albums.size();i++)
            {
                if (nameA.equals(albums.get(i).NameOfAlbum))
                {
                    flagForFind = true;
                    break;
                }
                else
                {
                    flagForFind = false;
                }
            }
    }
    public void findMusicFromAlbum()
    {
        System.out.println("Write name album");
        String name = sc.next();
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).NameOfAlbum.equals(name))
            albums.get(i).findMusicFromArtist();
        }

    }

    public void findMusicFromArtist() {
        for (int i = 0; i < albums.size(); i++) {
            albums.get(i).findMusicFromArtist();
        }
    }

    public void findMusicFromGenre() {
        for (int i = 0; i < albums.size(); i++) {
            albums.get(i).findMusicFromGenre();
        }
    }

    public void findMusic() {
        for (int i = 0; i < albums.size(); i++) {
            albums.get(i).findMusic();
        }
    }

    public boolean getFlag()
    {
        return flagForFind;
    }
}
