
public abstract class Rekening {
    private String nomor;
    private String pemilik;
    private int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public void tarik(int jumlah) {
        saldo -= jumlah;
    }

    public void setor(int jumlah) {
        saldo += jumlah;
    }

    // Method abstrak — wajib diimplementasikan subclass
    public abstract int biayaAdminBulanan();

    // Method konkret: potong biaya dari saldo
    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }
}
