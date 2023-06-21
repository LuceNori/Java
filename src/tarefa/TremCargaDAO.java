package tarefaLp2BD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TremCargaDAO {
    public void cadastrar(TremCarga tremCarga) throws SQLException {
        String sql = "INSERT INTO tremCarga (quantidadeVagoes, tipoCarga) VALUES (?, ?)";

        try (PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, tremCarga.getQuantidadeVagoes());
            stmt.setString(2, String.valueOf(tremCarga.getTipoCarga()));

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    tremCarga.setIdTrem(rs.getInt(1));
                }
            }
        }
    }

    public TremCarga buscarPorId(int idTrem) throws SQLException {
        String sql = "SELECT * FROM tremCarga WHERE idTrem = ?";

        try (PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, idTrem);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int quantidadeVagoes = rs.getInt("quantidadeVagoes");
                    String tipoCarga = rs.getString("tipoCarga");

                    return new TremCarga(idTrem, quantidadeVagoes, tipoCarga);
                }
            }
        }

        return null;
    }

    public void excluirPorId(int idTrem) throws SQLException {
        String sql = "DELETE FROM tremCarga WHERE idTrem = ?";

        try (PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, idTrem);

            stmt.executeUpdate();
        }
    }

    public List<TremCarga> listarTodos() throws SQLException {
        List<TremCarga> tremCargas = new ArrayList<>();
        String sql = "SELECT * FROM tremCarga";

        try (PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idTrem = rs.getInt("idTrem");
                int quantidadeVagoes = rs.getInt("quantidadeVagoes");
                String tipoCarga = rs.getString("tipoCarga");

                tremCargas.add(new TremCarga(idTrem, quantidadeVagoes, tipoCarga));
            }
        }

        return tremCargas;
    }
}


