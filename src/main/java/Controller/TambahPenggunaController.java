package Controller;

import Dao.PembeliDAO;
import Model.Pembeli;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TambahPenggunaController implements Initializable {

    @FXML
    private TextField addEmail;

    @FXML
    private StackPane addFormAdmin;

    @FXML
    private TextField addNo;

    @FXML
    private PasswordField addPassword;

    @FXML
    private TextField addUsername;

    @FXML
    private Button tambahBt;

    @FXML
    private TextField tipePengguna;

    private static Pembeli p1 = new Pembeli();
    private static PembeliDAO pp1 = new PembeliDAO();
    private AlertMessage alert = new AlertMessage();

    public void tambah(ActionEvent event) throws IOException {
        if (addUsername.getText().isEmpty() && addEmail.getText().isEmpty() && addNo.getText().isEmpty() && addPassword.getText().isEmpty() && tipePengguna.getText().isEmpty()) {
            alert.errorMessage("DATA YANG ANDA MASUKKAN BELUM LENGKAP");
        } else {
            Timestamp tanggalDaftar = new Timestamp(System.currentTimeMillis());
            p1.setNama(addUsername.getText());
            p1.setPassword(addPassword.getText());
            p1.setEmail(addEmail.getText());
            p1.setNoHP(addNo.getText());
            p1.setTipePengguna(tipePengguna.getText());
            p1.setTanggalDaftar(tanggalDaftar);
            int jumlahTerbeli = 0;
            pp1.tambahPembeli(p1);
            alert.succesMessage("AKUN SUKSES DIBUAT :)");
            URL url = new File("src/main/java/view/MenuAdmin.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Admin");
            stage.show();
            addFormAdmin.getScene().getWindow().hide();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
