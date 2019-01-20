package Com.company;



public class Music {
    public String NameOfMusic;
    public int[] ReleaseDate = new int[2];
    public String subgenre = "";

    Music(int month, int year, String n, String s)
    {
        NameOfMusic = n;
        ReleaseDate[0] = month;
        ReleaseDate[1] = year;
        subgenre = s;
    }

    public int getYear()
    {
        return ReleaseDate[3];
    }

    public String getNameOfMusic()
    {
        return NameOfMusic;
    }

}
