package com.example.librarian.LoginAdmin;

import com.example.Util.common;
import com.example.connectDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControllerLoginAdmin {
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;
    @FXML
    private Label wrongAccount;
    @FXML
    private Button loginButton;
    private common cm;
    public void login(ActionEvent event) throws IOException {
        checkLogin();
    }
    public void cancel(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void checkLogin() {
        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();

        String veriflyLogin = "select count(1) from Thu_thu where manhanvien = '"+Username.getText()+"' AND Password = '"+Password.getText()+"' ;" ;
        try {
            Statement statement = conn.createStatement();
            ResultSet quertResul = statement.executeQuery(veriflyLogin);

            while (quertResul.next()){
                if (quertResul.getInt(1 ) == 1){
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    URL urlSceneAdmin = new File("E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\java\\com\\example\\librarian\\Admin\\Admin.fxml").toURI().toURL();
                    FXMLLoader loader = new FXMLLoader();
                    writeFile(Username.getText());
                    Parent adminView = loader.load(urlSceneAdmin);
                    Scene sceneAdmin = new Scene(adminView);
                    stage.setScene(sceneAdmin);
                } else if (Username.getText().equals("")  && Password .getText().equals("") ) {
                    wrongAccount.setText("tên đăng nhập và mật khẩu không được bỏ trống ");
                } else{
                    wrongAccount.setText("Sai tên đăng nhập hoặc mật khẩu");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeFile(String useName) {
        String path = "E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\resources\\saveUserLogin";
        final File dirUpload = new File(path);
        if (!dirUpload.exists())
            dirUpload.mkdirs();
        String headerCenterFilePath = path + File.separator + "userLogin";
        this.cm.writeFileInfo(headerCenterFilePath, useName);
    }
}
