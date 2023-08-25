//khởi tạo danh sách cho bảng phòng ban
function initTableDepartment() {
    $('tbody').empty();
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'GET',
        async: false,
        success: function (result) {
            result.forEach(function (item) {
                $('tbody').append(
                    '<tr>' +
                    '<td>' + item.id + '</td>' +
                    '<td>' + item.name + '</td>' +
                    '<td>' +
                    '<a class="edit" title="Edit" data-toggle="tooltip" onclick ="opendUpdateModalDepartment(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
                    '<a class="delete" title="Delete" data-toggle="tooltip" onclick ="deleteDepartment(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
                    '</td>' +
                    '</tr>'
                )
            });
        }
    });
}

function hideAddNewModalDepartment() {
    $("#departmentModal").modal("hide");
}

function openAddNewModalDepartment() {
    $("#departmentModal").modal("show");
    resetModalDepartment();
}

function saveDepartment() {
    var departmentId = document.getElementById("departmentId").value;

    if (departmentId == null || departmentId == "") {
        createNewDepartment();
    } else {
        updateDepartment(departmentId);
    }
    showAlertSuccess();
}

function createNewDepartment() {
    var name = document.getElementById("name").value;

    var department = {
        name: name

    }
    // gọi api thêm mới phòng ban
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'POST',
        data: JSON.stringify(department),
        contentType: "application/json;charset=utf-8",
        async: false,
        success: function (result) {
        }
    });

    initTableDepartment();
    hideAddNewModalDepartment();
}

function updateDepartment(departmentId) {
    var name = document.getElementById("name").value;

    var department = {
        name: name

    }
    // gọi api để cập nhật phòng ban
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + departmentId,
        type: 'PUT',
        data: JSON.stringify(department),
        async: false,
        contentType: "application/json;charset=utf-8",
        success: function (result) {

        }
    });
    initTableDepartment();
    hideAddNewModalDepartment();
}

function opendUpdateModalDepartment(departmentId) {
    openAddNewModalDepartment();
    // gọi api lấy phòng ban theo id
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + departmentId,
        type: 'GET',
        async: false,
        success: function (result) {
            //fill data
            document.getElementById("departmentId").value = result.id;
            document.getElementById("name").value = result.name;
        }
    });
}


function resetModalDepartment() {
    document.getElementById("departmentId").value = "";
    document.getElementById("name").value = "";
}

function deleteDepartment(departmentId) {
    var result = confirm("có chắc chắn xóa không?");
    if (result == true) {
        $.ajax({
            url: 'http://localhost:8080/api/v1/departments/' + departmentId,
            type: 'DELETE',
            async: false,
            success: function (result) {

            }
        });

        initTableDepartment();
        showAlertSuccess();
    }
}