import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-detallesusuario',
  templateUrl: './detallesusuario.component.html',
  styleUrls: ['./detallesusuario.component.css']
})
export class DetallesusuarioComponent implements OnInit {
  ngOnInit(): void {}

  constructor(private _Activatedroute:ActivatedRoute, private router: Router, public _api: ApiService) { }

  idUsuario:number=parseInt(this._Activatedroute.snapshot.paramMap.get("e")||"0");
  

}
