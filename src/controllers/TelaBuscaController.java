package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import dao.DaoTremCarga;
import entidades.TremCargaLP;

public class TelaBuscaController {
    private DaoTremCarga daoTremCarga;

    @FXML
    private TextField idTremCargaTextField;

    public void setDaoTremCarga(DaoTremCarga daoTremCarga) {
        this.daoTremCarga = daoTremCarga;
    }

    @FXML
    public void buscarTremCargaPorId() {
        String idTremCargaText = idTremCargaTextField.getText();

        try {
            int idTremCarga = Integer.parseInt(idTremCargaText);
            TremCargaLP tremCarga = daoTremCarga.buscarTremCargaPorId(idTremCarga);

            if (tremCarga != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Busca de Trem de Carga");
                alert.setHeaderText(null);
                alert.setContentText("ID do Trem de Carga: " + tremCarga.getIdTremCarga() + "\n" +
                        "Tipo de Carga: " + tremCarga.getTipoCarga());
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Busca de Trem de Carga");
                alert.setHeaderText(null);
                alert.setContentText("Trem de carga não encontrado!");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("O ID do trem de carga deve ser um número válido!");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Erro ao acessar o banco de dados: " + e.getMessage());
            alert.showAndWait();
        }
    }
}