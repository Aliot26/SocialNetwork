import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {RouterModule} from "@angular/router";
import {HttpModule} from "@angular/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {UserService} from "./user.service";
import {UserComponent} from "./user.component";
import {LoginService} from "../authorization/login.service";
import {UserRoutingModule} from "./user-routing.module";

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        UserRoutingModule,
        ReactiveFormsModule,
        RouterModule
    ],
    declarations: [
        UserComponent
    ],
    providers: [
        UserService,
        LoginService
    ]
})
export class UserModule {
}