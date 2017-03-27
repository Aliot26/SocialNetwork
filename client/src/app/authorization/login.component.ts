import {Component, OnInit} from "@angular/core";
import {FormGroup, FormControl, Validators} from "@angular/forms";
import {LoginService} from "./login.service";
import {Router} from "@angular/router";
import {User} from "../model/user";

@Component({
    selector: 'login-component',
    templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading: boolean = false;
    error: string = '';

    constructor(private loginService: LoginService, private router: Router) {
    }

    ngOnInit(): void {
        this.loginForm = new FormGroup({
            username: new FormControl('', Validators.required),
            password: new FormControl('', Validators.required)
        });
        this.loginService.logout();
    }

    onSubmit() {
        this.loading = true;
        this.loginService.login(new User({username:this.loginForm.value.username,
            password:this.loginForm.value.password}))
            .subscribe(
                result => {
                    if (result === true) {
                        alert("Login success!");
                        this.router.navigate(['/profile']);
                    } else {
                        alert("Login Failed!");
                        this.error = 'Authentification error';
                        this.loading = false;
                        this.router.navigate(['/login']);
                    }
                }
            );
    }
    reset() {
        this.loginForm.reset();
    }

}