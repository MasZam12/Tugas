package Model;

import java.sql.Timestamp;

public class Properti {

    private int propertiId;
    private String nama;
    private String deskripsi;
    private String lokasi;
    private double harga;
    private double panjangRumah;
    private double lebarRumah;
    private double luasRumah;
    private double jumlahDiFavoritkan;
    private String idUser; // Menunjukkan pemilik Properti
    private String ketersediaan;
    private Timestamp waktuDitambahkan; // Tambahkan atribut waktuDitambahkan
    private String gambar;

    // Constructor
    public Properti(String nama, String deskripsi, String lokasi, double harga, double panjangRumah, double lebarRumah, double luasRumah, double jumlahDiFavoritkan, String ketersediaan, Timestamp waktuDitambahkan, String idUser, String gambar) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.harga = harga;
        this.panjangRumah = panjangRumah;
        this.lebarRumah = lebarRumah;
        this.luasRumah = panjangRumah * lebarRumah;
        this.jumlahDiFavoritkan = jumlahDiFavoritkan;
        this.ketersediaan = ketersediaan;
        this.waktuDitambahkan = waktuDitambahkan; // Inisialisasi atribut waktuDitambahkan
        this.idUser = idUser;
        this.gambar = gambar;
    }

    public Properti(int propertiId, String nama, String deskripsi, String lokasi, double harga, double panjangRumah, double lebarRumah, double luasRumah, double jumlahDiFavoritkan,String idUser, String ketersediaan, Timestamp waktuDitambahkan) {
        this.propertiId = propertiId;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.harga = harga;
        this.panjangRumah = panjangRumah;
        this.lebarRumah = lebarRumah;
        this.luasRumah = luasRumah;
        this.jumlahDiFavoritkan = jumlahDiFavoritkan;
        this.ketersediaan = ketersediaan;
        this.waktuDitambahkan = waktuDitambahkan;
        this.idUser = idUser;
    }

    public Properti(int propertiId, String nama, String deskripsi, String lokasi, double harga, double panjangRumah, double lebarRumah, double luasRumah, String idUser, String ketersediaan, Timestamp waktuDitambahkan) {
        this.propertiId = propertiId;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.harga = harga;
        this.panjangRumah = panjangRumah;
        this.lebarRumah = lebarRumah;
        this.luasRumah = luasRumah;
        this.idUser = idUser;
        this.ketersediaan = ketersediaan;
        this.waktuDitambahkan = waktuDitambahkan;
    }

    public Properti(String nama, String deskripsi, String lokasi, double harga, double panjangRumah, double lebarRumah, double luasRumah, double jumlahDiFavoritkan, String ketersediaan, Timestamp waktuDitambahkan) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.harga = harga;
        this.panjangRumah = panjangRumah;
        this.lebarRumah = lebarRumah;
        this.luasRumah = luasRumah;
        this.jumlahDiFavoritkan = jumlahDiFavoritkan;
        this.ketersediaan = ketersediaan;
        this.waktuDitambahkan = waktuDitambahkan;
    }

    public Properti(int propertiId, String nama, String deskripsi, String lokasi, double harga, double panjangRumah, double lebarRumah, double luasRumah, String ketersediaan) {
        this.propertiId = propertiId;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.harga = harga;
        this.panjangRumah = panjangRumah;
        this.lebarRumah = lebarRumah;
        this.luasRumah = luasRumah;
        this.ketersediaan = ketersediaan;
    }

    public Properti(String nama, String deskripsi, String lokasi, double harga, double panjangRumah, double luasRumah, double jumlahDiFavoritkan, String ketersediaan, Timestamp waktuDitambahkan) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.harga = harga;
        this.panjangRumah = panjangRumah;
        this.lebarRumah = lebarRumah;
        this.luasRumah = panjangRumah * lebarRumah;
        this.jumlahDiFavoritkan = jumlahDiFavoritkan;
        this.ketersediaan = ketersediaan;
        this.waktuDitambahkan = waktuDitambahkan; // Inisialisasi atribut waktuDitambahkan
    }

    public Properti() {
    }

    // Getter and Setter for waktuDitambahkan
    public Timestamp getWaktuDitambahkan() {
        return waktuDitambahkan;
    }

    public void setWaktuDitambahkan(Timestamp waktuDitambahkan) {
        this.waktuDitambahkan = waktuDitambahkan;
    }

    public int getPropertiId() {
        return propertiId;
    }

    public void setPropertiId(int propertiId) {
        this.propertiId = propertiId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getPanjangRumah() {
        return panjangRumah;
    }

    public void setPanjangRumah(double panjangRumah) {
        this.panjangRumah = panjangRumah;
    }

    public double getLebarRumah() {
        return lebarRumah;
    }

    public void setLebarRumah(double lebarRumah) {
        this.lebarRumah = lebarRumah;
    }

//    public double getLuasRumah(double panjangRumah, double lebarRumah) {
//        return luasRumah = panjangRumah * lebarRumah;
//    }
//
//    public void setLuasRumah(double luasRumah) {
//        this.luasRumah = luasRumah;
//    }

    public double getLuasRumah() {
        return luasRumah;
    }

    public void setLuasRumah(double luasRumah) {
        this.luasRumah = luasRumah;
    }
    

    public double getJumlahDiFavoritkan() {
        return jumlahDiFavoritkan;
    }

    public void setJumlahDiFavoritkan(double jumlahDiFavoritkan) {
        this.jumlahDiFavoritkan = jumlahDiFavoritkan;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getKetersediaan() {
        return ketersediaan;
    }

    public void setKetersediaan(String ketersediaan) {
        this.ketersediaan = ketersediaan;
    }
    
    public String getGambar(){
        return gambar;
    }

    public void displayProperti(Properti i) {
        System.out.println("ID Properti: " + i.propertiId);
        System.out.println("Nama: " + i.nama);
        System.out.println("Deskripsi: " + i.deskripsi);
        System.out.println("Lokasi: " + i.lokasi);
        System.out.println("Harga: " + i.harga);
        System.out.println("Panjang Rumah: " + i.panjangRumah);
        System.out.println("Lebar Rumah: " + i.lebarRumah);
        System.out.println("Luas Rumah: " + i.luasRumah);
        System.out.println("Jumlah di Favoritkan: " + i.jumlahDiFavoritkan);
        System.out.println("ID Pemilik Properti: " + i.idUser);
        System.out.println("Ketersediaan: " + i.ketersediaan);
        System.out.println("Waktu Ditambahkan: " + i.waktuDitambahkan);
    }

}
