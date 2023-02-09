import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user/user.service';
import { User } from 'src/app/interfaces/UserInterface';
import { Router } from '@angular/router';
@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  private emailInput: String;
  private passwordInput: String;
  private signinFailed: boolean;

  constructor(private userService : UserService, private route: Router) { 

  }

  ngOnInit() {

  }

  public signin() {
    this.userService.userLogin(this.emailInput, this.passwordInput).subscribe({
      next: (user : User) => {
        this.userService.setSignedInUser(user);
        this.route.navigateByUrl('/listspage');
      },
      error: (err : Error) => {
        console.log(err);
        this.signinFailed = true;
      },
      complete: () => {

      }
    });
  }

}
