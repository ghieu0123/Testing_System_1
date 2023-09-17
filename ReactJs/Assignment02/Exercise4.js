//Question 1:Convert function sau về Arrow Function ngắn nhất có thể
var tinh = function (a) { return a + 100; };
console.log(tinh(100));
//Question 2:Convert function sau về Arrow Function ngắn nhất
//  a>
var tinh1 = function (a, b) { return a + b + 100; };
console.log(tinh1(1, 2));
//  b>
var tinh2 = function (a, b) {
    var chuck = 42;
    return a + b + chuck;
};
console.log(tinh2(5, 10));
//  c>
var bob = function (a) { return a + 100; };
console.log(bob(10));
