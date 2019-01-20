package Com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {
    public String NameOfCatalog;
    Catalog(String k)
    {
        NameOfCatalog = k;
    }
    Scanner scan = new Scanner(System.in);
    public ArrayList<Artist> Catalog = new ArrayList<>();
    boolean flag = true;
    String TempNickname = "";
    String TempName = "";

    public void AddArtist()
    {
        while(flag)
        {
            System.out.println("Write nick");
            TempNickname = scan.next();
            System.out.println("Write name");
            TempName = scan.next();
            Artist temp = new Artist(TempName, TempNickname);
            Catalog.add(temp);
            temp.funcWithAlbum();
            System.out.println("Enter 1, if you have any artist");
            if(scan.nextInt() != 1)
            {
                flag = false;
                break;
            }
        }
    }

    public void FindArtists()
    {
        System.out.println("Write name or nick of artist");
            String tempFind = scan.next();
            boolean flagForFindArt = false;
        for(int i = 0;i < Catalog.size();i++) {
            if (tempFind.equals(Catalog.get(i).NameOfArtist)|| tempFind.equals(Catalog.get(i).Nickname)) {
                flagForFindArt = true;
                break;
            }
        }
        if (flagForFindArt)
        {
            System.out.println("Yes, this artist is on the list");
        }
        else {
            System.out.println("Sorry, but your artist is not listed");
        }

    }

    public void FindAlbum()
    {
        boolean flagForFindAl = false;
        System.out.println("Write name of album for find");
        String tempNameAlb = scan.next();
        for(int i = 0;i < Catalog.size();i++) {
            Catalog.get(i).findAlbum(tempNameAlb);
            if (Catalog.get(i).getFlag()) {
                flagForFindAl = true;
                break;
            }
        }
        if (flagForFindAl)
        {
            System.out.println("Your album is found");
        }
        else
        {
            System.out.println("Your album is not found");
        }
    }

    public void findMusicFromArtist()
    {
        System.out.println("Write name artist for find");
        String name = scan.next();
        for (int j = 0;j < Catalog.size();j++)
        {
            if (Catalog.get(j).NameOfArtist.equals(name))
            {
                Catalog.get(j).findMusicFromArtist();
            }
        }
    }

    public void findMusicFromAlbum()
    {
        for (int j = 0;j < Catalog.size();j++)
        {
            Catalog.get(j).findMusicFromAlbum();
        }
    }

    public void findMusicFromGenre()
    {
        for (int j = 0;j < Catalog.size();j++)
        {
            Catalog.get(j).findMusicFromGenre();
        }
    }

    public void findMusic()
    {
        for (int j = 0;j < Catalog.size();j++)
        {
            Catalog.get(j).findMusic();
        }
    }
}
