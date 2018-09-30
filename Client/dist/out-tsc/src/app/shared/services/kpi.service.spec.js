"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var testing_1 = require("@angular/core/testing");
var kpi_service_1 = require("./kpi.service");
describe('KpiService', function () {
    beforeEach(function () {
        testing_1.TestBed.configureTestingModule({
            providers: [kpi_service_1.KpiService]
        });
    });
    it('should be created', testing_1.inject([kpi_service_1.KpiService], function (service) {
        expect(service).toBeTruthy();
    }));
});
//# sourceMappingURL=kpi.service.spec.js.map