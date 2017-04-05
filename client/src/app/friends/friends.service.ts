import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response} from "@angular/http";
import {environment} from "../constants/environment";
import {Observable} from "rxjs";

@Injectable()
export class FriendsService {

    constructor(private http: Http) {
    }

    getFriendsById(id: number) {
        return this.http.get(environment.FRIENDS_URL + "/" + id)
            .map(response => response.json())
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }

    create(current_id: number, friend_id: number): Observable<any> {
        const body = JSON.stringify({
            current_id: current_id,
            friend_id: friend_id
        });
        const headers = new Headers({
            'Content-Type': 'application/json'
        });
        const options = new RequestOptions({headers: headers});
        console.log(body);
        return this.http.post(environment.FRIENDS_ADD_URL, body, options)
            .map((response: Response) => response.status === 200)
            .catch(this.handleError);
        // response.status === 201);
    }
}