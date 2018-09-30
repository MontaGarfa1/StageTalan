import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FlashMessagesModule } from 'angular2-flash-messages';
import { FlashMessagesService } from 'angular2-flash-messages';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { AlertModule } from '../alert/alert.module';

@NgModule({
    imports: [ReactiveFormsModule,CommonModule, FormsModule,LoginRoutingModule,FlashMessagesModule.forRoot(),AlertModule],
    declarations: [LoginComponent],
    providers: [FlashMessagesService],

})
export class LoginModule {}
