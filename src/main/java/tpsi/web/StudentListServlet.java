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
            try (PrintWriter out = response.getWriter()) {
                HttpSession session = request.getSession();
                if (session.getAttribute("studentList") == null) {
                    session.setAttribute("studentList", new ArrayList<Student>());
                }
                if (session.getAttribute("visitCounter") == null) {
                    session.setAttribute("visitCounter", 0);
                }
                session.setAttribute("visitCounter", (Integer) session.getAttribute("visitCounter") + 1);
                List<Student> students = (ArrayList<Student>) session.getAttribute("studentList");
                String fname = request.getParameter("firstName");
                String lname = request.getParameter("lastName");
                String email = request.getParameter("emailAddress");
                if((fname!=null) && (lname!=null) && (email!=null)){
                    students.add(new Student(fname, lname, email));
                }
                session.setAttribute("studentList", students);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Java Web - laboratorium 5</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Lista studentów</h1><br>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<th>Imie</th><th>Nazwisko</th><th>Email</th>");
                out.println("</tr>");
                for (Student s : students){
                    out.println("<tr><td>" + s.getFirstName() + "</td><td>" + s.getLastName() + "</td><td>" + s.getEmailAddress() + "</td></tr>");
                }
                out.println("</table>");
                out.println("<br><form action='/TPSI_5/studentList' method='get'>");
                out.println("Imie: <input type='text' name='firstName'><br>");
                out.println("Nazwisko: <input type='text' name='lastName'><br>");
                out.println("Email: <input type='email' name='emailAddress'><br>");
                out.println("<input type='submit' value='Dodaj studenta'>");
                out.println("</form>");
                out.println("<br><br>Licznik odwiedzin: " + (Integer)session.getAttribute("visitCounter"));
                out.println("</body>");
                out.println("</html>");
            }
    }
}