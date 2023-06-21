package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import dao.DaoTremCarga;
import controllers.TelaMenuController;
import controllers.TelaCadastroController;
import controllers.TelaBuscaController;
import controllers.TelaExclusaoController;
import controllers.TelaListagemController;
public class MainLP extends Application {
    private DaoTremCarga daoTremCarga;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            daoTremCarga = new DaoTremCarga();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/TelaMenu.fxml"));
            Parent root = loader.load();

            TelaMenuController telaMenuController = loader.getController();
            telaMenuController.setDaoTremCarga(daoTremCarga);
            telaMenuController.setMainLP(this);

            Scene scene = new Scene(root,600,400);
            primaryStage.setTitle("Sistema de Gerenciamento de Trem de Carga");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public void abrirTelaCadastro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/TelaCadastro.fxml"));
            Parent root = loader.load();

            TelaCadastroController telaCadastroController = loader.getController();
            telaCadastroController.setDaoTremCarga(daoTremCarga);

            Stage stage = new Stage();
            stage.setTitle("Cadastro de Trem de Carga");
            stage.setScene(new Scene(root,600,400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void abrirTelaBusca() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/TelaBusca.fxml"));
            Parent root = loader.load();

            TelaBuscaController telaBuscaController = loader.getController();
            telaBuscaController.setDaoTremCarga(daoTremCarga);

            Stage stage = new Stage();
            stage.setTitle("Busca de Trem de Carga");
            stage.setScene(new Scene(root,600,400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void abrirTelaExclusao() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/TelaExclusao.fxml"));
            Parent root = loader.load();

            TelaExclusaoController telaExclusaoController = loader.getController();
            telaExclusaoController.setDaoTremCarga(daoTremCarga);

            Stage stage = new Stage();
            stage.setTitle("Exclusão de Trem de Carga");
            stage.setScene(new Scene(root,600,300));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void abrirTelaListagem() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/TelaListagem.fxml"));
            Parent root = loader.load();
            TelaListagemController telaListagemController = loader.getController();
            telaListagemController.setDaoTremCarga(daoTremCarga);
            Stage stage = new Stage();
            stage.setTitle("Listagem de Trens de Carga");
            stage.setScene(new Scene(root,600,400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
