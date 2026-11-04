package com.mycompany.sistemreservasiruangbelajarkampus;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemReservasiRuangBelajarKampus {
public static void cariReservasi(
    String kode,
    ArrayList<Reservasi> daftarReservasi) {

     boolean ditemukan = false;

    System.out.println("\nHasil pencarian kode: " + kode);

    for (Reservasi r : daftarReservasi) {
        if (r.getKodeReservasi().equalsIgnoreCase(kode)) {
            r.tampilkanInfo();
            r.cekFasilitas();
            ditemukan = true;
            break;
        }
    }

    if (!ditemukan) {
        System.out.println("Data reservasi tidak ditemukan.");
    }
}

public static void cariReservasi(
        String nama,
        String tanggal,
        ArrayList<Reservasi> daftarReservasi) {

    boolean ditemukan = false;

    System.out.println("\nHasil pencarian nama dan tanggal:");

    for (Reservasi r : daftarReservasi) {
        if (r.getPengguna().getNama().equalsIgnoreCase(nama)
                && r.getTanggal().equalsIgnoreCase(tanggal)) {

            r.tampilkanInfo();
            r.cekFasilitas();
            ditemukan = true;
        }
    }
        if (!ditemukan) {
        System.out.println(
            "Data pemesan dan tanggal tidak ditemukan."
        );
    }
    }
public static void tampilkanSemua(
        ArrayList<Reservasi> daftarReservasi) {

    System.out.println("\n====== DAFTAR RESERVASI ======");

    if (daftarReservasi.isEmpty()) {
        System.out.println("Belum ada data reservasi.");
        return;
    }

    for (int i = 0; i < daftarReservasi.size(); i++) {
        System.out.println("\nData ke-" + (i + 1));
        daftarReservasi.get(i).tampilkanInfo();
        daftarReservasi.get(i).cekFasilitas();
    }

    System.out.println("\nTotal reservasi: "
            + daftarReservasi.size());
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
            
            if (reservasi instanceof DapatDipesan) {
                DapatDipesan dapatDipesan =
                    (DapatDipesan) reservasi;

                dapatDipesan.konfirmasiPemesanan();
            }

            if (reservasi instanceof DapatDicekFasilitas) {
                DapatDicekFasilitas dapatDicek =
                    (DapatDicekFasilitas) reservasi;

                dapatDicek.tampilkanFasilitasTambahan();
            }

            System.out.println(
                "Reservasi berhasil diproses.");  
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
                            
                 PengelolaReservasi pengelola =
                         new PengelolaReservasi();

                 
                 ArrayList<Reservasi> daftarReservasi =
                         pengelola.getDaftarReservasi();

                
                 pengelola.tambahPengguna(
                         new Pengguna("Alya Putri", "251101001", "081234567890")
                 );

                 pengelola.tambahPengguna(
                         new Pengguna("Bima Saputra", "251101002", "082345678901")
                 );

                 pengelola.tambahPengguna(
                         new Pengguna("Citra Lestari", "251101003", "083456789012")
                 );
           
           pengelola.tambahReservasi(
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
                    true
                )
            );

         
           pengelola.tambahReservasi(
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
                    "Lab Pemrograman"
                )
            );

          
            pengelola.tambahReservasi(
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
                    false
                )
            );

          
            pengelola.tambahReservasi(
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
                )
            );
            System.out.println(
                "====================================================");
            System.out.println(
                "       SISTEM RESERVASI RUANG BELAJAR KAMPUS       ");
            System.out.println(
                "====================================================");
            boolean isRunning = true;

            while (isRunning){
            System.out.println("\n---------------- MENU UTAMA ----------------");
            System.out.println("1. Tambah Data Reservasi");
            System.out.println("2. Tampilkan Seluruh Data");
            System.out.println("3. Pencarian / Aksi Khusus");
            System.out.println("4. Kelola Pengguna (HashMap)");
            System.out.println("5. Lihat Fasilitas Kampus (Composition)");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
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
                        System.out.println("\n--- TAMBAH RESERVASI ---");
                        System.out.println("1. Ruang Kelas");
                        System.out.println("2. Laboratorium");
                        System.out.println("3. Ruang Seminar");
                        System.out.print("Pilih tipe ruangan (1-3): ");

                        int jenis;

                        try {
                            jenis = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Pilihan harus berupa angka.");
                            break;
                        }

                        if (jenis < 1 || jenis > 3) {
                            System.out.println("Jenis ruangan tidak valid.");
                            break;
                        }

                        System.out.print("Kode reservasi: ");
                        String kode = scanner.nextLine();

                        boolean kodeSudahAda = false;

                        for (Reservasi r : daftarReservasi) {
                            if (r.getKodeReservasi().equalsIgnoreCase(kode)) {
                                kodeSudahAda = true;
                                break;
                            }
                        }

                        if (kode.trim().isEmpty() || kodeSudahAda) {
                            System.out.println("Kode kosong atau sudah digunakan.");
                            break;
                        }

                        System.out.print("Nama pemesan: ");
                        String nama = scanner.nextLine();

                        System.out.print("NIM: ");
                        String nim = scanner.nextLine();

                        System.out.print("Nomor HP: ");
                        String nomorHP = scanner.nextLine();

                        System.out.print("Tanggal reservasi (dd-mm-yyyy): ");
                        String tanggal = scanner.nextLine();

                        System.out.print("Durasi (jam): ");

                        int durasi;

                        try {
                            durasi = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Durasi harus berupa angka.");
                            break;
                        }

                        if (nama.trim().isEmpty() || nim.trim().isEmpty()
                                || nomorHP.trim().isEmpty()
                                || tanggal.trim().isEmpty()
                                || durasi < 1 || durasi > 12) {
                            System.out.println("Data tidak valid. Periksa kembali input.");
                            break;
                        }

                        Pengguna pengguna = new Pengguna(nama, nim, nomorHP);

                        if (jenis == 1) {
                            System.out.print("Kapasitas ruangan: ");
                            int kapasitas;

                            try {
                                kapasitas = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Kapasitas harus berupa angka.");
                                break;
                            }

                            if (kapasitas < 5 || kapasitas > 100) {
                                System.out.println("Kapasitas harus 5-100 orang.");
                                break;
                            }

                            System.out.print("Memiliki proyektor? (y/n): ");
                            boolean proyektor =
                                    scanner.nextLine().equalsIgnoreCase("y");

                            pengelola.tambahReservasi(
                                new RuangKelas(
                                    kode, pengguna, tanggal,
                                    durasi, kapasitas, proyektor
                                )
                            );

                        } else if (jenis == 2) {
                            System.out.print("Jenis laboratorium: ");
                            String jenisLab = scanner.nextLine();

                            System.out.print("Jumlah komputer: ");
                            int komputer;

                            try {
                                komputer = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Jumlah komputer harus berupa angka.");
                                break;
                            }

                            if (jenisLab.trim().isEmpty() || komputer < 1) {
                                System.out.println("Data laboratorium tidak valid.");
                                break;
                            }

                           pengelola.tambahReservasi(
                                new RuangLaboratorium(
                                    kode, pengguna, tanggal,
                                    durasi, komputer, jenisLab
                                )
                            );

                        } else if (jenis == 3) {
                            System.out.print("Kapasitas seminar: ");
                            int kapasitas;

                            try {
                                kapasitas = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Kapasitas harus berupa angka.");
                                break;
                            }

                            if (kapasitas < 10 || kapasitas > 300) {
                                System.out.println("Kapasitas harus 10-300 orang.");
                                break;
                            }

                            System.out.print("Memiliki sound system? (y/n): ");
                            boolean soundSystem =
                                    scanner.nextLine().equalsIgnoreCase("y");

                            pengelola.tambahReservasi(
                                new RuangSeminar(
                                    kode, pengguna, tanggal,
                                    durasi, kapasitas, soundSystem
                                )
                            );
                        }
                        pengelola.tambahPengguna(pengguna);

                        System.out.println("Reservasi berhasil ditambahkan.");
                        break;


                    
                    case 2: {
                        tampilkanSemua(daftarReservasi);
                        break;
                    }

                    case 3: {
                        System.out.println("\n--- PENCARIAN / AKSI KHUSUS ---");
                        System.out.println("1. Cari berdasarkan kode reservasi");
                        System.out.println("2. Cari berdasarkan nama dan tanggal");
                        System.out.println("3. Proses Reservasi");
                        System.out.print("Pilih (1/2/3): ");

                        int mode;

                        try {
                            mode = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Pilihan harus berupa angka.");
                            break;
                        }

                        if (mode == 1) {
                            System.out.print("Masukkan kode reservasi: ");
                            String kodeCari = scanner.nextLine();

                            cariReservasi(kodeCari, daftarReservasi);

                        } else if (mode == 2) {
                            System.out.print("Masukkan nama pemesan: ");
                            String namaCari = scanner.nextLine();

                            System.out.print("Masukkan tanggal: ");
                            String tanggalCari = scanner.nextLine();

                            cariReservasi(namaCari, tanggalCari, daftarReservasi);

                        } else if (mode == 3) {

                            if (daftarReservasi.isEmpty()) {
                                System.out.println("Belum ada data reservasi.");

                            } else {
                                System.out.println("\n--- PILIH RESERVASI ---");

                                for (int i = 0; i < daftarReservasi.size(); i++) {
                                    System.out.println(
                                        (i + 1) + ". " +
                                        daftarReservasi.get(i).getKodeReservasi()
                                    );
                                }

                                System.out.print("Pilih nomor reservasi: ");

                                int nomor;

                                try {
                                    nomor = Integer.parseInt(scanner.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Input harus berupa angka.");
                                    break;
                                }

                                if (nomor >= 1 && nomor <= daftarReservasi.size()) {
                            Reservasi reservasiDipilih =
                                        daftarReservasi.get(nomor - 1);

                                TransaksiReservasi.prosesTransaksi(
                                        reservasiDipilih.getPengguna(),
                                        reservasiDipilih
                                );

                                } else {
                                    System.out.println("Nomor reservasi tidak valid.");
                                }
                            }

                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }

                        break;
                    }

                    case 4: {

                        System.out.println("\n--- KELOLA PENGGUNA ---");

                        System.out.println("1. Tambah Pengguna");
                        System.out.println("2. Cari Pengguna");
                        System.out.println("3. Tampilkan Semua Pengguna");

                        System.out.print("Pilih: ");

                        int menuAnggota;

                        try {
                            menuAnggota = Integer.parseInt(scanner.nextLine());

                        } catch (NumberFormatException e) {

                            System.out.println("Pilihan harus berupa angka.");
                            break;
                        }

                        if (menuAnggota == 1) {

                            System.out.print("Masukkan NIM: ");
                            String nimBaru = scanner.nextLine();

                            System.out.print("Masukkan Nama: ");
                            String namaBaru = scanner.nextLine();

                            System.out.print("Masukkan Nomor HP: ");
                            String hpBaru = scanner.nextLine();

                            if (nimBaru.trim().isEmpty()
                                    || namaBaru.trim().isEmpty()
                                    || hpBaru.trim().isEmpty()) {

                                System.out.println("Data tidak boleh kosong.");

                            } else if (pengelola.cariPengguna(nimBaru) != null) {

                                System.out.println("NIM sudah terdaftar.");

                            } else {

                                pengelola.tambahPengguna(
                                        new Pengguna(namaBaru, nimBaru, hpBaru)
                                );
                            }

                        } else if (menuAnggota == 2) {

                            System.out.print("Masukkan NIM yang dicari: ");

                            String cariNim = scanner.nextLine();

                            Pengguna ditemukan =
                                    pengelola.cariPengguna(cariNim);

                            if (ditemukan != null) {

                                System.out.println("\nPengguna ditemukan:");

                                ditemukan.tampilkanPengguna();

                            } else {

                                System.out.println("Pengguna tidak ditemukan.");
                            }

                        } else if (menuAnggota == 3) {

                            pengelola.tampilkanSemuaPengguna();

                        } else {

                            System.out.println("Pilihan tidak tersedia.");
                        }

                        break;
                    }
                    case 5: {

                        System.out.println("\n--- INFORMASI FASILITAS KAMPUS ---");

                        pengelola.tampilkanFasilitasKampus();

                        break;
                    }
                    case 6: {
                        System.out.println(
                            "Terima kasih telah menggunakan " +
                            "Sistem Reservasi Ruang Belajar Kampus."
                        );

                        isRunning = false;
                        break;
                    }

                    default:
                        System.out.println("Pilihan menu tidak tersedia.");

                } 
            } 
        } 
    } 
} 