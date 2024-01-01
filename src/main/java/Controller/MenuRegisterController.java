package Controller;

import Other.AlertMessage;
import Other.User;
import Dao.PembeliDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Model.Admin;
import Model.Pembeli;
import java.io.File;

public class MenuRegisterController implements Initializable {

    @FXML
    private CheckBox Checkbox;

    @FXML
    private CheckBox CreateCheckbox;

    @FXML
    private TextField CreateEmail;

    @FXML
    private Hyperlink CreateHyperlink;

    @FXML
    private TextField CreateNo;

    @FXML
    private PasswordField CreatePassword;

    @FXML
    private TextField CreateShowPassword;

    @FXML
    private TextField CreateUsername;

    @FXML
    private Button LoginBt;

    @FXML
    private StackPane MenuRegistrasi;
    
    @FXML
    private StackPane MenuRegistrasiKontarktor;

    @FXML
    private PasswordField Password;

    @FXML
    private TextField ShowPassword;

    @FXML
    private AnchorPane SignInForm;

    @FXML
    private AnchorPane SignupForm;

    @FXML
    private TextField Username;

    @FXML
    private Button signUpBt;

    @FXML
    private Hyperlink toSigninHyperlink;

    @FXML
    private ComboBox<?> loginAs;

    private static Pembeli p1 = new Pembeli();
    private static PembeliDAO pp1 = new PembeliDAO();

    private AlertMessage alert = new AlertMessage();

    public void switchForm(ActionEvent event) {
        if (event.getSource() == toSigninHyperlink) {
            SignInForm.setVisible(false);
            SignupForm.setVisible(true);
        } else if (event.getSource() == CreateHyperlink) {
            SignInForm.setVisible(true);
            SignupForm.setVisible(false);
        }
    }

    public void loginshowPassword(ActionEvent event) {
        if (Checkbox.isSelected()) {
            ShowPassword.setText(Password.getText());
            ShowPassword.setVisible(true);
            Password.setVisible(false);
        } else {
            Password.setText(ShowPassword.getText());
            ShowPassword.setVisible(false);
            Password.setVisible(true);
        }
    }

    public void createshowPassword(ActionEvent event) {
        if (CreateCheckbox.isSelected()) {
            CreateShowPassword.setText(CreatePassword.getText());
            CreateShowPassword.setVisible(true);
            CreatePassword.setVisible(false);
        } else {
            CreatePassword.setText(CreateShowPassword.getText());
            CreateShowPassword.setVisible(false);
            CreatePassword.setVisible(true);
        }
    }
    Admin adm = new Admin();

    public void login() throws IOException {
        String enteredUsername = Username.getText();
        String enteredPassword = Password.getText();
        if (adm.isValidAdmin(enteredUsername, enteredPassword)) {
            alert.succesMessage("WELCOME ADMIN");
            URL url = new File("src/main/java/view/MenuAdmin.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Admin");
            stage.show();
            MenuRegistrasi.getScene().getWindow().hide();
        } else if (pp1.isValidPembeli(enteredUsername, enteredPassword)) {
            alert.succesMessage("WELCOME");
            URL url = new File("src/main/java/view/MainView.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            MenuRegistrasi.getScene().getWindow().hide();
        }
    }

    public void create() {
        if (CreateUsername.getText().isEmpty() && CreatePassword.getText().isEmpty() && CreateEmail.getText().isEmpty() && CreateNo.getText().isEmpty()) {
            alert.errorMessage("HARAP LENGKAPI DATA ANDA");
        } else {
            Timestamp tanggalDaftar = new Timestamp(System.currentTimeMillis());
            p1.setNama(CreateUsername.getText());
            p1.setPassword(CreatePassword.getText());
            p1.setEmail(CreateEmail.getText());
            p1.setNoHP(CreateNo.getText());
            p1.setTipePengguna("pembeli");
            p1.setTanggalDaftar(tanggalDaftar);
            int jumlahTerbeli = 0;
            String tipePengguna = "Pembeli";
            pp1.tambahPembeli(p1);
            alert.succesMessage("AKUN SUKSES DIBUAT :)");
        }
    }

    public void userList() {
        List<String> listU = new ArrayList<>();
        for (String data : User.users) {
            listU.add(data);
        }
        ObservableList listData = FXCollections.observableList(listU);
        loginAs.setItems(listData);
    }

    public void pindah(ActionEvent event) throws IOException {
        if (loginAs.getSelectionModel().getSelectedItem() == "User") {
            URL url = new File("src/main/java/view/MenuRegister.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            MenuRegistrasi.getScene().getWindow().hide();
        } else if (loginAs.getSelectionModel().getSelectedItem() == "Kontraktor") {
            URL url = new File("src/main/java/view/MenuRegisterKontraktor.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            MenuRegistrasiKontarktor.getScene().getWindow().hide();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList();
    }

}
