import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  loggedUser = localStorage.getItem('user');
  

  constructor(private userService: UserService, private router: Router) {}


  ngOnInit() {
    if (this.loggedUser) {
      this.router.navigate(['/user-home']);
    }
  }

  login() {
    // this.userService.loginUser(this.user).subscribe(user => {
    //   console.log(document.getElementById('inputUsername'));
    //   if(!user) {
    //     this.userService.loggedIn = false;
    //   } else {
    //     localStorage.setItem('user', JSON.stringify(user));
    //     console.log(`User, ${this.user.username}, successfully logged in!`);
    //     console.log(localStorage.getItem('user'));
    //     this.router.navigate(['user-home']);
    //   }
    // })
    let inputUsername = (<HTMLInputElement>document.getElementById('inputUsername')).value;
    let inputPassword = (<HTMLInputElement>document.getElementById('inputPassword')).value;
    if (inputUsername && inputPassword) {
      this.router.navigate(['user-home']);
    }

  }

}
