import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {environment} from "../constants/environment";

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

    // create(friends: Friends): Observable<any> {
    //     const body = JSON.stringify({
    //         title: news.title, content: news.content, user: news.author
    //     });
    //     const headers = new Headers({
    //         'Content-Type': 'application/json'
    //     });
    //     const options = new RequestOptions({headers: headers});
    //     console.log(body);
    //     return this.http.post(environment.NEWS_ADD_URL, body, options)
    //         .map((response: Response) => response.status === 201)
    //         .catch(this.handleError);
    //     // response.status === 201);
    // }
}