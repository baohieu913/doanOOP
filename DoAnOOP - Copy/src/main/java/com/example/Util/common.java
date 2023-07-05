package com.example.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.apache.commons.io.FileUtils;

public class common {

    public static boolean isEmty(String str) {
        return str == null || "".equals(str);
    }

    public static void writeFileInfo(final String path, final String content) {
        File file = new File(path);
        try (FileOutputStream fos = new FileOutputStream(file);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
            osw.write(content);
        } catch (Exception ex) {
            System.out.println("writeFileInfo error: " + ex.getMessage());
        }
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

    public static void alertService(String header, String type) {
        Alert alert = new Alert("confirm".equals(type) ? Alert.AlertType.CONFIRMATION : "error".equals(type) ? Alert.AlertType.ERROR : Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(header);
        Optional<ButtonType> result = alert.showAndWait();
    }

}
