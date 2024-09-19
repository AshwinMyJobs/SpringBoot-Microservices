import { Component } from '@angular/core';
import { Employee } from '../../Model/Employee'
import { Userservice } from '../../services/userservice.service';
import { SessionService } from '../../services/session.service';

@Component({
  selector: 'app-register-employee',
  templateUrl: './register-employee.component.html',
  styleUrl: './register-employee.component.css'
})
export class RegisterEmployeeComponent {

  employee = new Employee();

  constructor(private userService : Userservice, private sessionService : SessionService){}

  registerEmployee(){
    console.log("registerEmployee method is called...........");
    console.log(this.employee);
    this.userService.saveEmployee(this.employee).subscribe((res)=>console.log(res));
  }
}
