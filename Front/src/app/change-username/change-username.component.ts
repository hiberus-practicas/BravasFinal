import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-change-username',
  templateUrl: './change-username.component.html',
  styleUrls: ['./change-username.component.css']
})
export class ChangeUsernameComponent implements OnInit {

  constructor(private _api: ApiService) { }

  ngOnInit(): void {
  }

  changeUsername(){
    this._api.changeUsername("usuario");
  }
}
