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
var http_1 = require("@angular/common/http");
var httpOptions = {
    headers: new http_1.HttpHeaders({ 'Content-Type': 'application/json' })
};
var KpiService = /** @class */ (function () {
    function KpiService(http) {
        this.http = http;
        this.userUrl = 'http://localhost:9000/';
    }
    //Get all kpi by index
    KpiService.prototype.getKpi = function (index) {
        return this.http.get(this.userUrl + index + "/" + "all");
    };
    //Get request response
    KpiService.prototype.getReqRes = function (param) {
        console.log(param);
        //return this.http.get("http://localhost:8099/dailyKpi/req/monta");
        return this.http.get(this.userUrl + "dailyKpi/req/" + param);
    };
    //Get AccountByID
    KpiService.prototype.getKpiByID = function (kpi, index) {
        return this.http.get(this.userUrl + index + "/" + kpi.idKpi);
    };
    //Delete AccountById
    KpiService.prototype.deleteKpiByID = function (kpi, index) {
        return this.http.delete(this.userUrl + index + "/delete/" + kpi.idKpi);
    };
    //add account
    KpiService.prototype.addKpi = function (kpi, index) {
        return this.http.post(this.userUrl + index, kpi);
    };
    // get Query reponse
    KpiService.prototype.getQueryResponse = function (querys) {
        return this.http.get(this.userUrl + "allKpi/query/" + JSON.stringify(querys));
    };
    KpiService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], KpiService);
    return KpiService;
}());
exports.KpiService = KpiService;
//# sourceMappingURL=kpi.service.js.map