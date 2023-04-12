<%--
  Created by IntelliJ IDEA.
  User: PH22349
  Date: 29/03/2023
  Time: 12:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <title>Set</title>
</head>
<body>
<div class="container">
    <header class="d-flex justify-content-center py-3">
        <ul class="nav nav-pills">
            <li class="nav-item"><a href="/" class="nav-link" aria-current="page">Home</a></li>
            <li class="nav-item"><a href="/chuc-vu/hien-thi" class="nav-link ">Chức vụ</a></li>
            <li class="nav-item"><a href="/Chi-TietSp/hien-thi" class="nav-link ">Chi tiết sản phẩm</a></li>
            <li class="nav-item"><a href="/cua-hang/hien-thi" class="nav-link">Cửa hàng</a></li>
            <li class="nav-item"><a href="/dong-san-pham/hien-thi" class="nav-link">Dòng sản phẩm</a></li>
            <li class="nav-item"><a href="/khach-hang/hien-thi" class="nav-link">Khách hàng</a></li>
            <li class="nav-item"><a href="/MauSac/hien-thi" class="nav-link">Màu sắc</a></li>
            <li class="nav-item"><a href="/NhanVien/hien-thi" class="nav-link">Nhân viên</a></li>
            <li class="nav-item"><a href="/NSX/hien-thi" class="nav-link">Nhà sản xuất</a></li>
            <li class="nav-item"><a href="/SanPham/hien-thi" class="nav-link active">Sản phẩm</a></li>

        </ul>
    </header>
</div>
<form action="update" method="post">
    <div>
        <label for="">ID</label>
        <input type="text" placeholder="" name="id" value="${list.id}">
    </div>
    <div>
        <label for="">Mã</label>
        <input type="text" placeholder="" name="ma" value="${list.ma}">
    </div>
    <div>
        <label for="">Tên</label>
        <input type="text" placeholder="" name="ten" value="${list.ten}">
    </div>
    <div>
        <label for="">Tên đệm</label>
        <input type="text" placeholder="" name="tenDem" value="${list.tenDem}">
    </div>
    <div>
        <label for="">Họ</label>
        <input type="text" placeholder="" name="ho" value="${list.ho}">
    </div>
    <div>
        <label for="">Ngày sinh</label>
        <input type="text" placeholder="" name="ngaySinh" value="${list.ngaySinh}">
    </div>
    <div>
        <label for="">SDT</label>
        <input type="text" placeholder="" name="sdt" value="${list.sdt}">
    </div>
    <div>
        <label for="">Địa chỉ</label>
        <input type="text" placeholder="" name="diaChi" value="${list.diaChi}">
    </div>
    <div>
        <label for="">Thành phố</label>
        <input type="text" placeholder="" name="thanhPho" value="${list.thanhPho}">
    </div>
    <div>
        <label for="">Quốc gia</label>
        <input type="text" placeholder="" name="quocGia" value="${list.quocGia}">
    </div>
    <div>
        <label for="">Mật khẩu</label>
        <input type="text" placeholder="" name="matKhau" value="${list.matKhau}">
    </div>
    <div>
        <button type="submit">Update</button>
    </div>
</form>
<%@include file="../Bootstrap/footer.jsp"%>

</body>
</html>
