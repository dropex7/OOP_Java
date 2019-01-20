package pack;

import java.util.ArrayList;
import java.util.Scanner;

class Service {
    private Idao idao;
    Service(Idao dao) {
        this.idao = dao;
    }

    private static Scanner scanner = new Scanner(System.in);

    void CreateShop() {
        System.out.println("Введите ID магазина");
        int tempId = scanner.nextInt();
        System.out.println("Введите название магазина");
        String tempName = scanner.next();
        idao.CreateShop(tempId, tempName);
    }

    void CreateProduct() {
        System.out.println("Введите ID магазина");
        int tempId = scanner.nextInt();
        System.out.println("Введите название продукта");
        String tempName = scanner.next();
        System.out.println("Введите количество продукта");
        int tempQuan = scanner.nextInt();
        System.out.println("Введите цену продукта");
        int tempPrice = scanner.nextInt();
        idao.CreateProduct(tempId, tempName, tempQuan, tempPrice);
    }

    void AddPackProduct() {
        ArrayList<Product> myProd;
        System.out.println("Введите сколько видов продукта хотите завести");
        int count = scanner.nextInt();
        System.out.println("Введите ID магазина ");
        int tempId = scanner.nextInt();
        myProd = idao.AllProductsInShop(tempId);
        for (int i = 0; i < count; i++) {
            System.out.println("Введите название продукта ");
            String tempName = scanner.next();
            boolean now = false;
            for (Product aMyProd : myProd) {
                if (aMyProd.getName().equals(tempName)) {
                    now = true;
                }
            }

            if (now) {
                System.out.println("Введите количество продукта ");
                int tempQuan = scanner.nextInt();
                System.out.println("Введите цену продукта");
                int tempPrice = scanner.nextInt();
                idao.UpdateProduct(tempQuan, tempPrice);
            } else {
                System.out.println("Введите количество продукта ");
                int tempQuan = scanner.nextInt();
                System.out.println("Введите цену продукта");
                int tempPrice = scanner.nextInt();
                idao.CreateProduct(tempId, tempName, tempQuan, tempPrice);
            }
        }
    }

    void FindProfit()
    {
        System.out.println("Введите название товара");
        String findProd = scanner.next();
        System.out.println(idao.profitShop(findProd));
    }

    void WhatCanBuy()
    {
        ArrayList<Product> products;
        ArrayList<Product> basket = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        System.out.println("Введите ID магазина ");
        int tempId = scanner.nextInt();
        products = idao.AllProductsInShop(tempId);
        System.out.println("Сколько у вас денег?");
        int tempMoney = scanner.nextInt();
        for (int k = 0;k < products.size();k++)
        {
            counts.add(0);
        }
        while(tempMoney > products.get(0).getPrice())
        {
            for (int i = 0;i < products.size();i++)
            {
                if(tempMoney > products.get(i).getPrice())
                {
                    basket.add(products.get(i));
                    counts.set(i,(counts.get(i) + 1));
                    tempMoney -= products.get(i).getPrice();
                }
            }
        }
        System.out.println("Вы сможете купить : ");
        for (int j = 0;j < counts.size();j++)
        {
            System.out.print(basket.get(j).getName());
            System.out.println(" - " + counts.get(j));
        }
    }

    int BuyPackProducts()
    {
        int result = 0;
        System.out.println("Введите ID магазина ");
        int tempId = scanner.nextInt();
        ArrayList<Product> products = idao.AllProductsInShop(tempId);
        System.out.println("Введите количество продуктов");
        int tempCount = scanner.nextInt();
        if (tempCount <= products.size()) {
            for (int k = 0;k < tempCount;k++) {
                System.out.println("Введите название продукта");
                String tempName = scanner.next();
                System.out.println("Введите количество продукта");
                int tempQuan = scanner.nextInt();
                for (Product product : products) {
                    if (product.getName().equals(tempName) && tempQuan <= product.getQuantity()) {
                        result += product.getPrice() * tempQuan;
                    }
                }
                if (result == 0) {
                    System.out.println("Товара нет");
                    System.exit(-1);
                }
            }
            return result;
        }else
        {
            System.out.println("Нет на складе!");
            return 0;
        }
    }

    String BestShop()
    {
        ArrayList<Integer> sum = new ArrayList<>();
        ArrayList<Product> back = new ArrayList<>();
        ArrayList<Shop> shops;
        shops = idao.AllShops();
        for (Shop shop1 : shops) {
            int id = shop1.getID();
            shop1.products = idao.AllProductsInShop(id);
        }
        System.out.println("Введите сколько видов товаров");
        int Count = scanner.nextInt();
        for (int i = 0; i < Count ; i++){
            System.out.println("Введите название товара");
            String tempName = scanner.next();
            System.out.println("Введите количество");
            int tempQuantity = scanner.nextInt();
            back.add(new Product(tempQuantity, tempName));
        }
        int res = 0;
        int currentCount = 0;
        for (Shop shop : shops) {
            if (Count <= shop.products.size()) {
                for (Product aBack : back) {
                    for (int j = 0; j < shop.products.size(); j++)
                        if (shop.products.get(j).getName().equals(aBack.getName()) && aBack.getQuantity() <= shop.products.get(j).getQuantity()) {
                            res += shop.products.get(j).getPrice() * aBack.getQuantity();
                            currentCount += 1;
                            //System.out.println("C - " + res);
                        }
                }
            }
            if (currentCount == 2) {
                sum.add(res);
                res = 0;
                currentCount = 0;
            }else
            {
                sum.add(0);
            }
        }
        String result;
        int shopID = 0;
        int resSum = sum.get(0);
        for (int i = 0; i < (sum.size()); i++) {
            if (resSum < sum.get(i) && sum.get(i) != 0) {
                shopID = i;
                resSum = sum.get(i);
            }
        }
        result = shops.get(shopID).getName();
        return result;
    }
}
