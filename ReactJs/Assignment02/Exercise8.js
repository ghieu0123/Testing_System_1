var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
function createUser8() {
    console.log("Call API Create User (1)");
    let call = new Promise((resolve, reject) => {
        setTimeout(() => {
            // return resolve("Create User successfully!");
            return reject("Create User Err");
        }, 1000);
    });
    return call;
}
function createGroup8() {
    return __awaiter(this, void 0, void 0, function* () {
        console.log("Call API Create Group (2)");
        let call = new Promise((resolve, reject) => {
            setTimeout(() => {
                return resolve("Create Group successfully!");
                // return reject("Create Group Err");
            }, 1000);
        });
        return call;
    });
}
function addUserToGroup8() {
    return __awaiter(this, void 0, void 0, function* () {
        console.log("Call API Add User To Group (3)");
        let call = new Promise((resolve, reject) => {
            setTimeout(() => {
                return resolve("Add User To Group successfully!");
                // return reject("Add User To Group Err");
            }, 1000);
        });
        return call;
    });
}
function createUserAndGroup8() {
    return __awaiter(this, void 0, void 0, function* () {
        try {
            // call API
            let resultCreateUser = yield createUser8();
            console.log(resultCreateUser);
            let resultCreateGroup = yield createGroup8();
            console.log(resultCreateGroup);
            let resultAddUserToGroup = yield addUserToGroup8();
            console.log(resultAddUserToGroup);
        }
        catch (error) {
            console.log(error);
            console.log("End");
        }
    });
}
createUserAndGroup8();
