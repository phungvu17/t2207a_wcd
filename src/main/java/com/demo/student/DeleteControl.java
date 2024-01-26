//package com.demo.student;
//
//
//import com.dao.StudenDAO;
//import com.entities.Student;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet(value = "/delete")
//public class DeleteControl extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idParam = request.getParameter("id");
//
//        if (idParam != null && !idParam.isEmpty()) {
//            int studentId = Integer.parseInt(idParam);
//
//            StudenDAO studentDAO = new StudenDAO();
//            boolean deletionSuccess = studentDAO.delete(new Student(studentId, "", "", ""));
//
//            if (deletionSuccess) {
//                response.sendRedirect(request.getContextPath() + "/student");
//                return;
//            }
//        }
//
//        response.getWriter().write("Error deleting student or invalid ID");
//    }
//}