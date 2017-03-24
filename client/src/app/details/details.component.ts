import {Component, OnInit} from "@angular/core";
import {Details} from "../model/details";
import {DetailsService} from "./details.service";


@Component({
    selector: 'details-component',
    templateUrl: './details.component.html'
})
export class DetailsComponent implements OnInit {

    detailsList: Details[];

    constructor(private detailsService: DetailsService) {
    }

    ngOnInit(): void {
        this.loadData()
         }

    private loadData() {
        this.detailsService.loadAll()
            .subscribe(detailsList => this.detailsList = detailsList);
    }
}