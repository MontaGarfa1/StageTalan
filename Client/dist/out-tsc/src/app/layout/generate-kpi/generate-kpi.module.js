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
var generate_kpi_component_1 = require("./generate-kpi.component");
var generate_kpi_routing_module_1 = require("./generate-kpi-routing.module");
var forms_1 = require("@angular/forms");
var GenerateKpiModule = /** @class */ (function () {
    function GenerateKpiModule() {
    }
    GenerateKpiModule = __decorate([
        core_1.NgModule({
            imports: [
                common_1.CommonModule,
                generate_kpi_routing_module_1.GenerateKpiRoutingModule,
                forms_1.FormsModule
            ],
            declarations: [generate_kpi_component_1.GenerateKpiComponent]
        })
    ], GenerateKpiModule);
    return GenerateKpiModule;
}());
exports.GenerateKpiModule = GenerateKpiModule;
//# sourceMappingURL=generate-kpi.module.js.map