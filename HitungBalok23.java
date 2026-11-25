import java.util.Scanner;

public class HitungBalok23 {

    static int hitungLuas(int pjg, int lbr) {
        int luas = pjg * lbr;
        return luas;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int p, l, t;

        for (int i = 1; i <= 3; i++) {
            System.out.println("=== Balok " + i + " ===");
            System.out.print("Masukkan panjang: ");
            p = input.nextInt();
            System.out.print("Masukkan lebar: ");
            l = input.nextInt();
            System.out.print("Masukkan tinggi: ");
            t = input.nextInt();

            System.out.println("Luas permukaan balok: " + hitungLuasPermukaanBalok(p, l, t));
            System.out.println("Volume balok: " + hitungVolume(t, p, l));
            System.out.println();
        }

        input.close();
    }
}