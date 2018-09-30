"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var common_1 = require("@angular/common");
var search_component_1 = require("./search.component");
var search_routing_module_1 = require("./search-routing.module");
var forms_1 = require("@angular/forms");
var statistic_component_1 = require("./statistic/statistic.component");
var get_values_pipe_1 = require("../../pipes/get-values.pipe");
var material_1 = require("@angular/material");
var ng2_charts_1 = require("ng2-charts");
var ng_bootstrap_1 = require("@ng-bootstrap/ng-bootstrap");
var SearchModule = /** @class */ (function () {
    function SearchModule() {
    }
    SearchModule = __decorate([
        core_1.NgModule({
            imports: [
                common_1.CommonModule,
                forms_1.FormsModule,
                search_routing_module_1.SearchRoutingModule,
                material_1.MatToolbarModule,
                material_1.MatInputModule,
                material_1.MatTableModule,
                material_1.MatPaginatorModule,
                ng2_charts_1.ChartsModule,
                ng_bootstrap_1.NgbModule.forRoot()
            ],
            declarations: [search_component_1.SearchComponent, statistic_component_1.StatisticComponent, get_values_pipe_1.GetValuesPipe]
        })
    ], SearchModule);
    return SearchModule;
}());
exports.SearchModule = SearchModule;
//# sourceMappingURL=search.module.js.map