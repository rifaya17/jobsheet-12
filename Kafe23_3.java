import java.util.Scanner;

public class Kafe23_3 {

    public static int hitungTotal(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};
        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }
    
    public static int hitungDiskon(int total, String kodePromo, boolean isMember) {
        int diskon = 0;

        if (kodePromo.equals("DISKON50")) {
            diskon = total * 50 / 100;
        } else if (kodePromo.equals("DISKON30")) {
            diskon = total * 30 / 100;
        } else {
            System.out.println("Kode promo invalid");
        }

        if (isMember) {
            diskon = diskon + (total * 10 / 100);
        }

        return diskon;
    }

    public static void Menu() {
        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp. 15,000");
        System.out.println("2. Cappuccino - Rp. 20,000");
        System.out.println("3. Latte - Rp. 22,000");
        System.out.println("4. Teh Tarik - Rp. 12,000");
        System.out.println("5. Roti Bakar - Rp. 10,000");
        System.out.println("6. Mie Goreng - Rp. 18,000");
        System.out.println("=============================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu();

        System.out.print("\nMasukkan nomor menu yang ingin anda pesan: ");
        int pilihanMenu = sc.nextInt();
        System.out.print("Masukkan jumlah item yang ingin dipesan: ");
        int banyakItem = sc.nextInt();
        System.out.print("Masukkan kode promo: ");
        String kodePromo = sc.next();
        System.out.print("Apakah member? (y/n): ");
        String jawab = sc.next();
        boolean isMember = jawab.equalsIgnoreCase("y");

        int total = hitungTotal(pilihanMenu, banyakItem);
        int diskon = hitungDiskon(total, kodePromo, isMember);
        int totalBayar = total - diskon;

        System.out.println();
        System.out.println("Total harga      : Rp. " + total);
        System.out.println("Besar diskon     : Rp. " + diskon);
        System.out.println("Total yang dibayar: Rp. " + totalBayar);

        sc.close();
    }
}