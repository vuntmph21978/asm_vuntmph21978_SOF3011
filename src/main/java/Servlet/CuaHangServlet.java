package Servlet;

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
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CuaHang> listCh = new ArrayList<>();
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            listCh = cuaHangRepository.getAll();
            request.setAttribute("list", listCh);
            request.getRequestDispatcher("/View/CuaHang/CuaHang.jsp").forward(request,response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getById(id);
            request.setAttribute("list", cuaHang);
            request.getRequestDispatcher("/View/CuaHang/Detail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getById(id);
            cuaHangRepository.delete(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getById(id);
            request.setAttribute("list", cuaHang);
            request.getRequestDispatcher("/View/CuaHang/Update.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
