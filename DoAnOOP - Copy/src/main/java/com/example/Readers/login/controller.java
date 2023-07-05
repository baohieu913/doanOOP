package com.example.Readers.login;

import com.example.connectDatabase;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.Util.common;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class controller {
    @FXML
    private TextField UsernameLogin;
    @FXML
    private PasswordField PasswordLogin;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField IDReader;
    @FXML
    private TextField nameReader;
    @FXML
    private DatePicker birthOfDate;
    @FXML
    private TextField userSex;
    @FXML
    private TextField address;
    @FXML
    private TextField userPhoneNumber;
    @FXML
    private TextField userEmail;
    @FXML
    private TextField classroom;
    @FXML
    private TextField department;
    @FXML
    private Button loginButton;
    private common cm;

    public void RegisterAccount(ActionEvent event) throws IOException, SQLException {

        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();
        PreparedStatement pstmt = null;

        try {

            conn.setAutoCommit(false);

            if (!this.cm.isEmty(IDReader.getText()) &&
            !this.cm.isEmty(nameReader.getText()) &&
            !this.cm.isEmty(userSex.getText()) &&
            !this.cm.isEmty(address.getText()) &&
            !this.cm.isEmty(userPhoneNumber.getText()) &&
            !this.cm.isEmty(userEmail.getText()) &&
            !this.cm.isEmty(classroom.getText()) &&
            !this.cm.isEmty(department.getText()) &&
            !this.cm.isEmty(UsernameLogin.getText()) &&
            !this.cm.isEmty(PasswordLogin.getText()) ) {
                String sql = "insert into Doc_gia(mdg, Ho_ten, Ngay_sinh, Dia_chi, Lop, Khoa, Gmail, So_dien_thoai, Gioi_tinh, Ngay_bat_dau) values(?,?,?,?,?,?,?,?,?,GETDATE())";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,IDReader.getText());
                pstmt.setString(2,nameReader.getText());
                pstmt.setDate(3,Date.valueOf(birthOfDate.getValue()));
                pstmt.setString(4,address.getText());
                pstmt.setString(5,classroom.getText());
                pstmt.setString(6,department.getText());
                pstmt.setString(7,userEmail.getText());
                pstmt.setString(8,userPhoneNumber.getText());
                pstmt.setString(9,userSex.getText());
                pstmt.executeUpdate();
                String sql_ = "insert into Users(mdg, Username, Password) values(?,?,?)";
                pstmt = conn.prepareStatement(sql_);
                pstmt.setString(1,IDReader.getText());
                pstmt.setString(2,UsernameLogin.getText());
                pstmt.setString(3,PasswordLogin.getText());
                pstmt.executeUpdate();
            }

            conn.commit();
            this.cm.alertService("Đăng kí thành công","success");

        } catch (Exception e) {
            conn.rollback();
            this.cm.alertService("Đăng kí thất bại","error");
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null){ pstmt.close(); }
            } catch (SQLException e) {}
            try {
                if(conn != null){ conn.close(); }
            } catch (SQLException e) {}
        }

    }
    public void register(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        URL urlSceneAdmin = new File("E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\java\\com\\example\\Readers\\login\\Register New Account.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        Parent readerView = loader.load(urlSceneAdmin);
        Scene sceneReader = new Scene(readerView);
        stage.setScene(sceneReader);
    }
    public void signAsLibrarian(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        URL urlSceneAdmin = new File("E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\java\\com\\example\\librarian\\LoginAdmin\\Login Admin.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        Parent readerView = loader.load(urlSceneAdmin);
        Scene sceneReader = new Scene(readerView);
        stage.setScene(sceneReader);
    }

    public void returnLogin(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        URL urlSceneAdmin = new File("E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\java\\com\\example\\Readers\\login\\login.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        Parent readerView = loader.load(urlSceneAdmin);
        Scene sceneReader = new Scene(readerView);
        stage.setScene(sceneReader);
    }

    public void login(ActionEvent event) {
        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();

        String userLogin = "select count(1) from Users where Username = '"+UsernameLogin.getText()+"' AND Password = '"+PasswordLogin.getText()+"' ;" ;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(userLogin);

            while (rs.next()) {
                if (rs.getInt(1)==1) {
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    URL urlSceneReader = new File("E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\java\\com\\example\\Readers\\ReaderFunction\\Library Overall.fxml").toURI().toURL();
                    FXMLLoader loader = new FXMLLoader();
                    writeFile(UsernameLogin.getText());
                    Parent readerView = loader.load(urlSceneReader);
                    Scene sceneReader = new Scene(readerView);
                    stage.setScene(sceneReader);
                } else if (UsernameLogin.getText().equals("")  && PasswordLogin .getText().equals("") ) {
                    wrongLogin.setText("tên đăng nhập và mật khẩu không được bỏ trống ");
                } else{
                    wrongLogin.setText("Sai tên đăng nhập hoặc mật khẩu");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String useName) {
        String path = "E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\resources\\saveReaderLogin";
        final File dirUpload = new File(path);
        if (!dirUpload.exists())
            dirUpload.mkdirs();
        String headerCenterFilePath = path + File.separator + "readerLogin";
        this.cm.writeFileInfo(headerCenterFilePath, useName);
    }

}
