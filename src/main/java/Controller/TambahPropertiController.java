package Controller;

import Dao.PropertiDAO;
import Model.Properti;
import Other.AlertMessage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TambahPropertiController implements Initializable {

    @FXML
    private TextField tambahDeskripsiProperti;

    @FXML
    private StackPane tambahPropertiForm;

    @FXML
    private TextField tambahHargaProperti;

    @FXML
    private TextField tambahLebarProperti;

    @FXML
    private TextField tambahLokasiProperti;

    @FXML
    private TextField tambahNamaProperti;

    @FXML
    private TextField tambahPanjangProperti;

    @FXML
    private Button tambahPropertiBt;

    @FXML
    private Button uploadPropertiBt;

    public static Properti properti = new Properti();
    public static PropertiDAO propertiDao = new PropertiDAO();
    public AlertMessage alert = new AlertMessage();

    public void tambahPro(ActionEvent event) throws IOException {
        if (tambahNamaProperti.getText().isEmpty() && tambahLokasiProperti.getText().isEmpty() && tambahHargaProperti.getText().isEmpty() && tambahPanjangProperti.getText().isEmpty() && tambahDeskripsiProperti.getText().isEmpty() && tambahLebarProperti.getText().isEmpty()) {
            alert.errorMessage("HARAP LENGKAPI DATA YANG ANDA MASUKKAN");
        } else {
            Timestamp tanggalDaftar = new Timestamp(System.currentTimeMillis());
            properti.setNama(tambahNamaProperti.getText());
            properti.setLokasi(tambahLokasiProperti.getText());
            properti.setPanjangRumah(Double.parseDouble(tambahPanjangProperti.getText()));
            properti.setLebarRumah(Double.parseDouble(tambahLebarProperti.getText()));
            properti.setHarga(Double.parseDouble(tambahHargaProperti.getText()));
            properti.setDeskripsi(tambahDeskripsiProperti.getText());
            properti.setWaktuDitambahkan(tanggalDaftar);
            propertiDao.tambahProperti(properti);
            alert.succesMessage("PROPERTI BERHASIL DITAMBAHKAN");
            URL url = new File("src/main/java/view/MenuAdmin.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Admin");
            stage.show();
            tambahPropertiForm.getScene().getWindow().hide();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
