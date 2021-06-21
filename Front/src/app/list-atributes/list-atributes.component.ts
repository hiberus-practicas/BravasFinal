import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';
import { Atributo } from '../Interfaces/Atributo';

@Component({
  selector: 'app-list-atributes',
  templateUrl: './list-atributes.component.html',
  styleUrls: ['./list-atributes.component.css']
})
export class ListAtributesComponent implements OnInit {

  constructor(public _api: ApiService, private router:Router) { this._api.mantenerSession()}

  atributes:Atributo[];


  listAtributes():void{
    this._api.listAtributes().subscribe(objeto=>this.atributes=objeto);
  }
  deleteAtribute(e:string){
    this._api.deleteAtribute(e);
    this.listAtributes();
    this.router.navigate(['list-atributes']);
    

  }
    ngOnInit(): void {
    this.listAtributes()
    console.log(this.atributes)
  }
  
}
