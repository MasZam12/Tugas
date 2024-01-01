package Controller;

import Dao.BaseDAO;
import Dao.PembeliDAO;
import Dao.PropertiDAO;
import Model.Pengguna;
import Model.Properti;
import Other.AlertMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuAdminController implements Initializable {

    @FXML
    private TableColumn<String, Pengguna> IdUser;

    @FXML
    private Button addUserBt;

    @FXML
    private StackPane adminForm;

    @FXML
    private TableColumn<Timestamp, Pengguna> daftarUser;

    @FXML
    private Button dashboardBt;

    @FXML
    private AnchorPane dashboardForm;

    @FXML
    private Button deleteUserBt;

    @FXML
    private TableColumn<String, Pengguna> tipePenggunaUser;

    @FXML
    private TableColumn<String, Pengguna> emailUser;

    @FXML
    private Button exitBt;

    @FXML
    private Button homeBt;

    @FXML
    private Button kontraktorBt;

    @FXML
    private AnchorPane kontraktorForm;

    @FXML
    private TableColumn<String, Pengguna> nameUser;

    @FXML
    private TableColumn<String, Pengguna> noUser;

    @FXML
    private Button propertiBt;

    @FXML
    private AnchorPane propertiForm;

    @FXML
    private TableView<Pengguna> tabelUser;

    @FXML
    private Button updateUserBt;

    @FXML
    private Button userBt;

    @FXML
    private AnchorPane userForm;

    @FXML
    private ImageView addImage;

    @FXML
    private TextField deskripsiProperti;

    @FXML
    private TextField hargaProperti;

    @FXML
    private TextField jenisProperti;

    @FXML
    private TextField lebarProperti;

    @FXML
    private TextField lokasiProperti;

    @FXML
    private TextField panjangProperti;

    @FXML
    private Button tambahProperti;

    @FXML
    private Button uploadImageBt;

    @FXML
    private Button updatePropertiBt;
    @FXML
    private Button tambahPropertiBt;

    @FXML
    private TableColumn<String, Properti> namaPropertiTable;

    @FXML
    private TableColumn<String, Properti> lokasiPropertiTable;

    @FXML
    private TableColumn<Properti, Double> luasPropertiTable;

    @FXML
    private TableColumn<String, Properti> idPropertiTable;

    @FXML
    private TableColumn<String, Properti> ketersediaanPropertiTable;

    @FXML
    private TableColumn<Double, Properti> hargaPropertiTable;

    @FXML
    private Button deletePropertiBt;

    @FXML
    private TableView<Properti> tabelProperti;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;
    private AlertMessage alert = new AlertMessage();
    private Image image;
    private static PropertiDAO g1 = new PropertiDAO();
    private static Properti pro1 = new Properti();
    private static PembeliDAO pp1 = new PembeliDAO();
    private ObservableList<Properti> addPropertiListData;
    private ObservableList<Pengguna> addPenggunaListData;

    public void switchPage(ActionEvent event) {
        if (event.getSource() == dashboardBt) {
            dashboardForm.setVisible(true);
            userForm.setVisible(false);
            kontraktorForm.setVisible(false);
        } else if (event.getSource() == userBt) {
            dashboardForm.setVisible(false);
            userForm.setVisible(true);
            kontraktorForm.setVisible(false);
        } else if (event.getSource() == kontraktorBt) {
            dashboardForm.setVisible(false);
            userForm.setVisible(false);
            kontraktorForm.setVisible(true);
        }
    }

    public void Switch(ActionEvent event) {
        try {
            URL url = new File("src/main/java/view/MainView.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.show();
        } catch (IOException e) {
        }
    }

    public ObservableList<Pengguna> addPenggunaGetData() {
        ObservableList<Pengguna> listData = FXCollections.observableArrayList();
        String selectData = "SELECT * FROM Pengguna";
        connect = BaseDAO.ConnectDB();
        Pengguna pem;
        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();
            while (result.next()) {
                pem = new Pengguna(
                        result.getString("idUser"),
                        result.getString("nama"),
                        result.getString("noHP"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getTimestamp("tanggalDaftar"),
                        result.getString("tipePengguna")
                );
                listData.add(pem);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (prepare != null) {
                    prepare.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
            }
        }
        return listData;
    }

    public ObservableList<Properti> addPropertiGetData() {
        ObservableList<Properti> listData = FXCollections.observableArrayList();
        String selectData = "SELECT * FROM Properti";
        connect = BaseDAO.ConnectDB();
        Properti pro;
        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();
            while (result.next()) {
                pro = new Properti(
                        result.getInt("propertiId"),
                        result.getString("nama"),
                        result.getString("deskripsi"),
                        result.getString("lokasi"),
                        result.getDouble("harga"),
                        result.getDouble("panjangRumah"),
                        result.getDouble("lebarRumah"),
                        result.getDouble("luasRumah"),
                        result.getString("ketersediaan")
                );
                listData.add(pro);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (prepare != null) {
                    prepare.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
            }
        }
        return listData;
    }

    public void displayPropertiData() {
        addPropertiListData = addPropertiGetData();

        idPropertiTable.setCellValueFactory(new PropertyValueFactory<>("propertiId"));
        namaPropertiTable.setCellValueFactory(new PropertyValueFactory<>("nama"));
        lokasiPropertiTable.setCellValueFactory(new PropertyValueFactory<>("lokasi"));
        hargaPropertiTable.setCellValueFactory(new PropertyValueFactory<>("harga"));
        luasPropertiTable.setCellValueFactory(new PropertyValueFactory<>("luasRumah"));
        ketersediaanPropertiTable.setCellValueFactory(new PropertyValueFactory<>("ketersediaan"));

        tabelProperti.setItems(addPropertiListData);
    }

    public void displayPenggunaData() {
        addPenggunaListData = addPenggunaGetData();

        IdUser.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        nameUser.setCellValueFactory(new PropertyValueFactory<>("nama"));
        noUser.setCellValueFactory(new PropertyValueFactory<>("noHP"));
        emailUser.setCellValueFactory(new PropertyValueFactory<>("email"));
        daftarUser.setCellValueFactory(new PropertyValueFactory<>("tanggalDaftar"));
        tipePenggunaUser.setCellValueFactory(new PropertyValueFactory<>("tipePengguna"));

        tabelUser.setItems(addPenggunaListData);
    }

    public void deleteProperti(ActionEvent event) {
        Properti pro = tabelProperti.getSelectionModel().getSelectedItem();
        int num = tabelProperti.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            alert.errorMessage("TOLONG PILIH ITEM");
            return;
        } else {
            if (alert.confirmationMessage("KAMU INGIN MENGAPUS ID :"
                    + pro.getPropertiId() + "?")) {
                g1.hapusProperti(pro.getPropertiId());
                alert.succesMessage("DATA BERHASIL DIHAPUS");
            } else {
                alert.errorMessage("DIBATALKAN");
            }
        }
        displayPropertiData();
    }

    public void deleteUser(ActionEvent event) {
        Pengguna pem = tabelUser.getSelectionModel().getSelectedItem();
        int num = tabelUser.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            alert.errorMessage("TOLONG PILIH ITEM");
            return;
        } else {
            if (alert.confirmationMessage("KAMU INGIN MENGAPUS ID :"
                    + pem.getIdUser() + "?")) {
                pp1.hapusPembeli(String.valueOf(pem.getIdUser()));
                alert.succesMessage("HAPUS DATA BERHASIL");
            } else {
                alert.errorMessage("DIBATALKAN");
            }
        }
        displayPenggunaData();
    }

    public void toTambah(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/view/TambahPengguna.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        adminForm.getScene().getWindow().hide();
    }

    public void adProp(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/view/TambahProperti.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        adminForm.getScene().getWindow().hide();
    }

    public void imporrImage(ActionEvent event) {
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*jpg", "*png"));

        Stage stage = (Stage) propertiForm.getScene().getWindow();
        File file = open.showOpenDialog(stage);

        if (file != null) {
            image = new Image(file.toURI().toString(), 200, 263, false, true);
            addImage.setImage(image);
        }
    }

    public void addProperti(ActionEvent event) {
        if (jenisProperti.getText().isEmpty() && lokasiProperti.getText().isEmpty() && hargaProperti.getText().isEmpty() && panjangProperti.getText().isEmpty() && lebarProperti.getText().isEmpty() && deskripsiProperti.getText().isEmpty()) {
            alert.errorMessage("HARAP LENGKAPI DATA TERLEBIH DAHULU");
        } else {
            pro1.setNama(jenisProperti.getText());
            pro1.setLokasi(lokasiProperti.getText());
            pro1.setHarga(Double.parseDouble(hargaProperti.getText()));
            pro1.setPanjangRumah(Integer.parseInt(panjangProperti.getText()));
            pro1.setLebarRumah(Integer.parseInt(lebarProperti.getText()));
            pro1.setDeskripsi(deskripsiProperti.getText());
            g1.tambahProperti(pro1);
            alert.succesMessage("PROPERTI BERHASIL DITAMBAHKAN");
        }
    }

    public void toHome(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/view/MainView.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        adminForm.getScene().getWindow().hide();
    }

    public void exitWin(ActionEvent event) throws IOException {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayPenggunaData();
        displayPropertiData();
    }

}
