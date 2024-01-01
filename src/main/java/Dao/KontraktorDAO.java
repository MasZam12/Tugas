package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import Model.Kontraktor;
import static Dao.BaseDAO.ConnectDB;

public class KontraktorDAO extends BaseDAO {

    public boolean isValidKontraktor(String enteredUsername, String enteredPassword) {
        return getIdUserKontraktor(enteredUsername, enteredPassword) != null;
    }

    public String getIdUserKontraktor(String enteredUsername, String enteredPassword) {
        String query = "SELECT idUser FROM revisi.pengguna WHERE nama = ? AND password = ? AND tipePengguna = 'Kontraktor'";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setString(1, enteredUsername);
            pS.setString(2, enteredPassword);

            ResultSet resultSet = pS.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("idUser");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memeriksa login: " + e.getMessage());
        }
        return null;
    }

    public Kontraktor infoAkun(String idUser) throws SQLException {
        Kontraktor akun = null;
        String query = "SELECT * FROM revisi.pengguna WHERE idUser = ?";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setString(1, idUser);
            ResultSet rs = pS.executeQuery();

            if (rs.next()) {
                akun = new Kontraktor(
                        rs.getString("nama"),
                        rs.getString("noHP"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getTimestamp("tanggalDaftar"),
                        rs.getString("link")
                );
                akun.setIdUser(idUser);
            } else {
                System.out.println("Data tidak ditemukan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal mengambil data akun: " + e.getMessage());
            throw e;
        }
        return akun;
    }

    public List<Kontraktor> getSemuaKontraktor() {
        List<Kontraktor> kontraktors = new ArrayList<>();
        String query = "SELECT * FROM revisi.pengguna WHERE tipePengguna='Kontraktor'";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query); ResultSet resultSet = pS.executeQuery()) {

            while (resultSet.next()) {
                String idUser = resultSet.getString("idUser");
                String nama = resultSet.getString("nama");
                String noHP = resultSet.getString("noHP");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Timestamp tanggalDaftar = resultSet.getTimestamp("tanggalDaftar");
                String link = resultSet.getString("link");
                Kontraktor kontraktor = new Kontraktor(idUser, nama, noHP, email, password, tanggalDaftar, "Kontraktor", link);
                kontraktors.add(kontraktor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal mengambil data kontraktor: " + e.getMessage());
        }
        return kontraktors;
    }

    public List<Kontraktor> getidUserKontraktor() {
        List<Kontraktor> idKontraktor = new ArrayList<>();
        String query = "SELECT * FROM revisi.pengguna WHERE tipePengguna='Pembeli'";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query); ResultSet resultSet = pS.executeQuery()) {

            while (resultSet.next()) {
                String idUser = resultSet.getString("idUser");
                Kontraktor idK = new Kontraktor(idUser);
                idKontraktor.add(idK);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal mengambil data pembeli: " + e.getMessage());
        }
        return null;
    }

    public void tambahKontraktor(Kontraktor kontraktor) {
        String query = "INSERT INTO revisi.pengguna (nama, noHP, email, password, tanggalDaftar, link, tipePengguna) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setString(1, kontraktor.getNama());
            pS.setString(2, kontraktor.getNoHP());
            pS.setString(3, kontraktor.getEmail());
            pS.setString(4, kontraktor.getPassword());
            pS.setTimestamp(5, kontraktor.getTanggalDaftar());
            pS.setString(6, kontraktor.getLink());
            pS.setString(7, kontraktor.getTipePengguna());

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dimasukkan ke tabel kontraktor.");
            } else {
                System.out.println("Gagal memasukkan data ke tabel kontraktor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memasukkan data ke tabel kontraktor: " + e.getMessage());
        }
    }

    public void updateKontraktor(Kontraktor kontraktor) {
        String query = "UPDATE revisi.pengguna SET nama=?, noHP=?, email=?, password=?, link=? WHERE idUser=?";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setString(1, kontraktor.getNama());
            pS.setString(2, kontraktor.getNoHP());
            pS.setString(3, kontraktor.getEmail());
            pS.setString(4, kontraktor.getPassword());
            //pS.setTimestamp(5, kontraktor.getTanggalDaftar());
            pS.setString(5, kontraktor.getLink());
            //pS.setString(7, kontraktor.getTipePengguna());
            pS.setString(6, kontraktor.getIdUser());

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data kontraktor berhasil diperbarui.");
            } else {
                System.out.println("Gagal memperbarui data kontraktor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memperbarui data kontraktor: " + e.getMessage());
        }
    }

    public void hapusKontraktor(String idUser) {
        String query = "DELETE FROM revisi.pengguna WHERE idUser = ?";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setString(1, idUser);

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dihapus dari tabel kontraktor.");
            } else {
                System.out.println("Gagal menghapus data dari tabel kontraktor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal menghapus data dari tabel kontraktor: " + e.getMessage());
        }
    }

}
