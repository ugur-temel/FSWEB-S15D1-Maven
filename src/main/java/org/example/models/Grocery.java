package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();
    public static void startGrocery(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running){
            System.out.println("0-STOP, 1-ADD ELEMENT, 2-REMOVE ELEMENT");
            String input = scanner.nextLine();
            int choice = Integer.parseInt(input);
            if(choice == 0){
                running = false;
            } else if (choice == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String itemsToAdd = scanner.nextLine();
                addItems(itemsToAdd);
            } else if (choice == 2) {
                System.out.println("Cıkarılmasını istediginiz elemanları giriniz.");
                String itemsToRemove = scanner.nextLine();
                removeItems(itemsToRemove);
            }
            printSorted();
        }
        scanner.close();
    }
    public static void addItems(String input){
        String[] items = input.split(",");
        for(String item: items){
            String trimmed = item.trim().toLowerCase();
            if(!checkItems(trimmed)){
                groceryList.add(trimmed);
            }else {
                System.out.println(trimmed + ": Zaten mevcut.");
            }
        }
        Collections.sort(groceryList);
    }
    public static void removeItems(String input){
        String[] items = input.split(",");
        for(String item: items){
            String trimmed = item.trim().toLowerCase();
            if(checkItems(trimmed)){
                groceryList.remove(trimmed);
            }else {
                System.out.println(trimmed + ": Bulunamadı.");
            }
        }
        Collections.sort(groceryList);
    }
    public static boolean checkItems(String product){
        return groceryList.contains(product.toLowerCase());
    }
    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}
