package com.company;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class WorkingWithFile {
    HashMap<String, HashMap<String, Object>> sectionMap = new HashMap<>();

    //Проверка на существование файла
    public void readFile(String fileName) throws Exception {
        boolean isFirstSection = true;
        HashMap<String, Object> paramMap = new HashMap<>();
        String section = null;
        try {
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (str.indexOf(';') != -1) {
                    str = str.substring(0, str.indexOf(';'));
                }
                str = str.trim();
                if (str.isEmpty()) {
                    continue;
                }
                if (isNameSection(str)){
                    if(isFirstSection){
                        section = getNameSection(str);
                        isFirstSection = false;
                    }
                    else{
                        sectionMap.put(section, paramMap);
                        section = getNameSection(str);
                        paramMap = new HashMap<>();
                    }
                    continue;
                }
                String[] args = str.split("=");
                if (args.length != 2) {
                    throw new ValidationException();
                }
                //проверка на отсустсвие сторонних символов в arg[0]
                Object param;
                args[0] = args[0].trim();
                args[1] = args[1].trim();
                if (args[1].matches("[-+]?\\d+")){
                    param = Integer.parseInt(args[1]);
                    paramMap.put(args[0], param);
                    continue;
                }
                if (args[1].matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
                    param = Double.parseDouble(args[1]);
                    paramMap.put(args[0], param);
                    continue;
                }
                paramMap.put(args[0], args[1]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public boolean isNameSection(String str) {
        if (str.charAt(0)=='[' && str.charAt(str.length()-1)==']'){
            //проверить на отсутсвие сторонних символов
            //str.matches()
            return true;
        }
        return false;
    }

    public String getNameSection(String str){
        return str.substring(1, str.length()-1);
    }

    public Object getParam(String sectionName, String paramName) throws NoParamException {
        if (!sectionMap.containsKey(sectionName)) {
            throw new NoParamException();
        }
        Map<String, Object> paramMap = sectionMap.get(sectionName);
        if (!paramMap.containsKey(paramName)) {
            throw new NoParamException();
        }
        return paramMap.get(paramName);
    }
}

