package com.mycompany.sistemreservasiruangbelajarkampus;

public class TransaksiReservasi {

    public static void prosesTransaksi(
            Pengguna pengguna,
            Reservasi reservasi) {

        System.out.println("\n===== TRANSAKSI RESERVASI =====");

        if (pengguna == null || reservasi == null) {
            System.out.println("Transaksi gagal diproses.");
            return;
        }

        System.out.println(
                "Nama Pengguna : " + pengguna.getNama()
        );

        System.out.println(
                "NIM           : " + pengguna.getNim()
        );

        System.out.println(
                "Kode Reservasi: " + reservasi.getKodeReservasi()
        );

        System.out.println(
                "Tanggal       : " + reservasi.getTanggal()
        );

        System.out.println(
                "Durasi        : " + reservasi.getDurasiJam() + " jam"
        );

        System.out.println("\nDetail Ruangan:");

        reservasi.tampilkanDetailRuangan();

        if (reservasi instanceof DapatDipesan) {

            DapatDipesan pesan =
                    (DapatDipesan) reservasi;

            pesan.konfirmasiPemesanan();
        }

        System.out.println("\nStatus: Transaksi berhasil diproses.");
    }
}