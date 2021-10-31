import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Object> listCustomer = new ArrayList<>();
        listCustomer.add(new Customers("Nguyen Van A","1992-06-29","Quang Binh", "/img/1.jpg"));
        listCustomer.add(new Customers("Nguyen Van B","1993-03-11","Quang Ngai", "/img/1.jpg"));
        listCustomer.add(new Customers("Nguyen Van C","1995-04-11","Quang Tri", "/img/1.jpg"));
        listCustomer.add(new Customers("Nguyen Van D","1994-12-11","Ha Noi", "/img/1.jpg"));

        request.setAttribute("customer",listCustomer);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
