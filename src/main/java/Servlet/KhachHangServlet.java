package Servlet;

import Model.KhachHang;
import Repository.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {"/khach-hang/hien-thi",
        "/khach-hang/detail",
        "/khach-hang/update",
        "/khach-hang/delete",
        "/khach-hang/add"})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository repo = new KhachHangRepository();
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> listKhachHang = new ArrayList<>();
        String uri = request.getRequestURI();
        if (uri.contains("/khach-hang/hien-thi")) {
            listKhachHang = repo.getAll();
            request.setAttribute("list", listKhachHang);
            request.getRequestDispatcher("/View/KhachHang/KhachHang.jsp").forward(request, response);
        } else if (uri.contains("/khach-hang/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = repo.getById(id);
            String ngaySinh = date.format(khachHang.getNgaySinh());
            request.setAttribute("list", khachHang);
            request.setAttribute("ngaySinh", ngaySinh);
            request.getRequestDispatcher("/View/KhachHang/Detail.jsp").forward(request, response);
        } else if (uri.contains("/khach-hang/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = repo.getById(id);
            request.setAttribute("list", khachHang);
            request.getRequestDispatcher("/View/KhachHang/Update.jsp").forward(request, response);
        } else if (uri.contains("/khach-hang/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = repo.getById(id);
            repo.delete(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        } else if (uri.contains("/khach-hang/add")) {
            request.getRequestDispatcher("/View/KhachHang/add.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/khach-hang/add")) {
            Date ngaySinh;
            try {
                ngaySinh = date.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            KhachHang kh = new KhachHang();
            kh.setMa(request.getParameter("ma"));
            kh.setTen(request.getParameter("ten"));
            kh.setTenDem(request.getParameter("tenDem"));
            kh.setHo(request.getParameter("ho"));
            kh.setSdt(request.getParameter("sdt"));
            kh.setDiaChi(request.getParameter("diaChi"));
            kh.setThanhPho(request.getParameter("thanhPho"));
            kh.setQuocGia(request.getParameter("quocGia"));
            kh.setMatKhau(request.getParameter("matKhau"));
            kh.setNgaySinh(ngaySinh);
            repo.add(kh);
            response.sendRedirect("/khach-hang/hien-thi");
        }
        if (uri.contains("/khach-hang/update")) {
            Date ngaySinh;
            try {
                ngaySinh = date.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            KhachHang kh = new KhachHang();
            kh.setMa(request.getParameter("ma"));
            kh.setTen(request.getParameter("ten"));
            kh.setTenDem(request.getParameter("tenDem"));
            kh.setHo(request.getParameter("ho"));
            kh.setSdt(request.getParameter("sdt"));
            kh.setDiaChi(request.getParameter("diaChi"));
            kh.setThanhPho(request.getParameter("thanhPho"));
            kh.setQuocGia(request.getParameter("quocGia"));
            kh.setMatKhau(request.getParameter("matKhau"));
            kh.setNgaySinh(ngaySinh);
            repo.add(kh);
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }
}
