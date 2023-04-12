package Servlet;

import Model.ChucVu;
import Model.MauSac;
import Repository.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {
        "/MauSac/hien-thi",
        "/MauSac/update",
        "/MauSac/view-update",
        "/MauSac/detail",
        "/MauSac/delete",
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository = new MauSacRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MauSac> listMs = new ArrayList<>();
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            listMs = mauSacRepository.getAll();
            request.setAttribute("list", listMs );
            request.getRequestDispatcher("/View/MauSac/MauSac.jsp").forward(request,response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getById(id);
            request.setAttribute("list", mauSac);
            request.getRequestDispatcher("/View/MauSac/detail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac  = mauSacRepository.getById(id);
            mauSacRepository.delete(mauSac);
            response.sendRedirect("/Cua-Hang/hien-thi");
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac  = mauSacRepository.getById(id);
            request.setAttribute("list", mauSac);
            request.getRequestDispatcher("/View/MauSac/update.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
