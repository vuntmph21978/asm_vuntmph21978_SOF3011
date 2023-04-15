package Servlet;

import Model.DongSP;
import Repository.DongSPRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {
        "/dong-san-pham/hien-thi",
        "/dong-san-pham/update",
        "/dong-san-pham/view-update",
        "/dong-san-pham/delete",
        "/dong-san-pham/detail",

})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DongSP> listDsp = new ArrayList<>();
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            listDsp = dongSPRepository.getAll();
            request.setAttribute("list", listDsp);
            request.getRequestDispatcher("/View/DongSP/DongSP.jsp").forward(request,response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = dongSPRepository.getById(id);
            request.setAttribute("list", dongSP);
            request.getRequestDispatcher("/View/DongSP/Detail.jsp").forward(request,response);
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = dongSPRepository.getById(id);
            request.setAttribute("list", dongSP);
            request.getRequestDispatcher("/View/DongSP/Update.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = dongSPRepository.getById(id);
            dongSPRepository.delete(dongSP);
            response.sendRedirect("/dong-san-pham/hien-thi");
        }else if (uri.contains("add")){
            request.getRequestDispatcher("/View/DongSP/add.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            dongSPRepository.add(new DongSP(ma,ten));
            response.sendRedirect("/dong-san-pham/hien-thi");
        }else if (uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            dongSPRepository.update(new DongSP(id,ma,ten));
            response.sendRedirect("/dong-san-pham/hien-thi");
        }
    }
}
