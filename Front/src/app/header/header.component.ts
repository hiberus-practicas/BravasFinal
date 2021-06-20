import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  
  ngOnInit(): void { this._api.mantenerSession()}

  constructor(public _api: ApiService) { }

  

  logout(){sessionStorage.removeItem("isLogged");{ this._api.logueado=false
    this._api.peticionid=0;
  }
}

  

}
