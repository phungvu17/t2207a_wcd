//package com.demo.student;
//
//import com.dao.StudenDAO;
//
//import com.entities.Student;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet(value = "/update")
//public class UpdateControl extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idParam = request.getParameter("id");
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//
//        if (idParam != null && !idParam.isEmpty()) {
//            int studentId = Integer.parseInt(idParam);
//
//            // Set these attributes to make them accessible in the JSP
//            request.setAttribute("id", studentId);
//            request.setAttribute("name", name);
//            request.setAttribute("email", email);
//            request.setAttribute("address", address);
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("student/update.jsp");
//            dispatcher.forward(request, response);
//        } else {
//            // Handle the case where the ID parameter is missing or invalid
//            response.getWriter().write("Invalid student ID");
//        }
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idParam = request.getParameter("id");
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//
//
//        int studentId = Integer.parseInt(idParam);
//
//        StudenDAO studentDAO = new StudenDAO();
//        Student updatedStudent = new Student(studentId, name, email, address);
//
//        boolean updateSuccess = studentDAO.update(updatedStudent);
//
//        if (updateSuccess) {
//            response.sendRedirect(request.getContextPath() + "/student");
//        } else {
//            response.getWriter().write("Error updating student");
//        }
//
//    }
//}