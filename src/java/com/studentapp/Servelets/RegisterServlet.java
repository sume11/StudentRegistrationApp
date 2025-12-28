package com.studentapp.servlets;

import com.studentapp.dao.StudentDAO;
import com.studentapp.model.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
                try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String yearStr = request.getParameter("year");
            
            int year = Integer.parseInt(yearStr);
            Student student = new Student(name, email, year);
            StudentDAO dao = new StudentDAO();
            
            boolean success = dao.addStudent(student);
            
            if (success) {
                response.sendRedirect("showAll");
            } else {
                response.sendRedirect("register.html?error=1");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.html?error=2");
        }
    }
}