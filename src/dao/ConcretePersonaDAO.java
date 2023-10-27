package dao;
import datasource.ConnectionDBH;

import java.sql.*;
import java.io.IOException;
import java.util.*;

public abstract class ConcretePersonaDAO implements PersonaDAO {

    private static ConnectionDBH connection_db;
    //private final ConnectionDBH connection_db;

    public ConcretePersonaDAO(ConnectionDBH connectionDBH) {
        this.connection_db = connectionDBH;
    }

    public static void add() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Inserisci le info della persona:");
            System.out.println("id: ");
            int id = sc.nextInt();
            System.out.println("nome: ");
            Scanner nm = new Scanner(System.in);
            String nome = nm.nextLine();
            System.out.println("cognome: ");
            Scanner cn = new Scanner(System.in);
            String cognome = cn.nextLine();
            System.out.println("età: ");
            Scanner et = new Scanner(System.in);
            int eta = et.nextInt();
            System.out.println("e-mail: ");
            Scanner ma = new Scanner(System.in);
            String mail = ma.nextLine();
            System.out.println("telefono: ");
            Scanner tl = new Scanner(System.in);
            String tel = tl.nextLine();
            String query = "INSERT INTO persona (id, nome, cognome, età, email, tel) VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection connection = connection_db.getConnectData();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, nome);
                preparedStatement.setString(3, cognome);
                preparedStatement.setInt(4, eta);
                preparedStatement.setString(5, mail);
                preparedStatement.setString(6, tel);

                int campiAggiunti = preparedStatement.executeUpdate();
                if (campiAggiunti > 0) {
                    System.out.println("Persona aggiunta con successo.");
                } else {
                    System.out.println("Impossibile aggiungere.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


    public static void readPersona() {
        String url = "jdbc:mysql://localhost:3306/persona";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from persona");
            while (resultSet.next()) {
                System.out.println("-------------------------------------------------");
                System.out.println("- id:" + resultSet.getString(1));
                System.out.println("- nome: " + resultSet.getString(2));
                System.out.println("- cognome: " + resultSet.getString(3));
                System.out.println("- età: " + resultSet.getString(4));
                System.out.println("- e-mail: " + resultSet.getString(5));
                System.out.println("- telefono: " + resultSet.getString(6));
                System.out.println("-------------------------------------------------");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


    public static void updateEmail() {
        System.out.println("Quale email di persona vuoi cambiare?\n" +
                "Inserisci l'id della persona: ");
        Scanner i = new Scanner(System.in);
        int id = i.nextInt();
        String query = "UPDATE persona SET email = ? WHERE id = ?";
        System.out.println("Qual è la nuova mail?");
        Scanner nm = new Scanner(System.in);
        String nuovaMail = nm.nextLine();
        persona.setEmail(nuovaMail);
        try(Connection connection = connection_db.getConnectData();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nuovaMail);
            preparedStatement.setInt(2, id);
            int mailAggiornata = preparedStatement.executeUpdate();
            if(mailAggiornata>0){
                System.out.println("E-mail aggiornata con successo");
            }else{
                System.out.println("C'è stato un errore nell'aggiornamento della mail.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static void updateTel() {
        System.out.println("A quale persona vuoi cambiare il numero di telefono?\n" +
                "Inserisci l'id della persona: ");
        Scanner i = new Scanner(System.in);
        int id = i.nextInt();
        String query = "UPDATE persona SET tel = ? WHERE id = ?";
        System.out.println("Qual è il nuovo numero?");
        Scanner nm = new Scanner(System.in);
        String nuovoNumero = nm.nextLine();

        try(Connection connection = connection_db.getConnectData();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nuovoNumero);
            preparedStatement.setInt(2, id);
            int numAggiornato = preparedStatement.executeUpdate();
            if(numAggiornato>0){
                System.out.println("Numero aggiornato con successo");
            }else{
                System.out.println("C'è stato un errore nell'aggiornamento della mail.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static void delete() {
        System.out.println("Quale persona vuoi rimuovere? \n Inserisci id.");
        Scanner p = new Scanner(System.in);
        int id = p.nextInt();
        String query = "DELETE FROM `persona` WHERE id = ?";

        try (Connection connection = connection_db.getConnectData();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            System.out.println("Confermi?");
            Scanner d = new Scanner(System.in);
            String decisione = d.nextLine();

            if (decisione.equals("Sì") || decisione.equals("si") || decisione.equals("sì") || decisione.equals("Si")) {
                int campoEliminato = preparedStatement.executeUpdate();
                if (campoEliminato > 0) {
                    System.out.println("Persona eliminata.");
                } else {
                    System.out.println("E' stato impossibile eliminare questa persona.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
