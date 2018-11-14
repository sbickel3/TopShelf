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

  constructor(private http: HttpClient) { }

  loginUser(user: User): Observable<User> {
    console.log(`Attempting to login user: ${user.username}`);
    let userJSON = JSON.stringify(user);
    return this.http.post<User>(environment.apiURL + '/user-home', userJSON, HTTP_OPTIONS);
  }
}
