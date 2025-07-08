import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Online Book Store\n-------------------");
        Inventory inventory = new Inventory();

        Book book1 = new PaperBook("111", "Data Structure", 2015,100 , 10);
        Book book2 = new PaperBook("222", "OOP", 1990,300,10);
        Book book3 = new EBook("333", "Machine Learning", 2022, 200, "PDF");
        Book book4 = new ShowCase("444", "Database", 2022, 300);
        inventory.addBook(book1);
        inventory.addBook(book2);
        inventory.addBook(book3);
        inventory.addBook(book4);
        System.out.println("------------------------------------------");

        inventory.removeOutdatedBooks(10);
        List<String> errors = new ArrayList<>();

        try {
            inventory.buyBook("111",1,"shahd@gmail.com", "5 street maadi");
        } catch (Exception e) {
            errors.add("Quantum book store: " + e.getMessage());
        }

        try {
            inventory.buyBook("222", 1, "ali@email.com", "5 street dokki");
        } catch (Exception e) {
            errors.add("Quantum book store: " + e.getMessage());
        }

        try {
            inventory.buyBook("333", 1, "mohammed@email.com");
        } catch (Exception e) {
            errors.add("Quantum book store: " + e.getMessage());
        }

        try {
            inventory.buyBook("444", 1, "jo@email.com");
        } catch (Exception e) {
            errors.add("Quantum book store: " + e.getMessage());
    }

        System.out.println("\nNotify:");
        for (String error : errors) {
            System.out.println(error);
        }
}}