package task.dao;

import java.sql.*;

public class GroupDao {

    public void groupCreate(String groupname){
        String sql = "CREATE TABLE info." + groupname + "(" +
                "id integer," +
                "name text" +
                        ");";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/university", "postgres", "postgres");
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void groupGet(String groupname){
        String sql = "SELECT * FROM info." + groupname;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/university", "postgres", "postgres");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.print(resultSet.getString("id"));
                System.out.print(" ");
                System.out.println(resultSet.getString("name"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void groupDelete(String groupname){
        String sql = "DROP TABLE info." + groupname;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/university", "postgres", "postgres");
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
