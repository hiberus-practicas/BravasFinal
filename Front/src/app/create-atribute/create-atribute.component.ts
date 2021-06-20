import { ApiService } from '../api.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-create-atribute',
  templateUrl: './create-atribute.component.html',
  styleUrls: ['./create-atribute.component.css']
})
export class CreateAtributeComponent implements OnInit {
  ngOnInit(): void {}

  constructor(public _api: ApiService) { }

  nombreAtributo:string;
  tipoDato:string;
  descripcion:string;

  createAtribute(){
    if(this.tipoDato!="") return this._api.createAtribute(this.nombreAtributo,this.tipoDato,this.descripcion);
    return null;
  }

}
