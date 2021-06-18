import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute } from '@angular/router';
import { Router, RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
  id=parseInt(this._Activatedroute.snapshot.paramMap.get("e")||"0")
  miatributo=""
  constructor(private _Activatedroute:ActivatedRoute, private router: Router, private _api: ApiService) { }
  project:any={}
  projectAtributes:any={}
  getProject(e:number){
    this._api.getProject(e).subscribe((objeto:any)=>this.project=objeto);
    console.log(this.project)
  }
  getProjectAtributes(e:number){
    this._api.getProjectAtribute(e).subscribe((objeto:any)=>this.projectAtributes=objeto)
    console.log(this.projectAtributes)
  }
  ngOnInit(): void {
    this.getProject(this.id);
    this.getProjectAtributes(this.id);
  }

}
