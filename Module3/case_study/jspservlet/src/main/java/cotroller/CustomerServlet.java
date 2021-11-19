package cotroller;

import model.bean.Customer;
import model.service.CustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }
        try {
            if (actionUser.equals("addNewCus")) {
                String idTypeCus = request.getParameter("idTypeCus");
                String name = request.getParameter("inputNameCus");
                String date = request.getParameter("dateOfBirthCus");
                String idCard = request.getParameter("idCus");
                String phone = request.getParameter("phoneCus");
                String email = request.getParameter("emailCus");
                String address = request.getParameter("inputAddressCus");
                int idCus = (int) (Math.random() * 1000);

                Customer customer = new Customer(idCus, idTypeCus, name, date, idCard, phone, email, address);
                this.customerService.addNewCus(customer);
                request.setAttribute("msg","successfully added new");
                request.setAttribute("listCus", this.customerService.showAll());
                request.getRequestDispatcher("displayCus.jsp").forward(request, response);
            } else if (actionUser.equals("edit")) {
                String idTypeCus = request.getParameter("idTypeCus");
                String name = request.getParameter("inputNameCus");
                String date = request.getParameter("dateOfBirthCus");
                String idCard = request.getParameter("idCus");
                String phone = request.getParameter("phoneCus");
                String email = request.getParameter("emailCus");
                String address = request.getParameter("inputAddressCus");
                int idCus = Integer.parseInt(request.getParameter("idCus"));

                Customer customer = new Customer(idCus, idTypeCus, name, date, idCard, phone, email, address);
                this.customerService.edit(customer);
                List<Customer> customers = new ArrayList<>();
                customers.add(this.customerService.showCus(idCus));
                request.setAttribute("msg","Update successful");
                request.setAttribute("listCus", customers);
                request.getRequestDispatcher("displayCus.jsp").forward(request, response);
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
            if (actionUser.equals("addNewCustomer")) {
                response.sendRedirect("addNewCus.jsp");
            } else if (actionUser.equals("displayCustomer")) {
                request.setAttribute("listCus", this.customerService.showAll());
                request.getRequestDispatcher("displayCus.jsp").forward(request, response);
            } else if (actionUser.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("idCus"));

                request.setAttribute("listCus", this.customerService.showCusEdit(id));
                request.getRequestDispatcher("formEditCus.jsp").forward(request, response);
            } else if (actionUser.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("idCus"));
                this.customerService.delete(id);
                request.setAttribute("listCus", this.customerService.showAll());
                request.getRequestDispatcher("displayCus.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
