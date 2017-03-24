import {Role} from "./role";
export class User {
    username: string;
    password: string;
    roles: Role[];
    token: string;

    constructor(username: string, password: string) {
        this.username = username;
        this.password = password;
    }
}