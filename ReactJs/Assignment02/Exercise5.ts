//Question 1: khai báo 1 function multiply() có 2 tham số a,b. Và có b có default value
var multiply = (a, b:number = 10) =>  console.log(a * b);
multiply(1);
multiply(5, 5)

//Question 2: khai báo 1 function multiply() có tham số không giới hạn
var multiply1 = (...myArr) => {
    var tinh = 1;
    myArr.map(number => {
        tinh *= number;
    })
    console.log(tinh);
}
multiply1(9, 3, 5);

//Question 3: khai báo 1 function printInformation() có 2 tham số name, email.
//Và có email là optional parameter
var printInformation = (name:String, email?:String) => {
    if(email == undefined)
        console.log(`Tôi là ${name} đẹp trai nhưng chưa có email`);
    else
        console.log(`nhìn kìa!!! ${name} đã đẹp trai lại còn có email là: ${email}`);
}
printInformation("nam");
printInformation("nam", "namProVip@gmail.com");