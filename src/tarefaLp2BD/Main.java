package tarefaLp2BD;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static TremCargaDAO tremCargaDAO = new TremCargaDAO();

    public static void main(String[] args) {
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
    }

    private static void cadastrarTremCarga() throws SQLException {
        System.out.println("Informe a quantidade de vagões:");
        int quantidadeVagoes = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Informe o tipo de carga:");
        String tipoCarga = scanner.nextLine();
        TremCarga tremCarga = new TremCarga(0, quantidadeVagoes, tipoCarga);
        tremCargaDAO.cadastrar(tremCarga);

        System.out.println("Item cadastrado com sucesso. ID: " + tremCarga.getIdTrem());
    }

    private static void buscarTremCargaPorId() throws SQLException {
        System.out.println("Informe o ID do item:");
        int idTrem = scanner.nextInt();
        scanner.nextLine();

        TremCarga tremCarga = tremCargaDAO.buscarPorId(idTrem);

        if (tremCarga != null) {
            System.out.println("ID: " + tremCarga.getIdTrem());
            System.out.println("Quantidade de vagões: " + tremCarga.getQuantidadeVagoes());
            System.out.println("Tipo de carga: " + tremCarga.getTipoCarga());
        } else {
            System.out.println("Item não encontrado!");
        }
    }

    private static void excluirTremCargaPorId() throws SQLException {
        System.out.println("Informe o ID do item:");
        int idTrem = scanner.nextInt();
        scanner.nextLine();

        tremCargaDAO.excluirPorId(idTrem);

        System.out.println("Item excluído com sucesso.");
    }

    private static void exibirTodosTremCarga() throws SQLException {
        for (TremCarga tremCarga : tremCargaDAO.listarTodos()) {
            System.out.println("ID: " + tremCarga.getIdTrem());
            System.out.println("Quantidade de vagões: " + tremCarga.getQuantidadeVagoes());
            System.out.println("Tipo de carga: " + tremCarga.getTipoCarga());
            System.out.println();
        }
        }
        }
