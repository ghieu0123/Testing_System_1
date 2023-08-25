//khởi tạo danh sách cho bảng nhân viên
function initTableAccount() {
    $('tbody').empty();
    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts',
        type: 'GET',
        async: false,
        success: function (result) {
            result.forEach(function (item) {
                $('tbody').append(
                    '<tr>' +
                    '<td>' + item.accountId + '</td>' +
                    '<td>' + item.fullName + '</td>' +
                    '<td>' + item.department.name + '</td>' +
                    '<td>' + item.phone + '</td>' +
                    '<td>' +
                    '<a class="edit" title="Edit" data-toggle="tooltip" onclick ="opendUpdateModalAccount(' + item.accountId + ')"><i class="material-icons">&#xE254;</i></a>' +
                    '<a class="delete" title="Delete" data-toggle="tooltip" onclick ="deleteAccount(' + item.accountId + ')"><i class="material-icons">&#xE872;</i></a>' +
                    '</td>' +
                    '</tr>'
                )
            });
        }
    });
}

// tạo dropdown phòng ban
function initDepartmentCbList() {
    $('#department-select').empty();
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'GET',
        async: false,
        success: function (result) {
            result.forEach(function (item) {
                $('#department-select').append(
                    '<option' + ' value="' + item.id + '">' + item.name + '</option>'
                )
            });
        }
    });
}

function openAddNewModalAccount() {
    $("#accountModal").modal("show");
    initDepartmentCbList();
    resetAccountModal();
}

function saveAccount() {
    var accountId = document.getElementById("accountId").value;
    validateAccount(accountId);
}

function opendUpdateModalAccount(accountId) {
    openAddNewModalAccount();
    // gọi api lấy nhân viên theo id
    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts/' + accountId,
        type: 'GET',
        async: false,
        success: function (result) {
            //fill data
            document.getElementById("department-select").value = result.department.id;
            document.getElementById("accountId").value = result.accountId;
            document.getElementById("fullName").value = result.fullName;
            document.getElementById("email").value = result.email;
            document.getElementById("password").value = result.password;
            document.getElementById("confirmPassword").value = result.confirmPassword;
            document.getElementById("phone").value = result.phone;
        }
    });
}

function createNewAccount() {

    var fullName = document.getElementById("fullName").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var phone = document.getElementById("phone").value;
    var departmentId = document.getElementById("department-select").value;

    var account = {
        fullName: fullName,
        email: email,
        password: password,
        confirmPassword: confirmPassword,
        phone: phone,
        department: {
            id: departmentId
        }
    }
    // gọi api thêm mới nhân viên
    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts',
        type: 'POST',
        data: JSON.stringify(account),
        async: false,
        contentType: "application/json;charset=utf-8",
        success: function (result) {
        }
    });

    initTableAccount();
    hideAddNewModalAccount();
}

function updateAccount(accountId) {

    var fullName = document.getElementById("fullName").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var phone = document.getElementById("phone").value;
    var departmentId = document.getElementById("department-select").value;

    var account = {
        fullName: fullName,
        email: email,
        password: password,
        confirmPassword: confirmPassword,
        phone: phone,
        department: {
            id: departmentId
        }
    }

    // gọi api để cập nhật nhân viên 
    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts/' + accountId,
        type: 'PUT',
        data: JSON.stringify(account),
        async: false,
        contentType: "application/json;charset=utf-8",
        success: function (result) {

        }
    });
    initTableAccount();
    hideAddNewModalAccount();
}

function deleteAccount(accountId) {
    var result = confirm("có chắc chắn xóa không?");
    if (result == true) {
        $.ajax({
            url: 'http://localhost:8080/api/v1/accounts/' + accountId,
            type: 'DELETE',
            async: false,
            success: function (result) {

            }
        });

        initTableAccount();
        showAlertSuccess();
    }
}

function validateAccount(accountId) {
    var message = [];
    var fullName = document.getElementById("fullName").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var phone = document.getElementById("phone").value;
    var departmentId = document.getElementById("department-select").value;

    if (fullName == "") {
        message.push("Bạn chưa nhập full name\n");
    }
    if (email == "") {
        message.push("Bạn chưa nhập email\n");
    }
    if (password == "") {
        message.push("Bạn chưa nhập password\n");
    }
    if (confirmPassword == "") {
        message.push("Bạn chưa nhập confirmPassword\n");
    }
    if (phone == "") {
        message.push("Bạn chưa nhập phone\n");
    }
    if(password != "" && confirmPassword != ""){
        if (password != confirmPassword) {
            message.push("password và confirmPassword không khớp");
        }
    }
    
    if (message.length > 0) {
        alert(message);
        return;
    } else {
        if (accountId == null || accountId == "") {
            createNewAccount();
        } else {
            updateAccount(accountId);
        }
        showAlertSuccess();
    }

}

function hideAddNewModalAccount() {
    $("#accountModal").modal("hide");
}

function resetAccountModal() {
    document.getElementById("accountId").value = "";
    document.getElementById("fullName").value = "";
    document.getElementById("email").value = "";
    document.getElementById("password").value = "";
    document.getElementById("confirmPassword").value = "";
    document.getElementById("phone").value = "";
}