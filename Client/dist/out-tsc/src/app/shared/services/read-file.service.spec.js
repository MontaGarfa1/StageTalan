"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var testing_1 = require("@angular/core/testing");
var read_file_service_1 = require("./read-file.service");
describe('ReadFileService', function () {
    beforeEach(function () {
        testing_1.TestBed.configureTestingModule({
            providers: [read_file_service_1.ReadFileService]
        });
    });
    it('should be created', testing_1.inject([read_file_service_1.ReadFileService], function (service) {
        expect(service).toBeTruthy();
    }));
});
//# sourceMappingURL=read-file.service.spec.js.map