import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  ngOnInit(): void {
    console.log(this.logged);
  }
  logged=localStorage.getItem("isLogged");

  constructor(    private _api: ApiService,private router:Router) { }

  email=""
  password=""

  login(){
   if(this._api.login(this.email, this.password)){this.router.navigate([''])}
  }
  logout(){
    sessionStorage.removeItem("isLogged");
  }
}
