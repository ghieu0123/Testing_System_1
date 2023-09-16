// Question1: tìm và in ra phần tử có giá trị nhỏ nhất trong mảng sau [10, 6, 8, 9, 3]
var myArr = [10, 6, 8, 9, 3];
var min = myArr[0];
myArr.map(function (number) {
    if (number < min)
        min = number;
});
console.log("Số nhỏ nhất trong mảng: " + min);
