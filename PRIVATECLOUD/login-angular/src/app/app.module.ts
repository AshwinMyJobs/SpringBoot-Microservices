import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { EmptyError } from 'rxjs';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeByIdComponent } from './employee-by-id/employee-by-id.component';
import { AssignEmpDeptComponent } from './employee/assign-emp-dept/assign-emp-dept.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MatSelectModule } from '@angular/material/select';
import { RegisterEmployeeComponent } from './employee/register-employee/register-employee.component';

const routes: Routes = [
  { path: 'Login', component: LoginComponent },
  { path: 'Employee', component: EmployeeComponent },
  { path: 'EmployeeByID', component: EmployeeByIdComponent },
  { path: 'EmpDept', component: AssignEmpDeptComponent},
  { path: 'RegisterEmployee', component: RegisterEmployeeComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeComponent,
    EmployeeByIdComponent,
    AssignEmpDeptComponent,
    RegisterEmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    MatSelectModule
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
