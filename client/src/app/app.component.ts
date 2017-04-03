import {Component, OnInit} from '@angular/core';
import {environment} from "./constants/environment";
import {User} from "./model/user";

@Component({
    selector: 'my-app',
    templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {
    showLink: boolean;
    public currentUser: User;

    ngOnInit(): void {
        if (this.currentUser != null) {
            this.showLink = true;
        }
    }

    logout(): void {
        localStorage.removeItem(environment.USER_CONST);
    }
}
