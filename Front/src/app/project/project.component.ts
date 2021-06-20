import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute } from '@angular/router';
import { Router, RouterModule, Routes } from '@angular/router';
import { Proyecto } from '../Interfaces/Proyecto';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
  ngOnInit(): void {
    this.listProject(this.id);
    this.listProjectAtributes(this.id);
  }
 
  constructor(private _Activatedroute:ActivatedRoute, private router: Router, public _api: ApiService) { }

  
  project:Proyecto;
  projectAtributes:any;
  id=parseInt(this._Activatedroute.snapshot.paramMap.get("e")||"0")
  miatributo:string;

  listProject(e:number):void{
    this._api.getProject(e).subscribe((objeto:any)=>this.project=objeto);
    console.log(this.project)
  }
  listProjectAtributes(e:number):void{
    this._api.getProjectAtribute(e).subscribe((objeto:any)=>this.projectAtributes=objeto)
    console.log(this.projectAtributes)
  }


}
