package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Model.Task;
import Service.TaskServiceImpl;

@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    TaskServiceImpl service = new TaskServiceImpl();

    // =========================
    // ADD + UPDATE
    // =========================
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        // 🔐 SESSION CHECK
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/Login.jsp");
            return;
        }

        // ADD TASK
        if ("add".equals(action)) {

            String title = req.getParameter("title");
            String desc = req.getParameter("description");
            String status = req.getParameter("status");

            Task task = new Task(title, desc, status);
            service.addTask(task);

            // 🔥 redirect to list
            resp.sendRedirect(req.getContextPath() + "/TaskServlet");
        }

        // UPDATE TASK
        else if ("update".equals(action)) {

            int id = Integer.parseInt(req.getParameter("id"));

            String title = req.getParameter("title");
            String desc = req.getParameter("description");
            String status = req.getParameter("status");

            Task task = new Task(title, desc, status);

            service.updateTask(id, task);

            resp.sendRedirect(req.getContextPath() + "/TaskServlet");
        }
    }

    // =========================
    // VIEW + DELETE + EDIT
    // =========================
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 🔐 SESSION CHECK
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/Login.jsp");
            return;
        }

        String action = req.getParameter("action");

        // DELETE
        if ("delete".equals(action)) {

            int id = Integer.parseInt(req.getParameter("id"));

            service.deleteTask(id);

            resp.sendRedirect(req.getContextPath() + "/TaskServlet");
            return;
        }

        // EDIT PAGE
        if ("edit".equals(action)) {

            int id = Integer.parseInt(req.getParameter("id"));

            Task task = service.getTask(id);

            req.setAttribute("task", task);

            RequestDispatcher rd = req.getRequestDispatcher("editTask.jsp");
            rd.forward(req, resp);
            return;
        }

        // VIEW ALL TASKS
        List<Task> tasks = service.getAllTasks();

        req.setAttribute("tasks", tasks);

        RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
        rd.forward(req, resp);
    }
}