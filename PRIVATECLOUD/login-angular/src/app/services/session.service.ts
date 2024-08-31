import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  sessionStorage: any | undefined;

  constructor() { }

  storeJwtToken(user: string, jwtToken: string){
    sessionStorage.setItem("user", user);
    sessionStorage.setItem("jwtToken", jwtToken);
  }

  getUser(): any{
    return sessionStorage.getItem("user");
  }

  getJwtToken(): any{
    return sessionStorage.getItem("jwtToken");
  }
}
