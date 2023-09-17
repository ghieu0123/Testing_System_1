
class Person {

    private name: string;
    private country: string;
    private isMale: boolean;
    private birthDay: number;

    constructor(name: string, country: string, isMale: boolean, birthDay: number) {
        this.name = name;
        this.country = country;
        this.isMale = isMale;
        this.birthDay = birthDay;
    }

    public getName(): string {
        return this.name;
    }

    public getCountry(): string {
        return this.country;
    }

    public getIsMale(): boolean {
        return this.isMale;
    }

    public getBirthDay(): number {
        return this.birthDay;
    }

}

export const persons: Person[] = [
    new Person("A", "Vietnam", true, 15),
    new Person("A", "US", false, 16),
    new Person("A", "China", false, 19)
];