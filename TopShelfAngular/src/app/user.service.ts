import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { User } from './models/user';
import { environment } from 'src/environments/environment';

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
  registerSucess: boolean = false;

  constructor(private http: HttpClient) {
  }

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  loginUser(user: User): Observable<User> {
    console.log(`Attempting to login user: ${user.username}`);
    let userJSON = JSON.stringify(user);
    return this.http.post<User>(environment.apiURL + 'chefs/login', userJSON, HTTP_OPTIONS);
  }

  registerUser(user: User): Observable<User>{
    console.log(`Attempting to login user: ${user.username}`);
    let userJSON = JSON.stringify(user);
    console.log(environment.apiURL);
    return this.http.post<User>(environment.apiURL + 'chefs/register', userJSON, HTTP_OPTIONS);
  }
}
