import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SignupRoutingModule } from './signup-routing.module';
import { SignupComponent } from './signup.component';
import { FormsModule,  ReactiveFormsModule,} from '@angular/forms';
import { AlertModule } from '../alert/alert.module';

@NgModule({
  imports: [
    CommonModule,
    SignupRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    AlertModule

  ],
  declarations: [SignupComponent],})
export class SignupModule { }
