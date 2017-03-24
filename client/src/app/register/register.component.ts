import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from "../user/user.service";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {User} from "../model/user";

@Component({
    selector: 'register-component',
    templateUrl: './register.component.html'
})

export class RegisterComponent {
    userForm: FormGroup;
    loading: boolean = false;
    error: string = '';

    constructor(private userService: UserService, private router: Router) {
    }


    ngOnInit(): void {
        this.userForm = new FormGroup({
            username: new FormControl('', Validators.required),
            password: new FormControl('', Validators.required)
        });
    }

    onSubmit() {
        this.loading = true;
        this.userService.create(new User(this.userForm.value.username, this.userForm.value.password))
            .subscribe(result => {
                if (result === true) {
                    alert("Success!");
                    this.router.navigate(['/home']);
                } else {
                    alert("FOOOO!");
                    this.loading = false;
                }
            });
    }

    reset() {
        this.userForm.reset();
    }

}
