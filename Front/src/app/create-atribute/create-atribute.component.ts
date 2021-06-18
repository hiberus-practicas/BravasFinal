import { ApiService } from '../api.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-create-atribute',
  templateUrl: './create-atribute.component.html',
  styleUrls: ['./create-atribute.component.css']
})
export class CreateAtributeComponent implements OnInit {

  constructor(private _api: ApiService) { }

  ngOnInit(): void {
  }
  nombreAtributo:string=""
  tipoDato:string="null"
  descripcion:string=""
  createAtribute(){
    if(this.tipoDato!="null"){
    return this._api.createAtribute(this.nombreAtributo,this.tipoDato,this.descripcion)
    }else{
      alert("Selecciona el tipo de dato")
      return null;
    }
    this.nombreAtributo=""
    this.tipoDato="null"
    this.descripcion=""
  }

}
