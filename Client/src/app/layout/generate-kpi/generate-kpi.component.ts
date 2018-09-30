import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { ReadFileService } from '../../shared/services/read-file.service';
import { KpiConfig } from '../../model/KpiConfig';
import { Meter } from '../../model/Meter';
import { Demand } from '../../model/Demand';
import { Capability } from '../../model/Capability';
import { CollectResult } from '../../model/CollectResult';
import { KpiService } from '../../shared/services/kpi.service';
import { isArrayLike } from 'rxjs/internal-compatibility';
import { Kpi } from '../../model/Kpi';

@Component({
  selector: 'app-generate-kpi',
  templateUrl: './generate-kpi.component.html',
  styleUrls: ['./generate-kpi.component.scss'],
  animations: [routerTransition()]

})
export class GenerateKpiComponent implements OnInit {
  add:number=0;
  addedKpi:Kpi;


  dataTOback:Array<string>=new  Array<string>();

  kpiConfig: Array<KpiConfig>;
  fileStringKpiConfig: any;
  errorKpiConfig: boolean = false;

  meter: Array<Meter>;
  fileStringMeter: any;
  errorMeter: boolean = false;

  demand: Array<Demand>;
  fileStringDemand: any;
  errorDemand: boolean = false;

  collectResult: Array<CollectResult>;
  fileStringCollectResult: any;
  errorCollectResult: boolean = false;

  capability: Array<Capability>;
  fileStringCapability: any;
  errorCapability: boolean = false;

  message: string;
  alerts: Array<any> = [];

  constructor(private kpiService: KpiService) { 
    this.alerts.push({
      id: 1,
      type: 'success',
      message: 'This is an success alert',
  }, {
      id: 2,
      type: 'danger',
      message: 'This is a danger alert',
  });


  }
  public closeAlert(alert: any) {
    const index: number = this.alerts.indexOf(alert);
    this.alerts.splice(index, 1);
}
  ngOnInit() {
  }
  submitedFile() {
    if (this.fileStringKpiConfig == null) {
      this.errorKpiConfig = true;
      this.message = "File Vide !!"
    } else if (this.fileStringMeter == null) {
      this.errorKpiConfig = false;
      this.errorMeter = true;
      this.message = "File Vide !!"

    } else if (this.fileStringDemand == null) {
      this.errorMeter = false;
      this.errorKpiConfig = false;

      this.errorDemand = true;
      this.message = "File Vide !!"


    } else if (this.fileStringCollectResult == null) {
      this.errorMeter = false;
      this.errorKpiConfig = false;
      this.errorDemand = false;
      this.errorCollectResult = true;
      this.message = "File Vide !!"


    } else if (this.fileStringCapability == null) {
      this.errorCollectResult = false;
      this.errorMeter = false;
      this.errorKpiConfig = false;
      this.errorDemand = false;
      this.errorCapability = true;
      this.message = "File Vide !!"

    }
    else {
      this.errorCollectResult = false;
      this.errorMeter = false;
      this.errorKpiConfig = false;
      this.errorDemand = false;
      this.errorCapability = false;
      console.log("all file not empty")
      try {
        this.kpiConfig = JSON.parse(this.fileStringKpiConfig)
        try {
          this.errorKpiConfig = false;
          this.meter = JSON.parse(this.fileStringMeter)
          try {
            this.errorMeter = false;
            this.demand = JSON.parse(this.fileStringDemand)
            try {
              this.errorDemand = false;
              this.collectResult = JSON.parse(this.fileStringCollectResult)
              try {
                this.errorCollectResult = false;
                this.capability = JSON.parse(this.fileStringCapability)
                this.errorCapability = false;
                console.log(this.kpiConfig);
                console.log(this.meter);
                console.log(this.demand);
                console.log(this.collectResult);
                console.log(this.capability);
                this.dataTOback.push(JSON.stringify(this.kpiConfig));
                this.dataTOback.push(JSON.stringify(this.meter));
                this.dataTOback.push(JSON.stringify(this.demand));
                this.dataTOback.push(JSON.stringify(this.collectResult));
                this.dataTOback.push(JSON.stringify(this.capability));
                this.kpiService.setKpiInformantion(this.dataTOback).subscribe(data=>{
                  console.log(data);
                  if(data == null){
                  this.add=2;
                  this.alerts[1].message="Erreur de l'ajout de Kpi";}
                  else{
                    this.add=1;
                    this.addedKpi=data;
                    this.alerts[0].message="Kpi Id = "+this.addedKpi.idKpi+"   Kpi name = "+this.addedKpi.kpiname;
                   }
                  this.dataTOback =new Array<string>();
                },error=>{
                  this.add=2;
                  console.log(error);
                  this.alerts[1].message=error.message;
                  this.dataTOback =new Array<string>();

                })

              } catch (error) {
                console.log(error)
                this.errorCapability = true;
                this.message = "Cannot parse JSON ";
              }
            } catch (error) {
              this.errorCollectResult = true;
              this.message = "Cannot parse JSON ";
            }
          } catch (error) {
            this.errorDemand = true;
            this.message = "Cannot parse JSON ";
          }
        } catch (error) {
          this.errorMeter = true;
          this.message = "Cannot parse JSON ";
        }
      } catch (error) {
        this.errorKpiConfig = true;
        this.message = "Cannot parse JSON ";
      }
    }
  }

  /* getFileDetails (evt) {
     console.log("sqfqs");
     var file: File = evt.target.files[0];
     var myReader: FileReader = new FileReader();
     var fileType = evt.target.parentElement.id;
     myReader.onloadend = (e) => {
       this.fileString = myReader.result;
    };
      myReader.readAsText(file);
      
 
 
   }*/
  getKpiConfigDetails(evt) {

    console.log("sqfqs");
    var file: File = evt.target.files[0];
    var myReader: FileReader = new FileReader();
    var fileType = evt.target.parentElement.id;
    myReader.onloadend = (e) => {
      this.fileStringKpiConfig = myReader.result;
    };
    myReader.readAsText(file);



  }
  getMeterDetails(evt) {
    console.log("sqfqs");
    var file: File = evt.target.files[0];
    var myReader: FileReader = new FileReader();
    var fileType = evt.target.parentElement.id;
    myReader.onloadend = (e) => {
      this.fileStringMeter = myReader.result;
    };
    myReader.readAsText(file);


  }
  getDemandDetails(evt) {
    console.log("sqfqs");
    var file: File = evt.target.files[0];
    var myReader: FileReader = new FileReader();
    var fileType = evt.target.parentElement.id;
    myReader.onloadend = (e) => {
      this.fileStringDemand = myReader.result;
    };
    myReader.readAsText(file);
  }
  getCollectResultDetails(evt) {
    console.log("sqfqs");
    var file: File = evt.target.files[0];
    var myReader: FileReader = new FileReader();
    var fileType = evt.target.parentElement.id;
    myReader.onloadend = (e) => {
      this.fileStringCollectResult = myReader.result;
    };
    myReader.readAsText(file);

  }
  getCapabilityDetails(evt) {
    console.log("sqfqs");
    var file: File = evt.target.files[0];
    var myReader: FileReader = new FileReader();
    var fileType = evt.target.parentElement.id;
    myReader.onloadend = (e) => {
      this.fileStringCapability = myReader.result;
    };
    myReader.readAsText(file);
  }

}
