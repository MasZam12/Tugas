package Model;

import java.sql.Timestamp;

public class Pembeli extends Pengguna {

    private int jumlahTerbeli;
    private int favorit;

    public Pembeli(String idUser, String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String tipePengguna, int jumlahTerbeli, int favorit) {
        super(idUser, nama, noHP, email, password, tanggalDaftar, "Pembeli");
        this.jumlahTerbeli = jumlahTerbeli;
        this.favorit = favorit;
    }

    public Pembeli(String idUser) {
        super(idUser);
    }

    public Pembeli(String nama, String noHP, String email, String password) {
        super(nama, noHP, email, password);
    }

    public Pembeli(String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String tipePengguna) {
        super(nama, noHP, email, password, tanggalDaftar, tipePengguna);
    }

    public Pembeli(String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String tipePengguna, int jumlahTerbeli) {
        super(nama, noHP, email, password, tanggalDaftar, tipePengguna);
        this.jumlahTerbeli = jumlahTerbeli;
    }

    public Pembeli(String nama, String noHP, String email, String password, Timestamp tanggalDaftar, int jumlahTerbeli, int favorit) {
        super(nama, noHP, email, password, tanggalDaftar);
        this.jumlahTerbeli = jumlahTerbeli;
        this.favorit = favorit;
    }

    public Pembeli() {
    }

    public boolean isValidPembeli(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(email) && enteredPassword.equals(password);
    }

    public void displayInfo(Pembeli akun) {
        super.displayInfo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("JumlahTerbeli:" + akun.getJumlahTerbeli());
        System.out.println("jumlahFavorit  :" + akun.getFavorit());
    }

    public int getJumlahTerbeli() {
        return jumlahTerbeli;
    }

    public void setJumlahTerbeli(int jumlahTerbeli) {
        this.jumlahTerbeli = jumlahTerbeli;
    }

    public int getFavorit() {
        return favorit;
    }

    public void setFavorit(int favorit) {
        this.favorit = favorit;
    }
}
