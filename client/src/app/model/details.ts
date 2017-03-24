import {User} from "./user";
export class Details {
    firstname: string;
    surname: string;
    photo: string;
    user: User;

    constructor(name: string, surname: string, photo: string, user: User) {
        this.firstname = name;
        this.surname = surname;
        this.photo = photo;
        this.user = user;
    }
}