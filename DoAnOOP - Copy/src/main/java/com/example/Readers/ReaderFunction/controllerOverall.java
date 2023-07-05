package com.example.Readers.ReaderFunction;

import com.example.Util.common;
import com.example.connectDatabase;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class controllerOverall implements Initializable {
    @FXML
    private Label beginDate;
    @FXML
    private Label endDate;
    @FXML
    private Label readerAddress;
    @FXML
    private Label readerClass;
    @FXML
    private Label readerDepartment;
    @FXML
    private Label readerEmail;
    @FXML
    private Label readerId;
    @FXML
    private Label readerName;
    @FXML
    private Label readerPhoneNumber;
    @FXML
    private Label readerSex;
    @FXML
    private Label readerBirthOfDate;
    @FXML
    private Label borrowId;
    @FXML
    private TextField adminId;
    @FXML
    private Label borrowDate;
    @FXML
    private Label returnDate;
    @FXML
    private Label readerId2;
    @FXML
    private TextField codeBook1;
    @FXML
    private TextField codeBook2;
    @FXML
    private TextField codeBook3;
    @FXML
    private TextField codeBook4;
    @FXML
    private TextField numberBook1;
    @FXML
    private TextField numberBook2;
    @FXML
    private TextField numberBook3;
    @FXML
    private TextField numberBook4;
    @FXML
    private Label returnId;
    @FXML
    private TextField borrowId2;
    @FXML
    private Label readerId3;
    @FXML
    private TextField adminId2;
    @FXML
    private Label returnDate2;
    @FXML
    private TextField codeBook1_;
    @FXML
    private TextField codeBook2_;
    @FXML
    private TextField codeBook3_;
    @FXML
    private TextField codeBook4_;
    @FXML
    private TextField numberBook1_;
    @FXML
    private TextField numberBook2_;
    @FXML
    private TextField numberBook3_;
    @FXML
    private TextField numberBook4_;
    @FXML
    private TextField note1;
    @FXML
    private TextField note2;
    @FXML
    private TextField note3;
    @FXML
    private TextField note4;
    @FXML
    private TextField status1;
    @FXML
    private TextField status2;
    @FXML
    private TextField status3;
    @FXML
    private TextField status4;
    @FXML
    private Label nameBook;
    @FXML
    private Label codeBook;
    @FXML
    private Label authorBook;
    @FXML
    private Label numberBook;
    @FXML
    private Text introBook;
    @FXML
    private ImageView avatarView;
    @FXML
    private File avatarFile;
    private List<GridPane> gridPaneList;
    private common cm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        String sql = "select mdg, Ho_ten, Ngay_sinh, Dia_chi, Lop, Khoa, Gmail, So_dien_thoai, Gioi_tinh, Ngay_bat_dau, Ngay_ket_thuc from Quan_ly_doc_gia";
        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();
        PreparedStatement pstmt = null;

        try {

            String readerAccount = this.cm.readValueFile("E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\resources\\saveReaderLogin\\readerLogin");

            String sql = "select mdg, Ho_ten, Ngay_sinh, Dia_chi, Lop, Khoa, Gmail, So_dien_thoai, Gioi_tinh, Ngay_bat_dau, Ngay_ket_thuc from Quan_ly_doc_gia where UserName = '"+readerAccount+"'";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                readerId.setText(rs.getString(1));
                readerName.setText(rs.getString(2));
                readerBirthOfDate.setText(rs.getString(3));
                readerAddress.setText(rs.getString(4));
                readerClass.setText(rs.getString(5));
                readerDepartment.setText(rs.getString(6));
                readerEmail.setText(rs.getString(7));
                readerPhoneNumber.setText(rs.getString(8));
                readerSex.setText(rs.getString(9));
                beginDate.setText(rs.getString(10));
                endDate.setText(rs.getString(11));
                writeFile(readerId.getText());
            }

            String sql1 = "select mdg from Quan_ly_doc_gia where mdg = '"+readerId.getText()+"'";
            pstmt = conn.prepareStatement(sql1);
            ResultSet rs1 = pstmt.executeQuery();
            while (rs1.next()) {
                readerId2.setText(rs1.getString(1));
                readerId3.setText(rs1.getString(1));
            }

            String sql2 = "select * from NgayHienTai";
            pstmt = conn.prepareStatement(sql2);
            ResultSet rs2 = pstmt.executeQuery();
            while (rs2.next()) {
                borrowDate.setText(rs2.getString(1));
                returnDate2.setText(rs2.getString(1));
            }

            String sql3 = "select Ngay_tra_sach from Ngay_tra_sach";
            pstmt = conn.prepareStatement(sql3);
            ResultSet rs3 = pstmt.executeQuery();
            while (rs3.next()) {
                returnDate.setText(rs3.getString(1));
            }


            String sql4 = "select * from ma_muon";
            pstmt = conn.prepareStatement(sql4);
            ResultSet rs4 = pstmt.executeQuery();
            while (rs4.next()) {
                borrowId.setText(rs4.getString(1));
//                returnId.setText(rs4.getString(1));
            }

            String sql5 = "select * from ma_muon";
            pstmt = conn.prepareStatement(sql5);
            ResultSet rs5 = pstmt.executeQuery();
            while (rs5.next()) {
                returnId.setText(rs5.getString(1));
            }

            // test insert sach dang muon trong doc gia
            ResultSet resultSet = DataRetriever.retrieveData();
            int rowIndex = 0;
            while (resultSet.next() && rowIndex<6) {
                String name = resultSet.getString("Ten_sach");
                String code = resultSet.getString("masach");
                int quantity = resultSet.getInt("So_luong_sach_con_muon");
                if (quantity > 0) {
                    GridPane gridPane = getGridPaneByRowIndex(rowIndex);
                    setValuesInGridPane(gridPane, name, code, quantity);
                }
                rowIndex++;
            }

            // test insert sach trong doc gia
            ResultSet resultSet1 = DataRetriever.retrieveBookData();
            int rowIndex1 = 0;
            while (resultSet1.next() && rowIndex1<22) {
                String name1 = resultSet1.getString("Ten_sach");
                String code1 = resultSet1.getString("masach");
                int quantity1 = resultSet1.getInt("So_luong_con_lai");
                String intro1 = resultSet1.getString("gioi_thieu_sach");
                String author1 = resultSet1.getString("Ten_tac_gia");
                if (quantity1 > 0) {
                    GridPane gridPane1 = getGridPaneBookByRowIndex(rowIndex1);
                    setValuesInGPBook(gridPane1, name1, intro1, author1, code1, quantity1);
                }
                rowIndex1++;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        restoreAvatarFromFile();
    }
    @FXML
    private GridPane gpBookBorrowContainer;
    public GridPane getGridPaneByRowIndex(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < gpBookBorrowContainer.getRowCount()) {
            return (GridPane) gpBookBorrowContainer.getChildren().get(rowIndex);
        }
        return null;
    }
    public void setValuesInGridPane(GridPane gridPane, String name, String code, int quantity) {
        if (gridPane != null) {
            Label nameLabel = new Label(name);
            Label codeLabel = new Label("Mã sách:     " + code);
            Label quantityLabel = new Label("Số lượng:     " + quantity);

            GridPane.setHalignment(nameLabel, HPos.CENTER);
            GridPane.setValignment(nameLabel, VPos.CENTER);

            gridPane.add(nameLabel, 1, 0);
            gridPane.add(codeLabel, 1, 1);
            gridPane.add(quantityLabel, 1, 2);
        }
    }
    public void writeFile(String useName) {
        String path = "E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\resources\\saveReaderID";
        final File dirUpload = new File(path);
        if (!dirUpload.exists())
            dirUpload.mkdirs();
        String headerCenterFilePath = path + File.separator + "readerID";
        this.cm.writeFileInfo(headerCenterFilePath, useName);
    }

    // test insert book
    @FXML
    private GridPane gpBookContainer;
    public GridPane getGridPaneBookByRowIndex(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < gpBookContainer.getRowCount()) {
            return (GridPane) gpBookContainer.getChildren().get(rowIndex);
        }
        return null;
    }
    public void setValuesInGPBook(GridPane gridPane, String name, String intro, String author, String code, int quantity) {
        if (gridPane != null) {
            Label nameLabel = new Label(name);
            Label introLabel = new Label(intro);
            Label authorLabel = new Label(author);
            Label codeLabel = new Label("Mã sách:     " + code);
            Label quantityLabel = new Label("Số lượng:     " + quantity);

            GridPane.setHalignment(nameLabel, HPos.CENTER);
            GridPane.setValignment(nameLabel, VPos.CENTER);

            GridPane.setHalignment(authorLabel, HPos.RIGHT);
            GridPane.setValignment(authorLabel, VPos.CENTER);

            gridPane.add(nameLabel, 1, 0);
            gridPane.add(introLabel,1,1);
            gridPane.add(authorLabel,1,2);
            gridPane.add(codeLabel, 1, 3);
            gridPane.add(quantityLabel, 1, 4);
        }
    }

    public void borrow(ActionEvent event) throws SQLException {

        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();
        PreparedStatement pstmt = null;

        try {

            conn.setAutoCommit(false);

                String sql = "insert into Muon_sach(mdg, manhanvien, Ngay_muon, mamuon) values (?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,readerId2.getText());
                pstmt.setString(2,adminId.getText());
                pstmt.setString(3,borrowDate.getText());
                pstmt.setString(4, borrowId.getText());
                pstmt.executeUpdate();

            if (!this.cm.isEmty(codeBook1.getText()) && !this.cm.isEmty(numberBook1.getText())) {
                String sql1 = "insert into Sach_muon(mamuon, masach, So_luong) values(?,?,'"+Integer.parseInt(numberBook1.getText())+"')";
                pstmt = conn.prepareStatement(sql1);
                pstmt.setString(1,borrowId.getText());
                pstmt.setString(2, codeBook1.getText());
                pstmt.executeUpdate();
            }
            if (!this.cm.isEmty(codeBook2.getText()) && !this.cm.isEmty(numberBook2.getText())) {
                String sql2 = "insert into Sach_muon(mamuon, masach, So_luong) values(?,?,'"+Integer.parseInt(numberBook2.getText())+"')";
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, borrowId.getText());
                pstmt.setString(2, codeBook2.getText());
                pstmt.executeUpdate();
            }
            if (!this.cm.isEmty(codeBook3.getText()) && !this.cm.isEmty(numberBook3.getText())) {
                String sql3 = "insert into Sach_muon(mamuon, masach, So_luong) values(?,?,'"+Integer.parseInt(numberBook3.getText())+"')";
                pstmt = conn.prepareStatement(sql3);
                pstmt.setString(1, borrowId.getText());
                pstmt.setString(2, codeBook3.getText());
                pstmt.executeUpdate();
            }
            if (!this.cm.isEmty(codeBook4.getText()) && !this.cm.isEmty(numberBook4.getText())) {
                String sql4 = "insert into Sach_muon(mamuon, masach, So_luong) values(?,?,'"+Integer.parseInt(numberBook4.getText())+"')";
                pstmt = conn.prepareStatement(sql4);
                pstmt.setString(1, borrowId.getText());
                pstmt.setString(2, codeBook4.getText());
                pstmt.executeUpdate();
            }

            conn.commit();
            this.cm.alertService("Mượn thành công","success");

        } catch (Exception e) {
            conn.rollback();
            this.cm.alertService("Mượn thất bại","error");
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

    public void returnBook(ActionEvent event) throws SQLException {

        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();
        PreparedStatement pstmt = null;

        try {

            conn.setAutoCommit(false);

            String sql = "insert into Tra_sach(matra, mdg, manhanvien, Ngay_tra) values('"+returnId.getText()+"',?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,readerId3.getText());
            pstmt.setString(2,adminId2.getText());
            pstmt.setString(3,returnDate2.getText());
            pstmt.executeUpdate();

            if (!this.cm.isEmty(codeBook1_.getText()) &&
                !this.cm.isEmty(numberBook1_.getText()) ) {
                String sql1 = "insert into sach_tra(matra, masach, So_luong, mdg) values('"+returnId.getText()+"',?,?,'"+readerId.getText()+"')";
                pstmt = conn.prepareStatement(sql1);
                pstmt.setString(1, codeBook1_.getText());
                pstmt.setString(2, numberBook1_.getText());
                pstmt.executeUpdate();
            }

            if (!this.cm.isEmty(codeBook2_.getText()) &&
                !this.cm.isEmty(numberBook2_.getText())) {
                String sql2 = "insert into sach_tra(matra, masach, So_luong, mdg) values('"+returnId.getText()+"',?,?,'"+readerId.getText()+"')";
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, codeBook2_.getText());
                pstmt.setString(2, numberBook2_.getText());
                pstmt.executeUpdate();
            }

            if (!this.cm.isEmty(codeBook3_.getText()) &&
                !this.cm.isEmty(numberBook3_.getText())) {
                String sql3 = "insert into sach_tra(matra, masach, So_luong, mdg) values('"+returnId.getText()+"',?,?,'"+readerId.getText()+"')";
                pstmt = conn.prepareStatement(sql3);
                pstmt.setString(1, codeBook3_.getText());
                pstmt.setString(2, numberBook3_.getText());
                pstmt.executeUpdate();
            }

            if (!this.cm.isEmty(codeBook4_.getText()) &&
                !this.cm.isEmty(numberBook4_.getText())) {
                String sql4 = "insert into sach_tra(matra, masach, So_luong, mdg) values('"+returnId.getText()+"',?,?,'"+readerId.getText()+"')";
                pstmt = conn.prepareStatement(sql4);
                pstmt.setString(1, codeBook4_.getText());
                pstmt.setString(2, numberBook4_.getText());
                pstmt.executeUpdate();
            }

            conn.commit();
            this.cm.alertService("Trả thành công!", "success");

        } catch (Exception e) {
            conn.rollback();
            this.cm.alertService("Trả thất bại","error");
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
            String avatarFolderPath = System.getProperty("user.home") + File.separator + ".avatar";
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
        String avatarFolderPath = System.getProperty("user.home") + File.separator + ".avatar";
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
