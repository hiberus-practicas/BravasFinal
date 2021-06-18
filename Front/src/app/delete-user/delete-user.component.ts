import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';


@Component({
  selector: 'app-delete-user',
  templateUrl: './delete-user.component.html',
  styleUrls: ['./delete-user.component.css']
})
export class DeleteUserComponent implements OnInit {

  constructor(private _api: ApiService) { }

  ngOnInit(): void {
  }
  deleteUser(){
    let userId:number=parseInt(sessionStorage.getItem("isLogged")||"0")
    this._api.deleteUser(userId);
    sessionStorage.removeItem("isLogged")
  }
}
