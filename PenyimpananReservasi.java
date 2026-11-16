
package com.mycompany.sistemreservasiruangbelajarkampus;

import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PenyimpananReservasi {


    public static void simpanData(PengelolaReservasi pengelola) {

        try {
            FileOutputStream fileKeluar =
                    new FileOutputStream("data_reservasi.dat");

            ObjectOutputStream objekKeluar =
                    new ObjectOutputStream(fileKeluar);

            objekKeluar.writeObject(pengelola);

            objekKeluar.close();

            System.out.println("Data berhasil disimpan ke file .dat!");

        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }


    public static PengelolaReservasi muatData() {

        File file = new File("data_reservasi.dat");

        if (!file.exists()) {
            System.out.println("Belum ada file penyimpanan. Memulai data baru.");
            return new PengelolaReservasi();
        }

        try {
            FileInputStream fileMasuk =
                    new FileInputStream(file);

            ObjectInputStream objekMasuk =
                    new ObjectInputStream(fileMasuk);

            PengelolaReservasi pengelola =
                    (PengelolaReservasi) objekMasuk.readObject();

            objekMasuk.close();

            System.out.println("Data berhasil dimuat dari file .dat!");

            return pengelola;

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Gagal memuat data: " + e.getMessage());

            return new PengelolaReservasi();
        }
    }


    public static void catatLog(String aktivitas) {

        try {
            FileWriter penulis =
                    new FileWriter("log_reservasi.txt", true);

            penulis.write(aktivitas + "\n");

            penulis.close();

            System.out.println("Log aktivitas berhasil dicatat.");

        } catch (IOException e) {
            System.out.println("Gagal menulis log: " + e.getMessage());
        }
    }

    public static void bacaLog() {

        System.out.println("\n===== RIWAYAT AKTIVITAS =====");

        File file = new File("log_reservasi.txt");

        try {
            Scanner pembaca = new Scanner(file);

            if (!pembaca.hasNextLine()) {
                System.out.println("Belum ada riwayat aktivitas.");
            }

            while (pembaca.hasNextLine()) {
                System.out.println(pembaca.nextLine());
            }

            pembaca.close();

        } catch (FileNotFoundException e) {
            System.out.println("File log belum tersedia.");
        }
    }
}
