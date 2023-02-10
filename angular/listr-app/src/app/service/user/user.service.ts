import { Injectable } from '@angular/core';
import { User } from 'src/app/interfaces/UserInterface';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private USER_SERVICE_URI : string;
  private loggedInUser: User;

  constructor(private http : HttpClient) { 
    this.USER_SERVICE_URI = environment.USER_SERVICE_URI;
  }

  public userLogin(em :String, pass: String) : Observable<User> {
    return this.http.post<User>(this.USER_SERVICE_URI + 'login', {email: em, passwordHash: pass});
  }

  public getUserInfo(em: String) : Observable<User> {
    return this.http.post<User>(this.USER_SERVICE_URI + 'email', {email: em});
  }

  public signupUser(fn: String, ln: String, em: String, pass: String) : Observable<User> {
    return this.http.post<User>(this.USER_SERVICE_URI, {firstName: fn, lastName: ln, email: em, passwordHash: pass});
  }

  public setSignedInUser(userData: User) {
    this.loggedInUser = userData;
  }

  public async getSignedInUser(): Promise<User> {
    return this.loggedInUser;
  }
}