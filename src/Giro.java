public class Giro extends Rekening {
    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    public int getBatasOverdraft() {
        return batasOverdraft;
    }

    // Aturan: biaya admin selalu Rp15.000
    @Override
    public int biayaAdminBulanan() {
        return 15_000;
    }

    // Override method tarik dari Bab 10 — boleh tarik sampai batas overdraft
    @Override
    public void tarik(int jumlah) {
        if (jumlah <= getSaldo() + batasOverdraft) {
            super.tarik(jumlah);
        }
    }
}
