import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-list-projects',
  templateUrl: './list-projects.component.html',
  styleUrls: ['./list-projects.component.css']
})
export class ListProjectsComponent implements OnInit {

  constructor(private _api: ApiService, private router: Router) { }

  projects:any=[]
  listProjects():void{
    this._api.listProjects().subscribe((objeto:any)=>this.projects=objeto);
  }

  ngOnInit(): void {
    this.listProjects()

  }

  navToProject(e:any){
    this.router.navigate(['/project/'+e])

  }
}
