import {Component} from "@angular/core";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {NewsService} from "../news.service";
import {News} from "../../model/news";
import {Router} from "@angular/router";

@Component({
    selector: 'add-news',
    templateUrl: './add-news.component.html'
})
export class AddNewsComponent{
    newsForm: FormGroup;

    constructor(private newsService: NewsService, private router: Router){}

    reset() {
        this.newsForm.reset();
    }

    ngOnInit(): void {
        this.newsForm = new FormGroup({
            title: new FormControl('', Validators.required),
            content: new FormControl('', Validators.required)
        });
    }

    onSubmit() {
        this.newsService.create(new News({title:this.newsForm.value.title,
            content:this.newsForm.value.content}))
            .subscribe(result => {
                if (result === true) {
                    alert("Success!");
                    this.router.navigate(['/user/news']);
                } else {
                    alert("This username already exists!");
                }
            });
    }


}