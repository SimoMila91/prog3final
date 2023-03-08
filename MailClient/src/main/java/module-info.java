module com.progiii.mailclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires org.kordamp.bootstrapfx.core;
    requires de.jensd.fx.glyphs.fontawesome;


    opens com.progiii.mailclient to javafx.fxml;
    exports com.progiii.mailclient;
    exports com.progiii.mailclient.controllers;
    exports com.progiii.mailclient.controllers.client;
    exports com.progiii.mailclient.models;

}