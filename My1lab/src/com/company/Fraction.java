package com.company;

public class Fraction {
    private int M;
    private int N;

    public Fraction(int m, int n) {
        this.M = m;
        this.N = n;
    }

    public int getM() {
        return M;
    }

    public int getN() {
        return N;
    }

    public void setM(int m) {
        this.M = m;
    }

    public void setN(int n) {
        this.N = n;
    }

    public double Value() {
        return ((double) M / N);
    }


}
