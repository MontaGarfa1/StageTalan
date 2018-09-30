import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import { Observable } from 'rxjs/Observable';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class ReadFileService {
  constructor(private http:HttpClient) { }
  getJsonData(url):Observable<any> {
    return this.http.get(url).map((res:Response) => res.json());
  }
}
