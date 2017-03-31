import {Injectable} from "@angular/core";
import {environment} from "../constants/environment";
import {Http} from "@angular/http";

@Injectable()
export class NewsService {

    constructor(private http: Http) {
    }

    getNewsByAuthor(id: number) {
        return this.http.get(environment.NEWS_URL + "/" + id)
            .map(responce => responce.json())
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}