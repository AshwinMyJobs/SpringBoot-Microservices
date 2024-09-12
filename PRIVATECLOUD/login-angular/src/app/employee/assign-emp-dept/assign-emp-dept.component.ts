import { Component } from '@angular/core';
import { Userservice } from '../../services/userservice.service';
import { SessionService } from '../../services/session.service';
import { Department } from '../../Model/Department';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Employee } from '../../Model/Employee';

@Component({
  selector: 'app-assign-emp-dept',
  templateUrl: './assign-emp-dept.component.html',
  styleUrl: './assign-emp-dept.component.css'
})
export class AssignEmpDeptComponent {

  public departments: any;
  public employees: any;

  form!: FormGroup;
  selectedOption!: string;

  constructor(private userService : Userservice, private sessionService : SessionService, private fb: FormBuilder){
    this.form = this.fb.group({
      selectedOption: ['', Validators.nullValidator],
    });

    this.getAllDepartments();
    this.getAllEmployees();
  }

  ngOnInit(): void {
    departments: Department;
  }

  getAllDepartments(){
    console.log("getAllDepartments() method is called.......");
    this.userService.getAllDepartments().subscribe((res)=>{this.departments=res;console.log(res)});
  }

  getAllEmployees(){
    console.log("getAllDepartments() method is called.......");
    this.userService.getAllEmployees().subscribe((res)=>{this.employees=res;console.log(res)});
  }

}
