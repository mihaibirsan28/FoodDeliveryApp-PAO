package database;

import entities.persoane.Client;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDatabase {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS clienti" + "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30), prenume varchar(30), numarTelefon varchar(30), adresa varchar(30))";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTable() {
        String deleteTableSql = "DROP TABLE clienti";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(deleteTableSql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClient(String nume, String prenume, String numarTelefon, String adresa) {
        String insertClientSql = "INSERT INTO clienti(nume, prenume, numarTelefon, adresa) VALUES (?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertClientSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2,prenume);
            preparedStatement.setString(3, numarTelefon);
            preparedStatement.setString(4, adresa);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int id) {
        String deleteClientSql = "DELETE FROM clienti where id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteClientSql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateClient(String adresa, int id) {
        String editClientSql = "UPDATE clienti set adresa = ? where id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(editClientSql);
            preparedStatement.setString(1, adresa);
            preparedStatement.setInt(2,id);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> getAllClienti() {
        String selectSql = "SELECT * FROM clienti";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Client> clients = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var nume = resultSet.getString("nume");
                var prenume = resultSet.getString("prenume");
                var numarTelefon = resultSet.getString("numarTelefon");
                var adresa = resultSet.getString("adresa");

                Client client = new Client(id, nume, prenume, numarTelefon, adresa);

                clients.add(client);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public Client getClientById(int id) {
        String selectSql = "SELECT * FROM clienti WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToClient(resultSet);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Client mapToClient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Client(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
        }
        return null;
    }

}
