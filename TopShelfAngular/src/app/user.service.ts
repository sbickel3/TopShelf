import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { User } from './models/user';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-type': 'application/json'
  })
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

  constructor(private http: HttpClient, private router: Router) {}

  loginUser(user: User): boolean {
    console.log(`Attempting to login user: ${user.username}`);
    let userJSON = JSON.stringify(user);
    this.http.post<User>(environment.apiURL + 'chefs/login', userJSON, HTTP_OPTIONS).subscribe(loggedUser => {
        if(!loggedUser) {
          this.loggedIn.next(false);
          this.userLoggedIn = false;
        } else {
          this.loggedIn.next(true);
          localStorage.setItem('user', JSON.stringify(loggedUser));
          console.log(`User, ${user.username}, successfully logged in!`);
          console.log(localStorage.getItem('user'));
          this.router.navigate(['user-home']);
          this.userLoggedIn = true;
        }
    })
    return this.userLoggedIn;
  }

  registerUser(user: User): Observable<User>{
    console.log(`Attempting to register user: ${user.username}`);
    let userJSON = JSON.stringify(user);
    console.log(environment.apiURL);
    return this.http.post<User>(environment.apiURL + 'chefs/register', userJSON, HTTP_OPTIONS);
  }

  logout() {
    localStorage.removeItem('user');
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }
}
