package Controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    public static HashMap<String, String> users = new HashMap<>();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if (users.containsKey(user)) {

            // 👉 redirect back to register with message
            resp.sendRedirect(req.getContextPath() + "/Register.html?msg=exists");

        } else {

            users.put(user, pass);

            // 👉 redirect to login page
            resp.sendRedirect(req.getContextPath() + "/Login.jsp?msg=registered");
        }
    }
}