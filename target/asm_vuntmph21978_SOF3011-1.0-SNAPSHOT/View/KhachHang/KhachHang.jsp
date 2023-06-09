<%--
  Created by IntelliJ IDEA.
  User: PH22349
  Date: 29/03/2023
  Time: 1:21 SA
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <title>Khach hang</title>
    <link rel="stylesheet" href="../Bootstrap/index.css">
</head>
<body>
<div class="background-image">

    <div class="background-image">
        <div class="container">
            <header class="d-flex justify-content-center py-3">
                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="/home" class="nav-link" aria-current="page">Home</a></li>
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

<a type="button" class="btn btn-primary" href="/khach-hang/add">Add</a>
<table class="table">
    <thead>
    <th>ID</th>
    <th>Mã</th>
    <th>Tên</th>
    <th>Tên đệm</th>
    <th>Họ</th>
    <th>Ngày sinh</th>
    <th>SDT</th>
    <th>Địa chỉ</th>
    <th>Thành Phố</th>
    <th>Quốc gia</th>
    <th>Mật khẩu</th>
    <th>Hành động</th>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.ma}</td>
            <td>${l.ten}</td>
            <td>${l.tenDem}</td>
            <td>${l.ho}</td>
            <td>${l.ngaySinh}</td>
            <td>${l.sdt}</td>
            <td>${l.diaChi}</td>
            <td>${l.thanhPho}</td>
            <td>${l.quocGia}</td>
            <td>${l.matKhau}</td>
            <td>
                <a type="button" class="btn btn-primary" href="/khach-hang/detail?id=${l.id}">Detail</a>
                <a type="button" class="btn btn-danger" href="/khach-hang/delete?id=${l.id}">Delete</a>
                <a type="button" class="btn btn-warning" href="/khach-hang/update?id=${l.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="../Bootstrap/footer.jsp" %>
</div>
</body>
</html>
