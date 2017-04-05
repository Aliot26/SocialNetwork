import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {RouterModule} from "@angular/router";
import {HttpModule} from "@angular/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {UserService} from "./user.service";
import {UserComponent} from "./user.component";
import {LoginService} from "../authorization/login.service";
import {UserRoutingModule} from "./user-routing.module";
import {UpdateProfileComponent} from "./update/update-profile.component";
import {NewsService} from "../news/news.service";
import {AddNewsComponent} from "../news/add/add-news.component";
import {NewsComponent} from "../news/news.component";
import {FriendsComponent} from "../friends/friends.component";
import {FriendsService} from "../friends/friends.service";
import {SearchFriendsComponent} from "../friends/search/search-friends.component";
import {RequestComponent} from "../friends/request/request.component";


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
        UserComponent,
        NewsComponent,
        FriendsComponent,
        SearchFriendsComponent,
        RequestComponent,
        AddNewsComponent,
        UpdateProfileComponent
    ],
    providers: [
        UserService,
        LoginService,
        NewsService,
        FriendsService
    ]
})
export class UserModule {
}