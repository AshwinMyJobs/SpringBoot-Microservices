import { Component } from '@angular/core';
import { Employee } from '../Model/Employee';
import { Userservice } from '../services/userservice.service';
import { SessionService } from '../services/session.service';

@Component({
  selector: 'app-employee-by-id',
  templateUrl: './employee-by-id.component.html',
  styleUrl: './employee-by-id.component.css'
})
export class EmployeeByIdComponent {
  
  public data: any;

  lis = [];

  empid!: number;

  jwtToken!:string;

  constructor(private userService : Userservice, private sessionService : SessionService){}

  ngOnInit(): void {
    this.jwtToken = this.sessionService.getJwtToken();
    data: Employee;
  }

  getEmployeeById(){
    this.userService.getEmployeeByID(this.empid).subscribe((results)=>{console.log(results);this.data=results;this.handleView()});
  }

  getAllEmployees(){
    this.userService.getAllEmployees().subscribe((res)=>console.log(res));
  }
  handleView(){
    this.data.firstName = "";
  }
}
