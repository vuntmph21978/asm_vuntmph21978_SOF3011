package Servlet;

import Model.NSX;
import Model.SanPham;
import Repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/SanPham/hien-thi",
        "/SanPham/update",
        "/SanPham/view-update",
        "/SanPham/detail",
        "/SanPham/delete",

})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> listSp = new ArrayList<>();
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            listSp = sanPhamRepository.getAll();
            request.setAttribute("list", listSp);
            request.getRequestDispatcher("/View/SanPham/SanPham.jsp").forward(request,response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getById(id);
            request.setAttribute("list", sanPham);
            request.getRequestDispatcher("/View/SanPham/detail.jsp").forward(request,response);
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getById(id);
            request.setAttribute("list", sanPham);
            request.getRequestDispatcher("/View/SanPham/update.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getById(id);
            sanPhamRepository.delete(sanPham);
            response.sendRedirect("/SanPham/hien-thi");
        }else if (uri.contains("add")){
            request.getRequestDispatcher("/View/SanPham/add.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            sanPhamRepository.add(new SanPham(ma,ten));
            response.sendRedirect("/SanPham/hien-thi");
        }else if (uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            sanPhamRepository.update(new SanPham(id,ma,ten));
            response.sendRedirect("/SanPham/hien-thi");
        }
    }
}
