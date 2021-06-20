import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../api.service';
import { AtributoDTO } from '../Interfaces/dto/AtributoDTO';
import { Proyecto } from '../Interfaces/Proyecto';

@Component({
  selector: 'app-list-projects',
  templateUrl: './list-projects.component.html',
  styleUrls: ['./list-projects.component.css']
})
export class ListProjectsComponent implements OnInit {
  ngOnInit(): void {this._api.mantenerSession();
 
    if(this.todosProyectos=="todos"){
      this.listProjects();
      this.todosProyectos="";
    }
  }

  constructor(public _api: ApiService, private router: Router,private _Activatedroute:ActivatedRoute) { }

  @Input() textoBusqueda:string;
  @Input() filtros:AtributoDTO[];

  projects:Proyecto[];
  todosProyectos:string=this._Activatedroute.snapshot.paramMap.get("e")||"todos";


  listProjects():void{this._api.listProjects().subscribe(objeto=>this.projects=objeto);}

  semanticSearch():void{ 
    console.log(this.textoBusqueda);
    this._api.semanticSearch(this.textoBusqueda).subscribe((objeto:any)=>this.projects=objeto);}

  navToProject(e:any){ this.router.navigate(['/project/'+e])}

  busquedafiltrada():void{
    for(let i=0;i<this.filtros.length;i++){
    this._api.busquedafiltrada(this.filtros[i]).subscribe((Proyectosservidor:Proyecto[])=>this.projects=Proyectosservidor);
    }
    console.log(this.projects);

  }



}
