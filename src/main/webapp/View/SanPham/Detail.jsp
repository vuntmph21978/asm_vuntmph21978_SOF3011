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
<form class="form-group" action="">
    <div>
        <label for="">ID</label>
        <input class="form-control" type="text" placeholder="" name="id" value="${list.id}" readonly>
    </div>
    <div>
        <label for="">Mã</label>
        <input class="form-control" type="text" placeholder="" name="ma" value="${list.ma}" readonly>
    </div>
    <div>
        <label for="">Tên</label>
        <input class="form-control" type="text" placeholder="" name="ten" value="${list.ten}" readonly>
    </div>
    <div>
        <label for="">Tên đệm</label>
        <input class="form-control" type="text" placeholder="" name="tenDem" value="${list.tenDem}"readonly>
    </div>
    <div>
        <label for="">Họ</label>
        <input class="form-control" type="text" placeholder="" name="ho" value="${list.ho}"readonly>
    </div>
    <div>
        <label for="">Ngày sinh</label>
        <input class="form-control" type="date" placeholder="" name="ngaySinh" value="${ngaySinh}"readonly>
    </div>
    <div>
        <label for="">SDT</label>
        <input class="form-control" type="text" placeholder="" name="sdt" value="${list.sdt}"readonly>
    </div>
    <div>
        <label for="">Địa chỉ</label>
        <input class="form-control" type="text" placeholder="" name="diaChi" value="${list.diaChi}"readonly>
    </div>
    <div>
        <label for="">Thành phố</label>
        <input  class="form-control"type="text" placeholder="" name="thanhPho" value="${list.thanhPho}"readonly>
    </div>
    <div>
        <label for="">Quốc gia</label>
        <input  class="form-control"type="text" placeholder="" name="quocGia" value="${list.quocGia}"readonly>
    </div>
    <div>
        <label for="">Mật khẩu</label>
        <input class="form-control" type="text" placeholder="" name="matKhau" value="${list.matKhau}"readonly>
    </div>
    <button><a href="/khach-hang/hien-thi">Quay lại</a></button>
</form>
<%@include file="../Bootstrap/footer.jsp"%>

</body>
</html>
