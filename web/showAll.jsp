<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.studentapp.model.Student"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Students</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
        .container { max-width: 1000px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h1 { color: #333; border-bottom: 2px solid #4CAF50; padding-bottom: 10px; }
        .actions { margin: 20px 0; display: flex; gap: 15px; }
        .btn { 
            padding: 10px 20px; 
            background: #4CAF50; 
            color: white; 
            text-decoration: none; 
            border-radius: 5px;
            display: inline-block;
        }
        .btn:hover { background: #45a049; }
        table { width: 100%; border-collapse: collapse; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #4CAF50; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        tr:hover { background-color: #e0f7fa; }
        .empty { text-align: center; padding: 40px; color: #666; font-size: 18px; }
        .count { background: #e3f2fd; padding: 10px; border-radius: 4px; margin: 10px 0; }
    </style>
</head>
<body>
    <div class="container">
        <h1>All Registered Students</h1>        
        <div class="actions">
            <a href="register.html" class="btn">Register New Student</a>
            <a href="index.html" class="btn">Home</a>
        </div>
        <div class="count">
            Total Students Registered: 
            <strong>
                <% 
                    List<Student> students = (List<Student>) request.getAttribute("students");
                    if (students == null) {
                        out.print("0");
                    } else {
                        out.print(students.size());
                    }
                %>
            </strong>
        </div>
        <%
            if (students == null || students.isEmpty()) {
        %>
            <div class="empty">
                No students registered yet.<br>
                <a href="register.html">Register the first student</a>
            </div>
        <%
            } else {
        %>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Year</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Student student : students) {
                    %>
                        <tr>
                            <td><%= student.getId() %></td>
                            <td><%= student.getName() %></td>
                            <td><%= student.getEmail() %></td>
                            <td>Year <%= student.getYear() %></td>
                            <td>
                                <%
                                    int year = student.getYear();
                                    if (year == 1) out.print("Freshman");
                                    else if (year == 2) out.print("Sophomore");
                                    else if (year == 3) out.print("Junior");
                                    else if (year == 4) out.print("Senior");
                                    else out.print("Graduate");
                                %>
                            </td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        <%
            }
        %>
    </div>
</body>
</html>