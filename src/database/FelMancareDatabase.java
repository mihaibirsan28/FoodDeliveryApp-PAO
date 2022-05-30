package database;

import entities.restaurant.FelMancare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FelMancareDatabase {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS feluriMancare" + "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(70), pret double, ingrediente varchar(100))";

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
        String deleteTableSql = "DROP TABLE feluriMancare";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(deleteTableSql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFelMancare(String nume, double pret, String ingrediente) {
        String insertFeluriMancareSql = "INSERT INTO feluriMancare (nume, pret, ingrediente) VALUES (?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertFeluriMancareSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setDouble(2, pret);
            preparedStatement.setString(3, ingrediente);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFelMancare(int id) {
        String deleteFelMancareSql = "DELETE FROM feluriMancare where id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteFelMancareSql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFelMancare(double pret, int id) {
        String editFelMancareSql = "UPDATE feluriMancare set pret = ? where id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(editFelMancareSql);
            preparedStatement.setDouble(1, pret);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FelMancare> getAllFelMancare() {
        String selectSql = "SELECT * FROM feluriMancare";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<FelMancare> feluriMancare = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var nume = resultSet.getString("nume");
                var pret = resultSet.getDouble("pret");
                var ingrediente = resultSet.getString("ingrediente");

                FelMancare felMancare = new FelMancare(id, nume, pret, ingrediente);

                feluriMancare.add(felMancare);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return feluriMancare;
    }

    public FelMancare getFelMancareById(int id) {
        String selectSql = "SELECT * FROM feluriMancare WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToFelMancare(resultSet);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private FelMancare mapToFelMancare(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new FelMancare(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getString(4));
        }
        return null;
    }
}
