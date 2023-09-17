function createUser8() {
    console.log("Call API Create User (1)");
    let call = new Promise((resolve, reject) => {
        setTimeout(() => {
            // return resolve("Create User successfully!");
            return reject("Create User Err");
        }, 1000);
    })
    return call;
}

async function createGroup8() {  
    console.log("Call API Create Group (2)");
    let call = new Promise((resolve, reject) => {
        setTimeout(() => {
            return resolve("Create Group successfully!");
            // return reject("Create Group Err");
        }, 1000);
    })
    return call;
}

async function addUserToGroup8() {
    console.log("Call API Add User To Group (3)");
    let call = new Promise((resolve, reject) => {
        setTimeout(() => {
            return resolve("Add User To Group successfully!");
            // return reject("Add User To Group Err");
        }, 1000);
    })
    return call;
}

async function createUserAndGroup8() {

    try {
        // call API
        let resultCreateUser = await createUser8();
        console.log(resultCreateUser);
    
        let resultCreateGroup = await createGroup8();
        console.log(resultCreateGroup);
    
        let resultAddUserToGroup = await addUserToGroup8();
        console.log(resultAddUserToGroup);
    } catch (error) {
        console.log(error);
        console.log("End");        
    }
}
createUserAndGroup8();