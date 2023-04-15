package Servlet;

import Model.ChiTietSP;
import Repository.ChiTietSPRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChiTietSpServlet", value = {
        "/Chi-TietSp/hien-thi",
        "/Chi-TietSp/detail",
        "/Chi-TietSp/update",
        "/Chi-TietSp/view-update",
        "/Chi-TietSp/add",
        "/Chi-TietSp/delete"


})
public class ChiTietSpServlet extends HttpServlet {
     private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChiTietSP> listCtsp = new ArrayList<>();
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            listCtsp = chiTietSPRepository.getAll();
            request.setAttribute("list", listCtsp);
            request.getRequestDispatcher("/View/ChiTietSP/ChiTietSP.jsp").forward(request,response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP ctsp=  chiTietSPRepository.getByID(id);
            request.setAttribute("list",ctsp);
            request.getRequestDispatcher("/View/ChiTietSP/Detail.jsp").forward(request,response);
        }else if (uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP ctsp=  chiTietSPRepository.getByID(id);
            request.setAttribute("list",ctsp);
            request.getRequestDispatcher("/View/ChiTietSP/Update.jsp").forward(request,response);
        }else if (uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP ctsp=  chiTietSPRepository.getByID(id);
            chiTietSPRepository.Delete(ctsp);
            response.sendRedirect("/Chi-TietSp/hien-thi");
        }
        else if (uri.contains("add")){
            request.getRequestDispatcher("/View/ChiTietSP/add.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")){
            Integer namBH = Integer.parseInt(request.getParameter("namBH"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            float giaNhap = Float.parseFloat(request.getParameter("giaNhap"));
            float giaBan = Float.parseFloat(request.getParameter("giaBan"));
            chiTietSPRepository.Add(new ChiTietSP(giaBan,giaNhap,moTa,namBH,soLuongTon));
            response.sendRedirect("/Chi-TietSp/hien-thi");
        }else if (uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            Integer namBH = Integer.parseInt(request.getParameter("namBH"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            float giaNhap = Float.parseFloat(request.getParameter("giaNhap"));
            float giaBan = Float.parseFloat(request.getParameter("giaBan"));
            chiTietSPRepository.Update(new ChiTietSP(id,namBH, moTa, soLuongTon, giaNhap, giaBan));
            response.sendRedirect("/Chi-TietSp/hien-thi");
        }
    }
}
