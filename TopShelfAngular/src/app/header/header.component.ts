import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn$: Observable<boolean>;

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.isLoggedIn$ = this.userService.isLoggedIn;
  }

  onLogout() {
    this.userService.logout();
  }

}
