import {Component, OnInit} from "@angular/core";
import {User} from "../../model/user";
import {LoginService} from "../../authorization/login.service";
import {UserService} from "../../user/user.service";
//import {FriendsService} from "../friends.service";
@Component({
    selector: 'request-friends',
    templateUrl: './request.component.html'
})
export class RequestComponent   implements OnInit {
    public currentUser: User;
    requestList: User[];

    constructor(private userService: UserService,
                //private friendsService: FriendsService
    ) {
    }

    ngOnInit(): void {
        this.loadData()
    }


    private loadData() {
        this.currentUser = LoginService.getCurrentUser();
        this.userService.loadRequestedUsers(this.currentUser.id)
            .subscribe(requestList => this.requestList = requestList);
    }
}
