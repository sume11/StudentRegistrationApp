package com.studentapp.Servelets;

import com.studentapp.dao.StudentDAO;
import com.studentapp.model.Student;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            try {
            StudentDAO dao = new StudentDAO();
            List<Student> students = dao.getAllStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("showAll.jsp").forward(request, response);
                    } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}