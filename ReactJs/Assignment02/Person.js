class Person {
    constructor(name, country, isMale, birthDay) {
        this.name = name;
        this.country = country;
        this.isMale = isMale;
        this.birthDay = birthDay;
    }
    getName() {
        return this.name;
    }
    getCountry() {
        return this.country;
    }
    getIsMale() {
        return this.isMale;
    }
    getBirthDay() {
        return this.birthDay;
    }
}
export const persons = [
    new Person("A", "Vietnam", true, 15),
    new Person("A", "US", false, 16),
    new Person("A", "China", false, 19)
];
