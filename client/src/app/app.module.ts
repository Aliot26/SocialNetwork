import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {HttpModule} from "@angular/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {LoginComponent} from "./authorization/login.component";
import {LoginService} from "./authorization/login.service";
import {RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {RegisterComponent} from "./register/register.component";
import {NotFoundComponent} from "./notfound/not-found.component";
import {GuardService} from "./guard/guard.service";
import {UserModule} from "./user/user.module";
import {AdminComponent} from "./admin/admin.component";
import {LocationStrategy, HashLocationStrategy} from "@angular/common";
import {TranslateModule} from "./translate/translate.module";


@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        UserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        RouterModule,
        TranslateModule.forRoot()
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        LoginComponent,
        RegisterComponent,
        AdminComponent,
        NotFoundComponent
    ],
    providers: [
        {provide: LocationStrategy, useClass: HashLocationStrategy},
        LoginService,
        GuardService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
