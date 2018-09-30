import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';

@Component({
    selector: 'app-layout',
    templateUrl: './layout.component.html',
    styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit {
    currentUser: User;
    collapedSideBar: boolean;

    constructor() {
     }

    ngOnInit() {
    }

    receiveCollapsed($event) {
        this.collapedSideBar = $event;
    }
}
