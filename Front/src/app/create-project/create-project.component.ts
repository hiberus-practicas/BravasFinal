import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';
import { Atributo } from '../Interfaces/Atributo';
import { ProyectoAddDTO } from '../Interfaces/dto/ProyectoAddDTO';
import { ProyectoAtributoDTO } from '../Interfaces/dto/ProyectoAtributoDTO';


@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {
  ngOnInit(): void {
    this._api.listAtributes().subscribe(elemento=>this.listar=elemento);
  }

  constructor(private _api: ApiService,private router:Router) { }

  nombreProyecto:string;
  nombreEquipo:string;
  vistaAtributos:boolean=false;
  listar:Atributo[];
  value:string;
  atributos:ProyectoAtributoDTO[]=[];


  addAtributo(nombreatributo:string):void{
    let atributo=new ProyectoAtributoDTO(nombreatributo,this.value);
    this.atributos.push(atributo);
    this.value="";
    this.listar.filter(elemento => elemento.nombreAtributo!=nombreatributo);
  }


  createProject(){
    console.log(this.nombreProyecto)
    let proyecto=new ProyectoAddDTO(this.nombreProyecto,this.nombreEquipo,this.atributos);
    this._api.createProject(proyecto);
    this.router.navigate(['buscador'])
    
}
}
