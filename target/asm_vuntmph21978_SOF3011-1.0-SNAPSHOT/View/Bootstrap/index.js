setTimeout(function () {
    const loader = document.querySelector('.loading');
    const dataTable = document.querySelector('#data');
    loader.className += ' hidden'; // class "hidden" để ẩn đi hiệu ứng loading khi trang được tải hoàn tất
    dataTable.className = dataTable.className.replace('hidden', ''); // class "hidden" để ẩn bảng dữ liệu ban đầu
    generateData();
}, 3000);