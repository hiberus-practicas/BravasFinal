import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';


@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {

  constructor(private _api: ApiService) { }

  ngOnInit(): void {
  }
  createProject(){
    this._api.createProject("nombre","equipo",[
      {
        "valor": "esto es p",
        "nombre": "p"
    },
    {
      "valor": 2,
      "nombre": "numero"
    }
    ]);
  }
}
