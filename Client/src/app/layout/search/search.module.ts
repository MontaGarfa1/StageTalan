import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchComponent } from './search.component';
import { SearchRoutingModule } from './search-routing.module';
import { FormsModule } from '@angular/forms';
import { StatisticComponent } from './statistic/statistic.component';
import { GetValuesPipe } from '../../pipes/get-values.pipe';
import {MatPaginatorModule,MatInputModule, MatTableModule, MatToolbarModule,MatIcon, MatDialogModule } from '@angular/material';
import { ChartsModule } from 'ng2-charts';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SearchRoutingModule,
    MatToolbarModule, 
    MatInputModule, 
    MatTableModule,
    MatPaginatorModule,
    ChartsModule,
    NgbModule.forRoot()
  ],
  declarations: [SearchComponent, StatisticComponent,GetValuesPipe]
})
export class SearchModule { }
