package task.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import task.dao.StudentsDao;
import task.dto.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentsController", urlPatterns = "/students")
public class StudentsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentsDao dao = new StudentsDao();
        int id = Integer.parseInt(req.getParameter("id"));
        dao.studentGet(id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentsDao dao = new StudentsDao();
        Student student = new Student();
        String name = req.getParameter("name");
        student.setName(name);
        double score = Double.parseDouble(req.getParameter("score"));
        student.setScore(score);
        int age = Integer.parseInt(req.getParameter("age"));
        student.setAge(age);
        int id = Integer.parseInt(req.getParameter("id"));
        student.setId(id);
        boolean olympic = Boolean.parseBoolean(req.getParameter("olympic"));
        student.setOlympicGamer(olympic);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student);
        dao.studentAdd(json);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentsDao dao = new StudentsDao();
        int id = Integer.parseInt(req.getParameter("id"));
        dao.studentDelete(id);
    }
}
