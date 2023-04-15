<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="View/Bootstrap/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>

<div class="loading"></div>
<div class="background-image" id="data" class="hidden">
    <div class="container">
        <header class="d-flex justify-content-center py-3">
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="/home" class="nav-link active" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="/chuc-vu/hien-thi" class="nav-link">Chức vụ</a></li>
                <li class="nav-item"><a href="/Chi-TietSp/hien-thi" class="nav-link">Chi tiết sản phẩm</a></li>
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

    <div class="row g-4 py-5 row-cols-1 row-cols-lg-3" style="text-align: center">
        <div class="feature col">

            <h3 class="fs-2" style="text-align: center">Chức vụ</h3>
            <a href="/chuc-vu/hien-thi">
                <img src="View/Bootstrap/chucvu.jfif">
                <br>
                <a href="/chuc-vu/hien-thi" class="btn btn-sm btn-outline-secondary">
                    Call to action
                </a>
            </a>
        </div>
        <div class="feature col">
            <h3 class="fs-2" style="text-align: center">Chi tiết sản phẩm</h3>
            <a href="/Chi-TietSp/hien-thi">
                <img src="View/Bootstrap/chitietsanpham.jfif">
                <br>
                <a href="/Chi-TietSp/hien-thi" class="btn btn-sm btn-outline-secondary">
                    Call to action
                </a></a>
        </div>
        <div class="feature col">
            <h3 class="fs-2" style="text-align: center">Cửa hàng</h3>
            <a href="/cua-hang/hien-thi">
                <img src="View/Bootstrap/cuahang.jfif">
                <br>
                <a href="/cua-hang/hien-thi" class="btn btn-sm btn-outline-secondary">
                    Call to action
                </a></a>
        </div>
        <div class="feature col">
            <h3 class="fs-2" style="text-align: center">Dòng sản phẩm</h3>
            <a href="/dong-san-pham/hien-thi">
                <img src="View/Bootstrap/dongsanpham.jfif">
                <br>
                <a href="/dong-san-pham/hien-thi" class="btn btn-sm btn-outline-secondary">
                    Call to action
                </a></a>
        </div>
        <div class="feature col">
            <h3 class="fs-2" style="text-align: center">Khách hàng</h3>
            <a href="/khach-hang/hien-thi">
                <img src="View/Bootstrap/khachhang.jfif">
                <br>
                <a href="/khach-hang/hien-thi" class="btn btn-sm btn-outline-secondary">
                    Call to action
                </a></a>
        </div>
        <div class="feature col">
            <h3 class="fs-2" style="text-align: center">Màu sắc</h3>
            <a href="/MauSac/hien-thi">
                <img src="View/Bootstrap/mausac.jfif">
                <br>
                <a href="/MauSac/hien-thi" class="btn btn-sm btn-outline-secondary">
                    Call to action
                </a></a>
        </div>
        <div class="feature col">
            <h3 class="fs-2" style="text-align: center">Nhân viên</h3>
            <a href="/NhanVien/hien-thi">
                <img src="View/Bootstrap/nhanvien.jfif">
                <br>
                <a href="/NhanVien/hien-thi" class="btn btn-sm btn-outline-secondary">
                    Call to action
                </a></a>
        </div>
        <div class="feature col">
            <h3 class="fs-2" style="text-align: center">Nhà sản xuất</h3>
            <a href="/NSX/hien-thi">
                <img src="View/Bootstrap/nhasanxuat.jfif">
                <br>
                <a href="/NSX/hien-thi" class="btn btn-sm btn-outline-secondary">
                    Call to action
                </a></a>
        </div>
        <div class="feature col">
            <h3 class="fs-2" style="text-align: center">Sản phẩm</h3>
            <a href="/SanPham/hien-thi">
                <img src="View/Bootstrap/sanpham.jfif">
                <br>
                <a href="/SanPham/hien-thi" class="btn btn-sm btn-outline-secondary">
                    Call to action
                </a></a>
        </div>
    </div>


    <div class="container">
        <footer class="py-3 my-4">
            <ul class="nav justify-content-center border-bottom pb-3 mb-3">
                <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Home</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Features</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Pricing</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">FAQs</a></li>
                <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">About</a></li>
            </ul>
            <p class="text-center text-muted">© 2021 Company, Inc</p>
        </footer>
    </div>
</div>


<br/>

</body>
</html>