package Servlet;

import Model.ChucVu;
import Model.CuaHang;
import Repository.CuaHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/update",
        "/cua-hang/view-update",
        "/cua-hang/detail",
        "/cua-hang/delete",

})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository repo = new CuaHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CuaHang> listCh = new ArrayList<>();
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            listCh = repo.getAll();
            request.setAttribute("list", listCh);
            request.getRequestDispatcher("/View/CuaHang/CuaHang.jsp").forward(request,response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = repo.getById(id);
            request.setAttribute("list", cuaHang);
            request.getRequestDispatcher("/View/CuaHang/Detail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = repo.getById(id);
            repo.delete(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = repo.getById(id);
            request.setAttribute("list", cuaHang);
            request.getRequestDispatcher("/View/CuaHang/Update.jsp").forward(request,response);
        }else if (uri.contains("add")){
            request.getRequestDispatcher("/View/CuaHang/add.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quoGia");
            repo.add(new CuaHang(ma,ten,diaChi,thanhPho,quocGia));
            response.sendRedirect("/cua-hang/hien-thi");

        } else if (uri.contains("update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quoGia");
            repo.update(new CuaHang(id,ma,ten,diaChi,thanhPho,quocGia));
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }
}
