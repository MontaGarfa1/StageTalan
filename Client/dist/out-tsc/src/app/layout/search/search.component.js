"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var kpi_service_1 = require("../../shared/services/kpi.service");
var router_animations_1 = require("../../router.animations");
var SearchComponent = /** @class */ (function () {
    function SearchComponent(router, kpiService) {
        this.router = router;
        this.kpiService = kpiService;
        this.today = new Date();
        this.listMap = new Map();
        this.typeKpi = "all";
        this.keysmap = [];
        this.response = false;
        this.listKpis = [];
    }
    SearchComponent.prototype.ngOnInit = function () {
    };
    SearchComponent.prototype.addFilter = function (form) {
        var _this = this;
        var searchConifg = {
            typekpi: form.value.typekpi,
            datetype: form.value.datetype,
            dateFrom: form.value.dateFrom,
            dateTo: form.value.dateTo
        };
        console.log(searchConifg);
        this.kpiService.getQueryResponse(searchConifg).subscribe(function (data) {
            if (data == null) {
                console.log("undefind");
            }
            else {
                _this.listMap = JSON.parse(JSON.stringify(data));
                console.log(_this.listMap);
            }
        });
        this.response = true;
    };
    SearchComponent = __decorate([
        core_1.Component({
            selector: 'app-search',
            templateUrl: './search.component.html',
            styleUrls: ['./search.component.scss'],
            animations: [router_animations_1.routerTransition()]
        }),
        __metadata("design:paramtypes", [router_1.Router, kpi_service_1.KpiService])
    ], SearchComponent);
    return SearchComponent;
}());
exports.SearchComponent = SearchComponent;
//# sourceMappingURL=search.component.js.map