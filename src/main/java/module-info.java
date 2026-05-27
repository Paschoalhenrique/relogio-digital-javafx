module com.projetos.relogio {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.projetos.relogio to javafx.fxml;
    exports com.projetos.relogio;
}