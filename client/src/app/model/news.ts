export class News {
    title: string;
    content: string;
    author: number;
    date: Date;

    constructor(title: string, content: string, author: number, date: Date) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
    }
}