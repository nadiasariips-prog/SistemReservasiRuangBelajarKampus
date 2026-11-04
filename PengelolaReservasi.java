package com.mycompany.sistemreservasiruangbelajarkampus;

import java.util.ArrayList;
import java.util.HashMap;

public class PengelolaReservasi {

    // AGGREGATION
    private ArrayList<Reservasi> daftarReservasi;
    private HashMap<String, Pengguna> dataPengguna;

    // COMPOSITION
    private FasilitasKampus fasilitasKampus;

    public PengelolaReservasi() {

        daftarReservasi = new ArrayList<>();
        dataPengguna = new HashMap<>();

        // Objek dibuat langsung di dalam constructor
        fasilitasKampus = new FasilitasKampus(
                "Ruang Belajar Kampus",
                "Gedung Perkuliahan Unila",
                true
        );
    }

    // Menambahkan reservasi
    public void tambahReservasi(Reservasi reservasi) {
        daftarReservasi.add(reservasi);
    }

    // Mengambil daftar reservasi
    public ArrayList<Reservasi> getDaftarReservasi() {
        return daftarReservasi;
    }

    // Menambahkan pengguna
    public void tambahPengguna(Pengguna pengguna) {

        dataPengguna.put(
                pengguna.getNim(),
                pengguna
        );

        System.out.println("Data pengguna berhasil ditambahkan.");
    }

    // Mencari pengguna berdasarkan NIM
    public Pengguna cariPengguna(String nim) {
        return dataPengguna.get(nim);
    }

    // Menampilkan seluruh pengguna
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

    // Menampilkan fasilitas (Composition)
    public void tampilkanFasilitasKampus() {
        fasilitasKampus.tampilkanFasilitas();
    }
}