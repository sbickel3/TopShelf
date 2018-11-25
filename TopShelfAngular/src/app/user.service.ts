import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, BehaviorSubject, throwError } from 'rxjs';
import { User } from './models/user';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';
import { Chef } from './models/chef';
import { catchError } from 'rxjs/operators';

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-type': 'application/json'
  }),
};

@Injectable({
  providedIn: 'root'
})

export class UserService {

  private loggedIn = new BehaviorSubject<boolean>(false);
  private userLoggedIn: boolean;

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  registerSucess: boolean = false;

  constructor(private http: HttpClient, private router: Router) {
    if(localStorage.getItem('user')){
      this.loggedIn.next(true);
    }
  }

  loginUser(user: User): boolean {
    let userJSON = JSON.stringify(user);
    this.http.post<User>(environment.apiURL + 'chefs/login', userJSON, HTTP_OPTIONS).subscribe(loggedUser => {
        if(!loggedUser) {
          this.loggedIn.next(false);
          this.userLoggedIn = false;
        } else {
          this.loggedIn.next(true);
          window.localStorage.setItem('user', JSON.stringify(loggedUser));
          console.log(localStorage.getItem('user'));
          this.router.navigate(['user-home']);
          this.userLoggedIn = true;
        }
    })
    return this.userLoggedIn;
  }

  registerUser(chef: Chef): Observable<Boolean>{
    let chefJSON = JSON.stringify(chef);
    console.log(environment.apiURL);
    return this.http.post<Boolean>(environment.apiURL + 'chefs/register', chefJSON, HTTP_OPTIONS)
                      .pipe(catchError(this.errorHandler));
  }

  logout() {
    localStorage.removeItem('user');
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }

  errorHandler(error: HttpErrorResponse){
    return throwError(error.message || "Server Error");
  }
}
