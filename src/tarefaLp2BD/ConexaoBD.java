package tarefaLp2BD;
import java.sql.*;

public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost/trabalho_LP2";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static Connection conexao;

    public static Connection getConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        return conexao;
    }
}
