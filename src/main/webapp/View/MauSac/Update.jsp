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
            <li class="nav-item"><a href="/MauSac/hien-thi" class="nav-link active">Màu sắc</a></li>
            <li class="nav-item"><a href="/NhanVien/hien-thi" class="nav-link">Nhân viên</a></li>
            <li class="nav-item"><a href="/NSX/hien-thi" class="nav-link">Nhà sản xuất</a></li>
            <li class="nav-item"><a href="/SanPham/hien-thi" class="nav-link">Sản phẩm</a></li>

        </ul>
    </header>
</div>
<form class="form-group" action="/mau-sac/update?id=${mauSac.id}" method="post">

    <label>Mã</label>
    <input name="ma" placeholder="Mã" class="form-control" value="${list.ma}">
    <label>Tên</label>
    <input name="ten" placeholder="Tên" class="form-control" value="${list.ten}">
    <br>
    <button class="btn btn-primary"  type="submit">Update</button>
</form>
<%@include file="../Bootstrap/footer.jsp"%>

</body>
</html>
