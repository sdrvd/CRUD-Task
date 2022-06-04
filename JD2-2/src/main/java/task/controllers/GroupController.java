package task.controllers;

import task.dao.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "grouContoller", urlPatterns = "/groups")
public class GroupController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GroupDao dao = new GroupDao();
        String groupname = req.getParameter("groupname");
        dao.groupGet(groupname);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GroupDao dao = new GroupDao();
        String groupname = req.getParameter("groupname");
        dao.groupCreate(groupname);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GroupDao dao = new GroupDao();
        String groupname = req.getParameter("groupname");
        dao.groupDelete(groupname);
    }
}
