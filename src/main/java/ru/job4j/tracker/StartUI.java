package ru.job4j.tracker;


import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter itemName: ");
                String itemName = scanner.nextLine();
                Item newItem = new Item(itemName);
                tracker.add(newItem);
                System.out.println("Item is added: " + newItem);

            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] allItems = tracker.findAll();
                if (allItems.length == 0) {
                    System.out.println("Items list is empty.");
                } else {
                    for (Item itm : allItems) {
                        System.out.println(itm);
                    }
                }

            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.findById(id) != null) {
                    System.out.print("Enter name: ");
                    String newName = String.valueOf(scanner.nextLine());
                    Item newItem = new Item(id, newName);
                    tracker.replace(id, newItem);
                    System.out.println("The item was edited successfully.");
                } else {
                    System.out.println("Item with this id not detected");
                }

            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter id: ");
                int id1 = Integer.parseInt(scanner.nextLine());
                if (tracker.findById(id1) != null) {
                    tracker.delete(id1);
                    System.out.println("The item was deleted successfully.");
                } else {
                    System.out.println("Item with this id not detected");
                }

            } else if (select == 4) {
                System.out.println("=== Find item by id ====");
                System.out.print("Enter id: ");
                int id1 = Integer.parseInt(scanner.nextLine());
                if (tracker.findById(id1) != null) {
                    Item found = tracker.findById(id1);
                    System.out.println(found);
                } else {
                    System.out.println("Item with this id is not detected");
                }
            } else if (select == 5) {
                System.out.println("=== Find item by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] found =  tracker.findByName(name);
                if (found.length > 0) {
                    for (Item itm : found) {
                        System.out.println("Item was found. Item id: " + itm.getId()
                                + ", Item name is: "  + itm.getName());
                    }

                } else {
                    System.out.println("Item with this name is not found");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu:" + "\n" + "0. Add new Item" + "\n" + "1. Show all items" + "\n"
        + "2. Edit item" + "\n" + "3. Delete item" + "\n" + "4. Find item by Id" + "\n"
        + "5. Find items by name" + "\n" + "6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
