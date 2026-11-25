import java.util.Scanner;

public class RekapLaundry23 {

    static Scanner input = new Scanner(System.in);

    static void inputData(int[][] data, String[] layanan) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Layanan: " + layanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  Berat cucian Hari ke-" + (j + 1) + " (kg): ");
                data[i][j] = input.nextInt();
            }
        }
    }

    static void tampilTabel(int[][] data, String[] layanan, int[] harga) {
        System.out.print(String.format("%-16s%-12s", "Layanan", "Harga/kg"));
        for (int j = 0; j < data[0].length; j++) {
            System.out.print(String.format("%-11s", "Hari ke-" + (j + 1)));
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.print(String.format("%-16s%-12s", layanan[i], "Rp" + harga[i]));
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(String.format("%-11d", data[i][j]));
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

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
        System.out.println("Total pendapatan: Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah layanan: ");
        int jumlahLayanan = input.nextInt();
        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = input.nextInt();
        input.nextLine();

        String[] layanan = new String[jumlahLayanan];
        int[] harga = new int[jumlahLayanan];

        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = input.nextLine();
            System.out.print("Harga per kg " + layanan[i] + ": ");
            harga[i] = input.nextInt();
            input.nextLine();
        }

        int[][] data = new int[jumlahLayanan][jumlahHari];

        System.out.println();
        inputData(data, layanan);

        System.out.println();
        tampilTabel(data, layanan, harga);

        System.out.println();
        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println("Total " + layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        System.out.println();
        tampilLayananTertinggi(data, layanan);

        int idxHari = hariTersibuk(data);
        System.out.println("Hari tersibuk: Hari ke-" + (idxHari + 1));

        System.out.println();
        System.out.println("Pendapatan tiap layanan:");
        tampilPendapatan(data, layanan, harga);

        input.close();
    }
}