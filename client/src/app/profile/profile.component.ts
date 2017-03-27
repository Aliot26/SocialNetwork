import {Component, OnInit} from "@angular/core";
import {User} from "../model/user";
import {UserService} from "../user/user.service";
// import {environment} from "../constants/environment";
import {LoginService} from "../authorization/login.service";


@Component({
    selector: 'profile-component',
    templateUrl: './profile.component.html'
})
export class ProfileComponent implements OnInit {
    profileUser: User;
    currentUser: User;

    constructor(private userService: UserService) {
    }

    ngOnInit(): void {
        this.loadData()
    }

    loadData() {
        this.currentUser = LoginService.getCurrentUser();
        this.userService.getUserByUsername(this.currentUser.username)
            .subscribe(profileList => this.profileUser = profileList);
    }
}