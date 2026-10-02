package com.mycompany.sistemreservasiruangbelajarkampus;

public class Pengguna {
    private String nama;
    private String nim;
    private String nomorHP;

    public Pengguna(String nama, String nim, String nomorHP) {
        setNama(nama);
        setNim(nim);
        setNomorHP(nomorHP);
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama.trim();
        } else {
            this.nama = "Tanpa Nama";
        }
    }

    public String getNim() {
        return this.nim;
    }

    public void setNim(String nim) {
        if (nim != null && !nim.trim().isEmpty()) {
            this.nim = nim.trim();
        } else {
            this.nim = "N/A";
        }
    }

    public String getNomorHP() {
        return this.nomorHP;
    }

    public void setNomorHP(String nomorHP) {
        if (nomorHP != null && nomorHP.matches("[0-9]{10,15}")) {
            this.nomorHP = nomorHP;
        } else {
            this.nomorHP = "0000000000";
        }
    }

    public void tampilkanPengguna() {
        System.out.printf(
            "Nama: %-18s | NIM: %-12s | No. HP: %s%n",
            this.nama,
            this.nim,
            this.nomorHP
        );
    }
}