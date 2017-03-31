import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {NewsComponent} from "./news.component";


const routes: Routes = [
    {path: 'user/news', component: NewsComponent,}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class NewsRoutingModule {
}