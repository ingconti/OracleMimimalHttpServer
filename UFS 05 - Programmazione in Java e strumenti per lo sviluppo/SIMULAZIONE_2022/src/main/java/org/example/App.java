package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<City> cities = new ArrayList<City>();

    public static void main(String[] args) {
        System.out.println("Hello World!");
        buildProductList();
        buildCitiesList();
    }

    static void buildProductList() {
        products.add(new Product(36213,"Huawei Honor 8 BLACK",25.94, 6));
        products.add(new Product(36214,"Huawei Honor 8 RED",26.94, 1));
        products.add(new Product(36215,"Apple IPhone 13 RED",1226.94, 10));
        System.out.println(products);

        products.sort((o1, o2) -> {
            if (o1.getPrice()>o2.getPrice())
                return 1;
            if (o1.getPrice()<o2.getPrice())
                return -1;
            return 0;
        });
        System.out.println(products);

        Gson gson = new Gson();
        String jsonStr = gson.toJson(products);

    }

    static void buildCitiesList() {
        cities.add(new City(3,"Toronto",15.94));
        cities.add(new City(33,"Milan",25.94));
        cities.add(new City(55,"Rome",35.94));
        System.out.println(cities);

        cities.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.name);
        });

        System.out.println(cities);


        Gson gson = new Gson();
        String jsonStr = gson.toJson(cities);

    }
}
