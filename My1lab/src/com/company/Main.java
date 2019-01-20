package com.company;

import java.util.Set;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException
    {
        SetOfFraction t = new SetOfFraction();
        Polynomial l = new Polynomial();

        Fraction x = new Fraction(0,0);
        x.setM(4);
        x.setN(8);
        t.AddFraction(x);
        x.setM(10);
        x.setN(5);
        t.AddFraction(x);
        x.setM(6);
        x.setN(36);
        t.AddFraction(x);

        SetOfFraction k = new SetOfFraction();
        x.setM(3);
        x.setN(9);
        k.AddFraction(x);
        x.setM(5);
        x.setN(38);
        k.AddFraction(x);
        x.setM(7);
        x.setN(49);
        k.AddFraction(x);
        x.setM(14);
        x.setN(28);
        k.AddFraction(x);


        try
        {
            t.print();
            System.out.println(t.getMax());
            System.out.println(t.getMin());
            System.out.println(t.CountMaxFoo());
            System.out.println(t.CountMinFoo());
            k.print();
            System.out.println(k.getMax());
            System.out.println(k.getMin());
            System.out.println(k.CountMaxFoo());
            System.out.println(k.CountMinFoo());
            l.sum(t, k);
            l.print(t);
        }
        catch (Exception e) {
        }


    }


}
