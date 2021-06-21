import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public get isLogged() {
    return this._api.logueado;
  }

  ngOnInit(): void { }

  constructor(public _api: ApiService, private router: Router) { }

  email: string;
  password: string;

  login() {

    this._api.login(this.email, this.password)
      .subscribe(
        () => console.log('estoy logueado'),
        (error) => console.error(error));

  }

}
