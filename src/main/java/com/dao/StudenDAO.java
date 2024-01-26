package com.dao;

import com.entities.Student;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudenDAO<S> implements DAOInterface<Student> {

    @Override
    public List<Student> get() {
        String sql = "SELECT * FROM students";//JPQL
        ArrayList<Student> list = new ArrayList<>();
        try {
            Database db = Database.getInstance();
            ResultSet rs = db.getStatement().executeQuery(sql);

           while (rs.next()){
               list.add(new Student(rs.getInt("id"),
                       rs.getString("name"),
                       rs.getString("email"),
                       rs.getString("address")
               ));
           }
        }catch (Exception e){

        }
       return  list;

    }

    @Override
    public boolean create(Student student) {
        String sql = "INSERT INTO students (name, email, address) VALUES (?, ?, ?)";
        try {
            Database db = Database.getInstance();
            PreparedStatement prst = db.getPreparedStatement(sql);
            prst.setString(1,student.name);
            prst.setString(2,student.email);
            prst.setString(3,student.address);
            prst.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    @Override
    public boolean update(Student student) {
//        String sql = "UPDATE students SET name=?, email=?, address=? WHERE id=?";
//        try {
//            Database db = Database.getInstance();
//            PreparedStatement prst = db.getPreparedStatement(sql);
//            prst.setString(1, student.name);
//            prst.setString(2, student.email);
//            prst.setString(3, student.address);
//            prst.setInt(4, student.id);
//
//            prst.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        return false;
//    }
    }


    @Override
    public boolean delete(Student student) {
//        String sql = "DELETE FROM students WHERE id = ?";
//        try {
//            Database db = Database.getInstance();
//            PreparedStatement prst = db.getPreparedStatement(sql);
//            prst.setInt(1, student.id);
//            int rowsAffected = prst.executeUpdate();
//            return rowsAffected > 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        return false;
    }

    @Override
    public <K> Student find(K id) {
        return null;
    }
}
