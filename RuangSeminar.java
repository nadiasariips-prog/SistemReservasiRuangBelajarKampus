package com.mycompany.sistemreservasiruangbelajarkampus;
public class RuangSeminar extends Reservasi {
    private int kapasitas;
    private boolean memilikiSoundSystem;
    public RuangSeminar(
            String kodeReservasi,
            Pengguna pengguna,
            String tanggal,
            int durasiJam,
            int kapasitas,
            boolean memilikiSoundSystem) {
        super(
            kodeReservasi,
            pengguna,
            tanggal,
            durasiJam);
        setKapasitas(kapasitas);
        setMemilikiSoundSystem(memilikiSoundSystem);
    }
    public int getKapasitas() {
        return this.kapasitas;
    }
    public void setKapasitas(int kapasitas) {

        if (kapasitas >= 10 && kapasitas <= 300) {
            this.kapasitas = kapasitas;
        } else {
            this.kapasitas = 10;
        }
    }
    public boolean isMemilikiSoundSystem() {
        return this.memilikiSoundSystem;
    }
    public void setMemilikiSoundSystem(
            boolean memilikiSoundSystem) {

        this.memilikiSoundSystem =
                memilikiSoundSystem;
    }
    @Override
    public void tampilkanInfo() {

        super.tampilkanInfo();

        System.out.printf(
            "         Jenis: Ruang Seminar | Kapasitas: %d orang | Sound System: %s%n",
            this.kapasitas,
            this.memilikiSoundSystem
                ? "Tersedia"
                : "Tidak tersedia"
        );
    }
    @Override
    public void cekFasilitas() {

        super.cekFasilitas();

        System.out.println(
            "         Fasilitas: kursi peserta, meja, proyektor, dan sound system."
        );
    }
}