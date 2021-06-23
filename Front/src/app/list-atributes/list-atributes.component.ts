import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';
import { Atributo } from '../Interfaces/Atributo';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-list-atributes',
  templateUrl: './list-atributes.component.html',
  styleUrls: ['./list-atributes.component.css']
})
export class ListAtributesComponent implements OnInit {

  constructor(public _api: ApiService, private router:Router) { this._api.mantenerSession()}

  atributes:Atributo[];


  listAtributes():void{
    this._api.listAtributes().subscribe(objeto=>this.atributes=objeto);
  }
  deleteAtribute(e:string){

    Swal.fire({
      title: '¿Seguro que quiere borrar el atributo?',
      text: "no podrá deshacer este paso",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Borrar'
    }).then((result) => {
  
      if (result.isConfirmed) {
        console.log(e);
        this._api.deleteAtribute(e);
        this.listAtributes();
        this.router.navigate(['']);
        Swal.fire(
          'Borrado',
          'El atributo ha sido borrado',
          'success'
        )
      }
    })
    
 
    

  }
    ngOnInit(): void {
    this.listAtributes()
    console.log(this.atributes)
  }
  
}
