import {Component, OnInit} from "@angular/core";
import {User} from "../../model/user";
import {UserService} from "../../user/user.service";
import {LoginService} from "../../authorization/login.service";

@Component({
    selector: 'search-friends',
    templateUrl: './search-friends.component.html'
})
export class SearchFriendsComponent  implements OnInit  {
    userList: User[];
    public currentUser: User;

    constructor(private userService: UserService) {
    }

    ngOnInit(): void {
        this.loadData()
    }

    private loadData() {
        this.currentUser = LoginService.getCurrentUser();
        this.userService.loadFilteredUsers(this.currentUser.id)
            .subscribe(userList => this.userList = userList);
    }
}
