//Question1: Đếm số lượng các từ trong xâu kí tự "Every new day is another chance to change your life."
var messege: String = "Every new day is another chance to change your life.";
console.log("\nSố lượng các từ: " + messege.length);

//Question2: Viết hoa chữ cái đầu của mỗi từ của xây ký tự sau: "Stars can’t shine without darkness" và in ra màn hình.
function viethoa(message: String){
    const words = message.split(" ");
    var viethoachucaidau = words.map(word => {
        return word.charAt(0).toUpperCase() + word.slice(1);
    })
    return viethoachucaidau.join(" ");
}

var message: String = "Stars can’t shine without darkness";
console.log("\nViết hoa chữ cái đầu: " + viethoa(message));