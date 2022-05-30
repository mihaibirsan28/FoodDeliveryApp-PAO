package database;

import entities.restaurant.FelMancare;
import entities.restaurant.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDatabase {
    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS restaurante" + "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30), adresa varchar(50))";

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
        String deleteTableSql = "DROP TABLE restaurante";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(deleteTableSql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addRestaurant(String nume, String adresa) {
        String insertRestaurantSql = "INSERT INTO restaurante (nume, adresa) VALUES (?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertRestaurantSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2, adresa);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRestaurant(int id) {
        String deleteRestaurantSql = "DELETE FROM restaurante where id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteRestaurantSql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRestaurant(String adresa, int id) {
        String editRestaurantSql = "UPDATE restaurante set adresa = ? where id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(editRestaurantSql);
            preparedStatement.setString(1,adresa);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Restaurant> getAllRestaurante() {
        String selectSql = "SELECT * FROM restaurante";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<Restaurant> restaurante = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var nume = resultSet.getString("nume");
                var adresa = resultSet.getString("adresa");

                Restaurant restaurant = new Restaurant(id, nume, adresa);

                restaurante.add(restaurant);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurante;
    }

    public Restaurant getRestaurantById(int id) {
        String selectSql = "SELECT * FROM restaurante WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToRestaurant(resultSet);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Restaurant mapToRestaurant(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Restaurant(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
        }
        return null;
    }
}
