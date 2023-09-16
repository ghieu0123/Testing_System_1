
export class Department{
    private id:number;
    private name:String;

    constructor(id:number, name:String){
        this.id = id;
        this.name = name;
    }
    getId = ():number => {
        return this.id;
    }
    getName = ():String => {
        return this.name;
    }
}

export default function printDepartment (department:Department): void {
    console.log("id: " + department.getId() + ", name: " + department.getName())
}

export var department1: Department = new Department(1, "A");