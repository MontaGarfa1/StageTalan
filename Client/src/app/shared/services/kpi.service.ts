import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import { Kpi } from '../../model/Kpi';
import { Observable } from 'rxjs';
import {Search } from '../../model/Search';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class KpiService {

  
    private userUrl= 'http://localhost:9000/';
  
    constructor(private http:HttpClient) { }
  
    //Get all kpi by index
    public getKpi(index:string){
      return this.http.get<Kpi[]>(this.userUrl+index+"/"+"all");
    }
  
    //Get request response
    public getReqRes(param:String[]){
      console.log(param);
      //return this.http.get("http://localhost:8099/dailyKpi/req/monta");
      return this.http.get(this.userUrl+"dailyKpi/req/"+param);
    }
    //Get AccountByID
    public getKpiByID(kpi:Kpi,index:string){
      return this.http.get(this.userUrl+index+"/"+ kpi.idKpi);
    }
  
    //Delete AccountById
    public deleteKpiByID(kpi:Kpi,index:string){
      return this.http.delete(this.userUrl+index+"/delete/"+kpi.idKpi);
    }
    //add account
    public addKpi(kpi:Kpi,index:string)
    {
      return this.http.post<Account>(this.userUrl+index,kpi);
    }
    // get Query reponse
    public getQueryResponse(querys:Search):Observable<any>{
      
      return this.http.get(this.userUrl+"allKpi/query/"+JSON.stringify(querys)  );
    }
    public setKpiInformantion(input1:Array<string>){
      //console.log(JSON.stringify(this.strMapToObj(input)));
      console.log(input1);
      return this.http.post<Kpi>(this.userUrl+"generateKpiController/savekpi",input1)//+"/"+input2+"/"+input3+"/"+input4+"/"+input5);
   //      return this.http.get(this.userUrl+"generateKpiController/addKpi/"+JSON.JSONObject(input1)+"/"+JSON.stringify(input2)+"/"+JSON.stringify(input3)+"/"+JSON.stringify(input4)+"/"+JSON.stringify(input5));

    }
     
    //get stats by state
   // public getStateStats(){
    //  return this.http.get(this.userUrl+"/get/special").map((response=>response));
    //  return this.http.get<Map<String,Number>>(this.userUrl+"/get/special");
    //}
  
  }
  