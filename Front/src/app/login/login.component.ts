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
  }
  constructor(    private _api: ApiService,private router:Router) { }

  email=""
  password=""

  login(){
    this._api.login(this.email, this.password);
    this.router.navigate([''])
  }
  logout(){
    sessionStorage.removeItem("isLogged");
  }
}
