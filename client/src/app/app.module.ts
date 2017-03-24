import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {UserService} from "./user/user.service";
import {HttpModule} from "@angular/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {LoginComponent} from "./authorization/login.component";
import {LoginService} from "./authorization/login.service";
import {RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {UserComponent} from "./user/user.component";
import {RegisterComponent} from "./register/register.component";
import {NotFoundComponent} from "./notfound/not-found.component";
import {DetailsComponent} from "./details/details.component";
import {DetailsService} from "./details/details.service";
import {GuardService} from "./authorization/guard.service";
import {AllUsersComponent} from "./user/all/all-users.component";
@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        AppRoutingModule,
        ReactiveFormsModule,
        RouterModule
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        LoginComponent,
        RegisterComponent,
        UserComponent,
        DetailsComponent,
        AllUsersComponent,
        NotFoundComponent
    ],
    providers: [
        UserService,
        LoginService,
        GuardService,
        DetailsService

    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
