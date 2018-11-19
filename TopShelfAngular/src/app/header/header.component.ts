import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { takeUntil } from 'rxjs/operators';
import { User } from '../models/user';
import { Subject, Observable } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user: User;
  unsubscribeAll = new Subject();
  isLoggedIn$: Observable<boolean>;
  loggedUser = localStorage.getItem('user');

  constructor(private userService: UserService) {
    this.isLoggedIn$ = this.userService.isLoggedIn;
  }

  ngOnInit() {
   
  }

  logout(){
    localStorage.removeItem('user');
    window.location.reload();
  }
}
