package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import dao.DaoTremCarga;
import entidades.TremVagaoLP;
import entidades.TremCargaLP;

public class TelaCadastroController {
    private DaoTremCarga daoTremCarga;

    @FXML
    private TextField tipoCargaTextField;

    @FXML
    private TextField quantidadeVagoesTextField;

    public void setDaoTremCarga(DaoTremCarga daoTremCarga) {
        this.daoTremCarga = daoTremCarga;
    }

    @FXML
    public void cadastrarTremCarga() {
        String tipoCarga = tipoCargaTextField.getText();
        String quantidadeVagoesText = quantidadeVagoesTextField.getText();

        try {
            int quantidadeVagoes = Integer.parseInt(quantidadeVagoesText);

            TremCargaLP tremCarga = new TremCargaLP();
            tremCarga.setTipoCarga(tipoCarga);

            daoTremCarga.cadastrarTremCarga(tremCarga);

            for (int i = 0; i < quantidadeVagoes; i++) {
                TremVagaoLP vagao = new TremVagaoLP();
                vagao.setTipoVagao("Tipo do Vagão " + (i + 1));
                vagao.setPesoVagao(0.0); // Defina o peso adequado para o vagão
                tremCarga.adicionarVagao(vagao);
            }

            daoTremCarga.atualizarTremCarga(tremCarga);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro de Trem de Carga");
            alert.setHeaderText(null);
            alert.setContentText("Trem de carga cadastrado com sucesso!");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("A quantidade de vagões deve ser um número válido!");
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
