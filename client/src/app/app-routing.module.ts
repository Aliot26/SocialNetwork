import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import {LoginComponent} from "./authorization/login.component";
import {HomeComponent} from "./home/home.component";
import {UserComponent} from "./user/user.component";
import {AllUsersComponent} from "./user/all/all-users.component";
import {RegisterComponent} from "./register/register.component";
import {NotFoundComponent} from "./notfound/not-found.component";
import {DetailsComponent} from "./details/details.component";
import {GuardService} from "./guard/guard.service";
import {ProfileComponent} from "./profile/profile.component";

const routes: Routes = [

    {path: 'home', component: HomeComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'login', component: LoginComponent},
    {path: 'details/all', component: DetailsComponent},
    {path: 'profile', component: ProfileComponent},
    {path: 'user', component: UserComponent, canActivate: [GuardService], data: {roles: ['ROLE_ADMIN']},},
    {path: 'all-users', component: AllUsersComponent},
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: '**', component: NotFoundComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}