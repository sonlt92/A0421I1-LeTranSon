package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser =request.getParameter("actionUser");
        if (actionUser == null){
            actionUser = "";
        }

        switch (actionUser) {
            case "showAll":
                request.setAttribute("productListServlet", this.productService.showAll());
                request.getRequestDispatcher("showAll.jsp").forward(request, response);
                break;
            case "create":
                response.sendRedirect("create.jsp");
                break;
            case "update":
                request.setAttribute("productListServlet", this.productService.showAll());
                request.getRequestDispatcher("update.jsp").forward(request, response);
                break;
            case "delete":
                request.setAttribute("productListServlet", this.productService.showAll());
                request.getRequestDispatcher("delete.jsp").forward(request, response);
                break;
            case "show":
                request.setAttribute("productListServlet", this.productService.showAll());
                request.getRequestDispatcher("showList.jsp").forward(request, response);
                break;
            case "search":
                response.sendRedirect("search.jsp");
                break;
        }
        if (request.getParameter("index") != null){
            int index = Integer.parseInt(request.getParameter("index")) - 1;
            request.setAttribute("productUpdate", this.productService.showAll().get(index));
            request.getRequestDispatcher("formUpdate.jsp").forward(request, response);
        }
        if (request.getParameter("indexDelete") != null){
            int index = Integer.parseInt(request.getParameter("indexDelete")) - 1;

            this.productService.delete(this.productService.showAll().get(index).getId());
            request.setAttribute("productListServlet", this.productService.showAll());
            request.getRequestDispatcher("showAll.jsp").forward(request, response);
        }
        if (request.getParameter("indexShow") != null){
            int index = Integer.parseInt(request.getParameter("indexShow")) - 1;

            request.setAttribute("productShowDetails", this.productService.showAll().get(index));
            request.getRequestDispatcher("showDetails.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser =request.getParameter("actionUser");
        if (actionUser == null){
            actionUser = "";
        }

        switch (actionUser){
            case "create":
                String name = request.getParameter("name");
                int price = Integer.parseInt(request.getParameter("price"));
                String productDescription = request.getParameter("productDescription");
                String manufacturer = request.getParameter("manufacturer");
                int id = (int) (Math.random() * 1000);

                Product product = new Product(id,name,price,productDescription,manufacturer);

                this.productService.addNewProduct(product);
                request.setAttribute("productListServlet", this.productService.showAll());
                request.getRequestDispatcher("showAll.jsp").forward(request, response);
                break;
            case "update":
                int idUpdate = Integer.parseInt(request.getParameter("id"));
                String nameUpdate = request.getParameter("name");
                int priceUpdate = Integer.parseInt(request.getParameter("price"));
                String productDescriptionUpdate = request.getParameter("productDescription");
                String manufacturerUpdate = request.getParameter("manufacturer");

                Product productUpdate = new Product(idUpdate,nameUpdate,priceUpdate,productDescriptionUpdate,manufacturerUpdate);

                this.productService.addNewProduct(productUpdate);
                request.setAttribute("productListServlet", this.productService.showAll());
                request.getRequestDispatcher("showAll.jsp").forward(request, response);
            default:
                String nameSearch = request.getParameter("search");
                String msg = null;
                for (Product productList: this.productService.showAll()) {
                    if (nameSearch.equals(productList.getName())){
                        msg = "Details";
                        request.setAttribute("msg",msg);
                        request.setAttribute("productDetail", productList);
                        request.getRequestDispatcher("search.jsp").forward(request,response);
                        break;
                    }
                }
                msg = "not found";
                request.setAttribute("msg",msg);
                request.getRequestDispatcher("search.jsp").forward(request,response);
        }

    }
}

