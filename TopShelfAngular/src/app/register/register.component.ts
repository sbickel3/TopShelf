import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  isValid = true;
  registerSuccess = false;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  register() {
    this.userService.registerUser(this.user).subscribe(user => {
      if(!user){
        this.isValid = false;
      } else{
        console.log(`User, ${this.user.chef.username}, successfully logged in!`);
        this.registerSuccess = true;
        this.router.navigate(['login']);
      }
    })
  }

}
