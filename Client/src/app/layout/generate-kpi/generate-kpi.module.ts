import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GenerateKpiComponent } from './generate-kpi.component';
import { GenerateKpiRoutingModule } from './generate-kpi-routing.module';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  imports: [
    CommonModule,
    GenerateKpiRoutingModule,
    FormsModule,
    NgbModule.forRoot()

  ],
  declarations: [GenerateKpiComponent]
})
export class GenerateKpiModule { }
