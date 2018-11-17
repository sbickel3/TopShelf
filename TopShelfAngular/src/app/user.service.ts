import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
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

  loggedIn: boolean = false;
  registerSucess: boolean = false;

  constructor(private http: HttpClient) { }

  loginUser(user: User): Observable<User> {
    console.log(`Attempting to login user: ${user.username}`);
    let userJSON = JSON.stringify(user);
    let retrievedUser = this.http.post<User>(environment.apiURL + 'chef/login', userJSON, HTTP_OPTIONS);
    if (retrievedUser) {
      this.loggedIn = true;
      return retrievedUser;
    } else {
      this.loggedIn = false;
      return null;
    }
  }

  registerUser(user: User): Observable<User>{
    console.log(`Attempting to login user: ${user.username}`);
    let userJSON = JSON.stringify(user);
    console.log(environment.apiURL);
    return this.http.post<User>(environment.apiURL + 'chef/register', userJSON, HTTP_OPTIONS);
  }
}
