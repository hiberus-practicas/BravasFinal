import { ApiService } from '../api.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-atribute',
  templateUrl: './create-atribute.component.html',
  styleUrls: ['./create-atribute.component.css']
})
export class CreateAtributeComponent implements OnInit {
  ngOnInit(): void {
    this._api.mantenerSession()
  }

  constructor(public _api: ApiService, public router: Router) { }

  nombreAtributo:string;
  tipoDato:string;
  descripcion:string;

  createAtribute(){
    if(this.tipoDato!=""){
      this.router.navigate(['list-projects/todos'])
      return this._api.createAtribute(this.nombreAtributo,this.tipoDato,this.descripcion);
    } 
    return null;
  }

}
