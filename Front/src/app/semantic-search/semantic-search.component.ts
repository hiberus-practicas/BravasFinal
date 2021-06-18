import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { ActivatedRoute } from '@angular/router';
import { Router, RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-semantic-search',
  templateUrl: './semantic-search.component.html',
  styleUrls: ['./semantic-search.component.css']
})
export class SemanticSearchComponent implements OnInit {

  constructor(private _Activatedroute:ActivatedRoute, private router: Router, private _api: ApiService) { }

  busqueda:any=[]
  semanticSearch(s:string){
    this._api.semanticSearch(s).subscribe((objeto:any)=>this.busqueda=objeto);
  }



  ngOnInit(): void {
    this.semanticSearch("");
    console.log(this.busqueda)
  }

}
