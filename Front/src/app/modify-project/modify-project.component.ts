import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-modify-project',
  templateUrl: './modify-project.component.html',
  styleUrls: ['./modify-project.component.css']
})
export class ModifyProjectComponent implements OnInit {

  constructor(private _api: ApiService) { }

  ngOnInit(): void {
  }
  modifyProject() {
    this._api.modifyProject("nombre","nuevo nombre","equipo","nuevo equipo",1)
  }
}
