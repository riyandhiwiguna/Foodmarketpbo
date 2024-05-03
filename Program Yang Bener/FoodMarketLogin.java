//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import FoodMarket.Admin;
import FoodMarket.Order;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodMarketLogin {
    String adminUsername = "admin";
    String adminPassword = "admin";
    String costumerUsername = "costumer";
    String costumerPassword = "costumer";

    public FoodMarketLogin() {
    }

    public void LoginFoodMarket() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            while(true) {
                System.out.println("=================================================");
                System.out.println("                    L O G I N                    ");
                System.out.print("Masukan username: ");
                String inputUsername = scanner.nextLine();
                System.out.print("Masukan password: ");
                String inputPassword = scanner.nextLine();
                System.out.println("=================================================");
                if (inputUsername.equals(this.adminUsername) && inputPassword.equals(this.adminPassword)) {
                    System.out.println("Selamat Datang, Admin");
                    Admin admin = new Admin();
                    new Order();
                    boolean adminLoop = true;

                    while(true) {
                        int choice = getAdminChoice(scanner);
                        switch (choice) {
                            case 1:
                                Admin.addFoodMarket();
                                break;
                            case 2:
                                Admin.viewFoodMarket();
                                break;
                            case 3:
                                Admin.removeFoodMarket();
                                break;
                            case 4:
                                adminLoop = false;
                                System.out.println("Anda telah keluar dari mode Admin.");
                                break;
                            default:
                                System.out.println("Opsi tidak valid!");
                        }

                        if (!adminLoop) {
                            break;
                        }
                    }
                }
                else if (inputUsername.equals(this.costumerUsername) && inputPassword.equals(this.costumerPassword)) {
                    System.out.println("Selamat Datang, Customer");
                    Order order = new Order();
                    Admin admin = new Admin();
                    boolean orderLoop = true;

                    Order.MenuOrder(scanner);

                    while (orderLoop) {
                        int choice = MenuOrder(scanner);
                        switch (choice) {
                            case 1:
                                admin.viewMenu();
                                break;
                            case 2:
                                System.out.println("Anda telah logout.");
                                orderLoop = false;
                                break;
                            default:
                                System.out.println("Pilihan tidak valid!");
                        }
                    }

                } else {
                    System.out.println("Login gagal, Silahkan coba lagi.");
                }
            }
        }
    }

    private static int getAdminChoice(Scanner scanner) {
        System.out.println("\nMenu Admin:");
        System.out.println("1. Tambah Food Market");
        System.out.println("2. Lihat Food Market");
        System.out.println("3. Hapus Food Market");
        System.out.println("4. Login Ulang");
        System.out.print("Pilih opsi: ");

        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException var3) {
            System.out.println("Pilihan harus berupa angka!");
            System.out.println("=================================================");
            choice = getAdminChoice(scanner);
        }

        return choice;
    }

    public static int MenuOrder(Scanner scanner){
        System.out.println("======== MENU ORDER ========");
        System.out.println("| 1. Lihat FoodMarket       ");
        System.out.println("| 2. Logout                 ");
        System.out.println("============================");

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