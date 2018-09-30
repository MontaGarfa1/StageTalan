import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Search } from '../../model/Search'
import { KpiService } from '../../shared/services/kpi.service';
import { Kpi } from '../../model/Kpi';
import { routerTransition } from '../../router.animations';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss'],
  animations: [routerTransition()]

})
export class SearchComponent implements OnInit {
  today : Date = new Date();
  listMap : Map<String,Array<Kpi>>= new Map<String,Array<Kpi>>();
  typeKpi:string="all";
  keysmap : String[]= [];
  response:boolean=false;
  listKpis:Kpi[]=[];
  constructor(private router:Router,private kpiService:KpiService) { }

  ngOnInit() {

  }
  addFilter(form){
    let searchConifg: Search ={
      typekpi: form.value.typekpi,
      datetype: form.value.datetype,
      dateFrom: form.value.dateFrom,
      dateTo: form.value.dateTo
    }
    console.log(searchConifg);
    this.kpiService.getQueryResponse(searchConifg).subscribe(data=> {
      if(data==null){
        console.log("undefind")
      }else{
        this.listMap=JSON.parse(JSON.stringify(data));
      console.log(this.listMap);
      }
    })

    this.response=true;
    
  }
   

}