import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NavbarService } from '../navbar.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  loggedUser = localStorage.getItem('user');
  logInAttempt = false;
  

  constructor(private userService: UserService, private router: Router, private nav: NavbarService) {}


  ngOnInit() {
    if (this.loggedUser) {
      this.router.navigate(['/user-home']);
      this.nav.login();
    }
  }

  login() {
    this.logInAttempt = true;
    this.userService.loginUser(this.user).subscribe(user => {
      console.log(document.getElementById('inputUsername'));
      if(!user) { 
        this.nav.logout();
      } else {
        localStorage.setItem('user', JSON.stringify(user));
        console.log(`User, ${this.user.username}, successfully logged in!`);
        console.log(localStorage.getItem('user'));
        this.nav.login();
        console.log('loggedIn = ' + this.nav.loggedIn);
        this.router.navigate(['user-home']);
      }
    })

  }

}
