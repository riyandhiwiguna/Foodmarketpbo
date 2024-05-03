package FoodMarket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {
    private static ArrayList<FoodMarket_market> foodMarkets = new ArrayList<>(); // Use plural for markets
    public static ArrayList<Menu> menus = new ArrayList<>();

    public static Scanner scanner = new Scanner(System.in);


    // Add food market
    public static void addFoodMarket() {
        System.out.print("Masukan Id Food Market: ");
        int id = scanner.nextInt();

        System.out.print("Masukan Nama Food Market: ");
        String nama = scanner.next();

        System.out.print("Masukan Alamat Food Market: ");
        String alamat = scanner.next();

        FoodMarket_market foodMarket = new FoodMarket_market(id, nama, alamat);
        foodMarkets.add(foodMarket);  // Use 'foodMarkets'

        int Ulang = 0;
        do {
            System.out.println("========================================");
            System.out.println("Food Market: " + foodMarket.getNama());

            System.out.println("Tambahkan menu: ");
            System.out.println("1. Makanan");
            System.out.println("2. Minuman");
            System.out.print("Pilih opsi: ");
            int input = scanner.nextInt();

            System.out.print("Masukan nama menu: ");
            String namaMenu = scanner.next();

            System.out.print("Masukan harga menu: ");
            double hargaMenu;
            try {
                hargaMenu = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Harga harus berupa angka!");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            Menu menu = new Menu(id, namaMenu, hargaMenu);
            switch (input) {
                case 1:
                    menus.add(menu);
                    break;
                case 2:
                    menus.add(menu);
                    break;
                default:
                    System.out.println("Opsi tidak valid!");
            }

            System.out.print("Ingin menambah menu lagi? (y/n): ");
            String yn = scanner.next().toLowerCase();  // Case-insensitive input
            Ulang = (yn.equals("y")) ? 1 : 0;
        } while (Ulang == 1);
    }

    // View food market
    public static void viewFoodMarket() {
        if (foodMarkets.size() > 0) {
            for (int i = 0; i < foodMarkets.size(); i++) {
                System.out.println((i + 1) + ". " + foodMarkets.get(i).toString());
            }
        } else {
            System.out.println("Data Food Market belum ada!");
        }
    }

    public static void removeFoodMarket() {
        System.out.print("Masukan nomor id restaurant : ");
        int idFoodMarket = scanner.nextInt();

        if (idFoodMarket > 0 && idFoodMarket <= foodMarkets.size()) {
            foodMarkets.remove(idFoodMarket - 1);
            System.out.println("Restaurant terhapus!");
        } else {
            System.out.println("Id restaurant tidak ditemukan!");
        }
    }

    public static void viewMenu() {
        boolean finished = false;
        viewFoodMarket();
        System.out.print("Masukan Food Market yang diinginkan: ");
        int pilih = 0;
        try {
            pilih = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Pilihan harus berupa angka!");
            scanner.nextLine(); // Clear invalid input
            finished = true;
        }
        if (!finished) {
            if (foodMarkets.size() > 0) {
                for (FoodMarket_market foodMarket : foodMarkets) {
                    int res = foodMarket.getId();
                    if (menus.size() > 0) {
                        for (int i = 0; i < menus.size(); i++) {
                            int men = menus.get(i).getId();
                            if (pilih == res && res == men) {
                                System.out.println((i + 1) + ". " + menus.get(i).toString());
                            }
                        }
                    }
                }
            }
        }

    }
}