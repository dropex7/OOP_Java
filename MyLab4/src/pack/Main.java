package pack;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Idao idao = new DAO();
        Service service = new Service(idao);
        System.out.print("Выберите действие \n");
        System.out.print("1) Создать магазин \n");
        System.out.print("2) Создать товар\n");
        System.out.print("3) Завезти партию товаров в магазин \n");
        System.out.print("4) Найти магазин, в котором товар самый дешевый \n");
        System.out.print("5) Выбор товаров для покупки в магазине \n");
        System.out.print("6) Купить партию товаров в магазине \n");
        System.out.print("7) Поиск самой выгодной покупки группы товаров \n");
        System.out.print("0) Выход\n");
        int insert = scanner.nextInt();
        switch (insert) {
                case 0: {
                    System.exit(7);
                }
                break;
                case 1: {
                    service.CreateShop();
                }
                break;
                case 2: {
                    service.CreateProduct();
                }
                break;
                case 3: {
                    service.AddPackProduct();
                }
                break;
                case 4: {
                    service.FindProfit();
                }
                break;
                case 5:
                {
                    service.WhatCanBuy();
                }
                break;
                case 6: {
                    System.out.println("Сумма покупки : " + service.BuyPackProducts());
                }
                break;
                case 7:
                {
                    System.out.println(service.BestShop());
                }
                break;
            }
    }
}







