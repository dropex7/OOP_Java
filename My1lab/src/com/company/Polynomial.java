package com.company;

public class Polynomial extends SetOfFraction {

    public void sum(SetOfFraction f1, SetOfFraction f2)
    {
        boolean flag = true;
        int cell1, cell2 = 0;
        int max = f1.M.size() > f2.M.size() ? f1.M.size() : f2.M.size();
        int min = f1.M.size() < f2.M.size() ? f1.M.size() : f2.M.size();
        if (f1.M.size() > f2.M.size())
        {
            flag = false;
        }
        for (int i = 0; i < min; i++)
        {
            if (f1.M.get(i).getN() == f2.M.get(i).getN())
            {
                cell2 = f1.M.get(i).getM() + f2.M.get(i).getM();
            }
            else
            {
                cell1 = f1.M.get(i).getM() * f2.M.get(i).getN() + f1.M.get(i).getN() * f2.M.get(i).getM();
                cell2 = f1.M.get(i).getN() * f2.M.get(i).getN();
                f1.M.get(i).setM(cell1);
                f1.M.get(i).setN(cell2);
            }
        }
        if (flag)
        {
            for (int j = min; j < max; j++)
            {
                f1.M.add(j, new Fraction(f2.M.get(j).getM(), f2.M.get(j).getN()));
            }
        }


    }
    public void print(SetOfFraction f1)
    {
        for (int i = 0;i < f1.M.size();i++)
        {
            System.out.print(f1.M.get(i).Value() + " ");
        }
        System.out.println();
    }
}
