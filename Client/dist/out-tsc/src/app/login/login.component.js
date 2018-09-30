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
var router_animations_1 = require("../router.animations");
var angular2_flash_messages_1 = require("angular2-flash-messages");
var User_1 = require("../model/User");
var authentication_service_1 = require("../shared/services/authentication.service");
var LoginComponent = /** @class */ (function () {
    function LoginComponent(router, authService, flashMessage) {
        this.router = router;
        this.authService = authService;
        this.flashMessage = flashMessage;
        this.user = new User_1.User();
    }
    LoginComponent.prototype.ngOnInit = function () { };
    LoginComponent.prototype.onLoggedin = function (user) {
        /**
         *
            this.authService.login(user).subscribe(data => {
                if(data.success) {
        let jwt = resp.headers.get('Authorization');
              console.log(jwt);
          this.authService.saveToken(jwt);
        this.router.navigate(['/pages']);        } else {
                  this.flashMessage.show('fffffffff', {cssClass: 'alert-danger', timeout: 5000});
                 this.router.navigate(['/ok']);
                }
            });
         */
        var _this = this;
        console.log(user);
        this.authService.login(user)
            .subscribe(function (resp) {
            var jwt = resp.headers.get('Authorization');
            console.log(jwt);
            _this.authService.saveToken(jwt);
            _this.router.navigate(['']);
        }, function (err) {
            _this.flashMessage.show('Identifiant ou Mot de passe incorrecte', { cssClass: 'alert-danger', timeout: 5000 });
            _this.router.navigate(['/login']);
        });
    };
    LoginComponent = __decorate([
        core_1.Component({
            selector: 'app-login',
            templateUrl: './login.component.html',
            styleUrls: ['./login.component.scss'],
            animations: [router_animations_1.routerTransition()]
        }),
        __metadata("design:paramtypes", [router_1.Router, authentication_service_1.AuthenticationService, angular2_flash_messages_1.FlashMessagesService])
    ], LoginComponent);
    return LoginComponent;
}());
exports.LoginComponent = LoginComponent;
//# sourceMappingURL=login.component.js.map