<%--
  Created by IntelliJ IDEA.
  User: PH22349
  Date: 29/03/2023
  Time: 1:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <title>Add</title>
</head>
<body>
<div class="background-image">
    <div class="container">
        <header class="d-flex justify-content-center py-3">
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="/" class="nav-link" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="/chuc-vu/hien-thi" class="nav-link ">Chức vụ</a></li>
                <li class="nav-item"><a href="/Chi-TietSp/hien-thi" class="nav-link ">Chi tiết sản phẩm</a></li>
                <li class="nav-item"><a href="/cua-hang/hien-thi" class="nav-link">Cửa hàng</a></li>
                <li class="nav-item"><a href="/dong-san-pham/hien-thi" class="nav-link">Dòng sản phẩm</a></li>
                <li class="nav-item"><a href="/khach-hang/hien-thi" class="nav-link active">Khách hàng</a></li>
                <li class="nav-item"><a href="/MauSac/hien-thi" class="nav-link">Màu sắc</a></li>
                <li class="nav-item"><a href="/NhanVien/hien-thi" class="nav-link">Nhân viên</a></li>
                <li class="nav-item"><a href="/NSX/hien-thi" class="nav-link">Nhà sản xuất</a></li>
                <li class="nav-item"><a href="/SanPham/hien-thi" class="nav-link">Sản phẩm</a></li>

            </ul>
        </header>
    </div>
<form action="add" method="post">
    <div>
        <label for="">Mã</label>
        <input type="text" placeholder="Ma"class="form-control" name="ma" value="${list.ma}">
    </div>
    <div>
        <label for="">Tên</label>
        <input type="text" placeholder="Ten"class="form-control" name="ten" value="${list.ten}">
    </div>
    <div>
        <label for="">Tên đệm</label>
        <input type="text" placeholder="Ten dem"class="form-control" name="tenDem" value="${list.tenDem}">
    </div>
    <div>
        <label for="">Họ</label>
        <input type="text" placeholder="Ho"class="form-control" name="ho" value="${list.ho}">
    </div>
    <div>
        <label for="">Ngày sinh</label>
        <input type="text" placeholder="Ngay sinh"class="form-control" name="ngaySinh" value="${list.ngaySinh}">
    </div>
    <div>
        <label for="">SDT</label>
        <input type="text" placeholder="sdt"class="form-control" name="sdt" value="${list.sdt}">
    </div>
    <div>
        <label for="">Địa chỉ</label>
        <input type="text" placeholder="Dia chi"class="form-control" name="diaChi" value="${list.diaChi}">
    </div>
    <div>
        <label for="">Thành phố</label>
        <input type="text" placeholder="Thanh pho"class="form-control" name="thanhPho" value="${list.thanhPho}">
    </div>
    <div>
        <label for="">Quốc gia</label>
        <input type="text" placeholder="Quoc gia"class="form-control" name="quocGia" value="${list.quocGia}">
    </div>
    <div>
        <label for="">Mật khẩu</label>
        <input type="text" placeholder="Mat khau"class="form-control" name="matKhau" value="${list.matKhau}">
    </div>
    <div>
        <button type="submit" class="btn btn-primary">Add</button>
        <button><a href="/khach-hang/hien-thi" class="btn btn-primary">Quay lại</a></button>
    </div>
</form>
<%@include file="../Bootstrap/footer.jsp"%>
</body>
</html>
