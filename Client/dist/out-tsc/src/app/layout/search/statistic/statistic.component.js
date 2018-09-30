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
var material_1 = require("@angular/material");
var ng_bootstrap_1 = require("@ng-bootstrap/ng-bootstrap");
var Charts = /** @class */ (function () {
    function Charts() {
    }
    return Charts;
}());
var shared_1 = require("../../../shared");
var router_1 = require("@angular/router");
var router_animations_1 = require("../../../router.animations");
var StatisticComponent = /** @class */ (function () {
    function StatisticComponent(kpiService, router, modalService) {
        this.kpiService = kpiService;
        this.router = router;
        this.modalService = modalService;
        //displayedColumns: string[] = ['id', 'kpiname', 'date', 'lastupdate','value','deviationfromtarget','nbofincludedmeters'];
        this.displayedColumns = ['id', 'date', 'lastupdate', 'value', 'deviationfromtarget', 'nbofincludedmeters'];
        this.lineChartData = [];
        this.lineChartLabels = [];
        this.lineChartOptions = {
            responsive: true
        };
        this.lineChartLegend = true;
        this.lineChartType = 'line';
        this.listKpi = [];
    }
    StatisticComponent.prototype.ngOnInit = function () {
        this.dataSource = new material_1.MatTableDataSource(this.listKpi);
        this.length = this.listKpi.length;
        this.chartTitle = this.listKpi[0].kpiname;
        this.dataSource.paginator = this.paginator;
        var dataValue = [];
        var dataIncM = [];
        for (var i = 0; i < this.listKpi.length; i++) {
            this.lineChartLabels.push(this.listKpi[i].date);
            dataValue.push(this.listKpi[i].value);
            dataIncM.push(this.listKpi[i].deviationFromTarget);
        }
        var charts1 = new Charts;
        charts1.data = dataValue;
        charts1.label = "value";
        var charts2 = new Charts;
        charts2.data = dataIncM;
        charts2.label = "Deviation From Target";
        this.lineChartData.push(charts1);
        this.lineChartData.push(charts2);
        console.log(this.lineChartData);
    };
    StatisticComponent.prototype.pageChanged = function (event) { console.log("pageChanged"); };
    // events
    StatisticComponent.prototype.chartClicked = function (e) {
        console.log(e);
    };
    StatisticComponent.prototype.chartHovered = function (e) {
        console.log(e);
    };
    StatisticComponent.prototype.open = function (content) {
        var _this = this;
        this.modalService.open(content, { windowClass: 'modaldialog' }).result.then(function (result) {
            _this.closeResult = "Closed with: " + result;
        }, function (reason) {
            _this.closeResult = "Dismissed " + _this.getDismissReason(reason);
        });
    };
    StatisticComponent.prototype.getDismissReason = function (reason) {
        if (reason === ng_bootstrap_1.ModalDismissReasons.ESC) {
            return 'by pressing ESC';
        }
        else if (reason === ng_bootstrap_1.ModalDismissReasons.BACKDROP_CLICK) {
            return 'by clicking on a backdrop';
        }
        else {
            return "with: " + reason;
        }
    };
    __decorate([
        core_1.ViewChild(material_1.MatPaginator),
        __metadata("design:type", material_1.MatPaginator)
    ], StatisticComponent.prototype, "paginator", void 0);
    __decorate([
        core_1.Input(),
        __metadata("design:type", Array)
    ], StatisticComponent.prototype, "listKpi", void 0);
    StatisticComponent = __decorate([
        core_1.Component({
            selector: 'app-statistic',
            templateUrl: './statistic.component.html',
            styleUrls: ['./statistic.component.scss'],
            animations: [router_animations_1.routerTransition()]
        }),
        __metadata("design:paramtypes", [shared_1.KpiService, router_1.Router, ng_bootstrap_1.NgbModal])
    ], StatisticComponent);
    return StatisticComponent;
}());
exports.StatisticComponent = StatisticComponent;
//# sourceMappingURL=statistic.component.js.map