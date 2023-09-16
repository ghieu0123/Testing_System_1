"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.department1 = exports.Department = void 0;
var Department = /** @class */ (function () {
    function Department(id, name) {
        var _this = this;
        this.getId = function () {
            return _this.id;
        };
        this.getName = function () {
            return _this.name;
        };
        this.id = id;
        this.name = name;
    }
    return Department;
}());
exports.Department = Department;
function printDepartment(department) {
    console.log("id: " + department.getId() + ", name: " + department.getName());
}
exports.default = printDepartment;
exports.department1 = new Department(1, "A");
