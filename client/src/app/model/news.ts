interface INews {
    id?: number;
    title?: string;
    content?: string;
    author?: number;
    date?: Date;
}

export class News implements INews {
    id: number;
    title: string;
    content: string;
    author: number;
    date: Date;

    constructor(obj: INews = {}as INews) {
        let {
            title = '0',
            content = '0',
            author = 0,
        }:INews = obj as INews;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}