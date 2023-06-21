package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entidades.TremCargaLP;
import entidades.TremVagaoLP;

public class DaoTremCarga {
    private Connection connection;

    public DaoTremCarga() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/trabalhobd";
        String username = "root";
        String password = "";
        connection = DriverManager.getConnection(url, username, password);
    }
    public void atualizarTremCarga(TremCargaLP tremCarga) throws SQLException {
        String sqlUpdateTremCarga = "UPDATE tremcarga SET tipo_carga = ? WHERE id_trem_carga = ?";
        PreparedStatement statementTremCarga = connection.prepareStatement(sqlUpdateTremCarga);
        statementTremCarga.setString(1, tremCarga.getTipoCarga());
        statementTremCarga.setInt(2, tremCarga.getIdTremCarga());
        statementTremCarga.executeUpdate();
        statementTremCarga.close();

        String sqlDeleteVagoes = "DELETE FROM tremvagao WHERE id_trem_carga = ?";
        PreparedStatement statementDeleteVagoes = connection.prepareStatement(sqlDeleteVagoes);
        statementDeleteVagoes.setInt(1, tremCarga.getIdTremCarga());
        statementDeleteVagoes.executeUpdate();
        statementDeleteVagoes.close();

        String sqlInsertVagao = "INSERT INTO tremvagao (id_trem_carga, tipo_vagao, peso_vagao) VALUES (?, ?, ?)";
        PreparedStatement statementInsertVagao = connection.prepareStatement(sqlInsertVagao);
        List<TremVagaoLP> vagoes = tremCarga.getVagoes();
        for (TremVagaoLP vagao : vagoes) {
            statementInsertVagao.setInt(1, tremCarga.getIdTremCarga());
            statementInsertVagao.setString(2, vagao.getTipoVagao());
            statementInsertVagao.setDouble(3, vagao.getPesoVagao());
            statementInsertVagao.executeUpdate();
        }
        statementInsertVagao.close();
    }

    public void cadastrarTremCarga(TremCargaLP tremCarga) throws SQLException {
        String sql = "INSERT INTO tremcarga (tipo_carga) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, tremCarga.getTipoCarga());
        statement.executeUpdate();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int idTremCarga = generatedKeys.getInt(1);
            tremCarga.setIdTremCarga(idTremCarga);

            List<TremVagaoLP> vagoes = tremCarga.getVagoes();
            for (TremVagaoLP vagao : vagoes) {
                cadastrarVagao(idTremCarga, vagao);
            }
        }

        statement.close();
    }

    private void cadastrarVagao(int idTremCarga, TremVagaoLP vagao) throws SQLException {
        String sql = "INSERT INTO tremvagao (id_trem_carga, tipo_vagao, peso_vagao) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idTremCarga);
        statement.setString(2, vagao.getTipoVagao());
        statement.setDouble(3, vagao.getPesoVagao());
        statement.executeUpdate();
        statement.close();
    }

    public TremCargaLP buscarTremCargaPorId(int idTremCarga) throws SQLException {
        String sql = "SELECT * FROM tremcarga WHERE id_trem_carga = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idTremCarga);
        ResultSet resultSet = statement.executeQuery();

        TremCargaLP tremCarga = null;

        if (resultSet.next()) {
            tremCarga = new TremCargaLP();
            tremCarga.setIdTremCarga(resultSet.getInt("id_trem_carga"));
            tremCarga.setTipoCarga(resultSet.getString("tipo_carga"));
            tremCarga.setVagoes(buscarVagoesPorTremCarga(idTremCarga));
        }

        resultSet.close();
        statement.close();

        return tremCarga;
    }

    private List<TremVagaoLP> buscarVagoesPorTremCarga(int idTremCarga) throws SQLException {
        String sql = "SELECT * FROM tremvagao WHERE id_trem_carga = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idTremCarga);
        ResultSet resultSet = statement.executeQuery();

        List<TremVagaoLP> vagoes = new ArrayList<>();

        while (resultSet.next()) {
            TremVagaoLP vagao = new TremVagaoLP();
            vagao.setIdVagao(resultSet.getInt("id_vagao"));
            vagao.setTipoVagao(resultSet.getString("tipo_vagao"));
            vagao.setPesoVagao(resultSet.getDouble("peso_vagao"));
            vagoes.add(vagao);
        }

        resultSet.close();
        statement.close();

        return vagoes;
    }

    public boolean excluirTremCargaPorId(int idTremCarga) throws SQLException {
        boolean removido = false;

        String sql = "DELETE FROM tremcarga WHERE id_trem_carga = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idTremCarga);
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            removido = true;
        }

        statement.close();

        return removido;
    }

    public boolean excluirTremVagoesPorId(int idTremCarga) throws SQLException {
        boolean removido = false;

        String sql = "DELETE FROM tremvagao WHERE id_trem_carga = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idTremCarga);
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            removido = true;
        }

        statement.close();

        return removido;
    }

    public List<TremCargaLP> listarTodosTrensCarga() throws SQLException {
        List<TremCargaLP> trensCarga = new ArrayList<>();

        String sql = "SELECT * FROM tremcarga";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            TremCargaLP tremCarga = new TremCargaLP();
            tremCarga.setIdTremCarga(resultSet.getInt("id_trem_carga"));
            tremCarga.setTipoCarga(resultSet.getString("tipo_carga"));
            tremCarga.setVagoes(buscarVagoesPorTremCarga(tremCarga.getIdTremCarga()));
            trensCarga.add(tremCarga);
        }

        resultSet.close();
        statement.close();

        return trensCarga;
    }
}

