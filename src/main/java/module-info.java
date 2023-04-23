module com.example.expensetrackerjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.expensetrackerjava.model to javafx.base;
    opens com.example.expensetrackerjava to javafx.fxml;
    exports com.example.expensetrackerjava;
    exports com.example.expensetrackerjava.controller;
    opens com.example.expensetrackerjava.controller to javafx.fxml;
}