import java.util.Scanner;

public class BankSampah23 {

    static Scanner input = new Scanner(System.in);

    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah " + (i + 1) + " (kg): ");
            setoran[i] = input.nextDouble();
        }
        return setoran;
    }

    static void tampilSetoran(double[] setoran) {
        System.out.println("Daftar setoran:");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah " + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (int i = 0; i < setoran.length; i++) {
            total += setoran[i];
        }
        return total;
    }

    static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    static int nasabahTerbanyak(double[] setoran) {
        int indeksMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeksMax]) {
                indeksMax = i;
            }
        }
        return indeksMax;
    }

    public static void main(String[] args) {
        double hargaPerKg = 3000;

        System.out.print("Masukkan jumlah nasabah: ");
        int n = input.nextInt();
        System.out.println();

        double[] setoran = inputSetoran(n);

        System.out.println();
        tampilSetoran(setoran);

        System.out.println();
        System.out.println("Saldo tiap nasabah (Rp" + String.format("%.0f", hargaPerKg) + " per kg):");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], hargaPerKg);
            System.out.println("Nasabah " + (i + 1) + ": Rp" + String.format("%.2f", saldo));
        }

        System.out.println();
        System.out.println("Total setoran seluruh nasabah: " + totalSetoran(setoran) + " kg");

        int terbanyak = nasabahTerbanyak(setoran);
        System.out.println("Nasabah dengan setoran terbanyak: Nasabah " + (terbanyak + 1)
                + " (" + setoran[terbanyak] + " kg)");

        input.close();
    }
}