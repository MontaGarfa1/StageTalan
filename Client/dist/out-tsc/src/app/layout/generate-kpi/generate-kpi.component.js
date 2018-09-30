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
var router_animations_1 = require("../../router.animations");
var read_file_service_1 = require("../../shared/services/read-file.service");
var GenerateKpiComponent = /** @class */ (function () {
    function GenerateKpiComponent(readFileSerice) {
        this.readFileSerice = readFileSerice;
    }
    GenerateKpiComponent.prototype.ngOnInit = function () {
    };
    GenerateKpiComponent.prototype.submitedFile = function (form, event) {
        console.log(event);
        console.log(form);
        this.readFileSerice.getJsonData("file:///home/montagarfa/Documents/data.json").subscribe(function (data) { console.log(data); });
    };
    GenerateKpiComponent.prototype.getFileDetails = function (evt) {
        console.log(evt);
        var files = evt.target.files; // FileList object
        // files is a FileList of File objects. List some properties.
        var output = [];
        for (var i = 0, f; f = files[i]; i++) {
            var reader = new FileReader();
            // Closure to capture the file information.
            reader.onload = (function (theFile) {
                return function (e) {
                    // console.log('e readAsText = ', e);
                    // console.log('e readAsText target = ', e.target);
                    try {
                        this.json = JSON.parse(e.target.result);
                        console.log(this.json);
                    }
                    catch (ex) {
                        alert('ex when trying to parse json = ' + ex);
                    }
                };
            })(f);
            reader.readAsText(f);
        }
    };
    GenerateKpiComponent.prototype.getKpiConfigDetails = function (evt) {
    };
    GenerateKpiComponent.prototype.getMeterDetails = function (evt) {
    };
    GenerateKpiComponent.prototype.getDemandDetails = function (evt) {
    };
    GenerateKpiComponent.prototype.getCollectResultDetails = function (evt) {
    };
    GenerateKpiComponent.prototype.getCapabilityDetails = function (evt) { };
    GenerateKpiComponent = __decorate([
        core_1.Component({
            selector: 'app-generate-kpi',
            templateUrl: './generate-kpi.component.html',
            styleUrls: ['./generate-kpi.component.scss'],
            animations: [router_animations_1.routerTransition()]
        }),
        __metadata("design:paramtypes", [read_file_service_1.ReadFileService])
    ], GenerateKpiComponent);
    return GenerateKpiComponent;
}());
exports.GenerateKpiComponent = GenerateKpiComponent;
//# sourceMappingURL=generate-kpi.component.js.map