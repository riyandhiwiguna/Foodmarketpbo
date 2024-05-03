package FoodMarket;

import java.util.Scanner;

import java.util.InputMismatchException;

public class Order {


    private static boolean isLoggedIn;

    public static int MenuOrder(Scanner scanner){
        System.out.println("======== MENU ORDER ========");
        System.out.println("| 1. Lihat FoodMarket       ");
        System.out.println("| 2. Logout                 ");
        System.out.println("============================");
        System.out.print("Masukkan Pilihan yang Anda Inginkan ");
        int menuOrder = scanner.nextInt();
        switch (menuOrder){
            case 1:
                Admin.viewMenu();
                break;
            case 2:
                isLoggedIn = false;
                break;
        }
        int choice;
        try {
            choice = Admin.scanner.nextInt();
            Admin.scanner.nextLine();
        } catch (InputMismatchException var3) {
            System.out.println("Pilihan harus berupa angka!");
            System.out.println("=================================================");
            choice = MenuOrder(Admin.scanner);

        }

        return choice;
    }

}