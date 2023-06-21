package controllers;

import application.MainLP;
import dao.DaoTremCarga;
import javafx.fxml.FXML;

public class TelaMenuController {
    private DaoTremCarga daoTremCarga;
    private MainLP mainLP;

    public void setDaoTremCarga(DaoTremCarga daoTremCarga) {
        this.daoTremCarga = daoTremCarga;
    }

    public void setMainLP(MainLP mainLP) {
        this.mainLP = mainLP;
    }

    @FXML
    public void abrirTelaCadastro() {
        mainLP.abrirTelaCadastro();
    }

    @FXML
    public void abrirTelaBusca() {
        mainLP.abrirTelaBusca();
    }

    @FXML
    public void abrirTelaExclusao() {
        mainLP.abrirTelaExclusao();
    }

    @FXML
    public void abrirTelaListagem() {
        mainLP.abrirTelaListagem();
    }
}

