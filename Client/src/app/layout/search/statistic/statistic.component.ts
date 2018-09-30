import { Component, OnInit, Input, ViewChild } from '@angular/core';
import {MatPaginator,MatTableDataSource} from '@angular/material';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

class Charts{
  data:Number[];
  label:String
} 
import { KpiService } from '../../../shared';
import { Router } from '@angular/router';
import { Kpi } from '../../../model/Kpi';
import { routerTransition } from '../../../router.animations';
@Component({
  selector: 'app-statistic',
  templateUrl: './statistic.component.html',
  styleUrls: ['./statistic.component.scss'],
  animations: [routerTransition()]

})
export class StatisticComponent implements OnInit {
  closeResult: string;
  length:number;
 //displayedColumns: string[] = ['id', 'kpiname', 'date', 'lastupdate','value','deviationfromtarget','nbofincludedmeters'];
 displayedColumns: string[] = ['id', 'date', 'lastupdate','value','deviationfromtarget','nbofincludedmeters'];

 dataSource :MatTableDataSource<Kpi>;

 @ViewChild(MatPaginator) paginator: MatPaginator;
 public chartTitle : String;
 public lineChartData:Array<Charts> = [];
 public lineChartLabels:Array<any> = [];
 public lineChartOptions:any = {
   responsive: true
 };
 public lineChartLegend:boolean = true;
 public lineChartType:string = 'line';

 

 @Input()
 listKpi:Kpi[]=[];
 constructor(private kpiService:KpiService, private router:Router,private modalService: NgbModal) { 
   

 }
 

 ngOnInit() {
   this.dataSource = new MatTableDataSource<Kpi>(this.listKpi);
   this.length=this.listKpi.length;
   this.chartTitle = this.listKpi[0].kpiname;
   this.dataSource.paginator = this.paginator;
   let dataValue:Number[]=[];
   let dataIncM:Number[]=[];

   for(let i=0;i<this.listKpi.length;i++){
     this.lineChartLabels.push(this.listKpi[i].date);
     dataValue.push(this.listKpi[i].value);
     dataIncM.push(this.listKpi[i].deviationFromTarget)
   }
   let charts1:Charts= new Charts;
   charts1.data=dataValue;
   charts1.label="value";
   let charts2:Charts= new Charts;
   charts2.data=dataIncM;
   charts2.label="Deviation From Target";
   this.lineChartData.push(charts1);
   this.lineChartData.push(charts2);
 
console.log(this.lineChartData)}

 
  pageChanged(event){console.log("pageChanged")}

  // events
  public chartClicked(e: any): void {
   console.log(e);
 }

 public chartHovered(e: any): void {
   console.log(e);
 }

 open(content) {
  this.modalService.open(content,{windowClass: 'modaldialog'}).result.then((result) => {
    
      this.closeResult = `Closed with: ${result}`;
  }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
  });
}

private getDismissReason(reason: any): string {
  if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
  } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
  } else {
      return  `with: ${reason}`;
  }
}

}

