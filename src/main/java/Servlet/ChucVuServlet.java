package Servlet;

import Model.ChucVu;
import Repository.ChucVuRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {"" +
        "/chuc-vu/hien-thi",
        "/chuc-vu/update",
        "/chuc-vu/view-update",
        "/chuc-vu/detail",
        "/chuc-vu/delete",
        "/chuc-vu/add"

})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository repo = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChucVu> listCv = new ArrayList<>();
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            listCv = repo.getAll();
            request.setAttribute("list", listCv);
            request.getRequestDispatcher("/View/ChucVu/ChucVu.jsp").forward(request, response);
        } else if (uri.contains("detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu = repo.getById(id);
            request.setAttribute("list", chucVu);
            request.getRequestDispatcher("/View/ChucVu/Detail.jsp").forward(request, response);
        } else if (uri.contains("delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu = repo.getById(id);
            repo.delete(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        } else if (uri.contains("view-update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu = repo.getById(id);
            request.setAttribute("list", chucVu);
            request.getRequestDispatcher("/View/ChucVu/Update.jsp").forward(request, response);
        } else if (uri.contains("add")) {
            request.getRequestDispatcher("/View/ChucVu/add.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu cv = new ChucVu();
            cv.setMa(ma);
            cv.setTen(ten);
            repo.add(cv);
            response.sendRedirect("/chuc-vu/hien-thi");

        } else if (uri.contains("update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu cv = new ChucVu(id, ma, ten);
            repo.update(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }
}
