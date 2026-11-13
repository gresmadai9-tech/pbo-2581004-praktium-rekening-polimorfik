public class Tabungan extends Rekening implements BerBunga {
    private double persenBunga;

    public Tabungan(String nomor, String pemilik, int saldo, double persenBunga) {
        super(nomor, pemilik, saldo);
        this.persenBunga = persenBunga;
    }

    // Aturan: gratis jika saldo ≥ 1.000.000, selain itu Rp5.000
    @Override
    public int biayaAdminBulanan() {
        if (getSaldo() >= 1_000_000) {
            return 0;
        }
        return 5_000;
    }

    // Hitung bunga dari saldo SETELAH admin dipotong, lalu tambahkan ke saldo
    @Override
    public int tambahBunga() {
        int bunga = (int) Math.round(getSaldo() * persenBunga / 100);
        setor(bunga);
        return bunga;
    }

    public double getPersenBunga() {
        return persenBunga;
    }
}
