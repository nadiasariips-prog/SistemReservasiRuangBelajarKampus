package com.mycompany.sistemreservasiruangbelajarkampus;
public class RuangLaboratorium extends Reservasi implements DapatDicekFasilitas{

    private int jumlahKomputer;
    private String jenisLab;
    public RuangLaboratorium(
            String kodeReservasi,
            Pengguna pengguna,
            String tanggal,
            int durasiJam,
            int jumlahKomputer,
            String jenisLab) {
        super(kodeReservasi, pengguna, tanggal, durasiJam);
        setJumlahKomputer(jumlahKomputer);
        setJenisLab(jenisLab);
    }
    public int getJumlahKomputer() {
        return this.jumlahKomputer;
    }
    public void setJumlahKomputer(int jumlahKomputer) {
        if (jumlahKomputer >= 1 && jumlahKomputer <= 100) {
            this.jumlahKomputer = jumlahKomputer;
        } else {
            this.jumlahKomputer = 1;
        }
    }
    public String getJenisLab() {
        return this.jenisLab;
    }
    public void setJenisLab(String jenisLab) {
        if (jenisLab != null && !jenisLab.trim().isEmpty()) {
            this.jenisLab = jenisLab.trim();
        } else {
            this.jenisLab = "Laboratorium Komputer";
        }
    }
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(
            "         Jenis: Laboratorium | Lab: %-18s | Komputer: %d unit%n",
            this.jenisLab,
            this.jumlahKomputer
        );
    }

    @Override
    public void cekFasilitas() {
        super.cekFasilitas();
        System.out.println(
            "         Fasilitas: komputer, jaringan internet, dan perangkat praktikum."
        );
    }
     @Override
    public void tampilkanFasilitasTambahan() {
        System.out.println(
            "Pengecekan tambahan: " + jumlahKomputer
            + " komputer tersedia di " + jenisLab + "."
        );
    }
    
    @Override
    public void tampilkanDetailRuangan() {
        System.out.printf(
            "Detail Laboratorium: %s, %d komputer.%n",
            jenisLab,
            jumlahKomputer
        );
    }
}