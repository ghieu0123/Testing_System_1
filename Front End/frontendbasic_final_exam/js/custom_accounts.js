$(function(){
    $(".close").click(function(){
        $(".close").hide();
        $(".open").show();
        $(".vertical-menu li a .menu-icon").show();
        $(".vertical-menu li a .text").hide();
        $(".sidebar").css("width","7%");
        $(".main").css("width","93%");    
    });
    $(".open").click(function(){
        $(".open").hide();
        $(".close").show();
        $(".vertical-menu li a .menu-icon").hide();
        $(".vertical-menu li a .text").show();
        $(".sidebar").css("width","20%");
        $(".main").css("width","80%");
    });

    getAccountList();

    $("#btnCreate").click(function(){
        $("#account-info").show(200);
        $("#account-fullname").val("");
        $("#account-username").val("");
        $("#account-email").val("");
        $("#account-phone").val("");
        $("#account-id").val("");
    });

    $("#btnCancel").click(function(){
        $("#account-info").hide(200);
    })

    $("#btnSave").click(function(){
        var accountId = $("#account-id").val();
        console.log(accountId);

        if(accountId != null && accountId != ""){
            //update
            var accountFullname = $("#account-fullname").val();
            var accountUserName = $("#account-username").val();
            var accountEmail = $("#account-email").val();
            var accountPhone = $("#account-phone").val();

            var account = {
                fullname: accountFullname,
                username: accountUserName,
                email: accountEmail,
                phone: accountPhone
            }
            $.ajax({
                url: "https://64bbe8837b33a35a4446cbb8.mockapi.io/api/v1/accounts/" + accountId,
                type: "PUT",
                data: account,
                success: function(){
                    $('#msg').html("<h2>Cập nhật thành công!</h2>").fadeIn('slow');
                    $('#msg').delay(2000).fadeOut('slow');
                    $('#account-info').hide(200);
                    getAccountList();
                }
            });
        } else{
            //thêm
            var accountFullname = $("#account-fullname").val();
            var accountUserName = $("#account-username").val();
            var accountEmail = $("#account-email").val();
            var accountPhone = $("#account-phone").val();

            var account = {
                fullname: accountFullname,
                username: accountUserName,
                email: accountEmail,
                phone: accountPhone
            }

            $.ajax({
                url: "https://64bbe8837b33a35a4446cbb8.mockapi.io/api/v1/accounts",
                type: "POST",
                data: account,
                success: function(){
                    $('#msg').html("Thêm mới thành công!").fadeIn('slow'); //fadeIn:hiện
                    $('#msg').delay(2000).fadeOut('slow');//fadeOut: ẩn
                    $("#account-info").hide(200);
                    getAccountList();
                }
            });

        }

    })

});

function getAccountList(){
    $.ajax({
        url: "https://64bbe8837b33a35a4446cbb8.mockapi.io/api/v1/accounts/",
        type: "GET",
        success: function(accountArr){
            $("tbody").empty();
            accountArr.forEach(element => {
                $("tbody").append(
                  "<tr>" +
                      "<td>" + element.id + "</td>" +
                      "<td>" + element.fullname + "</td>" +
                      "<td>" + element.username + "</td>" +
                      "<td>" + element.email + "</td>" +
                      "<td>" + element.phone + "</td>" +
                      "<td>" + 
                          "<a href='#' id='btnEdit' onclick='editAccount(" + element.id + "); return false;'>Sửa</a>" +
                          " <a href='#' id='btnDelete' onclick='deleteAccount(" + element.id + "); return false;'>Xóa</a>" +
                      "</td>" +
                  "</tr>"
                );
            });
        }
    })
}

function editAccount(id){
    $('#account-info').show(200);
    console.log("id: " + id);

    $.ajax({
        url: "https://64bbe8837b33a35a4446cbb8.mockapi.io/api/v1/accounts/" + id,
        type: "GET",
        success: function(account){
            $("#account-fullname").val(account.fullname);
            $("#account-username").val(account.username);
            $("#account-email").val(account.email);
            $("#account-phone").val(account.phone);
            $("#account-id").val(account.id);
        }
    });
}

function deleteAccount(id){
    console.log("id: " + id);

    //xóa account theo id
    $.ajax({
        url: "https://64bbe8837b33a35a4446cbb8.mockapi.io/api/v1/accounts/" + id,
        type: "DELETE",
        success: function(){
            $('#msg').html("<h1>Xóa thành công!</h1>").fadeIn('slow'); //fadeIn:hiện
            $('#msg').delay(2000).fadeOut('slow');//fadeOut: ẩn
           getAccountList();
        }
    });

}
