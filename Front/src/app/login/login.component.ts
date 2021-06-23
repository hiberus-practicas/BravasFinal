import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public get isLogged() {
    return this._api.logueado;
  }

  ngOnInit(): void { 
    sessionStorage.removeItem("id")
  }

  constructor(public _api: ApiService, private router: Router) { }

  email: string;
  password: string;
  loginError:string="";

  login() {

    this._api.login(this.email, this.password)
      .subscribe(
        () => console.log(sessionStorage.getItem("id")),
        (error) => console.error(error));

        if(this.checkLogin()){
        this.loginError=""
     }
        this.router.navigate([''])
  
  }
  checkLogin(){
    if(sessionStorage.getItem("id")===null){
      this.loginError="Email o contraseña no valido"
      return false;
    }else{
      return true;
    }
  }

}
