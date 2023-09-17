//Question 1: khai báo 1 function multiply() có 2 tham số a,b. Và có b có default value
var multiply = function (a, b) {
    if (b === void 0) { b = 10; }
    return console.log(a * b);
};
multiply(1);
multiply(5, 5);
//Question 2: khai báo 1 function multiply() có tham số không giới hạn
var multiply1 = function () {
    var myArr = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        myArr[_i] = arguments[_i];
    }
    var tinh = 1;
    myArr.map(function (number) {
        tinh *= number;
    });
    console.log(tinh);
};
multiply1(9, 3, 5);
//Question 3: khai báo 1 function printInformation() có 2 tham số name, email.
//Và có email là optional parameter
var printInformation = function (name, email) {
    if (email == undefined)
        console.log("T\u00F4i l\u00E0 ".concat(name, " \u0111\u1EB9p trai nh\u01B0ng ch\u01B0a c\u00F3 email"));
    else
        console.log("nh\u00ECn k\u00ECa!!! ".concat(name, " \u0111\u00E3 \u0111\u1EB9p trai l\u1EA1i c\u00F2n c\u00F3 email l\u00E0: ").concat(email));
};
printInformation("nam");
printInformation("nam", "namProVip@gmail.com");
