package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.List;

import dao.DaoTremCarga;
import entidades.TremCargaLP;
import javafx.scene.control.Alert.AlertType;

public class TelaListagemController {
    private DaoTremCarga daoTremCarga;

    @FXML
    private VBox vBox;

    public void setDaoTremCarga(DaoTremCarga daoTremCarga) {
        this.daoTremCarga = daoTremCarga;
    }

    @FXML
    public void initialize() {
        try {
            daoTremCarga = new DaoTremCarga();
            List<TremCargaLP> trensCarga = daoTremCarga.listarTodosTrensCarga();
            for (TremCargaLP tremCarga : trensCarga) {
                Label label = new Label("ID do Trem de Carga: " + tremCarga.getIdTremCarga() + "		" +
                        "Tipo de Carga: " + tremCarga.getTipoCarga());
                vBox.getChildren().add(label);
            }
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Atenção");
            alert.setContentText("Erro ao Listar: " + e.getMessage());
            alert.show();
        }
    }
}

