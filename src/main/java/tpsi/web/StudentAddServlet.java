package tpsi.web;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "StudentAddServlet", urlPatterns = {"/studentAdd"})
public class StudentAddServlet extends HttpServlet {
    
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                HttpSession session = request.getSession();
                if (session.getAttribute("studentList") == null) {
                    session.setAttribute("studentList", new ArrayList<Student>());
                }
                List<Student> students = (ArrayList<Student>) session.getAttribute("studentList");
                String fname = request.getParameter("firstName");
                String lname = request.getParameter("lastName");
                String email = request.getParameter("emailAddress");
                if(!fname.isEmpty() && !lname.isEmpty() && !email.isEmpty()){
                    students.add(new Student(fname, lname, email));
                }
                session.setAttribute("studentList", students);
                response.sendRedirect("/TPSI_5/studentList");    
        }
    }