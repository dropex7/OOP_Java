package Com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Catalog k = new Catalog("Nova");
        boolean off = true;
        Scanner sc = new Scanner(System.in);
        while (off)
        {
            System.out.println("Select the desired item");
            System.out.println("1 - for add artist");
            System.out.println("2 - for find artist");
            System.out.println("3 - for find album");
            System.out.println("4 - for find music from artist");
            System.out.println("5 - for find music from album");
            System.out.println("6 - for find music from genre");
            System.out.println("7 - for find music");
            System.out.println("0 - for exit");
            int temp = sc.nextInt();
            switch (temp)
            {
                case 1:
                    k.AddArtist();
                    break;
                case 2:
                    k.FindArtists();
                    break;
                case 3:
                    k.FindAlbum();
                    break;
                case 4:
                    k.findMusicFromArtist();
                case 5:
                    k.findMusicFromAlbum();
                case 6:
                    k.findMusicFromGenre();
                case 7:
                    k.findMusic();
                default:
                    off = false;
                    break;
            }
        }
    }
}
