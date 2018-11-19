import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NavbarService {
  visible: boolean;
  loggedIn:boolean;

  constructor() { this.visible = false; this.loggedIn = false; }

  hide() { this.visible = false; }

  show() { this.visible = true; }

  toggle() { this.visible = !this.visible; }

  login() { this.loggedIn = true; }

  logout() { this.loggedIn = false }

}