package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import dao.DaoTremCarga;

public class TelaExclusaoController {
    private DaoTremCarga daoTremCarga;

    @FXML
    private TextField idTremCargaTextField;

    public void setDaoTremCarga(DaoTremCarga daoTremCarga) {
        this.daoTremCarga = daoTremCarga;
    }

    @FXML
    public void excluirTremCargaPorId() {
        String idTremCargaText = idTremCargaTextField.getText();

        try {
            int idTremCarga = Integer.parseInt(idTremCargaText);
            boolean removido = daoTremCarga.excluirTremCargaPorId(idTremCarga);

            if (removido) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Exclusão");
                alert.setHeaderText(null);
                alert.setContentText("Trem de carga removido com sucesso!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Exclusão");
                alert.setHeaderText(null);
                alert.setContentText("Não foi possível remover o trem de carga. Verifique o ID informado.");
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

