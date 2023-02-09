import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user/user.service';
import { User } from 'src/app/interfaces/UserInterface';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  private firstNameInput: String;
  private lastNameInput: String;
  private emailInput: String;
  private passwordInput: String;

  private signupSuccess: boolean;
  private signupFailure: boolean;

  constructor(private userService: UserService) {
    this.signupSuccess = false;
    this.signupFailure = false;
  }

  ngOnInit() {

  }

  public signup() {
    this.userService.signupUser(this.firstNameInput, this.lastNameInput, this.emailInput, this.passwordInput).subscribe({
      next: (user : User) => {
        console.log(user);
        this.signupSuccess = true;
        this.signupFailure = false;
      },
      error: (err: Error) => {
        console.log(err);
        this.signupFailure = true;
        this.signupSuccess = false;
      },
      complete: () => {

      }
    })
  }

}
