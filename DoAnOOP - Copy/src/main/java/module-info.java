module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.apache.commons.io;

//    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires net.synedra.validatorfx;
//    requires org.kordamp.ikonli.javafx;
//    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansolo.tilesfx;
//    requires com.almasb.fxgl.all;

//    opens com.example.Book to javafx.fxml;
//    exports com.example.Book;
//
    opens com.example.librarian.Admin to javafx.fxml;
    exports com.example.librarian.Admin;
    opens com.example.librarian.LoginAdmin to javafx.fxml;
    exports com.example.librarian.LoginAdmin;

    opens com.example.Readers.ReaderFunction to javafx.fxml;
    exports com.example.Readers.ReaderFunction;
    opens com.example.Readers.login to javafx.fxml;
    exports com.example.Readers.login;
}