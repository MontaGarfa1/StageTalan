import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { tokenNotExpired,JwtHelper } from 'angular2-jwt';
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private host:string="http://localhost:9000";
  private jwtToken;
  private roles:Array<any>=[];
  constructor(private http:HttpClient) { }

  saveToken(jwt:string){
    this.jwtToken=jwt;
    localStorage.setItem('token',jwt);
    let jwtHelper=new JwtHelper();
    this.roles=jwtHelper.decodeToken(this.jwtToken).roles;
  }


  login(user) {
    return this.http.post(this.host + "/login", user, {observe: 'response'});
  }

  loadToken() {

    this.jwtToken=localStorage.getItem('token');
return  this.jwtToken;
  }

  loggedIn() {
    
    return tokenNotExpired('token');
  }




  logout(){
    this.jwtToken=null;
    localStorage.removeItem('token');



    
    }


  // logout() {
  //   this.authToken = null;
  //   this.user = null;
  //   localStorage.clear();
  // }

  isAdmin(){
    for (let r of this.roles ){
      //console.log(r.authority);
      if(r.authority=="ADMIN") return true;
    }
    return false;
  }
}
