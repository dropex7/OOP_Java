package com.company;

import java.util.ArrayList;

public class SetOfFraction
{
    public ArrayList<Fraction> M;
    private Fraction MaxValue;
    private Fraction MinValue;
    private int CountMin;
    private int CountMax;

    public SetOfFraction()
    {
        M = new ArrayList<Fraction>();
    }

    public void AddFraction(Fraction n)
    {
        Fraction temp = new Fraction(0, 0);
        temp.setM(n.getM());
        temp.setN(n.getN());
        M.add(temp);
    }

    //максимальную дробь в наборе
    public double getMax() throws Exception
    {
        if(M.size()==0) throw new Exception();
        MaxValue = M.get(0);
        for(int i = 0; i < M.size(); i++)
        {
            if(MaxValue.Value() < M.get(i).Value())
                MaxValue = M.get(i);
        }
        return MaxValue.Value();
    }

    //минимальную дробь в наборе
    public double getMin() throws Exception
    {
        if(M.size()==0) throw new Exception();
        MinValue = M.get(0);
        for(int i = 0; i < M.size(); i++)
        {
            if(MinValue.Value() > M.get(i).Value())
                MinValue = M.get(i);
        }
        return MinValue.Value();
    }

    //количество дробей в наборе меньше заданной
    public int CountMinFoo() throws Exception
    {
        CountMin = 0;
        if (M.size() ==0) throw new Exception();
        for (int i = 0; i < M.size();i++)
        {
            if(M.get(i).Value() < M.get((M.size()- 1)).Value())
                CountMin += 1;
        }
        return CountMin;
    }


    //количество дробей в наборе больше заданной
    public int CountMaxFoo() throws Exception
    {
        CountMax = 0;
        if (M.size() == 0) throw new Exception();
        for (int i = 0; i < M.size();i++)
        {
            if(M.get(i).Value() > M.get((M.size()- 1)).Value())
                CountMax += 1;
        }
        return CountMax;
    }


    //Сложение дробей , также слежка за выходом из пределов массива


    public void print()
    {
        for (int i = 0;i < M.size();i++)
        {
            System.out.print(M.get(i).Value() + " ");
        }
        System.out.println();
    }

}


