import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute } from '@angular/router';
import { Router} from '@angular/router';
import { Atributo } from '../Interfaces/Atributo';
import { AtributoDTO } from '../Interfaces/dto/AtributoDTO';

@Component({
  selector: 'app-buscador',
  templateUrl: './buscador.component.html',
  styleUrls: ['./buscador.component.css']
})
export class BuscadorComponent implements OnInit {
  ngOnInit(): void {
    this._api.mantenerSession()
    this.listAtributes();
  }

  constructor(public _api:ApiService,private activatedRoute:ActivatedRoute,private router:Router) { }

  textoBusqueda:string="";
  filtros:AtributoDTO[]=[];
  vistafiltros:boolean=false;
  atributotem:Atributo=null;
  listar:Atributo[];
  value:any;

  listAtributes():void{
    this._api.listAtributes().subscribe(objeto=>this.listar=objeto);
  }
  addfilter(nombreatributo:string):void{
   let pushear =new AtributoDTO(nombreatributo,this.value);
   console.log(pushear);
    this.filtros.push(pushear);
    console.log(this.filtros);
  }
 


}
