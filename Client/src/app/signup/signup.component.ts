import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../router.animations';
import { Router } from '@angular/router';
import { SignUpService } from '../shared/services/sign-up.service';
import { User } from '../model/User';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertService } from '../shared';
import { first } from 'rxjs/operators';


@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.scss'],
    animations: [routerTransition()]
})
export class SignupComponent implements OnInit {
    registerForm: FormGroup;
    loading = false;
    submitted = false;
    constructor(private formBuilder: FormBuilder,
        private router:Router,private signupService:SignUpService,private alertService:AlertService) {}
        onSubmit(){
            this.submitted = true;
            if (this.registerForm.invalid) {
                return;
            }
            this.loading = true;
            console.log(this.registerForm.value)
            this.signupService.saveUser(this.registerForm.value).subscribe(data=>{
                this.alertService.success('Registration successful', true);
                this.router.navigate(['/login']); },
            error=>{
                this.alertService.error("Le nom d'utilisateur "+this.f.username.value+ " est déjà existe");
                    this.loading = false;
                    console.log(error)
            }
            )
     /*  this.user.username=form.value.username;
       this.user.password=form.value.password;
        this.signupService.saveUser(this.user).subscribe(data=> {console.log(data)}
    ,error=>{

    })
      //  this.router.navigate(["/login"]);
    }*/}
    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', [Validators.required, Validators.minLength(6)]]
        });
    }
    get f() { return this.registerForm.controls; }
}
