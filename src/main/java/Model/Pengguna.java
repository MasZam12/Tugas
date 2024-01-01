package Model;

import java.sql.Timestamp;

public class Pengguna {

    private String idUser;
    String nama;
    private String noHP;
    String email;
    String password;
    private java.sql.Timestamp tanggalDaftar;
    private String tipePengguna;

    public Pengguna(String nama, String noHP, String email, String password, Timestamp tanggalDaftar) {
        this.nama = nama;
        this.noHP = noHP;
        this.email = email;
        this.password = password;
        this.tanggalDaftar = tanggalDaftar;
    }

    public Pengguna(String nama, String noHP, String email, String password) {
        this.nama = nama;
        this.noHP = noHP;
        this.email = email;
        this.password = password;
    }

    public Pengguna(String idUser, String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String tipePengguna) {
        this.idUser = idUser;
        this.nama = nama;
        this.noHP = noHP;
        this.email = email;
        this.password = password;
        this.tanggalDaftar = tanggalDaftar;
        this.tipePengguna = tipePengguna;
    }

    public Pengguna(String idUser) {
        this.idUser = idUser;
    }

    public Pengguna(String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String tipePengguna) {
        this.nama = nama;
        this.noHP = noHP;
        this.email = email;
        this.password = password;
        this.tanggalDaftar = tanggalDaftar;
        this.tipePengguna = tipePengguna;
    }

    public Pengguna() {
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Nomor HP: " + noHP);
        System.out.println("Email: " + email);
        System.out.println("Tanggal Daftar: " + tanggalDaftar);
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getTanggalDaftar() {
        return tanggalDaftar;
    }

    public void setTanggalDaftar(Timestamp tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
    }

    public String getTipePengguna() {
        return tipePengguna;
    }

    public void setTipePengguna(String tipePengguna) {
        this.tipePengguna = tipePengguna;
    }

}
