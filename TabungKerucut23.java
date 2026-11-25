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

        System.out.print("Masukkan jari-jari: ");
        double r = input.nextDouble();
        System.out.print("Masukkan tinggi: ");
        double t = input.nextDouble();

        System.out.printf("Luas lingkaran       : %.2f%n", luasLingkaran(r));
        System.out.printf("Volume tabung        : %.2f%n", volumeTabung(r, t));
        System.out.printf("Luas permukaan tabung: %.2f%n", luasPermukaanTabung(r, t));
        System.out.printf("Volume kerucut       : %.2f%n", volumeKerucut(r, t));

        input.close();
    }
}
