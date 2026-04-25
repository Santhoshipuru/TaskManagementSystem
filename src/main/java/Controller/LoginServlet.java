package Controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if (RegisterServlet.users.containsKey(user) &&
            RegisterServlet.users.get(user).equals(pass)) {

            // 🔥 CREATE SESSION
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // 👉 go to add task page
            resp.sendRedirect(req.getContextPath() + "/addTask.html");

        } else {
            resp.sendRedirect(req.getContextPath() + "/Login.jsp?msg=invalid");
        }
    }
}