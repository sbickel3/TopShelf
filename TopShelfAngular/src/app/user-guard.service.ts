import { Injectable } from '@angular/core';
import { RouterStateSnapshot, Router, CanActivate } from '@angular/router';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class UserGuardService implements CanActivate{

  constructor(private router: Router) { }

  canActivate(route, state: RouterStateSnapshot){

    let authUser: User = (JSON.parse(localStorage.getItem('user')));

    if(authUser){
      return true;
    }

    this.router.navigate(['/']);
    return false;
  }
}
