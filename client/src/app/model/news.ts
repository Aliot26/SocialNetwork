export class News {
    title: string;
    content: string;
    author: string;
    data: Date;

    constructor(title: string, content: string, author: string,data: Date) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.data = data;
    }
}