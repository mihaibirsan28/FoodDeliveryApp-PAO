package database;

import entities.persoane.curier.CurierBiciclist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurierBiciclistDatabase {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS curieriBiciclisti" + "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30), prenume varchar(30), numarTelefon varchar(30), cnp varchar(30), salariu double)";

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
        String deleteTableSql = "DROP TABLE curieriBiciclisti";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(deleteTableSql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCurieriBiciclist(String nume, String prenume, String numarTelefon, String cnp, double salariu) {
        String insertCurierBiciclistSql = "INSERT INTO curieriBiciclisti(nume, prenume, numarTelefon, cnp, salariu) VALUES (?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertCurierBiciclistSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2,prenume);
            preparedStatement.setString(3, numarTelefon);
            preparedStatement.setString(4, cnp);
            preparedStatement.setDouble(5, salariu);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCurierBiciclist(int id) {
        String deleteCurierBiciclistSql = "DELETE FROM curieriBiciclisti where id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteCurierBiciclistSql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCurierBiciclist(double salariu, int id) {
        String editCurieriBiciclistSql = "UPDATE curieriBiciclisti set salariu = ? where id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(editCurieriBiciclistSql);
            preparedStatement.setDouble(1, salariu);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CurierBiciclist> getAllCurieriBiciclisti() {
        String selectSql = "SELECT * FROM curieriBiciclisti";
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        List<CurierBiciclist> curieriBiciclisti = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var nume = resultSet.getString("nume");
                var prenume = resultSet.getString("prenume");
                var numarTelefon = resultSet.getString("numarTelefon");
                var cnp = resultSet.getString("cnp");
                var salariu = resultSet.getDouble("salariu");

                CurierBiciclist curierBiciclist = new CurierBiciclist(id, nume, prenume, numarTelefon, cnp, salariu);

                curieriBiciclisti.add(curierBiciclist);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return curieriBiciclisti;
    }

    public CurierBiciclist getCurierBiciclistById(int id) {
        String selectSql = "SELECT * FROM curieriBiciclisti WHERE id = ?";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCurierBiciclist(resultSet);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private CurierBiciclist mapToCurierBiciclist(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new CurierBiciclist(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDouble(6));
        }
        return null;
    }

}
