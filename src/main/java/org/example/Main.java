package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Pokupately {
    private final String fullName;
    private final String email;
    private final String phoneNumber;
    private final String[] productPosition;
    private final int quantity;
    public Pokupately(String fullName, String email, String phoneNumber, String[] productPosition, int quantity) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.productPosition = productPosition;
        this.quantity = quantity;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String[] getProductPosition() {
        return productPosition;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] watchBrands = {"Apple", "Smart Watch", "Casio"};
        String[][] products = {
                {"Model A", "Apple"},
                {"Model B", "Smart Watch"},
                {"Model C", "Casio"},
        };


        ArrayList<Pokupately> Pokupateles = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите данные покупателя " + (i + 1) + ":");
            System.out.print("ФИО: ");
            String fullName = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Номер телефона: ");
            String phoneNumber = scanner.nextLine();

            System.out.println("Список имеющихся позиций в магазине:");
            for (String[] product : products) {
                System.out.println(product[0] + " - " + product[1]);
            }

            System.out.print("Введите позицию товара: ");
            String product = scanner.nextLine();

            int quantity;
            do {
                System.out.print("Введите количество: ");
                quantity = scanner.nextInt();
            } while (quantity <= 0);

            scanner.nextLine(); // Очистка буфера после nextInt()

            String[] productPosition = getProductPosition(products, product);

            Pokupately pokupately = new Pokupately(fullName, email, phoneNumber, productPosition, quantity);
            Pokupateles.add(pokupately);
        }

        System.out.println("Информация о заказах:");

        for (Pokupately customer : Pokupateles) {
            System.out.println("Покупатель: " + customer.getFullName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Номер телефона: " + customer.getPhoneNumber());
            System.out.println("Товар: " + customer.getProductPosition()[0]);
            System.out.println("Фирма: " + customer.getProductPosition()[1]);
            System.out.println("Количество: " + customer.getQuantity());
            System.out.println();
        }
    }

    private static String[] getProductPosition(String[][] products, String productName) {
        for (String[] product : products) {
            if (product[0].equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
