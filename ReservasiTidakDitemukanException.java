package com.mycompany.sistemreservasiruangbelajarkampus;

public class ReservasiTidakDitemukanException extends Exception {

    public ReservasiTidakDitemukanException(String pesan) {
        super(pesan);
    }
}