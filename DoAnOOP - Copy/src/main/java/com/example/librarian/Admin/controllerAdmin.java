package com.example.librarian.Admin;

import com.example.Util.common;
import com.example.connectDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class controllerAdmin implements Initializable {
    @FXML
    private Label orderCode;
    @FXML
    private Label manageAD;
    @FXML
    private DatePicker dateAdd;
    @FXML
    private TextField orderPrice;
    @FXML
    private TextField codeBook1;
    @FXML
    private TextField numberBook1;
    @FXML
    private TextField codeBook2;
    @FXML
    private TextField numberBook2;
    @FXML
    private TextField codeBook3;
    @FXML
    private TextField numberBook3;
    @FXML
    private TextField codeBook4;
    @FXML
    private TextField numberBook4;
    @FXML
    private Label employeId;
    @FXML
    private Label employeName;
    @FXML
    private Label employeSex;
    @FXML
    private Label dateOfBirth;
    @FXML
    private Label phoneNumber;
    @FXML
    private Label email;
    @FXML
    private TextField bookPrice;
    @FXML
    private TextField codeAuthor;
    @FXML
    private TextField codeBook_;
    @FXML
    private TextField codePublish;
    @FXML
    private TextArea introBook;
    @FXML
    private TextField languagesBook;
    @FXML
    private TextField nameBook_;
    @FXML
    private TextField typeBook;
    @FXML
    private TextField yearPublish;
    @FXML
    private TextField codePublish_;
    @FXML
    private TextField namePublish;
    @FXML
    private TextField addressPublish;
    @FXML
    private TextField emailPublish;
    @FXML
    private TextField phonePublish;
    @FXML
    private TextField representPublish;
    @FXML
    private TextField codeAuthor_;
    @FXML
    private TextField nameAuthor;
    @FXML
    private TextField birthOfYearAuthor;
    @FXML
    private TextField deathOfYearAuthor;
    @FXML
    private TextArea bioAuthor;
    @FXML
    private TextField nameAuthorS;
    @FXML
    private TableColumn<Publisher, String> codePublishColumn;
    @FXML
    private TableColumn<Publisher, String> namePublishColumn;
    @FXML
    private TableColumn<Publisher, String> addressPublishColumn;
    @FXML
    private TableColumn<Publisher, String> emailPublishColumn;
    @FXML
    private TableColumn<Publisher, String> phonePublishColumn;
    @FXML
    private TableColumn<Publisher, String> representPublishColumn;
    @FXML
    private TableView<Publisher> publishTable;
    private ObservableList<Publisher> publishList;
    @FXML
    private TableColumn<Author, String> codeAuthorColumn;
    @FXML
    private TableColumn<Author, String> nameAuthorColumn;
    @FXML
    private TableColumn<Author, String> birthYearAuthorColumn;
    @FXML
    private TableColumn<Author, String> deathYearAuthorColumn;
    @FXML
    private TableColumn<Author, String> bioAuthorColumn;
    @FXML
    private TableView<Author> authorTable;
    private ObservableList<Author> authorList;
    @FXML
    private ImageView avatarView;
    @FXML
    private File avatarFile;
    private common cm;

    public void save(ActionEvent event) throws SQLException {


        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();
        PreparedStatement pstmt = null;

        try {
            String userName = this.cm.readValueFile("E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\resources\\saveUserLogin\\userLogin");

            conn.setAutoCommit(false);
//            String df = "TT1";
            String sql = "insert into nhap_sach(madonhang, manhanvien, Ngay_nhap, Gia_tri) values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, orderCode.getText());
            pstmt.setString(2, userName);
            pstmt.setDate(3, Date.valueOf(dateAdd.getValue()));
            pstmt.setString(4,orderPrice.getText());
            pstmt.executeUpdate();

            if (!this.cm.isEmty(codeBook1.getText()) && !this.cm.isEmty(numberBook1.getText())) {
                String sql1_ = "insert into sach_nhap(madonhang, masach, So_luong) values(?,?,'"+Integer.parseInt(numberBook1.getText())+"')";
                pstmt = conn.prepareStatement(sql1_);
                pstmt.setString(1, orderCode.getText());
                pstmt.setString(2, codeBook1.getText());
                pstmt.executeUpdate();
            }
            if (!this.cm.isEmty(codeBook2.getText()) && !this.cm.isEmty(numberBook2.getText())) {
                String sql2_ = "insert into sach_nhap(madonhang, masach, So_luong) values(?,?,'"+Integer.parseInt(numberBook2.getText())+"')";
                pstmt = conn.prepareStatement(sql2_);
                pstmt.setString(1, orderCode.getText());
                pstmt.setString(2, codeBook2.getText());
                pstmt.executeUpdate();
            }
            if (!this.cm.isEmty(codeBook3.getText()) && !this.cm.isEmty(numberBook3.getText())) {
                String sql3_ = "insert into sach_nhap(madonhang, masach, So_luong) values(?,?,'"+Integer.parseInt(numberBook3.getText())+"')";
                pstmt = conn.prepareStatement(sql3_);
                pstmt.setString(1, orderCode.getText());
                pstmt.setString(2, codeBook3.getText());
                pstmt.executeUpdate();
            }
            if (!this.cm.isEmty(codeBook4.getText()) && !this.cm.isEmty(numberBook4.getText())) {
                String sql4_ = "insert into sach_nhap(madonhang, masach, So_luong) values(?,?,'"+Integer.parseInt(numberBook4.getText())+"')";
                pstmt = conn.prepareStatement(sql4_);
                pstmt.setString(1, orderCode.getText());
                pstmt.setString(2, codeBook4.getText());
                pstmt.executeUpdate();
            }
            conn.commit();
            this.cm.alertService("Lưu thông tin thành công!", "success");
        } catch (Exception e) {
            conn.rollback();
            this.cm.alertService("Lưu thông tin thất bại!", "error");
            e.printStackTrace();
        }
        finally {
            try {
                if(pstmt != null){ pstmt.close(); }
            } catch (SQLException e) {}
            try {
                if(conn != null){ conn.close(); }
            } catch (SQLException e) {}
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();
        PreparedStatement pstmt = null;

        try {
            String userName = this.cm.readValueFile("E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\resources\\saveUserLogin\\userLogin");
            manageAD.setText(userName);
            String sql = "select manhanvien, Ho_ten, Ngay_sinh, Gioi_tinh, So_dien_thoai, Gmail, Password from Thu_thu where manhanvien = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                employeId.setText(rs.getString(1));
                employeName.setText(rs.getString(2));
                employeSex.setText(rs.getString(4));
                dateOfBirth.setText(rs.getString(3));
                email.setText(rs.getString(6));
                phoneNumber.setText(rs.getString(5));
            }

            String sql1 = "select * from ma_muon";
            pstmt = conn.prepareStatement(sql1);
            ResultSet rs1 = pstmt.executeQuery();
            while (rs1.next()) {
                orderCode.setText(rs1.getString(1));
            }

            publishList = FXCollections.observableArrayList();
            codePublishColumn.setCellValueFactory(new PropertyValueFactory<>("codePublish"));
            namePublishColumn.setCellValueFactory(new PropertyValueFactory<>("namePublish"));
            addressPublishColumn.setCellValueFactory(new PropertyValueFactory<>("addressPublish"));
            emailPublishColumn.setCellValueFactory(new PropertyValueFactory<>("emailPublish"));
            phonePublishColumn.setCellValueFactory(new PropertyValueFactory<>("phonePublish"));
            representPublishColumn.setCellValueFactory(new PropertyValueFactory<>("representPublish"));
            publishTable.setItems(publishList);

            String sql_ = "select * from NXB";
            pstmt = conn.prepareStatement(sql_);
            ResultSet rs_ = pstmt.executeQuery();

            while (rs_.next()) {
                Publisher publisher = new Publisher();
                publisher.setCodePublish(rs_.getString("maNXB"));
                publisher.setNamePublish(rs_.getString("Ten_NXB"));
                publisher.setAddressPublish(rs_.getString("Dia_chi"));
                publisher.setEmailPublish(rs_.getString("Gmail"));
                publisher.setPhonePublish(rs_.getString("So_dien_thoai"));
                publisher.setRepresentPublish(rs_.getString("Ten_nguoi_dai_dien"));
                publishList.add(publisher);
            }
//            showPublisherData();

            authorList = FXCollections.observableArrayList();
            codeAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("codeAuthor"));
            nameAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("nameAuthor"));
            birthYearAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("birthOfYear"));
            deathYearAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("deathOfYear"));
            bioAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("bioAuthor"));
            authorTable.setItems(authorList);

            String sql__ = "select * from Tac_gia";
            pstmt = conn.prepareStatement(sql__);
            ResultSet rs__ = pstmt.executeQuery();

            while (rs__.next()) {
                Author author = new Author();
                author.setCodeAuthor(rs__.getString("matacgia"));
                author.setNameAuthor(rs__.getString("Ten_tac_gia"));
                author.setBirthOfYear(rs__.getString("Nam_sinh"));
                author.setDeathOfYear(rs__.getString("Nam_mat"));
                author.setBioAuthor(rs__.getString("Tieu_su"));
                authorList.add(author);
            }

            restoreAvatarFromFile();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancel1(ActionEvent event) {
        codeBook1.setText("");
        numberBook1.setText("");
    }

    public void cancel2(ActionEvent event) {
        codeBook2.setText("");
        numberBook2.setText("");
    }

    public void cancel3(ActionEvent event) {
        codeBook3.setText("");
        numberBook3.setText("");
    }

    public void cancel4(ActionEvent event) {
        codeBook4.setText("");
        numberBook4.setText("");
    }

    public void addInfoBook(ActionEvent event) throws SQLException {

        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();
        PreparedStatement pstmt = null;

        try {

            conn.setAutoCommit(false);

            String sql = "insert into sach(masach, Ten_sach, The_loai, maNXB, matacgia, Nam_xuat_ban, Ngon_ngu, Gia_tri) values(?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,codeBook_.getText());
            pstmt.setString(2,nameBook_.getText());
            pstmt.setString(3,typeBook.getText());
            pstmt.setString(4,codePublish.getText());
            pstmt.setString(5,codeAuthor.getText());
            pstmt.setString(6,yearPublish.getText());
            pstmt.setString(7,languagesBook.getText());
            pstmt.setString(8,bookPrice.getText());
            pstmt.executeUpdate();

            String sql_ = "insert into gioi_thieu(masach, gioi_thieu_sach, Ten_tac_gia) values('"+codeBook_.getText()+"',?,?)";
            pstmt = conn.prepareStatement(sql_);
            pstmt.setString(1,introBook.getText());
            pstmt.setString(2,nameAuthorS.getText());
            pstmt.executeUpdate();

            conn.commit();
            this.cm.alertService("Lưu thông tin sách thành công!", "success");
        } catch (Exception e) {
            conn.rollback();
            this.cm.alertService("Lưu thông tin sách thất bại!", "error");
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
    public void cancelInfoBook(ActionEvent event) {
        codeBook_.setText("");
        typeBook.setText("");
        codePublish.setText("");
        codeAuthor.setText("");
        yearPublish.setText("");
        languagesBook.setText("");
        bookPrice.setText("");
        nameBook_.setText("");
        introBook.setText("");
        nameAuthorS.setText("");
    }
    public void addInfoPublisher(ActionEvent event) throws SQLException {

        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();
        PreparedStatement pstmt = null;

        try {

            conn.setAutoCommit(false);

            String sql = "insert into NXB(maNXB, Ten_NXB, Dia_chi, Gmail, So_dien_thoai, Ten_nguoi_dai_dien) values(?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,codePublish_.getText());
            pstmt.setString(2,namePublish.getText());
            pstmt.setString(3,addressPublish.getText());
            pstmt.setString(4,emailPublish.getText());
            pstmt.setString(5,phonePublish.getText());
            pstmt.setString(6,representPublish.getText());
            pstmt.executeUpdate();

            conn.commit();
            this.cm.alertService("Lưu thông tin NXB thành công!", "success");
        } catch (Exception e) {
            conn.rollback();
            this.cm.alertService("Lưu thông tin NXB thất bại!", "error");
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
    public void delInfoPublisher(ActionEvent event) {
        Publisher selected = publishTable.getSelectionModel().getSelectedItem();
        publishList.remove(selected);
    }
    public void cancelInfoPublisher(ActionEvent event) {
        codePublish_.setText("");
        namePublish.setText("");
        addressPublish.setText("");
        emailPublish.setText("");
        phonePublish.setText("");
        representPublish.setText("");
    }

//    public ObservableList<Publisher> publisherDataList() throws SQLException {
//        ObservableList<Publisher> listData = FXCollections.observableArrayList();
//        connectDatabase connectSQL = new connectDatabase();
//        Connection conn = connectSQL.getConnection();
//        PreparedStatement pstmt = null;
//        try {
//            String sql_ = "select * from NXB";
//            pstmt = conn.prepareStatement(sql_);
//            ResultSet rs_ = pstmt.executeQuery();
//
//            while (rs_.next()) {
//                Publisher publisher = new Publisher();
//                publisher.setCodePublish(rs_.getString("maNXB"));
//                publisher.setNamePublish(rs_.getString("Ten_NXB"));
//                publisher.setAddressPublish(rs_.getString("Dia_chi"));
//                publisher.setEmailPublish(rs_.getString("Gmail"));
//                publisher.setPhonePublish(rs_.getString("So_dien_thoai"));
//                publisher.setRepresentPublish(rs_.getString("Ten_nguoi_dai_dien"));
//                listData.add(publisher);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return listData;
//    }
//    public void showPublisherData() throws SQLException {
//        publishList = publisherDataList();
//        codePublishColumn.setCellValueFactory(new PropertyValueFactory<>("codePublish"));
//        namePublishColumn.setCellValueFactory(new PropertyValueFactory<>("namePublish"));
//        addressPublishColumn.setCellValueFactory(new PropertyValueFactory<>("addressPublish"));
//        emailPublishColumn.setCellValueFactory(new PropertyValueFactory<>("emailPublish"));
//        phonePublishColumn.setCellValueFactory(new PropertyValueFactory<>("phonePublish"));
//        representPublishColumn.setCellValueFactory(new PropertyValueFactory<>("representPublish"));
//        publishTable.setItems(publishList);
//    }

    public void addInfoAuthor(ActionEvent event) throws SQLException {

        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();
        PreparedStatement pstmt = null;

        try {

            conn.setAutoCommit(false);

            String sql = "insert into Tac_gia(matacgia, Ten_tac_gia, Nam_sinh, Nam_mat, Tieu_su) values(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,codeAuthor_.getText());
            pstmt.setString(2,nameAuthor.getText());
            pstmt.setString(3,birthOfYearAuthor.getText());
            pstmt.setString(4,deathOfYearAuthor.getText());
            pstmt.setString(5,bioAuthor.getText());
            pstmt.executeUpdate();

            conn.commit();
            this.cm.alertService("Lưu thông tin tác giả thành công!", "success");
        } catch (Exception e) {
            conn.rollback();
            this.cm.alertService("Lưu thông tin tác giả thất bại!", "error");
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
    public void delInfoAuthor(ActionEvent event) {
        Author selected = authorTable.getSelectionModel().getSelectedItem();
        authorList.remove(selected);
    }
    public void cancelInfoAuthor(ActionEvent event) {
        codeAuthor_.setText("");
        nameAuthor.setText("");
        birthOfYearAuthor.setText("");
        deathOfYearAuthor.setText("");
        bioAuthor.setText("");
    }

    public void chooseAvatar(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Chọn ảnh đại diện");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Hình ảnh","*.jpg","*.png"));
        File selectFile = fileChooser.showOpenDialog(null);
        if (selectFile != null) {
            deleteAvatarFile();
            saveAvatarToFile(selectFile);
            Image image = new Image(selectFile.toURI().toString());
            avatarView.setImage(image);
        }
    }
    public void saveAvatarToFile(File file) {
        try {
            String avatarFolderPath = System.getProperty("user.home") + File.separator + ".avatar1";
            File avatarFolder = new File(avatarFolderPath);
            if (!avatarFolder.exists()) {
                avatarFolder.mkdirs();
            }
            File destinationFile = new File(avatarFolderPath, file.getName());
            Files.copy(file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            avatarFile = destinationFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void restoreAvatarFromFile() {
        String avatarFolderPath = System.getProperty("user.home") + File.separator + ".avatar1";
        File avatarFolder = new File(avatarFolderPath);
        if (avatarFolder.exists() && avatarFolder.isDirectory()) {
            File[] files = avatarFolder.listFiles();
            if (files != null && files.length > 0) {
                // Lấy tệp tin avatar cuối cùng trong thư mục lưu trữ
                avatarFile = files[files.length - 1];
                // Tạo Image từ tệp tin avatar và đặt nó vào ImageView
                Image avatarImage = new Image(avatarFile.toURI().toString());
                avatarView.setImage(avatarImage);
            }
        }
    }
    public void deleteAvatarFile() {
        if (avatarFile != null) {
            avatarFile.delete();
            avatarFile = null;
        }
    }
}
