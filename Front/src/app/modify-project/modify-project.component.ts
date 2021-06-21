import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute } from '@angular/router';
import { Proyecto } from '../Interfaces/Proyecto';
@Component({
  selector: 'app-modify-project',
  templateUrl: './modify-project.component.html',
  styleUrls: ['./modify-project.component.css']
})
export class ModifyProjectComponent implements OnInit {

  constructor(private _api: ApiService, private _Activatedroute:ActivatedRoute) { }
  nuevoNombre:string;
  nuevoEquipo:string;
  id=parseInt(this._Activatedroute.snapshot.paramMap.get("id")||"0");

  ngOnInit(): void {
  this._api.mantenerSession()
  }
  modifyProject() {
    this._api.modifyProject(this.nuevoNombre,this.nuevoEquipo,this.id)
  }
}
