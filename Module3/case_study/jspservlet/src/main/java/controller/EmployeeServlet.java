package controller;

import model.bean.Employee;
import model.service.EmployeeService;
import model.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }
        try {
            if (actionUser.equals("addNewEmployee")) {
                String name = request.getParameter("nameEmployee");
                String date = request.getParameter("dateOfBirthEmployee");
                String id = request.getParameter("idEmployee");
                String phone = request.getParameter("phoneEmployee");
                String email = request.getParameter("emailEmployee");
                String level = request.getParameter("levelEmployee");
                String position = request.getParameter("positionEmployee");
                String workingParts = request.getParameter("workingPartEmployee");
                String address = request.getParameter("inputAddressEmployee");
                int salary = Integer.parseInt(request.getParameter("inputSalaryEmployee"));
                int idEmployee = (int) (Math.random() * 10000);

                Employee employee = new Employee(idEmployee, name, date, email, id, phone, level, address, salary, position, workingParts);

                this.employeeService.addNewEmployee(employee);
                request.setAttribute("msg","successfully added new");
                request.setAttribute("employeeListServlet", this.employeeService.showAll());
                request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
            } else if (actionUser.equals("edit")) {
                String name = request.getParameter("nameEmployee");
                String date = request.getParameter("dateOfBirthEmployee");
                String id = request.getParameter("idEmployee");
                String phone = request.getParameter("phoneEmployee");
                String email = request.getParameter("emailEmployee");
                String level = request.getParameter("levelEmployee");
                String position = request.getParameter("positionEmployee");
                String workingParts = request.getParameter("workingPartEmployee");
                String address = request.getParameter("inputAddressEmployee");
                int salary = Integer.parseInt(request.getParameter("inputSalaryEmployee"));
                int idEmployee = Integer.parseInt(request.getParameter("id"));

                Employee employee = new Employee(idEmployee, name, date, email, id, phone, level, address, salary, position, workingParts);
                List<Employee> employeeList = new ArrayList<>();
                employeeList.add(this.employeeService.showEmployeeEdit(idEmployee));
                this.employeeService.edit(employee);
                request.setAttribute("msg","Update successful");
                request.setAttribute("employeeListServlet", employeeList);
                request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }
        try {
            switch (actionUser) {
                case "addNewEmployee":
                    response.sendRedirect("addNewEmployee.jsp");
                    break;
                case "displayEmployee":
                    request.setAttribute("employeeListServlet", this.employeeService.showAll());
                    request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
                    break;
                case "edit": {
                    int id = Integer.parseInt(request.getParameter("idEmployee"));

                    request.setAttribute("employeeServlet", this.employeeService.showEmployee(id));
                    request.getRequestDispatcher("formEdit.jsp").forward(request, response);
                    break;
                }
                case "delete": {
                    int id = Integer.parseInt(request.getParameter("idEmployee"));
                    this.employeeService.delete(id);
                    List<Employee> employees = this.employeeService.showAll();
                    request.setAttribute("employeeListServlet", employees);
                    request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
                    break;
                }
            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
