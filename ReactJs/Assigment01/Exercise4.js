// Question 1: Scope
// Khai báo biến fullName và function hello() để in ra fullName theo 3 cách
//  a) Khai báo fullName là Global scope
var fullName1 = "Hiếu đẹp trai";
function hello1(fullName) {
    console.log(fullName);
}
hello1(fullName1);
//  b) Khai báo fullName là Function scope
function hello2() {
    var fullName2 = "Hiếu đẹp trai";
    console.log(fullName2);
}
hello2();
//  c) Khai báo fullName là Lexical Scope
function hello3() {
    var fullName3 = "Hiếu đẹp trai";
    var message = function () {
        return "ohshjt, " + fullName3;
    };
    console.log(message());
}
hello3();
