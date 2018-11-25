import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { Chef } from '../models/chef';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form: FormGroup;
  chef: Chef = new Chef();
  isValid = true;
  isEmpty = true;
  registerSuccess = false;
  private formSubmitAttempt: boolean;

  public errorMsg;

  constructor(private userService: UserService, private router: Router, private fb: FormBuilder) { }

  ngOnInit() {
    this.form = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required]
    })
  }

  isFieldInvalid(field: string) {
    if ((!this.form.get(field).valid && this.form.get(field).touched) ||
      (this.form.get(field).untouched && this.formSubmitAttempt)) {
      this.isValid = false;
    } else {
      this.isValid = true;
    }
  }

  onSubmit() {
    if (this.form.valid) {
      let req = this.userService.registerUser(this.form.value);
      if (req) {
        this.register(req);
        this.isValid = true;
        this.isEmpty = false;
      } else {
        this.isValid = false;
      }
    } else {
      this.isEmpty = true;
      console.log(this.isEmpty);
    }
    this.formSubmitAttempt = true;
  }

  register(obs: Observable<Boolean>) {
    console.log(this.chef);
    obs.subscribe(

      () => {
        console.log("VALID");
        console.log(`User, ${this.chef.username}, successfully registered!`);
        //this.registerSuccess = true;
        window.alert("Registration successful! Please Log in.")
        this.router.navigate(['login']);
      },

      error => {
        if (error) {
          this.isValid = false;
        }
      }

    )
  }

}
