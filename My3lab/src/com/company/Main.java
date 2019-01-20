package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("Lab3.ini");
        WorkingWithFile t=new WorkingWithFile();
        try {
            t.readFile("Lab3.ini");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(t.getParam("NCMD", "SampleRate"));
            System.out.println(t.getParam("COMMON", "DiskCachePath"));
        } catch (NoParamException e) {
            e.printStackTrace();
        }
    }
}
