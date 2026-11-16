package com.mycompany.sistemreservasiruangbelajarkampus;

import java.io.Serializable;

public class FasilitasKampus implements Serializable {

    private static final long serialVersionUID = 1L;

    private String namaFasilitas;
    private String lokasi;
    private boolean tersedia;

    public FasilitasKampus(
            String namaFasilitas,
            String lokasi,
            boolean tersedia) {

        this.namaFasilitas = namaFasilitas;
        this.lokasi = lokasi;
        this.tersedia = tersedia;
    }

    public void tampilkanFasilitas() {

        System.out.println("\n===== FASILITAS KAMPUS =====");
        System.out.println("Nama Fasilitas : " + namaFasilitas);
        System.out.println("Lokasi         : " + lokasi);
        System.out.println("Status         : "
                + (tersedia ? "Tersedia" : "Tidak tersedia"));
    }
}