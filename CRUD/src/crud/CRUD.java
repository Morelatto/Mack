package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 */
public class CRUD {

    public static final String driver = "org.apache.derby.jdbc.ClientDriver";
    public static final String DATABASE_URL = "jdbc:derby://localhost:1527/EMPRESA";
    public static final String dbname = "EMPRESA";
    public static final String user = "mack";
    public static final String password = "mack";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String idDepartamento;
        String idCargo;
        String novoDepartamento;
        String novoCargo;
        String opcao;
        String opcao2;
        String atual;
        String novo;
        String nome;
        boolean stateDB = false;

        do {

            System.out.printf("\nOpção\tDescrição\n0\tInitialize\n1\tCreate\n2\tRead\n3\tUpdate\n4\tDelete\n5\tSair\n");
            opcao = input.next();

            switch (opcao) {

                case "0":

                    initialize();
                    System.out.printf("\nBanco inicializado.\n");
                    stateDB = true;
                    break;

                case "1":

                    if (stateDB == false) {
                        System.out.printf("\nBanco não foi inicializado.\n");
                        break;
                    } else {
                        System.out.printf("\nOpção\tDescrição\n1\tDepartamento\n2\tFuncionário\n3\tCargo\n4\tSair\n");
                        opcao2 = input.next();

                        switch (opcao2) {

                            case "1":

                                System.out.printf("NOME: ");
                                nome = input.next();

                                create(opcao2, nome, 0, 0);
                                break;

                            case "2":

                                System.out.printf("NOME: ");
                                nome = input.next();
                                System.out.printf("ID_DEPARTAMENTO: ");
                                idDepartamento = input.next();
                                System.out.printf("ID_CARGO: ");
                                idCargo = input.next();

                                create(opcao2, nome, Integer.parseInt(idDepartamento), Integer.parseInt(idCargo));
                                break;

                            case "3":

                                System.out.printf("NOME: ");
                                nome = input.next();

                                create(opcao2, nome, 0, 0);
                                break;

                            default:

                                if ("4".equals(opcao2)) {
                                } else {
                                    System.out.printf("\nOpção inválida.\n");
                                }
                        }
                        break;
                    }

                case "2":

                    if (stateDB == false) {
                        System.out.printf("\nBanco não foi inicializado.\n");
                        break;
                    } else {
                        System.out.printf("\nOpção\tDescrição\n1\tDepartamento\n2\tFuncionário\n3\tCargo\n4\tSair\n");
                        opcao = input.next();

                        read(opcao);
                        break;
                    }

                case "3":

                    if (stateDB == false) {
                        System.out.printf("\nBanco não foi inicializado.\n");
                        break;
                    } else {
                        System.out.printf("\nOpção\tDescrição\n1\tDepartamento\n2\tFuncionário\n3\tCargo\n4\tSair\n");
                        opcao2 = input.next();

                        switch (opcao2) {

                            case "1":

                                System.out.printf("Departamento atual: ");
                                atual = input.next();
                                System.out.printf("Departamento novo: ");
                                novo = input.next();

                                update("1", novo, atual, 0, 0);
                                break;

                            case "2":

                                System.out.printf("Funcioniário atual: ");
                                atual = input.next();
                                System.out.printf("Funcioniário novo: ");
                                novo = input.next();
                                System.out.printf("Departamento novo: ");
                                novoDepartamento = input.next();
                                System.out.printf("Cargo Novo: ");
                                novoCargo = input.next();

                                update("2", novo, atual, Integer.parseInt(novoDepartamento), Integer.parseInt(novoCargo));
                                break;

                            case "3":

                                System.out.printf("Cargo atual: ");
                                atual = input.next();
                                System.out.printf("Cargo novo: ");
                                novo = input.next();

                                update("3", novo, atual, 0, 0);
                                break;

                            default:
                                if ("4".equals(opcao2)) {
                                } else {
                                    System.out.printf("\nOpcão inválida.\n");
                                }
                        }
                        break;
                    }

                case "4":

                    if (stateDB == false) {
                        System.out.printf("\nBanco não foi inicializado.\n");
                        break;
                    } else {
                        System.out.printf("\nOpção\tDescrição\n1\tDepartamento\n2\tFuncionário\n3\tCargo\n4\tSair\n");
                        opcao2 = input.next();

                        switch (opcao2) {

                            case "1":

                                System.out.printf("NOME: ");
                                nome = input.next();
                                delete(opcao2, nome);
                                break;

                            case "2":

                                System.out.printf("NOME: ");
                                nome = input.next();
                                delete(opcao2, nome);
                                break;

                            case "3":

                                System.out.printf("NOME: ");
                                nome = input.next();
                                delete(opcao2, nome);
                                break;

                            default:

                                if ("4".equals(opcao)) {
                                } else {
                                    System.out.printf("Opção inválida.");
                                }
                        }
                    }

                default:
                    if ("4".equals(opcao)) {
                    } else {
                        System.out.printf("Opção inválida.");
                    }
            }
        } while (!"5".equals(opcao));

        close();
    }

    public static void initialize() {

        try {

            Class.forName(driver);
            connection = DriverManager.getConnection(DATABASE_URL, user, password);
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void create(String opcao, String nome, int idDepartamento, int idCargo) {

        try {

            switch (opcao) {

                case "1":

                    statement.executeUpdate("INSERT INTO " + dbname + ".DEPARTAMENTO (NOME) VALUES ('" + nome + "')");
                    System.out.printf("\nDepartamento " + nome + " inserido com sucesso.\n");
                    break;

                case "2":

                    statement.executeUpdate("INSERT INTO " + dbname + ".FUNCIONARIO (NOME, ID_CARGO, ID_DEPARTAMENTO) VALUES ('" + nome + "', " + idCargo + ", " + idDepartamento + ")");
                    System.out.printf("\nFuncionário " + nome + " inserido com sucesso.\n");
                    break;

                case "3":

                    statement.executeUpdate("INSERT INTO " + dbname + ".CARGO (NOME) VALUES ('" + nome + "')");
                    System.out.printf("\nCargo " + nome + " inserido com sucesso.\n");
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void read(String opcao) {

        try {

            switch (opcao) {

                case "1":

                    resultSet = statement.executeQuery("SELECT * FROM " + dbname + ".DEPARTAMENTO");

                    System.out.printf("\n%s\t%s\n", "ID_DEPARTAMENTO", "NOME");

                    while (resultSet.next()) {
                        System.out.printf("%s\t\t%s\n", resultSet.getString("ID_DEPARTAMENTO"), resultSet.getString("NOME"));
                    }
                    break;

                case "2":

                    resultSet = statement.executeQuery("SELECT * FROM " + dbname + ".FUNCIONARIO");

                    System.out.printf("\n%s\t%s\t%s\t%s\n", "ID_FUNCIONARIO", "ID_CARGO", "ID_DEPARTAMENTO", "NOME");

                    while (resultSet.next()) {
                        System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", resultSet.getString("ID_FUNCIONARIO"), resultSet.getString("ID_CARGO"), resultSet.getString("ID_DEPARTAMENTO"), resultSet.getString("NOME"));
                    }
                    break;

                case "3":

                    resultSet = statement.executeQuery("SELECT * FROM " + dbname + ".CARGO");

                    System.out.printf("\n%s\t%s\n", "ID_CARGO", "NOME");

                    while (resultSet.next()) {
                        System.out.printf("%s\t\t%s\n", resultSet.getString("ID_CARGO"), resultSet.getString("NOME"));
                    }
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(String opcao, String novo, String atual, int novoDepartamento, int novoCargo) {

        int rows;

        try {

            switch (opcao) {

                case "1":

                    rows = statement.executeUpdate("UPDATE " + dbname + ".DEPARTAMENTO SET NOME = '" + novo + "' WHERE NOME = '" + atual + "'");
                    if (rows > 0) {
                        System.out.printf("\nDepartamento " + atual + " atualizado para " + novo + ".\n");
                    } else {
                        System.out.printf("\nDepartamento " + atual + " não encontrado.\n");
                    }
                    break;

                case "2":

                    rows = statement.executeUpdate("UPDATE " + dbname + ".FUNCIONARIO SET NOME = '" + novo + "', ID_DEPARTAMENTO = " + novoDepartamento + ", ID_CARGO = " + novoCargo + " WHERE NOME = '" + atual + "'");
                    if (rows > 0) {
                        System.out.printf("\nFuncionário " + atual + " atualizado para " + novo + ".\n");
                    } else {
                        System.out.printf("\nFuncionário " + atual + " não encontrado.\n");
                    }
                    break;

                case "3":

                    rows = statement.executeUpdate("UPDATE " + dbname + ".CARGO SET NOME = '" + novo + "' WHERE NOME = '" + atual + "'");
                    if (rows > 0) {
                        System.out.printf("\nCargo " + atual + " atualizado para " + novo + ".\n");
                    } else {
                        System.out.printf("\nCargo " + atual + " não encontrado.\n");
                    }
                    break;

            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void delete(String opcao, String nome) {

        int rows;

        try {

            switch (opcao) {

                case "1":

                    rows = statement.executeUpdate("DELETE FROM " + dbname + ".DEPARTAMENTO WHERE NOME = '" + nome + "'");
                    if (rows > 0) {
                        System.out.printf("\nDepartamento " + nome + " deletado com sucesso.\n");
                    } else {
                        System.out.println("\nDepartamento " + nome + " não encontrado.\n");
                    }
                    break;

                case "2":

                    rows = statement.executeUpdate("DELETE FROM " + dbname + ".FUNCIONARIO WHERE NOME = '" + nome + "'");
                    if (rows > 0) {
                        System.out.printf("\nFuncionário " + nome + " deletado com sucesso.\n");
                    } else {
                        System.out.println("\nFuncionário " + nome + " não encontrado.\n");
                    }
                    break;

                case "3":

                    rows = statement.executeUpdate("DELETE FROM " + dbname + ".CARGO WHERE NOME = '" + nome + "'");
                    if (rows > 0) {
                        System.out.printf("\nCargo " + nome + " deletado com sucesso.\n");
                    } else {
                        System.out.println("\nnCargo " + nome + " não encontrado.\n");
                    }
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void close() {

        try {

            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }

            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
