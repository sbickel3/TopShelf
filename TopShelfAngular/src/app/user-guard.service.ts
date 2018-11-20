import { Injectable } from '@angular/core';
import { RouterStateSnapshot, Router, CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { UserService } from './user.service';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserGuardService implements CanActivate {

  constructor(private router: Router, private userService: UserService) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean> {
    return this.userService.isLoggedIn.pipe(take(1), map((isLoggedIn: boolean) => {
      if (!isLoggedIn) {
        this.router.navigate(['login']);
        return false;
      }
      return true;
    })
    )
  }
}
