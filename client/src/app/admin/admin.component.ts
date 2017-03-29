import {Component, OnInit} from "@angular/core";
import {UserService} from "../user/user.service";
import {User} from "../model/user";

@Component({
    selector: 'admin-component',
    templateUrl: './admin.component.html'
})

export class AdminComponent implements OnInit {
    userList: User[];

    constructor(private userService: UserService) {
    }

    ngOnInit(): void {
        this.loadAll()
    }

    private loadAll() {
        this.userService.loadUsers()
            .subscribe(userList => this.userList = userList);
    }
}