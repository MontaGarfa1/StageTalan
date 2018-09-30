import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private userUrl= 'http://localhost:9000/';
  constructor(private http:HttpClient) { }
  public saveUser(user){
    return this.http.post(this.userUrl+'register',user);
  }

}
