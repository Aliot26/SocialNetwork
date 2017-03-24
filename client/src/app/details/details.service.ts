import {Details} from "../model/details";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {Injectable} from "@angular/core";
import {environment} from "../constants/environment";

@Injectable()
export class DetailsService {

    constructor(private http: Http) {
    }

    loadAll() {
        return this.http.get(environment.DETAILS_URL+ "/all")
            .map((response: Response) => response.json())
            .catch(this.handleError);
    }

    // loadAll(): Promise<Details[]> {
    //     return this.http.get(environment.DETAILS_URL+ "/all")
    //         .toPromise()
    //         .then((response: Response) => response.json())
    //         .catch(this.handleError);
    // }

    add(details: Details) {
        const userToken = JSON.parse(localStorage.getItem(environment.USER_CONST)).token;
        const body = JSON.stringify({name: details.firstname, surname: details.surname, photo: details.photo});
        const headers = new Headers({'Content-Type': 'application/json', 'x-auth-token': userToken});
        const options = new RequestOptions({headers: headers});
        return this.http.post(environment.AUTH_USER_URL, body, options).map(() => {
            return true;
        });
    }

    loadById(id: number) {
        return this.http.get(environment.DETAILS_URL + "/" + id)
            .map((response: Response) => response.json())
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}