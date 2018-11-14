import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn = false;
  loggedUser = localStorage.getItem('user');

  constructor() { }

  ngOnInit() {
    if(this.loggedUser){
      this.isLoggedIn = true;
    } else{
      this.isLoggedIn = false;
    }
  }

}
