import {Component} from '@angular/core';
import {environment} from "./constants/environment";

@Component({
    selector: 'my-app',
    templateUrl: './app.component.html',
})
export class AppComponent {

    logout(): void {
        localStorage.removeItem(environment.USER_CONST);
    }
}
