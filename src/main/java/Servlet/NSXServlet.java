package Servlet;

import Model.MauSac;
import Model.NSX;
import Model.NhanVien;
import Repository.NSXRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {
        "/NSX/hien-thi",
        "/NSX/update",
        "/NSX/view-update",
        "/NSX/detail",
        "/NSX/delete",

})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepository = new NSXRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NSX> listNsx = new ArrayList<>();
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            listNsx = nsxRepository.getAll();
            request.setAttribute("list", listNsx);
            request.getRequestDispatcher("/View/NSX/Nsx.jsp").forward(request,response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = nsxRepository.getById(id);
            request.setAttribute("list", nsx);
            request.getRequestDispatcher("/View/NSX/detail.jsp").forward(request,response);
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = nsxRepository.getById(id);
            request.setAttribute("list", nsx);
            request.getRequestDispatcher("/View/NSX/update.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = nsxRepository.getById(id);
            nsxRepository.delete(nsx);
            response.sendRedirect("/NSX/hien-thi");
        }else if (uri.contains("add")){
            request.getRequestDispatcher("/View/NSX/add.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            nsxRepository.add(new NSX(ma,ten));
            response.sendRedirect("/NSX/hien-thi");
        }else if (uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            nsxRepository.update(new NSX(id,ma,ten));
            response.sendRedirect("/NSX/hien-thi");
        }
    }
}
