package wcd.jpa.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import wcd.jpa.entities.Student;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/list-student")
public class StudentController extends HttpServlet {
    private SessionFactory seeionFactory;
    @Override
    public void init() throws ServletException {
        try {
            seeionFactory = new Configuration()
                    .configure("hibernate.cfg.xml").buildSessionFactory();



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Session session = seeionFactory.openSession()){
            session.beginTransaction();
            List<Student>list = session.createQuery("FROM Student",Student.class).getResultList();
            session.getTransaction().commit();
            req.setAttribute("students",list);
        }
        req.getRequestDispatcher("student/list.jsp").forward(req,resp);
    }


}
