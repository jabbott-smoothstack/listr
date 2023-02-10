import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingComponent } from './components/landing/landing.component';
import { MainComponent } from './components/main/main.component';
import { SignupComponent } from './components/signup/signup.component';


const routes: Routes = [
  {path: "", component: LandingComponent},
  {path: "signup", component: SignupComponent},
  {path: "listspage", component: MainComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
