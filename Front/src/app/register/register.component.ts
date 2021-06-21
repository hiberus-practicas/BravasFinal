import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  ngOnInit(): void {this._api.mantenerSession()}
  constructor(public _api: ApiService,private router:Router) { }



  email:string;
  nombre:string;
  password:string;
  regExpEmail = new RegExp('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$');
  regExpNombre = new RegExp('^[a-z0-9._%+-]{5,25}$');
  regExpPass = new RegExp('^(?=.{8,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$');
  emailError:string="";   
  nombreError:string="";   
  passError:string=""; 


  
  register(){
    if(this.validateEmail(this.email))
      if(this.validateName(this.nombre))
        if(this.validatePassword(this.password)){
            this._api.register(this.email,this.nombre,this.password);
            this.router.navigate(['login'])
        }

  }

  validateEmail(email:String):Boolean{
    if(this.regExpEmail.test(this.email)) {
      this.emailError="";
      return true};

    this.emailError="Introduce un email valido (ej: email@email.com)"; 
     return false;
   }
   validateName(name:String):Boolean{
    if(this.regExpNombre.test(this.nombre)) {
      this.nombreError="";
      return true};

    this.nombreError="El nombre debe contener entre 5 y 25 caracteres";
     return false;
   }
   validatePassword(name:String):Boolean{
    if(this.regExpPass.test(this.password)){
      this.passError="";
      return true};

    this.passError="La contraseña debe contener numeros y letras, ademas debe tener un largo de 8 caracteres";
    return false;
   }

  }




