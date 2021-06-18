import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { UserService } from '../user.service';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  ngOnInit(): void {
  }
  constructor(
    private _user: UserService,
    private _api: ApiService
  ) { }



  email:string="";
  nombre:string="";
  password:string="";
  regExpEmail = new RegExp('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$');
  regExpNombre = new RegExp('[a-z0-9._%+-]{5,25}$');
  regExpPass = new RegExp('^(?=.{8,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$');
  emailError:string="";   
  nombreError:string="";   
  passError:string=""; 


  


  register(){
    this._api.register(this.email,this.nombre,this.password);
  }
   
    validateRegister(s:string){
      if(s=="email"){
        if(!this.regExpEmail.test(this.email)){
          this.emailError="Introduce un email valido (ej: email@email.com)"
       }else{
         this.emailError=""
       }
      }else if(s=="nombre"){
        if(!this.regExpNombre.test(this.nombre)){
          this.nombreError="El nombre debe contener entre 5 y 25 caracteres"
       }else{
         this.nombreError=""
       }
      }else{
        if(!this.regExpPass.test(this.password)){
          this.passError="La contraseña debe contener numeros y letras, ademas debe tener un largo de 8 caracteres"
       }else{
         this.passError=""
       }
      }
    }
}
