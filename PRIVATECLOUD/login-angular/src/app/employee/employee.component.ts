import { Component } from '@angular/core';
import { Employee } from '../Model/Employee'
import { Userservice } from '../services/userservice.service';
import { SessionService } from '../services/session.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {

  employee = new Employee();

  jwtToken!:string;

  constructor(private userService : Userservice, private sessionService : SessionService){}

  ngOnInit(): void {
    this.jwtToken = this.sessionService.getJwtToken()
  }

  saveEmployee(){
    this.userService.saveEmployee(this.employee).subscribe((res)=>console.log(res));
  }

}

