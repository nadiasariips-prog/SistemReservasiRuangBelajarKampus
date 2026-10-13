package com.mycompany.sistemreservasiruangbelajarkampus;

public abstract class Reservasi {
    private String kodeReservasi;
    private Pengguna pengguna;
    private String tanggal;
    private int durasiJam;

    private static int totalReservasi = 0;

    public Reservasi(String kodeReservasi, Pengguna pengguna, String tanggal, int durasiJam) {
        setKodeReservasi(kodeReservasi);
        setPengguna(pengguna);
        setTanggal(tanggal);
        setDurasiJam(durasiJam);
        totalReservasi++;
    }

    public String getKodeReservasi() {
        return this.kodeReservasi;
    }

    public void setKodeReservasi(String kodeReservasi) {
        if (kodeReservasi != null && !kodeReservasi.trim().isEmpty()) {
            this.kodeReservasi = kodeReservasi.trim();
        } else {
            this.kodeReservasi = "R-000";
        }
    }

    public Pengguna getPengguna() {
        return this.pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        if (pengguna != null) {
            this.pengguna = pengguna;
        }
    }

    public String getTanggal() {
        return this.tanggal;
    }

    public void setTanggal(String tanggal) {
        if (tanggal != null && !tanggal.trim().isEmpty()) {
            this.tanggal = tanggal.trim();
        } else {
            this.tanggal = "Belum ditentukan";
        }
    }

    public int getDurasiJam() {
        return this.durasiJam;
    }

    public void setDurasiJam(int durasiJam) {
        if (durasiJam >= 1 && durasiJam <= 12) {
            this.durasiJam = durasiJam;
        } else {
            this.durasiJam = 1;
        }
    }

    public static int getTotalReservasi() {
        return totalReservasi;
    }

    public void tampilkanInfo() {
        System.out.printf(
            "Kode: %-8s | Pemesan: %-18s | Tanggal: %-12s | Durasi: %2d jam%n",
            this.kodeReservasi,
            this.pengguna.getNama(),
            this.tanggal,
            this.durasiJam
        );
    }

    public void cekFasilitas() {
        System.out.println("Fasilitas mengikuti ruangan yang dipilih.");
    }
    
    public abstract void tampilkanDetailRuangan();
}