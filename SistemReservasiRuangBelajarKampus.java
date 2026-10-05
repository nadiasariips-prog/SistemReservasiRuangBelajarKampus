package com.mycompany.sistemreservasiruangbelajarkampus;

import java.util.Scanner;
public class SistemReservasiRuangBelajarKampus {

    public static void cariReservasi(
            String kode,
            Reservasi[] daftarReservasi,
            int jumlahReservasi) {

        System.out.println(
            "\nHasil pencarian berdasarkan kode: " + kode);

        boolean ditemukan = false;

        for (int i = 0; i < jumlahReservasi; i++) {
            if (daftarReservasi[i]
                    .getKodeReservasi()
                    .equalsIgnoreCase(kode)) {
                daftarReservasi[i].tampilkanInfo();
                daftarReservasi[i].cekFasilitas();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data reservasi tidak ditemukan.");
        }
    }

    public static void cariReservasi(
            String nama,
            String tanggal,
            Reservasi[] daftarReservasi,
            int jumlahReservasi) {

        System.out.println(
            "\nHasil pencarian pemesan dan tanggal: "
            + nama + " | " + tanggal);

        boolean ditemukan = false;
        for (int i = 0; i < jumlahReservasi; i++) {
            if (daftarReservasi[i]
                    .getPengguna()
                    .getNama()
                    .equalsIgnoreCase(nama)
                    &&
                daftarReservasi[i]
                    .getTanggal()
                    .equalsIgnoreCase(tanggal)) {

                daftarReservasi[i].tampilkanInfo();
                daftarReservasi[i].cekFasilitas();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data reservasi tidak ditemukan.");
        }
    }

    public static void tampilkanSemua(
            Reservasi[] daftarReservasi,
            int jumlahReservasi) {

        System.out.println(
            "\n================ DAFTAR RESERVASI ================");

        if (jumlahReservasi == 0) {
            System.out.println("Belum ada data reservasi.");
            return;
        }
        for (int i = 0; i < jumlahReservasi; i++) {
            System.out.println("\nData ke-" + (i + 1));
            daftarReservasi[i].tampilkanInfo();
            daftarReservasi[i].cekFasilitas();
        }

        System.out.println(
            "\nTotal objek Reservasi berhasil dibuat: "
            + Reservasi.getTotalReservasi());
    }
    public static void prosesReservasi(
        Reservasi reservasi) {
            System.out.println(
                "\n===== PROSES RESERVASI =====");       
            System.out.println(
                "Data reservasi yang diproses:");  
            reservasi.tampilkanInfo();
            System.out.println(
                "Memeriksa fasilitas:");
            reservasi.cekFasilitas();
            System.out.println(
                "Reservasi berhasil diproses.");  
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Reservasi[] daftarReservasi = new Reservasi[20];
            int jumlahReservasi = 0;
            boolean isRunning = true;

            daftarReservasi[jumlahReservasi++] =
                new RuangKelas(
                    "R-001",
                    new Pengguna(
                        "Alya Putri",
                        "251101001",
                        "081234567890"
                    ),
                    "05-10-2026",
                    2,
                    30,
                    true);

            daftarReservasi[jumlahReservasi++] =
                new RuangLaboratorium(
                    "R-002",
                    new Pengguna(
                        "Bima Saputra",
                        "251101002",
                        "082345678901"
                    ),
                    "06-10-2026",
                    3,
                    25,
                    "Lab Pemrograman");

            daftarReservasi[jumlahReservasi++] =
                new RuangKelas(
                    "R-003",
                    new Pengguna(
                        "Citra Lestari",
                        "251101003",
                        "083456789012"
                    ),
                    "07-10-2026",
                    1,
                    20,
                    false);
            daftarReservasi[jumlahReservasi++] =
                new RuangSeminar(
                    "R-004",
                    new Pengguna(
                        "Dina Maharani",
                        "251101004",
                        "084567890123"
                    ),
                    "08-10-2026",
                    2,
                    100,
                    true
                );
            System.out.println(
                "====================================================");
            System.out.println(
                "       SISTEM RESERVASI RUANG BELAJAR KAMPUS       ");
            System.out.println(
                "====================================================");

            while (isRunning) {

                System.out.println("\n---------------- MENU UTAMA ----------------");
                System.out.println("1. Tambah Data Reservasi");
                System.out.println("2. Tampilkan Seluruh Data");
                System.out.println( "3. Pencarian / Aksi Khusus");
                System.out.println("4. Keluar");
                System.out.print("Pilih menu (1-4): " );
                int pilihan;

                try {
                    pilihan =
                        Integer.parseInt(
                            scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println( "Input harus berupa angka." );
                    continue;
                }

                switch (pilihan) {

                    case 1:

                        if (jumlahReservasi >=
                            daftarReservasi.length) {
                            System.out.println("Kapasitas data reservasi sudah penuh."
                            );
                            break;
                        }

                        System.out.println("\n--- TAMBAH RESERVASI ---");
                        System.out.println("1. Ruang Kelas");
                        System.out.println("2. Laboratorium");
                        System.out.println("3. Ruang Seminar");
                        System.out.print("Pilih tipe ruangan (1/3): ");
                        int jenis;

                        try {
                            jenis =
                                Integer.parseInt(
                                    scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println( "Pilihan harus berupa angka."
                            );
                            break;
                        }

                        if (jenis != 1 && jenis != 2 && jenis != 3) {

                            System.out.println(
                                "Jenis ruangan tidak valid."
                            );

                            break;
                        }

                        System.out.print(
                            "Kode reservasi: "
                        );

                        String kode =
                            scanner.nextLine();


                        System.out.print(
                            "Nama pemesan: "
                        );

                        String nama =
                            scanner.nextLine();


                        System.out.print(
                            "NIM: "
                        );

                        String nim =
                            scanner.nextLine();


                        System.out.print(
                            "Nomor HP (10-15 digit): "
                        );

                        String nomorHP =
                            scanner.nextLine();


                        System.out.print(
                            "Tanggal reservasi (dd-mm-yyyy): "
                        );

                        String tanggal =
                            scanner.nextLine();


                        System.out.print(
                            "Durasi (jam, 1-12): "
                        );

                        int durasi;

                        try {

                            durasi =
                                Integer.parseInt(
                                    scanner.nextLine()
                                );

                        } catch (NumberFormatException e) {

                            System.out.println(
                                "Durasi harus berupa angka."
                            );

                            break;
                        }

                        Pengguna pengguna =
                            new Pengguna(
                                nama,
                                nim,
                                nomorHP
                            );

                        if (jenis == 1) {

                            System.out.print(
                                "Kapasitas ruangan (5-100 orang): "
                            );

                            int kapasitas;

                            try {

                                kapasitas =
                                    Integer.parseInt(
                                        scanner.nextLine()
                                    );

                            } catch (NumberFormatException e) {

                                System.out.println(
                                    "Kapasitas harus berupa angka."
                                );

                                break;
                            }


                            System.out.print(
                                "Memiliki proyektor? (y/n): "
                            );

                            boolean proyektor =
                                scanner
                                    .nextLine()
                                    .equalsIgnoreCase("y");


                            daftarReservasi[jumlahReservasi++] =
                                new RuangKelas(
                                    kode,
                                    pengguna,
                                    tanggal,
                                    durasi,
                                    kapasitas,
                                    proyektor
                                );
                           
                        } else if (jenis == 2) {

                            System.out.print(
                                "Jumlah komputer (1-100): "
                            );

                            int komputer;

                            try {

                                komputer =
                                    Integer.parseInt(
                                        scanner.nextLine()
                                    );

                            } catch (NumberFormatException e) {

                                System.out.println(
                                    "Jumlah komputer harus berupa angka."
                                );

                                break;
                            }
                        } else {

                            System.out.print(
                                "Kapasitas seminar (10-300 orang): "
                            );

                            int kapasitas;

                            try {

                                kapasitas =
                                    Integer.parseInt(
                                        scanner.nextLine()
                                    );

                            } catch (NumberFormatException e) {

                                System.out.println(
                                    "Kapasitas harus berupa angka."
                                );

                                break;
                            }


                            System.out.print(
                                "Memiliki sound system? (y/n): "
                            );

                            boolean soundSystem =
                                scanner
                                    .nextLine()
                                    .equalsIgnoreCase("y");


                            daftarReservasi[jumlahReservasi++] =
                                new RuangSeminar(
                                    kode,
                                    pengguna,
                                    tanggal,
                                    durasi,
                                    kapasitas,
                                    soundSystem
                                );
                        }


                            System.out.print(
                                "Jenis laboratorium: "
                            );

                            String jenisLab =
                                scanner.nextLine();
                            
                            System.out.print("Jumlah komputer: " );
                        int komputer;
                        try {
                            komputer = Integer.parseInt(
                                scanner.nextLine());
                        } catch (NumberFormatException e) {

                            System.out.println(
                                "Jumlah komputer harus berupa angka."
                            );

                            break;
                        }


                            daftarReservasi[jumlahReservasi++] =
                                new RuangLaboratorium(
                                    kode,
                                    pengguna,
                                    tanggal,
                                    durasi,
                                    komputer,
                                    jenisLab
                                );
                        


                        System.out.println(
                            "Reservasi berhasil ditambahkan."
                        );

                        break;

                    case 2:

                        tampilkanSemua(
                            daftarReservasi,
                            jumlahReservasi
                        );

                        break;

                    case 3:
                        System.out.println(
                            "\n--- PENCARIAN / AKSI KHUSUS ---"
                        );

                        System.out.println(
                            "1. Cari berdasarkan kode reservasi"
                        );

                        System.out.println(
                            "2. Cari berdasarkan nama dan tanggal"
                        );
                        System.out.println(
                            "3. Proses Reservasi"
                        );

                        System.out.print(
                            "Pilih (1/3): "
                        );


                        int mode;

                        try {

                            mode =
                                Integer.parseInt(
                                    scanner.nextLine()
                                );

                        } catch (NumberFormatException e) {

                            System.out.println(
                                "Pilihan harus berupa angka."
                            );

                            break;
                        }


                        if (mode == 1) {

                            System.out.print(
                                "Masukkan kode reservasi: "
                            );

                            String kodeCari =
                                scanner.nextLine();

                            cariReservasi(
                                kodeCari,
                                daftarReservasi,
                                jumlahReservasi
                            );


                        } else if (mode == 2) {

                            System.out.print(
                                "Masukkan nama pemesan: "
                            );

                            String namaCari =
                                scanner.nextLine();


                            System.out.print(
                                "Masukkan tanggal: "
                            );

                            String tanggalCari =
                                scanner.nextLine();

                            cariReservasi(
                                namaCari,
                                tanggalCari,
                                daftarReservasi,
                                jumlahReservasi
                            );
                        } else if (mode == 3) {
                            if (jumlahReservasi == 0) {

                                System.out.println(
                                    "Belum ada data reservasi."
                                );

                            } else {

                                System.out.println(
                                    "\n--- PILIH RESERVASI ---"
                                );

                                for (int i = 0;
                                     i < jumlahReservasi;
                                     i++) {

                                    System.out.println(
                                        (i + 1) + ". "
                                        + daftarReservasi[i]
                                            .getKodeReservasi()
                                    );
                                }

                                System.out.print(
                                    "Pilih nomor reservasi: "
                                );

                                int nomor;

                                try {

                                    nomor =
                                        Integer.parseInt(
                                            scanner.nextLine()
                                        );

                                } catch (NumberFormatException e) {

                                    System.out.println(
                                        "Input harus berupa angka."
                                    );

                                    break;
                                }

                                if (nomor >= 1 &&
                                    nomor <= jumlahReservasi) {

                                    Reservasi reservasiDipilih =
                                        daftarReservasi[nomor - 1];

                                    prosesReservasi(
                                        reservasiDipilih
                                    );

                                } else {

                                    System.out.println(
                                        "Nomor reservasi tidak valid."
                                    );
                                }
                            }
                        } else {
                            System.out.println("Pilihan tidak valid." );
                        }

                        break;
            

                    case 4:
                        System.out.println("\nTerima kasih telah menggunakan "+ "Sistem Reservasi Ruang Belajar Kampus.");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan menu tidak tersedia.");                           
                }
            }
        }
    }

}