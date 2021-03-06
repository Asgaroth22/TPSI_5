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

@WebServlet(name = "StudentListServlet", urlPatterns = {"/studentList"})
public class StudentListServlet extends HttpServlet {
    
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                HttpSession session = request.getSession();
                if (session.getAttribute("studentList") == null) {
                    session.setAttribute("studentList", new ArrayList<Student>());
                }
                if (session.getAttribute("visitCounter") == null) {
                    session.setAttribute("visitCounter", 0);
                }
                Integer counter  = (Integer) session.getAttribute("visitCounter") + 1;
                session.setAttribute("visitCounter", counter);
                List<Student> students = (ArrayList<Student>) session.getAttribute("studentList");
                request.setAttribute("students", students);
                request.setAttribute("visits", counter);
                request.getRequestDispatcher("studentList.jsp").forward(request, response);
    }
}
