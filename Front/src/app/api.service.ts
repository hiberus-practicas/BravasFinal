import { Attribute, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User, Atribute, Project } from './interfaces';
import { UserService } from './user.service';
import { EmailValidator } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private _http: HttpClient) {
   }

  api_url:string='http://192.168.80.38:8080/api/v01/';

  postId:any
  register(email:string, nombre:string, password:string){
    password= btoa(password)
    return this._http.post(this.api_url+'/usuarios',{
      email:email,
      username:nombre,
      pass:password
    }).toPromise().then((res)=> {
      this.postId = res;
  })
  console.log(this.postId)
}
login(nombre:string, password:string){
  password= btoa(password)
  return this._http.post(this.api_url+'/usuarios/login',{
    username:nombre,
    pass:password
  }).toPromise().then((res)=> {
    this.postId = res;
    if(this.postId.usuario_id!=0){
      sessionStorage.setItem("isLogged",this.postId.usuario_id)
    }
    else{
      alert("No existe")
    }
})
}



changePassword(password:string){
  let userLogged:User
  let idLogged:number=parseInt(sessionStorage.getItem("isLogged")||"0")
  
  this._http.get<User>(this.api_url+"usuarios/"+idLogged).subscribe((res:User)=> 
  {
    userLogged = res;
  console.log(this.api_url+"usuarios/"+idLogged)
  console.log(userLogged)
  return this._http.put(this.api_url+'usuarios/update/'+idLogged,{
    id:idLogged,
    email:userLogged.email,
    username:userLogged.username,
    pass:password
  }).toPromise().then((res)=> {
    this.postId = res;
  })
})
}


  changeUsername(username:string){
    let userLogged:User
    let idLogged:number=parseInt(sessionStorage.getItem("isLogged")||"0")
    
    this._http.get<User>(this.api_url+"usuarios/"+idLogged).subscribe((res:User)=> 
    {
      userLogged = res;
    console.log(this.api_url+"usuarios/"+idLogged)
    console.log(userLogged)
    return this._http.put(this.api_url+'usuarios/update/'+idLogged,{
      id:idLogged,
      email:userLogged.email,
      username:username,
      pass:userLogged.pass
    }).toPromise().then((res)=> {
      this.postId = res;
    })
  })
  }

  deleteUser(id:number){
    return this._http.delete(this.api_url+'usuarios/'+id).toPromise().then((res)=> {
      this.postId=res;
    })
    console.log(this.postId)
  }







  createAtribute(nombre:string,tipo:string,descripcion:string){
    return this._http.post(this.api_url+"atributos/",{
      nombreAtributo:nombre,
      tipoDato:tipo,
      descripcion:descripcion
    }).toPromise().then((res)=>{
      this.postId=res;
      console.log(this.postId)
    })
  }

  modifyAtribute(nombreActual:string,nuevoNombre:string){
    let atribute:Atribute
    this._http.get<Atribute>(this.api_url+"atributos/"+nombreActual).subscribe((res:Atribute)=> 
    {
      atribute = res;
    return this._http.put(this.api_url+'atributos/'+atribute.nombreAtributo,{
      nombreAtributo:nuevoNombre,
      tipoDato:atribute.tipoDato,
      descripcion:"joder"
    }).toPromise().then((res)=> {
      this.postId = res;
      console.log(this.postId)
    })
  })
  }

  deleteAtribute(nombre:string){
    return this._http.delete(this.api_url+'atributos/'+nombre).toPromise().then((res)=> {
      this.postId=res;
    })
    console.log(this.postId)
  }




  createProject(nombre:string,equipo:string,atributos?:object[]){
    return this._http.post(this.api_url+"proyectos/completo",{
      "nombre":nombre,
      "equipo":equipo,
      "atributos": atributos
    }).toPromise().then((res)=>{
      this.postId=res;
      console.log(this.postId)
    })

  }

  modifyProject(nombreActual:string,nuevoNombre:string, equipoActual:string, nuevoEquipo:string, id:number){
    return this._http.put(this.api_url+'proyectos/'+id,{
      nombre:nuevoNombre,
      equipo:nuevoEquipo,
      id:id
    }).toPromise().then((res)=> {
      this.postId = res;
      console.log(this.postId)
    })
  }

  deleteProject(nombre:string){
    return this._http.delete(this.api_url+'proyectos/'+nombre).toPromise().then((res)=> {
      this.postId=res;
    })
    console.log(this.postId)
  }

  listAtributes(){
    return this._http.get<any>(this.api_url+"atributos/");
  }
  listProjects(){
    return this._http.get<any>(this.api_url+"proyectos/");
  }

  getProject(e:number){
    return this._http.get<any>(this.api_url+'proyectos/'+e);
  }
  getProjectAtribute(e:number){
    return this._http.get<any>(this.api_url+'relaciones/proyecto/'+e);
  }
  semanticSearch(s:string){
    return this._http.get<any>(this.api_url+'relaciones/busqueda/'+s);
  }
}

