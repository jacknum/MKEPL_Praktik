import java.util.Date;
import java.util.Calendar;

public class LibraryMember {

    private MemberInfo info;
    private boolean statusAktif;
    private Keanggotaan Keanggotaan;
    private int jumlahBukuDipinjam;
    private int jumlahTerlambat;
    private int jumlahDenda;
    private int poinLoyalitas;
    private String kodeReferal;
    private boolean langgananBuletin;

    public LibraryMember(MemberInfo info, boolean statusAktif,
            String tingkatKeanggotaan, int jumlahBukuDipinjam,
            int jumlahTerlambat, int jumlahDenda,
            int poinLoyalitas, String kodeReferal,
            boolean langgananBuletin) {

        this.info = info;
        this.statusAktif = statusAktif;
        this.Keanggotaan = new Keanggotaan(tingkatKeanggotaan, poinLoyalitas);
        this.jumlahBukuDipinjam = jumlahBukuDipinjam;
        this.jumlahTerlambat = jumlahTerlambat;
        this.jumlahDenda = jumlahDenda;
        this.poinLoyalitas = poinLoyalitas;
        this.kodeReferal = kodeReferal;
        this.langgananBuletin = langgananBuletin;
    }

    public void cetakProfilLengkap() {
        System.out.println("===== PROFIL ANGGOTA =====");
        System.out.println("Nama         : " + info.getNamaLengkap());
        System.out.println("Jenis Kelamin: " + info.getJenisKelamin());
        System.out.println("Alamat       : " + info.getAlamat());
        System.out.println("Telepon      : " + info.getNomorTelepon());
        System.out.println("Email        : " + info.getEmail());
        System.out.println("Kode Anggota : " + info.getKodeAnggota());
        System.out.println("Tanggal Gabung: " + info.getTanggalGabung());
        System.out.println("Status Aktif : " + statusAktif);
        System.out.println("Tingkat      : " + Keanggotaan.getTingkat());
        System.out.println("Buku Dipinjam: " + jumlahBukuDipinjam);
        System.out.println("Terlambat    : " + jumlahTerlambat);
        System.out.println("Denda        : Rp " + jumlahDenda);
        System.out.println("Poin         : " + poinLoyalitas);
        System.out.println("Kode Referal : " + kodeReferal);
        System.out.println("Langganan Buletin: " + langgananBuletin);
        System.out.println("Skor Risiko : " + hitungSkorRisiko());
        System.out.println("Layak Upgrade?: " + Keanggotaan.layakUpgrade());
        System.out.println("===========================");
    }

    public double hitungSkorRisiko() {
        double skor = 0;
        skor += jumlahTerlambat * 1.5;
        skor += jumlahDenda * 0.1;
        if (!statusAktif)
            skor += 5;
        if (Keanggotaan.equals("DASAR"))
            skor += 2;
        if (jumlahBukuDipinjam > 50)
            skor -= 1.5;
        return skor;
    }

    public int getJumlahBukuDipinjam() {
        return jumlahBukuDipinjam;
    }

    public void setJumlahBukuDipinjam(int b) {
        jumlahBukuDipinjam = b;
    }

    public int getJumlahTerlambat() {
        return jumlahTerlambat;
    }

    public void setJumlahTerlambat(int t) {
        jumlahTerlambat = t;
    }

    public int getJumlahDenda() {
        return jumlahDenda;
    }

    public void setJumlahDenda(int d) {
        jumlahDenda = d;
    }

    public String getKodeReferal() {
        return kodeReferal;
    }

    public void setKodeReferal(String k) {
        kodeReferal = k;
    }

    public boolean getLanggananBuletin() {
        return langgananBuletin;
    }

    public void setLanggananBuletin(boolean l) {
        langgananBuletin = l;
    }

    public static class MemberInfo {
        private String namaLengkap;
        private String alamat;
        private String nomorTelepon;
        private String email;
        private String jenisKelamin;
        private String kodeAnggota;
        private Date tanggalGabung;

        public MemberInfo(String namaLengkap, String alamat, String nomorTelepon, String email, String jenisKelamin,
                String kodeAnggota, Date tanggalGabung) {
            this.namaLengkap = namaLengkap;
            this.alamat = alamat;
            this.nomorTelepon = nomorTelepon;
            this.email = email;
            this.jenisKelamin = jenisKelamin;
            this.kodeAnggota = kodeAnggota;
            this.tanggalGabung = tanggalGabung;
        }

        public String getNamaLengkap() {
            return namaLengkap;
        }

        public String getAlamat() {
            return alamat;
        }

        public String getNomorTelepon() {
            return nomorTelepon;
        }

        public String getEmail() {
            return email;
        }

        public String getJenisKelamin() {
            return jenisKelamin;
        }

        public String getKodeAnggota() {
            return kodeAnggota;
        }

        public Date getTanggalGabung() {
            return tanggalGabung;
        }
    }

    public static class Keanggotaan {
        private String tingkat;
        private int poin;

        public Keanggotaan(String tingkat, int poin) {
            this.tingkat = tingkat;
            this.poin = poin;
        }

        public boolean layakUpgrade() {
            return tingkat.equalsIgnoreCase("DASAR") && poin > 100;
        }

        public String getTingkat() {
            return tingkat;
        }

        public int getPoin() {
            return poin;
        }

        public void setTingkat(String tingkat) {
            this.tingkat = tingkat;
        }

        public void setPoin(int poin) {
            this.poin = poin;
        }
    }
}
