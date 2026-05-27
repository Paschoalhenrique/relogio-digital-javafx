package com.projetos.relogio;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelogioApp extends Application {

    final DateTimeFormatter FORMATADOR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    final DateTimeFormatter FORMATADOR_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void start(Stage palco) {
        Label rotuloData = new Label();
        rotuloData.setStyle("-fx-font-size: 20pt; -fx-text-fill: #F8F8FF;");
        //rotuloData.setStyle("-fx-font-size: 20pt; -fx-text-fill: green;");

        Label rotuloHora = new Label();
        rotuloHora.setStyle("-fx-font-size: 36pt; -fx-text-fill: #FF2800;");
        //rotuloHora.setStyle("-fx-font-size: 36pt; -fx-text-fill: lightblue;");

        KeyFrame keyFrameAtualizar = new KeyFrame(Duration.ZERO, e -> {
            LocalDateTime agora = LocalDateTime.now();
            rotuloData.setText(agora.format(FORMATADOR_DATA));
            rotuloHora.setText(agora.format(FORMATADOR_HORA));
        });

        KeyFrame keyFrameIntervalo = new KeyFrame(Duration.seconds(1));

        Timeline relogio = new Timeline();
        relogio.getKeyFrames().addAll(keyFrameAtualizar, keyFrameIntervalo);
        relogio.setCycleCount(Animation.INDEFINITE);
        relogio.play();

        VBox vboxLayout = new VBox(10, rotuloData, rotuloHora);
        vboxLayout.setAlignment(Pos.CENTER);
        vboxLayout.setStyle("-fx-background-color: black;");

        Scene cena = new Scene(vboxLayout, 400, 150);

        palco.setTitle("Relógio Digital.");
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
