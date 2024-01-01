package Dao;

import Dao.BaseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import Model.Pembeli;
import static Dao.BaseDAO.ConnectDB;

/**
 *
 * @author usama
 */
public class PembeliDAO extends BaseDAO {

    public boolean isValidPembeli(String enteredUsername, String enteredPassword) {
        return getIdUserPembeli(enteredUsername, enteredPassword) != null;
    }
    
    public String getIdUserPembeli(String enteredUsername, String enteredPassword) {
        String query = "SELECT idUser FROM revisi.pengguna WHERE nama = ? AND password = ? AND tipePengguna = 'Pembeli'";
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
        return null; // Return -1 jika data pengguna tidak ditemukan
    }

    public Pembeli infoAkun(String idUser) throws SQLException {
        Pembeli akun = new Pembeli();
        String query = "SELECT * FROM revisi.pengguna WHERE idUser = ?";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setString(1, idUser);
            ResultSet rs = pS.executeQuery();

            if (rs.next()) {
                akun = new Pembeli(
                        rs.getString("nama"),
                        rs.getString("noHP"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getTimestamp("tanggalDaftar"),
                        rs.getInt("jumlahTerbeli"),
                        rs.getInt("favorit")
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
    
    public List<Pembeli> getSemuaPembeli() {
        List<Pembeli> pembelis = new ArrayList<>();
        String query = "SELECT * FROM revisi.pengguna WHERE tipePengguna='Pembeli'";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query); ResultSet resultSet = pS.executeQuery()) {

            while (resultSet.next()) {
                String idUser = resultSet.getString("idUser");
                String nama = resultSet.getString("nama");
                String noHP = resultSet.getString("noHP");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Timestamp tanggalDaftar = resultSet.getTimestamp("tanggalDaftar");
                int jumlahTerbeli = resultSet.getInt("jumlahTerbeli");
                int favorit = resultSet.getInt("favorit");
                Pembeli pembeli = new Pembeli(idUser, nama, noHP, email, password, tanggalDaftar, "Pembeli", jumlahTerbeli, favorit);
                pembelis.add(pembeli);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal mengambil data pembeli: " + e.getMessage());
        }
        return null;
    }

    public List<Pembeli> getidUserPembeli() {
        List<Pembeli> idPembeli = new ArrayList<>();
        String query = "SELECT * FROM revisi.pengguna WHERE tipePengguna='Pembeli'";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query); ResultSet resultSet = pS.executeQuery()) {

            while (resultSet.next()) {
                String idUser = resultSet.getString("idUser");
                Pembeli idP = new Pembeli(idUser);
                idPembeli.add(idP);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal mengambil data pembeli: " + e.getMessage());
        }
        return null;
    }

    public void tambahPembeli(Pembeli pembeli) {
        String query = "INSERT INTO revisi.pengguna (nama, noHP, email, password, tanggalDaftar, jumlahTerbeli, favorit, tipePengguna) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setString(1, pembeli.getNama());
            pS.setString(2, pembeli.getNoHP());
            pS.setString(3, pembeli.getEmail());
            pS.setString(4, pembeli.getPassword());
            pS.setTimestamp(5, pembeli.getTanggalDaftar());
            pS.setInt(6, pembeli.getJumlahTerbeli());
            pS.setInt(7, pembeli.getFavorit());
            pS.setString(8, pembeli.getTipePengguna());

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dimasukkan ke tabel pembeli.");
            } else {
                System.out.println("Gagal memasukkan data ke tabel pembeli.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memasukkan data ke tabel pembeli: " + e.getMessage());
        }

    }

    public void updatePembeli(Pembeli pembeli) {
        String query = "UPDATE revisi.pengguna SET nama=?, noHP=?, email=?, password=? WHERE idUser=?";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setString(1, pembeli.getNama());
            pS.setString(2, pembeli.getNoHP());
            pS.setString(3, pembeli.getEmail());
            pS.setString(4, pembeli.getPassword());
            //pS.setTimestamp(5, pembeli.getTanggalDaftar());
            //pS.setInt(6, pembeli.getJumlahTerbeli());
            //pS.setInt(7, pembeli.getFavorit());
            pS.setString(5, pembeli.getIdUser());

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data pembeli berhasil diperbarui.");
            } else {
                System.out.println("Gagal memperbarui data pembeli.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memperbarui data pembeli: " + e.getMessage());
        }
    }

    public Pembeli hapusPembeli(String idUser) {
        String query = "DELETE FROM revisi.pengguna WHERE idUser = ?";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setString(1, idUser);

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dihapus dari tabel pembeli.");
            } else {
                System.out.println("Gagal menghapus data dari tabel pembeli.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal menghapus data dari tabel pembeli: " + e.getMessage());
        }
        return null;
    }

}
