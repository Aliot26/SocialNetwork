import {User} from "./user";
interface IFriends {
    id?: number;
    friend1_id?: User;
    friend2_id?: User;
    status?: boolean;
}
export class Friends implements IFriends {
    id: number;
    friend1_id: User;
    friend2_id: User;
    status: boolean;

    constructor(obj: IFriends = {}as IFriends) {
        let {
            friend1_id = null,
            friend2_id = null,
            status = false,

        }:IFriends = obj as IFriends;
        this.friend1_id = friend1_id;
        this.friend2_id = friend2_id;
        this.status = status;

    }
}