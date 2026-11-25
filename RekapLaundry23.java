import java.util.Scanner;

public class RekapLaundry23 {

    static Scanner input = new Scanner(System.in);

    // Menginputkan berat cucian setiap layanan untuk setiap hari
    static void inputData(int[][] data, String[] layanan, String[] hari) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Layanan: " + layanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  Berat cucian hari " + hari[j] + " (kg): ");
                data[i][j] = input.nextInt();
            }
        }
    }

    // Menampilkan seluruh data dalam bentuk tabel
    static void tampilTabel(int[][] data, String[] layanan, int[] harga, String[] hari) {
        System.out.print(String.format("%-14s%-12s", "Layanan", "Harga/kg"));
        for (int j = 0; j < hari.length; j++) {
            System.out.print(String.format("%-8s", hari[j]));
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.print(String.format("%-14s%-12s", layanan[i], "Rp" + harga[i]));
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(String.format("%-8d", data[i][j]));
            }
            System.out.println();
        }
    }

    // Total berat cucian satu layanan selama 6 hari
    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    // Menampilkan layanan dengan total berat cucian tertinggi
    static void tampilLayananTertinggi(int[][] data, String[] layanan) {
        int idxMax = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idxMax)) {
                idxMax = i;
            }
        }
        System.out.println("Layanan dengan cucian terbanyak: " + layanan[idxMax]
                + " (" + totalPerLayanan(data, idxMax) + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int idxMax = 0;
        int totalMax = 0;
        for (int j = 0; j < data[0].length; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (j == 0 || totalHari > totalMax) {
                totalMax = totalHari;
                idxMax = j;
            }
        }
        return idxMax;
    }

    static void tampilPendapatan(int[][] data, String[] layanan, int[] harga) {
        int totalPendapatan = 0;
        for (int i = 0; i < data.length; i++) {
            int pendapatan = totalPerLayanan(data, i) * harga[i];
            totalPendapatan += pendapatan;
            System.out.println(layanan[i] + ": Rp" + pendapatan);
        }
        System.out.println("Total pendapatan 6 hari: Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] harga = {6000, 8000, 5000, 12000};
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        int[][] data = new int[layanan.length][hari.length];

        inputData(data, layanan, hari);

        System.out.println();
        tampilTabel(data, layanan, harga, hari);

        System.out.println();
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Total " + layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        System.out.println();
        tampilLayananTertinggi(data, layanan);

        int idxHari = hariTersibuk(data);
        System.out.println("Hari tersibuk: " + hari[idxHari]);

        System.out.println();
        System.out.println("Pendapatan tiap layanan:");
        tampilPendapatan(data, layanan, harga);

        input.close();
    }
}