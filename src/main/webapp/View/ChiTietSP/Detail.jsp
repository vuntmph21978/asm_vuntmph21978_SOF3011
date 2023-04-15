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
<body><div class="background-image">
<div class="container">
    <header class="d-flex justify-content-center py-3">
        <ul class="nav nav-pills">
            <li class="nav-item"><a href="/" class="nav-link" aria-current="page">Home</a></li>
            <li class="nav-item"><a href="/chuc-vu/hien-thi" class="nav-link">Chức vụ</a></li>
            <li class="nav-item"><a href="/Chi-TietSp/hien-thi" class="nav-link active">Chi tiết sản phẩm</a></li>
            <li class="nav-item"><a href="/cua-hang/hien-thi" class="nav-link">Cửa hàng</a></li>
            <li class="nav-item"><a href="/dong-san-pham/hien-thi" class="nav-link">Dòng sản phẩm</a></li>
            <li class="nav-item"><a href="/khach-hang/hien-thi" class="nav-link">Khách hàng</a></li>
            <li class="nav-item"><a href="/MauSac/hien-thi" class="nav-link">Màu sắc</a></li>
            <li class="nav-item"><a href="/NhanVien/hien-thi" class="nav-link">Nhân viên</a></li>
            <li class="nav-item"><a href="/NSX/hien-thi" class="nav-link">Nhà sản xuất</a></li>
            <li class="nav-item"><a href="/SanPham/hien-thi" class="nav-link">Sản phẩm</a></li>

        </ul>
    </header>
</div>

<form class="form-group" method="post" action="/Chitiet-sp/update?id=${list.id}">

    <%--    <label>IdNsx</label>--%>
    <%--    <input name="idNsx" placeholder="IdNsx" class="form-control" value="${list.idNsx}" >--%>

    <%--    <label>IdSP </label>--%>
    <%--    <input name="idSp" placeholder="ID" class="form-control" value="${list.idSp.ma}">--%>

    <%--    <label>IdMauSac</label>--%>
    <%--    <input name="idMs" placeholder="ID" class="form-control" value="${list.idMs.ma}">--%>

    <%--    <label>IdDongSp</label>--%>
    <%--    <input name="idDongSp" placeholder="IdDongSp" class="form-control" value="${list.idDongSp.ma}">--%>

    <label>Năm Sx</label>
    <input name="namSX" placeholder="Năm Sx" class="form-control" value="${list.namSX}">

    <label>Mô tả</label>
    <input name="moTa" placeholder="Mô tả" class="form-control" value="${list.moTa}">

    <label>Số lượng tồn </label>
    <input name="soLuongTon" placeholder="Số lượng tồn " class="form-control" value="${list.soLuongTon}">

    <label>Giá nhập </label>
    <input name="giaNhap" placeholder="Giá nhập" class="form-control" value="${list.giaNhap}">

    <label>Giá bán </label>
    <input name="giaBan" placeholder="Giá bán" class="form-control" value="${list.giaBan}">
    <br>
        <a class="btn btn-primary" href="/Chi-TietSp/hien-thi" type="button"> Quay lại</a>

</form>
    <%@include file="../Bootstrap/footer.jsp" %>
</div>
</body>
</html>
