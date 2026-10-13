package com.mycompany.sistemreservasiruangbelajarkampus;

public class RuangKelas extends Reservasi implements DapatDipesan, DapatDicekFasilitas {

    private int kapasitas;
    private boolean memilikiProyektor;

    public RuangKelas(
            String kodeReservasi,
            Pengguna pengguna,
            String tanggal,
            int durasiJam,
            int kapasitas,
            boolean memilikiProyektor) {

        super(kodeReservasi, pengguna, tanggal, durasiJam);

        setKapasitas(kapasitas);
        setMemilikiProyektor(memilikiProyektor);
    }

    public int getKapasitas() {
        return this.kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        if (kapasitas >= 5 && kapasitas <= 100) {
            this.kapasitas = kapasitas;
        } else {
            this.kapasitas = 5;
        }
    }

    public boolean isMemilikiProyektor() {
        return this.memilikiProyektor;
    }

    public void setMemilikiProyektor(boolean memilikiProyektor) {
        this.memilikiProyektor = memilikiProyektor;
    }

    @Override
    public void tampilkanInfo() {

        super.tampilkanInfo();

        System.out.printf(
            "         Jenis: Ruang Kelas | Kapasitas: %d orang | Proyektor: %s%n",
            this.kapasitas,
            this.memilikiProyektor ? "Tersedia" : "Tidak tersedia"
        );
    }

    @Override
    public void cekFasilitas() {

        super.cekFasilitas();

        System.out.println(
            "         Fasilitas: meja, kursi, papan tulis, dan proyektor sesuai pilihan."
        );
    }
    @Override
    public void konfirmasiPemesanan() {
        System.out.println(
            "Konfirmasi: pemesanan ruang kelas "
            + getKodeReservasi() + " diproses."
        );
    }

    @Override
    public void tampilkanFasilitasTambahan() {
        System.out.println(
            "Fasilitas tambahan ruang kelas: proyektor "
            + (memilikiProyektor
                ? "tersedia."
                : "tidak tersedia.")
        );
    }
    
    @Override
    public void tampilkanDetailRuangan() {
        System.out.printf(
            "Detail Ruang Kelas: kapasitas %d orang.%n",
            kapasitas
        );
    }
}