import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response} from "@angular/http";
import 'rxjs/add/operator/toPromise';
import {User} from "../model/user";
import {environment} from "../constants/environment";
import {Observable} from "rxjs";

@Injectable()
export class UserService {

    constructor(private http: Http) { }

    getUsers(): Promise<User[]> {
        return this.http.get(environment.USER_URL)
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }

    getUserByUsername(inputText: string): Promise<User> {
        return this.http.get(environment.USER_URL + inputText)
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }

    create(user: User) : Observable<Boolean> {
        const body = JSON.stringify({username: user.username, password: user.password});
        const headers = new Headers({
            'Content-Type': 'application/json'
        });
        const options = new RequestOptions({headers: headers});
        return this.http.post(environment.AUTH_USER_URL, body, options)
            .map((response: Response) => response.status === 201);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}