package Com.company;

import java.util.ArrayList;

public class Compilation {
    public String nameofComp;
    public ArrayList<Music> packOfMusic = new ArrayList<>();

    Compilation(String k)
    {
        nameofComp = k;
    }

    public void addMusInPack(Music k)
    {
        packOfMusic.add(k);
    }

    public void allInComp()
    {
        for (int i = 0;i < packOfMusic.size();i++)
        {
            System.out.println(packOfMusic.get(i).NameOfMusic);
        }
    }
}
