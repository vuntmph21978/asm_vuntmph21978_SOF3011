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
    <title>Detail</title>
</head>
<body>
<div class="background-image">
    <div class="container">
        <header class="d-flex justify-content-center py-3">
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="/" class="nav-link" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="/chuc-vu/hien-thi" class="nav-link ">Chức vụ</a></li>
                <li class="nav-item"><a href="/Chi-TietSp/hien-thi" class="nav-link ">Chi tiết sản phẩm</a></li>
                <li class="nav-item"><a href="/cua-hang/hien-thi" class="nav-link active">Cửa hàng</a></li>
                <li class="nav-item"><a href="/dong-san-pham/hien-thi" class="nav-link">Dòng sản phẩm</a></li>
                <li class="nav-item"><a href="/khach-hang/hien-thi" class="nav-link">Khách hàng</a></li>
                <li class="nav-item"><a href="/MauSac/hien-thi" class="nav-link">Màu sắc</a></li>
                <li class="nav-item"><a href="/NhanVien/hien-thi" class="nav-link">Nhân viên</a></li>
                <li class="nav-item"><a href="/NSX/hien-thi" class="nav-link">Nhà sản xuất</a></li>
                <li class="nav-item"><a href="/SanPham/hien-thi" class="nav-link">Sản phẩm</a></li>

            </ul>
        </header>
    </div>

<form class="form-group" action="/cua-hang/detail" method="get">
    <label>Mã</label>
    <input name="ma" placeholder="Mã" type="text" class="form-control" value="${list.ma}">
    <label>Tên</label>
    <input name="ten" placeholder="Tên" type="text" class="form-control" value="${list.ten}">
    <label>Địa Chỉ</label>
    <input name="diaChi" placeholder="Địa Chỉ" type="text" class="form-control" value="${list.diaChi}">
    <label>Thành Phố</label>
    <input name="thanhPho" placeholder="Thành Phố" type="text" class="form-control" value="${list.thanhPho}">
    <label>Quốc Gia</label>
    <input name="quocGia" placeholder="Quốc Gia" type="text" class="form-control" value="${list.quocGia}">
    <button><a href="/cua-hang/hien-thi" class="btn btn-primary">Quay lại</a></button>

</form>

<%@include file="../Bootstrap/footer.jsp"%>

</body>
</html>
