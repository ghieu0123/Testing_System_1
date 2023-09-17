import {persons} from "./Person";
function question1() {
    const caculate = (a, b, operation) => {
        return operation(a, b);
    }
    const multiplier = (a, b) => a * b;
    const sum = (a, b) => a + b;

    let rs = caculate(2, 3, multiplier);
    console.log(rs);

}

// question2
const printPersonInVietNam1 = (persons) => {
    for (const person of persons) {
        if (person.country === "Vietnam") {
            console.log(person);
        }
    }
}

const printPersonInVietNam2 = (persons, country) => {
    for (const person of persons) {
        if (person.country === country) {
            console.log(person);
        }
    }
}

const printPersonInVietNam3 = (persons, country, action) => {
    for (const person of persons) {
        if (person.country === country) {
            action(person);
        }
    }
}

const printPerson = (person) => {
    console.log(person);
}

const printPersonInVietNam4 = (persons, compareCondition, action) => {
    for (const person of persons) {
        if (compareCondition(person)) {
            action(person);
        }
    }
}

const conditionCountry = (country) => {
    return (person) => person.country === country;
}

const conditionGender = (isMale) => {
    return (person) => person.isMale === isMale;
}

const conditionBirthDay = () => {
    return (person) => person.birthDay > 18;
}

function question2() {
    // printPersonInVietNam1(persons);
    // printPersonInVietNam2(persons, "US");
    // printPersonInVietNam3(persons, "China", printPerson);
    // printPersonInVietNam4(persons, conditionCountry("US"), printPerson);
    // printPersonInVietNam4(persons, conditionGender(false), printPerson);
    printPersonInVietNam4(persons, conditionBirthDay(), printPerson);
}

var grades = [
    { name: 'John', grade: 8, sex: 'M' },
    { name: 'Sarah', grade: 12, sex: 'F' },
    { name: 'Bob', grade: 16, sex: 'M' },
    { name: 'Johnny', grade: 2, sex: 'M' },
    { name: 'Ethan', grade: 4, sex: 'M' },
    { name: 'Paula', grade: 18, sex: 'F' },
    { name: 'Donald', grade: 5, sex: 'M' },
    { name: 'Jennifer', grade: 13, sex: 'F' },
    { name: 'Courtney', grade: 15, sex: 'F' },
    { name: 'Jane', grade: 9, sex: 'F' }
]

const average = (grades) => {
    let gr : number = 0;
    let result : number = 0;
    if(grades.length > 0){
        for (const grade of grades) {
            gr += grade.grade
        }
        result =  gr / grades.length;
    }
    return result;
}

const getBoys = (grades) => {
    let isBoy = student => student.sex === 'M'
    let resultGrades: object[] = [];
    if(grades.length > 0){
        for (const grade of grades) {
            if(isBoy(grade)){
                resultGrades.push(grade)
            }
        }
    }
    return resultGrades;
    // return grades.filter(isBoy);
}

const getGirls = (grades) => {
    let isBoy = student => student.sex === 'M'
    let resultGrades: object[] = [];
    if(grades.length > 0){
        for (const grade of grades) {
            if(!isBoy(grade)){
                resultGrades.push(grade)
            }
        }
    }
    return resultGrades;
    // return grades.filter(isBoy);
}

const minGrade = (grades) => {
    return Math.min(...grades.map((student) => student.grade));
}

const maxGrade = (grades) => {
    return Math.max(...grades.map((student) => student.grade));
}

function question3() {
    console.log("Thứ hạng trung bình của cả lớp");    
    console.log(average(grades));

    console.log("Thứ hạng trung bình của nam trong lớp");    
    console.log(average(getBoys(grades)));

    console.log("Thứ hạng trung bình của Nữ trong lớp"); 
    console.log(average(getGirls(grades)));
    
    console.log("Thứ hạng nam thấp nhất của cả lớp"); 
    console.log(minGrade(getBoys(grades)));
    
    console.log("Thứ hạng nam cao nhất của cả lớp"); 
    console.log(maxGrade(getBoys(grades)));
    
    console.log("Thứ hạng nữ thấp nhất của cả lớp"); 
    console.log(minGrade(getGirls(grades)));
    
    console.log("Thứ hạng nữ cao nhất của cả lớp"); 
    console.log(maxGrade(getGirls(grades)));
    
    console.log("Thứ hạng thấp nhất của cả lớp"); 
    console.log(minGrade(grades));
    
    console.log("Thứ hạng cao nhất của cả lớp"); 
    console.log(maxGrade(grades));
}

question1(), question2(), question3();