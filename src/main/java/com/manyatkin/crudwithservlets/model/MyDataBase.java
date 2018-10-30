package com.manyatkin.crudwithservlets.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MyDataBase {
    private static final MyDataBase INSTANCE = new MyDataBase();

    private final String URL = "jdbc:postgresql://localhost/test1";
    private final String USER = "postgres";
    private final String PASSWORD = "Qwer123";

    private final String TABLE_NAME = "items";
    private final String ID_COLUMN = "item_id";
    private final String VENDOR_CODE_COLUMN = "vendor_code";
    private final String NAME_COLUMN = "name";
    private final String COST_COLUMN = "cost";

    private MyDataBase() {
    }

    public static MyDataBase getInstance() {
        return INSTANCE;
    }

    private Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);

        return DriverManager.getConnection(URL, properties);
    }

    public void add(Item item) throws SQLException {
        String query = "INSERT INTO " + TABLE_NAME +
                " (" + VENDOR_CODE_COLUMN + ", " + NAME_COLUMN + ", " + COST_COLUMN + ") " +
                "VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, item.getVendorCode());
            statement.setString(2, item.getName());
            statement.setInt(3, item.getCost());

            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM " + TABLE_NAME +
                " WHERE " + ID_COLUMN + " = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);

            statement.executeUpdate();
        }
    }

    public void update(int id, String newVendorCode, String newName, int newCost) throws SQLException {
        String query = "UPDATE " + TABLE_NAME +
                " SET " + VENDOR_CODE_COLUMN + " = ?, " +
                NAME_COLUMN + " = ?, " +
                COST_COLUMN + " = ? " +
                "WHERE " + ID_COLUMN + " = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, newVendorCode);
            statement.setString(2, newName);
            statement.setInt(3, newCost);
            statement.setInt(4, id);

            statement.executeUpdate();
        }
    }

    public List<String> getItemsList() throws SQLException {
        List<String> res = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                res.add("id = " + resultSet.getString(ID_COLUMN)
                        + ", vendorCode = " + resultSet.getString(VENDOR_CODE_COLUMN)
                        + ", name = " + resultSet.getString(NAME_COLUMN)
                        + ", cost = " + resultSet.getString(COST_COLUMN));
            }
        }
        return res;
    }

}
