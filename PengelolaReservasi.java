package com.mycompany.sistemreservasiruangbelajarkampus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PengelolaReservasi implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Reservasi> daftarReservasi;
    private HashMap<String, Pengguna> dataPengguna;
    private FasilitasKampus fasilitasKampus;
    public PengelolaReservasi() {
        daftarReservasi = new ArrayList<>();
        dataPengguna = new HashMap<>();
        fasilitasKampus = new FasilitasKampus(
                "Ruang Belajar Kampus",
                "Gedung Perkuliahan Unila",
                true
        );
    }
    public void tambahReservasi(Reservasi reservasi) {
        daftarReservasi.add(reservasi);
    }
    public ArrayList<Reservasi> getDaftarReservasi() {
        return daftarReservasi;
    }
    public HashMap<String, Pengguna> getDataPengguna() {
    return dataPengguna;
}
    public void tambahPengguna(Pengguna pengguna) {
        dataPengguna.put(
                pengguna.getNim(),
                pengguna
        );
        System.out.println("Data pengguna berhasil ditambahkan.");
    }
    public Pengguna cariPengguna(String nim) {
        return dataPengguna.get(nim);
    }
    public void tampilkanSemuaPengguna() {
        System.out.println("\n===== DAFTAR PENGGUNA =====");

        if (dataPengguna.isEmpty()) {
            System.out.println("Belum ada data pengguna.");
            return;
        }
        for (Pengguna pengguna : dataPengguna.values()) {
            pengguna.tampilkanPengguna();
        }

        System.out.println(
                "Total pengguna: " + dataPengguna.size()
        );
    }
    public void tampilkanFasilitasKampus() {
        fasilitasKampus.tampilkanFasilitas();
    }
}