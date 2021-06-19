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
    this._api.createProject("Proyecto junio","Hiberus Osaba",[
      {
        "valor": "cordoba",
        "nombre": "ciudad origen"
    },
    {
      "valor": 500,
      "nombre": "numero paginas"
    }
    ]);
  }
}
