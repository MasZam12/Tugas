package Model;

import java.sql.Timestamp;

public class Kontraktor extends Pengguna {

    private String link;

    public Kontraktor(String idUser, String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String tipePengguna, String link) {
        super(idUser, nama, noHP, email, password, tanggalDaftar, "Kontraktor");
        this.link = link;
    }

    public void displayInfo(Kontraktor akun) {
        super.displayInfo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Link:" + akun.getLink());
    }

    public Kontraktor(String idUser) {
        super(idUser);
    }

    public Kontraktor(String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String link, String tipePengguna) {
        super(nama, noHP, email, password, tanggalDaftar, tipePengguna);
        this.link = link;
    }

    public Kontraktor(String nama, String noHP, String email, String password, Timestamp tanggalDaftar,String link) {
        super(nama, noHP, email, password, tanggalDaftar);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;

    }

    public Kontraktor() {
    }

    public boolean isValidKontraktor(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(email) && enteredPassword.equals(password);
    }

}
