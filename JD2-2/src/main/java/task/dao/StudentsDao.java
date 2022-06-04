package task.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.postgresql.util.PGobject;
import task.dto.Student;

import java.sql.*;

public class StudentsDao {
    private int id = 1;

    public void studentAdd(String json){
        String sql = "INSERT INTO info.students_list(student, id) VALUES(?, " + id + ")";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/university", "postgres", "postgres");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, json);
            statement.execute();
            id++;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void studentGet(int id){
        String sql = "SELECT student FROM info.students_list" +
                "WHERE id = '" + id + "';";
        String result = null;
        Student output = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/university", "postgres", "postgres");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                result = resultSet.getString("student");
                output = mapper.readValue(result, Student.class);
            }
            System.out.println(output.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void studentDelete(int id){
        String sql = "DELETE FROM info.students_list"
                +"WHERE id ='" + id + "';" ;
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
