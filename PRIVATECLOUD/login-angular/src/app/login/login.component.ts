import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { User } from '../Model/User';
import { Userservice } from '../services/userservice.service';
import { SessionService } from '../services/session.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  user = new User();

  constructor(private userService : Userservice, private sessionService : SessionService){

  }

  ngOnInit(): void {
    this.user.name = "";
    this.user.password = "";
  }

  authenticate(): void {
    console.log(this.user.name);
    console.log(this.user.password);
    this.userService.loginUser(this.user).subscribe((res)=>this.storeJwtTokenInSession(res));
  }

  storeJwtTokenInSession(res: any) {
    console.log("token : " +  JSON.stringify(res));
    console.log("token : " +  res.message);
    this.sessionService.storeJwtToken(this.user.name, res.message);
  }
}
