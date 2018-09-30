import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { routerTransition } from '../router.animations';
import { FlashMessagesService } from 'angular2-flash-messages';
import { User } from '../model/User';
import { first } from 'rxjs/operators';

import { AuthenticationService } from '../shared/services/authentication.service';
import { AlertService } from '../shared';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  animations: [routerTransition()]
})
export class LoginComponent implements OnInit {
  user:User;
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  constructor(private formBuilder: FormBuilder,
    private alertService: AlertService, public router: Router, private authService: AuthenticationService) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
    // reset login status
    this.authService.logout();
  }
  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }
  onSubmit() {

    this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        this.user=new User();
        this.user.username=this.f.username.value;
        this.user.password=this.f.password.value;
        this.authService.login(this.user).pipe(first())
        .subscribe(data => {
          let jwt = data.headers.get('Authorization');
        console.log(jwt);
        this.authService.saveToken(jwt);
          this.router.navigate(['']);
      },  error => {
        this.alertService.error("L'identifiant ou le mot de passe est incorrect");
        this.loading = false;
    });

/*
    console.log(user);
    this.authService.login(user)
      .subscribe(resp => {
        let jwt = resp.headers.get('Authorization');
        console.log(jwt);

        this.authService.saveToken(jwt);
        this.router.navigate(['']);
      },
        err => {
          this.router.navigate(['/login']);
        }
      )

*/

  }
}