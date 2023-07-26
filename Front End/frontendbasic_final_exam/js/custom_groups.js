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

    //lấy danh sách group
    getGroupList();
   

    //POST: thêm mới group

    $("#btnCreate").click(function(){
        $("#group-info").show(200);
        $("#group-name").val("");
        $("#group-id").val("");
    });

    $("#btnCancel").click(function(){
        $("#group-info").hide(200);
    });


    $("#btnSave").click(function(){

        var groupId = $("#group-id").val();
        console.log(groupId);

        if(groupId!=null && groupId !=""){
            //cập nhật

            var groupName = $("#group-name").val();

            var group = {
                name: groupName
            }

            $.ajax({
                url: "https://64bbe8837b33a35a4446cbb8.mockapi.io/api/v1/groups/" + groupId,
                type: "PUT",
                data: group,
                success: function(){
                    $('#msg').html("Cập nhật thành công!").fadeIn('slow'); //fadeIn:hiện
                    $('#msg').delay(2000).fadeOut('slow');//fadeOut: ẩn
                    $("#group-info").hide(200);
                    getGroupList();
                    
                }
            });

        }else{
            //thêm mới

            var groupName = $("#group-name").val();

            var group = {
                name: groupName
            }
    
    
            $.ajax({
                url: "https://64bbe8837b33a35a4446cbb8.mockapi.io/api/v1/groups",
                type: "POST",
                data: group,
                success: function(){
                    $('#msg').html("Thêm mới thành công!").fadeIn('slow'); //fadeIn:hiện
                    $('#msg').delay(2000).fadeOut('slow');//fadeOut: ẩn
                    $("#group-info").hide(200);
                    getGroupList();
                    
                }
            });


        }
     

    });

    
});

function getGroupList(){
 //1. GET: lấy danh sách các group
 $.ajax({
    url: "https://64bbe8837b33a35a4446cbb8.mockapi.io/api/v1/groups",
    type: "GET",
    success: function(groupArr){
        $("tbody").empty();   
        groupArr.forEach(element => {
          $("tbody").append(
            "<tr>" +
                "<td>" + element.id + "</td>" +
                "<td>" + element.name + "</td>" +
                "<td>" + 
                    "<a href='#' id='btnEdit' onclick='editGroup(" + element.id + "); return false;'>Sửa</a>" +
                    " <a href='#' id='btnDelete' onclick='deleteGroup(" + element.id + "); return false;'>Xóa</a>" +
                "</td>" +
            "</tr>"
          );
        });
    }
});

}
function editGroup(id){
    $("#group-info").show(200);
    console.log("id: " + id);

    $.ajax({
        url: "https://64bbe8837b33a35a4446cbb8.mockapi.io/api/v1/groups/" + id,
        type: "GET",
        success: function(group){
            $("#group-name").val(group.name);
            $("#group-id").val(group.id);
        }
    });

}

function deleteGroup(id){
    console.log("id: " + id);

    //xóa group theo id
    $.ajax({
        url: "https://64bbe8837b33a35a4446cbb8.mockapi.io/api/v1/groups/" + id,
        type: "DELETE",
        success: function(){
            $('#msg').html("<h1>Xóa thành công!</h1>").fadeIn('slow'); //fadeIn:hiện
            $('#msg').delay(2000).fadeOut('slow');//fadeOut: ẩn
           getGroupList();
        }
    });

}
