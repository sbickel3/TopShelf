import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;
  private formSubmitAttempt: boolean;
  user: User = new User();
  loggedUser = localStorage.getItem('user');
  isValid: boolean;


  constructor(
    private userService: UserService,
    private router: Router,
    private fb: FormBuilder,
  ) { }


  ngOnInit() {
    if (this.loggedUser) {
      console.log("LOGGED IN ALREADY")
      this.router.navigate(['user-home']);
    }
    this.form = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
}

isFieldInvalid(field: string){
  if ((!this.form.get(field).valid && this.form.get(field).touched) ||
    (this.form.get(field).untouched && this.formSubmitAttempt)) {
    this.isValid = false;
  } else {
    this.isValid = true;
  }
}

onSubmit(){
  if (this.form.valid) {
    if (this.userService.loginUser(this.form.value)) {
      this.isValid = true;
    } else {
      this.isValid = false;
    }
  }
  this.formSubmitAttempt = true;
}

}
