import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-list-atributes',
  templateUrl: './list-atributes.component.html',
  styleUrls: ['./list-atributes.component.css']
})
export class ListAtributesComponent implements OnInit {

  constructor(private _api: ApiService) { }

  atributes:any=[]


  listAtributes():void{
    this._api.listAtributes().subscribe(objeto=>this.atributes=objeto);
  }
  deleteAtribute(e:string){
    this._api.deleteAtribute(e);
  
    location.reload();
  }
    ngOnInit(): void {
    this.listAtributes()
    console.log(this.atributes)
  }
  
}
