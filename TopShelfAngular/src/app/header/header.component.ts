import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn = false;
  loggedUser = localStorage.getItem('user');

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.isLoggedIn = this.userService.loggedIn;
  }

}
