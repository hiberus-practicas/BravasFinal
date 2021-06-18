import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(    private _api: ApiService) { }

  ngOnInit(): void {
  }
  email=""
  password=""
  login(){
    this._api.login(this.email, this.password);
  }
  logout(){
    sessionStorage.removeItem("isLogged");
  }
}
