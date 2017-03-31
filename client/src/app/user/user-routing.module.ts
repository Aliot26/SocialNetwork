import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {UserComponent} from "./user.component";
import {UpdateProfileComponent} from "./update/update-profile.component";
import {NewsComponent} from "../news/news.component";
const routes: Routes = [
    {
        path: 'user', component: UserComponent,
        children: [
            {
                path: 'update-profile',
                component: UpdateProfileComponent
            },
            {
                path: 'news',
                component: NewsComponent
            }
        ]
    },
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class UserRoutingModule {
}