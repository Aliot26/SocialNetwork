import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {UserRoutingModule} from "../user/user-routing.module";
import {RouterModule} from "@angular/router";
import {NewsComponent} from "./news.component";
import {NewsService} from "./news.service";


@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        UserRoutingModule,
        ReactiveFormsModule,
        RouterModule,
    ],
    declarations: [
        NewsComponent
    ],
    providers: [
        NewsService
    ]
})
export class NewsModule {
}