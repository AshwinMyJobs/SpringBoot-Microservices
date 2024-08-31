import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../Model/User';
import { Observable } from 'rxjs';
import { Employee } from '../Model/Employee';

@Injectable({
  providedIn: 'root'
})
export class Userservice {

  private loginURL = "http://localhost:8001/login/authenticate";
  private saveEmployeeURL = "http://localhost:8001/employee/saveEmployee";
  private sayHello = "http://localhost:8001/employee/saveEmployee";
  private getEmpByID = "http://localhost:8001/employee/getEmployeeById/";
  private getAllEmp = "http://localhost:8001/employee/getEmployees";

  constructor(private httpClient :HttpClient) { }

  loginUser(user: User): Observable<Object> {
    return this.httpClient.post(`${this.loginURL}`, user);
  }

  saveEmployee(employee: Employee):Observable<Object>{
    return this.httpClient.post(`${this.saveEmployeeURL}`, employee);
  }

  getEmployeeByID(empid: number):Observable<Object>{
    return this.httpClient.get(`${this.getEmpByID}`+empid);
  }

  getAllEmployees():Observable<Object>{
    return this.httpClient.get(`${this.getAllEmployees}`);
  }

  sayHelloMethod(employee: Employee):Observable<Object>{
    return this.httpClient.post(`${this.sayHello}`, employee);
  }
}
