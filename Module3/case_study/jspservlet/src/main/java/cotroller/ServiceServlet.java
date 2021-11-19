package cotroller;

import model.bean.Service;
import model.service.ServicesService;
import model.service.impl.ServicesServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = {"/","/ServiceServlet"})

@MultipartConfig(
        fileSizeThreshold = 2097152,
        maxFileSize = 10485760L,
        maxRequestSize = 52428800L
)

public class ServiceServlet extends HttpServlet {
    private static final long SerialVersionUID = 1L;

    ServicesService servicesService = new ServicesServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }
        try {
            if (actionUser.equals("addNewService")) {
                //        luu du lieu vao thu muc /upload
                String uploadFolder = request.getServletContext().getRealPath("/imageService");
                Path uploadpath = Paths.get(uploadFolder);

                // neu thu muc chua ton tai thi tao moi
                if (!Files.exists(uploadpath)) {
                    Files.createDirectories(uploadpath);
                }

                // lay du lieu nguoi dung up load toi server
                Part imgPart = request.getPart("linkImg");

                //tra ve ten file nguoi dung up load du lieu
                String imgFileName = Paths.get(imgPart.getContentType()).getFileName().toString();

                imgPart.write(Paths.get(uploadpath.toString(), imgFileName).toString());

                String name = request.getParameter("nameService");
                int areaUsed = Integer.parseInt(request.getParameter("areaUsed"));
                int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
                int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
                int rentalCosts = Integer.parseInt(request.getParameter("rentalCosts"));
                String rentalType = request.getParameter("rentalType");
                String typeOfService = request.getParameter("typeOfService");
                int id = (int) (Math.random() * 1000);
                String linkImg = "imageService/" + imgFileName;

                Service service = new Service(id, name, areaUsed, numberOfFloors, maxPeople, rentalCosts, rentalType, typeOfService, linkImg);
                this.servicesService.addNewService(service);
                showServiceByPagination(request,response);
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
            if (actionUser.equals("addNewService")) {
                response.sendRedirect("addNewService.jsp");
            } else if (actionUser.equals("displayService")) {
                showServiceByPagination(request,response);
            }else if (actionUser.equals("displayServiceDetail")){
                int id = Integer.parseInt(request.getParameter("id"));
                List<Service> list = new ArrayList<>();
                list.add(this.servicesService.showServiceByID(id));
                request.setAttribute("detailService",list);
                request.getRequestDispatcher("displayDetailService.jsp").forward(request,response);
            }
        }catch (Exception e){

        }
    }
    protected void showServiceByPagination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = this.servicesService.showAll().size();
        int pageSize = 3;
        int endPage = 0;
        endPage = count / pageSize;
        if (count % pageSize !=0){
            endPage++;
        }
        int index = 0;
        if (request.getParameter("index") == null){
            index = 1;
        }else {
            index = Integer.parseInt(request.getParameter("index"));
        }

        if (index == 0){
            index = 1;
        }
        if (index > endPage){
            index = endPage;
        }
        request.setAttribute("index",index);
        request.setAttribute("endPage",endPage);
        request.setAttribute("listService", this.servicesService.displayPagination(index));
        request.getRequestDispatcher("displayService.jsp").forward(request, response);
    }
}
