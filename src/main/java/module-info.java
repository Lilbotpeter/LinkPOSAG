module com.example.linkposag {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.jfxtras.styles.jmetro;
    requires java.sql;


    requires java.net.http;


    opens com.example.linkposag to javafx.fxml;
    exports com.example.linkposag;
}