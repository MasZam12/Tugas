package Dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Properti;

public class PropertiDAO extends BaseDAO {

    public Properti getProperti(int propertiId) throws SQLException {
        Properti properti = null;
        String query = "Select * FROM properti WHERE propertiId='%d'";
        query = String.format(query, propertiId);
        PreparedStatement st = ConnectDB().prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            properti = new Properti(
                    rs.getInt("propertiId"),
                    rs.getString("nama"),
                    rs.getString("deskripsi"),
                    rs.getString("lokasi"),
                    rs.getDouble("harga"),
                    rs.getDouble("panjangRumah"),
                    rs.getDouble("lebarRumah"),
                    rs.getDouble("luasRumah"),
                    rs.getString("ketersediaan")) {
            };
        } else {
            System.out.println("Data tidak ditemukan");
            properti = new Properti() {
            };
        }
        return properti;
    }

    public void purchase(Properti properti, int propertiId, String idUser) {
        try {
            String query = "UPDATE revisi.properti SET ketersediaan='Terjual', idUser ='%s' WHERE propertiId = '%d'";
            query = String.format(query, idUser, propertiId);
            PreparedStatement st = ConnectDB().prepareStatement(query);
            st.executeUpdate(query);
            System.out.println("Data berhasil diupdate");
        } catch (SQLException e) {
            System.err.print("Error updating data " + e.getMessage());
        }
    }

    public List<Properti> getSemuaProperti() {
        List<Properti> propertis = new ArrayList<>();
        String query = "SELECT * FROM revisi.properti";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query); ResultSet resultSet = pS.executeQuery()) {

            while (resultSet.next()) {
                int idProperti = resultSet.getInt("propertiId");
                String nama = resultSet.getString("nama");
                String deskripsi = resultSet.getString("deskripsi");
                String lokasi = resultSet.getString("lokasi");
                double harga = resultSet.getDouble("harga");
                double panjangRumah = resultSet.getDouble("panjangRumah");
                double lebarRumah = resultSet.getDouble("lebarRumah");
                double luasRumah = resultSet.getDouble("luasRumah"); // Gunakan nama kolom yang tepat
                double jumlahDiFavoritkan = resultSet.getDouble("jumlahDiFavoritkan");
                String idUser = resultSet.getString("idUser");
                String ketersediaan = resultSet.getString("ketersediaan");
                Timestamp waktuDitambahkan = resultSet.getTimestamp("waktuDitambahkan");
                
                Properti properti = new Properti(idProperti, nama, deskripsi, lokasi, harga, panjangRumah, lebarRumah, luasRumah, jumlahDiFavoritkan,idUser, ketersediaan, waktuDitambahkan);
                propertis.add(properti);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal mengambil data properti: " + e.getMessage());
        }
        return propertis;
    }

    public void tambahProperti(Properti properti) {
        String query = "INSERT INTO revisi.properti (nama, deskripsi, lokasi, harga, panjangRumah, lebarRumah, luasRumah, jumlahDifavoritkan, ketersediaan, waktuDitambahkan, idUser) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setString(1, properti.getNama());
            pS.setString(2, properti.getDeskripsi());
            pS.setString(3, properti.getLokasi());
            pS.setDouble(4, properti.getHarga());
            pS.setDouble(5, properti.getPanjangRumah());
            pS.setDouble(6, properti.getLebarRumah());
            pS.setDouble(7, (properti.getLebarRumah() * properti.getPanjangRumah()));
            pS.setDouble(8, properti.getJumlahDiFavoritkan());
            pS.setString(9, properti.getKetersediaan());
            pS.setTimestamp(10, properti.getWaktuDitambahkan());
            pS.setNull(11, 0);

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dimasukkan ke tabel properti.");
            } else {
                System.out.println("Gagal memasukkan data ke tabel properti.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memasukkan data ke tabel properti: " + e.getMessage());
        }
    }

    public void updateProperti(Properti properti) {
        String query = "UPDATE revisi.properti SET nama=?, deskripsi=?, lokasi=?, harga=?, panjangRumah=?, lebarRumah=?, luasRumah=?, ketersediaan=?, idUser=? WHERE propertiId=?";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setString(1, properti.getNama());
            pS.setString(2, properti.getDeskripsi());
            pS.setString(3, properti.getLokasi());
            pS.setDouble(4, properti.getHarga());
            pS.setDouble(5, properti.getPanjangRumah());
            pS.setDouble(6, properti.getLebarRumah());
            pS.setDouble(7, properti.getLebarRumah() * properti.getPanjangRumah());
            pS.setString(8, properti.getKetersediaan());
            pS.setString(9, properti.getIdUser());
            pS.setInt(10, properti.getPropertiId());

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data properti berhasil diperbarui.");
            } else {
                System.out.println("Gagal memperbarui data properti.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memperbarui data properti: " + e.getMessage());
        }
    }

    public void hapusProperti(int propertiId) {
        String query = "DELETE FROM revisi.properti WHERE propertiId = ?";
        try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
            pS.setInt(1, propertiId);

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dihapus dari tabel properti.");
            } else {
                System.out.println("Gagal menghapus data dari tabel properti.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal menghapus data dari tabel properti: " + e.getMessage());
        }
    }

    public List<Properti> searchByLoc(String search) {
    List<Properti> matchLoc = new ArrayList<>();
    String query = "SELECT * FROM revisi.properti WHERE lokasi LIKE ? OR ketersediaan LIKE ?";

    try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
        pS.setString(1, "%" + search + "%");
        pS.setString(2, "%" + search + "%");
        ResultSet resultSet = pS.executeQuery();

        while (resultSet.next()) {
            Properti properti = new Properti(
                    resultSet.getInt("propertiId"),
                    resultSet.getString("nama"),
                    resultSet.getString("deskripsi"),
                    resultSet.getString("lokasi"),
                    resultSet.getDouble("harga"),
                    resultSet.getDouble("panjangRumah"),
                    resultSet.getDouble("lebarRumah"),
                    resultSet.getDouble("luasRumah"),
                    resultSet.getDouble("jumlahDiFavoritkan"),
                    resultSet.getString("idUser"),
                    resultSet.getString("ketersediaan"),
                    resultSet.getTimestamp("waktuDitambahkan")
            );
            matchLoc.add(properti);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Gagal melakukan pencarian berdasarkan lokasi: " + e.getMessage());
    }

    return matchLoc;
}

    public List<Properti> userPemilik(String idUser) {
    List<Properti> matchLoc = new ArrayList<>();
    String query = "SELECT * FROM revisi.properti WHERE idUser = ?";

    try (PreparedStatement pS = ConnectDB().prepareStatement(query)) {
        pS.setString(1, idUser);
        ResultSet resultSet = pS.executeQuery();

        while (resultSet.next()) {
            Properti properti = new Properti(
                    resultSet.getInt("propertiId"),
                    resultSet.getString("nama"),
                    resultSet.getString("deskripsi"),
                    resultSet.getString("lokasi"),
                    resultSet.getDouble("harga"),
                    resultSet.getDouble("panjangRumah"),
                    resultSet.getDouble("lebarRumah"),
                    resultSet.getDouble("luasRumah"),
                    resultSet.getDouble("jumlahDiFavoritkan"),
                    resultSet.getString("idUser"),
                    resultSet.getString("ketersediaan"),
                    resultSet.getTimestamp("waktuDitambahkan")
            );
            matchLoc.add(properti);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Gagal melakukan pencarian berdasarkan lokasi: " + e.getMessage());
    }

    return matchLoc;
}

}
