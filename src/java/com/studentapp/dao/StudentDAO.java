package com.studentapp.dao;

import com.studentapp.model.Student;
import com.studentapp.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (name, email, year) VALUES (?, ?, ?)";
           try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setInt(3, student.getYear());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;        
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY id DESC";
         try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setYear(rs.getInt("year"));
                   students.add(student);
            }   
        } catch (SQLException e) {
            e.printStackTrace();
        }   
        return students;
    }
    public int getStudentCount() {
        String sql = "SELECT COUNT(*) FROM students";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
             } catch (SQLException e) {
            e.printStackTrace();
        }   
        return 0;
    }
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        
        System.out.println("Total students: " + dao.getStudentCount());
        
        List<Student> students = dao.getAllStudents();
        System.out.println("All students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}