function logout(){
    storage.removeItem("ID");
    storage.removeItem("FULL_NAME");
    storage.removeItem("USERNAME");
    storage.removeItem("PASSWORD");
    storage.removeItem("ROLE");

    window.location.replace("http://127.0.0.1:5500/Frontend_Phong/templates/login.html");
}