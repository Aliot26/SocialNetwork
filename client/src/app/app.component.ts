import {Component} from '@angular/core';
import {environment} from "./constants/environment";
import {User} from "./model/user";

@Component({
    selector: 'my-app',
    templateUrl: './app.component.html',
})
export class AppComponent {
    public currentUser: User;
    logout(): void {
        this.currentUser = null;
        localStorage.removeItem(environment.USER_CONST);

    }
}
