import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  ngOnInit(): void {}

  constructor( public _api: ApiService,private router:Router) { }

  email:string;
  password:string;

  login(){if(this._api.login(this.email, this.password)){
    this.router.navigate(['']);
    this._api.logueado=true;
  }
   
  }
 

}
