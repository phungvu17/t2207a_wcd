package com.demo.student;

import com.dao.StudenDAO;
import com.entities.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/student")
public class StudentControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        StudenDAO studenDAO = new StudenDAO();
        List<Student> list = studenDAO.get();
        req.setAttribute("students",list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/student/list.jsp");
        dispatcher.forward(req, resp);

    }

    // query


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/student");
    }
}
