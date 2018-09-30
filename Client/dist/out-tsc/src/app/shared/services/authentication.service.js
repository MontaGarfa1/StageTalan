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
var angular2_jwt_1 = require("angular2-jwt");
require("rxjs/add/operator/map");
var AuthenticationService = /** @class */ (function () {
    function AuthenticationService(http) {
        this.http = http;
        this.host = "http://localhost:9000";
        this.roles = [];
    }
    AuthenticationService.prototype.saveToken = function (jwt) {
        this.jwtToken = jwt;
        localStorage.setItem('token', jwt);
        var jwtHelper = new angular2_jwt_1.JwtHelper();
        this.roles = jwtHelper.decodeToken(this.jwtToken).roles;
    };
    AuthenticationService.prototype.login = function (user) {
        return this.http.post(this.host + "/login", user, { observe: 'response' });
    };
    AuthenticationService.prototype.loadToken = function () {
        this.jwtToken = localStorage.getItem('token');
        return this.jwtToken;
    };
    AuthenticationService.prototype.loggedIn = function () {
        return angular2_jwt_1.tokenNotExpired('token');
    };
    AuthenticationService.prototype.logout = function () {
        this.jwtToken = null;
        localStorage.removeItem('token');
    };
    // logout() {
    //   this.authToken = null;
    //   this.user = null;
    //   localStorage.clear();
    // }
    AuthenticationService.prototype.isAdmin = function () {
        for (var _i = 0, _a = this.roles; _i < _a.length; _i++) {
            var r = _a[_i];
            //console.log(r.authority);
            if (r.authority == "ADMIN")
                return true;
        }
        return false;
    };
    AuthenticationService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [http_1.HttpClient])
    ], AuthenticationService);
    return AuthenticationService;
}());
exports.AuthenticationService = AuthenticationService;
//# sourceMappingURL=authentication.service.js.map