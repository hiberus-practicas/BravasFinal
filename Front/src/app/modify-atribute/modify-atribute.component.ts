import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-modify-atribute',
  templateUrl: './modify-atribute.component.html',
  styleUrls: ['./modify-atribute.component.css']
})
export class ModifyAtributeComponent implements OnInit {

  constructor(private _api: ApiService) { }

  ngOnInit(): void {
  }
  modifyAtribute(){
    this._api.modifyAtribute("atributoPrueba","nombreCambiado")
  }
}
