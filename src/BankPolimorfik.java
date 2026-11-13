public class BankPolimorfik {
    public static void main(String[] args) {
        // Coba instantiasi abstract class — error berikut muncul saat dijalankan:
        // error: Rekening is abstract; cannot be instantiated
        // Rekening r = new Rekening("999", "Eko", 0);

        // 1. Buat objek di variabel masing-masing
        Tabungan ani = new Tabungan("101", "Ani", 1_000_000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300_000, 2.0);
        Giro budi = new Giro("201", "Budi", 200_000, 500_000);

        // 2. Masukkan ke dua array
        Rekening[] semua = { ani, citra, budi };
        BerBunga[] berbunga = { ani, citra };

        // ========== REKENING AWAL ==========
        System.out.println("========== REKENING AWAL ==========");
        for (Rekening r : semua) {
            System.out.printf("%s | %-6s | Rp%,d%n",
                    r.getNomor(), r.getPemilik(), r.getSaldo());
            if (r instanceof Tabungan) {
                Tabungan t = (Tabungan) r;
                System.out.printf("      Tabungan, bunga %.1f%% per bulan%n", t.getPersenBunga());
            } else {
                Giro g = (Giro) r;
                System.out.printf("      Giro, batas overdraft Rp%,d%n", g.getBatasOverdraft());
            }
        }

        // ========== AKHIR BULAN ============
        System.out.println("\n========== AKHIR BULAN ============");
        // Proses biaya admin — lewat loop atas "semua"
        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();
            System.out.printf("%s biaya admin  : Rp%,d%n", r.getNomor(), biaya);
        }
        // Proses bunga — lewat loop atas "berbunga" saja
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();
            System.out.printf("%s bunga        : Rp%,d%n", b.getNomor(), bunga);
        }

        // ========== REKENING AKHIR =========
        System.out.println("\n========== REKENING AKHIR ==========");
        int total = 0;
        for (Rekening r : semua) {
            System.out.printf("%s | %-6s | Rp%,d%n",
                    r.getNomor(), r.getPemilik(), r.getSaldo());
            if (r instanceof Tabungan) {
                Tabungan t = (Tabungan) r;
                System.out.printf("      Tabungan, bunga %.1f%% per bulan%n", t.getPersenBunga());
            } else {
                Giro g = (Giro) r;
                System.out.printf("      Giro, batas overdraft Rp%,d%n", g.getBatasOverdraft());
            }
            total += r.getSaldo();
        }
        System.out.println("-----------------------------------");
        System.out.printf("Total dana bank : Rp%,d%n", total);
    }
}
