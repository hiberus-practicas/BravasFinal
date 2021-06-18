import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  constructor(private _api: ApiService) { }

  ngOnInit(): void {
  }
  changePassword(){
    this._api.changePassword("contraseña");
  }
}
