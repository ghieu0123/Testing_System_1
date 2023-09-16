// Question 1: Scope
// Khai báo biến fullName và function hello() để in ra fullName theo 3 cách
//  a) Khai báo fullName là Global scope
let fullName1:String = "Hiếu đẹp trai";

function hello1(fullName:String){
    console.log(fullName);
}
hello1(fullName1);

//  b) Khai báo fullName là Function scope
function hello2(){
    let fullName2 = "Hiếu đẹp trai";
    console.log(fullName2);
}

hello2();

//  c) Khai báo fullName là Lexical Scope
function hello3(){
    let fullName3 = "Hiếu đẹp trai";
    let message = () => {
        return "ohshjt, " + fullName3;
    }
    console.log(message());
}
hello3();