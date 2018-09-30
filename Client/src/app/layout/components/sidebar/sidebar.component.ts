import { Component, Output, EventEmitter, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/generateKpi', title: 'Generate Kpi',  icon:'fa fa-fw fa-dashboard', class: '' },
    { path: '/search', title: 'Search',  icon: 'fa fa-fw fa-bar-chart-o', class: '' },
  //  { path: '/dashboard', title: 'Dashboard',  icon:'fa fa-fw fa-dashboard', class: '' },
    
   /*{ path: '/charts', title: 'Charts',  icon:'fa fa-fw fa-bar-chart-o', class: '' },
    { path: '/tables', title: 'Tables',  icon:'fa fa-fw fa-table', class: '' },
    { path: '/forms', title: 'Forms',  icon:'fa fa-fw fa-edit', class: '' },
    { path: '/bs-element', title: 'Bootstrap Element',  icon:'fa fa-fw fa-desktop', class: '' },
    { path: '/grid', title: 'Bootstrap Grid',  icon:'fa fa-fw fa-wrench', class: '' },
    { path: '/components', title: 'Component',  icon:'fa fa-th-list', class: '' },
    { path: '/blank-page', title: 'Blank Page',  icon:'fa fa-file-o', class: '' }
*/]
;
@Component({
    selector: 'app-sidebar',
    templateUrl: './sidebar.component.html',
    styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit{
    menuItems: RouteInfo[];

    isActive: boolean = false;
    collapsed: boolean = false;
    showMenu: string = '';
    pushRightClass: string = 'push-right';
    ngOnInit() {
        this.menuItems = ROUTES.filter(menuItem => menuItem);
        console.log(this.menuItems);

    }
    @Output() collapsedEvent = new EventEmitter<boolean>();
    
    constructor(private translate: TranslateService, public router: Router) {
        this.translate.addLangs(['en', 'fr', 'ur', 'es', 'it', 'fa', 'de']);
        this.translate.setDefaultLang('en');
        const browserLang = this.translate.getBrowserLang();
        this.translate.use(browserLang.match(/en|fr|ur|es|it|fa|de/) ? browserLang : 'en');

        this.router.events.subscribe(val => {
            if (
                val instanceof NavigationEnd &&
                window.innerWidth <= 992 &&
                this.isToggled()
            ) {
                this.toggleSidebar();
            }
        });
    }

    eventCalled() {
        this.isActive = !this.isActive;
    }

    addExpandClass(element: any) {
        if (element === this.showMenu) {
            this.showMenu = '0';
        } else {
            this.showMenu = element;
        }
    }

    toggleCollapsed() {
        this.collapsed = !this.collapsed;
        this.collapsedEvent.emit(this.collapsed);
    }

    isToggled(): boolean {
        const dom: Element = document.querySelector('body');
        return dom.classList.contains(this.pushRightClass);
    }

    toggleSidebar() {
        const dom: any = document.querySelector('body');
        dom.classList.toggle(this.pushRightClass);
    }

    rltAndLtr() {
        const dom: any = document.querySelector('body');
        dom.classList.toggle('rtl');
    }

    changeLang(language: string) {
        this.translate.use(language);
    }

    onLoggedout() {
        localStorage.removeItem('isLoggedin');
    }
}
