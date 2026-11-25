import java.util.Scanner;

public class TabungKerucut23 {
    static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }

    static double luasPermukaanTabung(double r, double t) {
        return 2 * luasLingkaran(r) + 2 * Math.PI * r * t;
    }

    static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Menu Perhitungan ===");
            System.out.println("1. Luas Lingkaran");
            System.out.println("2. Volume Tabung");
            System.out.println("3. Luas Permukaan Tabung");
            System.out.println("4. Volume Kerucut");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            double r, t;
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jari-jari: ");
                    r = input.nextDouble();
                    System.out.printf("Luas lingkaran: %.2f%n", luasLingkaran(r));
                    break;
                case 2:
                    System.out.print("Masukkan jari-jari: ");
                    r = input.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    t = input.nextDouble();
                    System.out.printf("Volume tabung: %.2f%n", volumeTabung(r, t));
                    break;
                case 3:
                    System.out.print("Masukkan jari-jari: ");
                    r = input.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    t = input.nextDouble();
                    System.out.printf("Luas permukaan tabung: %.2f%n", luasPermukaanTabung(r, t));
                    break;
                case 4:
                    System.out.print("Masukkan jari-jari: ");
                    r = input.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    t = input.nextDouble();
                    System.out.printf("Volume kerucut: %.2f%n", volumeKerucut(r, t));
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        input.close();
    }
}
