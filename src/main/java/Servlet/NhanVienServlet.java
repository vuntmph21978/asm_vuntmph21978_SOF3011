package Servlet;

import Model.NhanVien;
import Repository.NhanVienRepository;
import com.oracle.wls.shaded.org.apache.bcel.generic.IUSHR;
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

@WebServlet(name = "NhanVienServlet", value = {
        "/NhanVien/hien-thi",
        "/NhanVien/update",
        "/NhanVien/view-update",
        "/NhanVien/detail",
        "/NhanVien/delete",
        "/NhanVien/add"

})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> listNv = new ArrayList<>();
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            listNv = nhanVienRepository.getAll();
            request.setAttribute("list", listNv);
            request.getRequestDispatcher("/View/NhanVien/NhanVien.jsp").forward(request,response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getById(id);
            request.setAttribute("list", nhanVien);
            request.getRequestDispatcher("/View/NhanVien/detail.jsp").forward(request,response);
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getById(id);
            request.setAttribute("list", nhanVien);
            request.getRequestDispatcher("/View/NhanVien/update.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getById(id);
            nhanVienRepository.delete(nhanVien);
            response.sendRedirect("/NhanVien/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh;
            try{
                ngaySinh =  simpleDateFormat.parse(request.getParameter("ngaySinh"));
            }catch (ParseException e){
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String trangThai = request.getParameter("trangThai");
            nhanVienRepository.add(new NhanVien(ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, trangThai));
            response.sendRedirect("/nhan-vien/hien-thi");
        }else  if(uri.contains("update")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh;
            try{
                ngaySinh =  simpleDateFormat.parse(request.getParameter("ngaySinh"));
            }catch (ParseException e){
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String trangThai = request.getParameter("trangThai");
            nhanVienRepository.update(new NhanVien(ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, trangThai));
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }

}
