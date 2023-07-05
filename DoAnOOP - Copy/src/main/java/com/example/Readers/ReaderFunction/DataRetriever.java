package com.example.Readers.ReaderFunction;

import com.example.connectDatabase;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.Util.common;
import org.apache.commons.io.FileUtils;

public class DataRetriever {
    private common cm;

    public static ResultSet retrieveData() throws IOException {
        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String readerID = readValueFile("E:\\java\\IdeaProjects\\DoAnOOP - Copy\\src\\main\\resources\\saveReaderID\\readerID");

        try {
            String sql = "select masach, So_luong_sach_con_muon, Ten_sach from Thong_tin_sach_con_muon where mdg = '"+readerID+"'";
//            " where mdg = '"+readerId.getText()+"'";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
//            System.out.println(readerID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static String readValueFile(String path) throws IOException {
        String content = "";
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            try {
                content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            } catch (Exception e) {
                System.out.println("Can't read value in the header file !");
                content = "";
            }
        }
        return content;
    }
    public static ResultSet retrieveBookData() {
        connectDatabase connectSQL = new connectDatabase();
        Connection conn = connectSQL.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select masach, Ten_sach, gioi_thieu_sach, Ten_tac_gia, So_luong_con_lai from book_doc_gia";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
