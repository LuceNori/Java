package tarefa;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainLP {
    private static Scanner scanner = new Scanner(System.in);
    private static DaoTremCarga daoTremCarga;

    public static void main(String[] args) {
        try {
            daoTremCarga = new DaoTremCarga();

            while (true) {
                System.out.println("Selecione uma opção:");
                System.out.println("1 - Cadastrar um item");
                System.out.println("2 - Buscar um item (por id)");
                System.out.println("3 - Excluir um item (por id)");
                System.out.println("4 - Exibir todos os itens");
                System.out.println("0 - Sair");

                try {
                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            cadastrarTremCarga();
                            break;
                        case 2:
                            buscarTremCargaPorId();
                            break;
                        case 3:
                            excluirTremCargaPorId();
                            break;
                        case 4:
                            exibirTodosTremCarga();
                            break;
                        case 0:
                            System.out.println("Saindo...");
                            return;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida!");
                    scanner.nextLine();
                } catch (SQLException e) {
                    System.out.println("Erro ao acessar o banco de dados: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void cadastrarTremCarga() throws SQLException {
        System.out.println("Informe o tipo de carga:");
        String tipoCarga = scanner.nextLine();
        TremCargaLP tremCarga = new TremCargaLP();
        tremCarga.setTipoCarga(tipoCarga);

        System.out.println("Informe a quantidade de vagões:");
        int quantidadeVagoes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidadeVagoes; i++) {
            System.out.println("Informe o carregamento do vagão:");
            String tipoVagao = scanner.nextLine();

            System.out.println("Informe o peso do vagão:");
            double pesoVagao = scanner.nextDouble();
            scanner.nextLine();

            TremVagaoLP vagao = new TremVagaoLP();
            vagao.setTipoVagao(tipoVagao);
            vagao.setPesoVagao(pesoVagao);
            tremCarga.adicionarVagao(vagao);
        }

        daoTremCarga.cadastrarTremCarga(tremCarga);
        System.out.println("Trem de carga cadastrado com sucesso!");
    }

    private static void buscarTremCargaPorId() throws SQLException {
        System.out.println("Informe o ID do trem de carga:");
        int idTremCarga = scanner.nextInt();
        scanner.nextLine();

        TremCargaLP tremCarga = daoTremCarga.buscarTremCargaPorId(idTremCarga);

        if (tremCarga != null) {
            System.out.println("Trem de carga encontrado:");
            System.out.println("ID: " + tremCarga.getIdTremCarga());
            System.out.println("Tipo de carga: " + tremCarga.getTipoCarga());
            System.out.println("Vagões:");

            for (TremVagaoLP vagao : tremCarga.getVagoes()) {
                System.out.println("ID do vagão: " + vagao.getIdVagao());
                System.out.println("Tipo do vagão: " + vagao.getTipoVagao());
                System.out.println("Peso do vagão: " + vagao.getPesoVagao());
                System.out.println("--------------------");
            }
        } else {
            System.out.println("Trem de carga não encontrado!");
        }
    }

    private static void excluirTremCargaPorId() throws SQLException {
        System.out.println("Informe o ID do trem de carga:");
        int idTremCarga = scanner.nextInt();
        scanner.nextLine();

        boolean removido = daoTremCarga.excluirTremCargaPorId(idTremCarga);
        boolean removido2 = daoTremCarga.excluirTremVagoesPorid(idTremCarga);

        if (removido) {
            System.out.println("Trem de carga removido com sucesso!");
        } else {
            System.out.println("Trem de carga não encontrado!");
        }
        if (removido2) {
            System.out.println("Vagões do trem também removido com sucesso!");
        } else {
            System.out.println("Trem de carga não encontrado!");
        }
        
    }

    private static void exibirTodosTremCarga() throws SQLException {
        System.out.println("Lista de todos os trens de carga:");

        List<TremCargaLP> trensCarga = daoTremCarga.listarTodosTrensCarga();

        for (TremCargaLP tremCarga : trensCarga) {
            System.out.println("ID: " + tremCarga.getIdTremCarga());
            System.out.println("Tipo de carga: " + tremCarga.getTipoCarga());
            System.out.println("Vagões:");

            for (TremVagaoLP vagao : tremCarga.getVagoes()) {
                System.out.println("ID do vagão: " + vagao.getIdVagao());
                System.out.println("Tipo do vagão: " + vagao.getTipoVagao());
                System.out.println("Peso do vagão: " + vagao.getPesoVagao());
                System.out.println("--------------------");
            }
        }
    }
}
