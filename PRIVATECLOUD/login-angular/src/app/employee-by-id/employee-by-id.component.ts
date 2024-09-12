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

  lis = [];

  empid!: number;

  jwtToken!:string;

  constructor(private userService : Userservice, private sessionService : SessionService){}

  ngOnInit(): void {
    this.jwtToken = this.sessionService.getJwtToken();
    data: Employee;
  }

  getEmployeeDetails(){
    if(this.empid!=null)
      this.getEmployeeById();
    else
      this.getAllEmployees();
  }

  public data: any;
  getEmployeeById(){
    console.log("getEmployeeById() method is called.......");
    this.userService.getEmployeeByID(this.empid).subscribe((res)=>{this.data=res;console.log(res);});
  }

  getAllEmployees(){
    console.log("getAllEmployees() method is called.......");
    this.userService.getAllEmployees().subscribe((res)=>{this.data=res;console.log(res)});
  }


  handleView(){
    this.data.firstName = "";
  }
}
