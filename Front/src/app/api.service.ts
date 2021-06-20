import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Usuario } from './Interfaces/Usuario';
import { Atributo } from './Interfaces/Atributo';
import { Observable } from 'rxjs';
import { Proyecto } from './Interfaces/Proyecto';
import { AtributoDTO } from './Interfaces/dto/AtributoDTO';
import { ProyectoAddDTO } from './Interfaces/dto/ProyectoAddDTO';
import { UsuarioDto } from './Interfaces/dto/UsuarioDTO';
 


@Injectable({
  providedIn: 'root'
})
export class ApiService implements OnInit{
  ngOnInit(): void { }

  constructor(private _http: HttpClient){}  
   logueado:boolean=false;

   
   postId:any;
   api_url:string='http://localhost:8080/api/v01/';
  //  api_url:string='http://192.168.80.38:8080/api/v01/';
  peticionid:number;

  



  register(email:string, nombre:string, password:string){
    password= btoa(password);
    return this._http.post(this.api_url+'/usuarios',{
      email:email,
      username:nombre,
      pass:password
    }).toPromise().then((res)=> {
      this.postId = res;
  })
  }
login(nombre:string, password:string):boolean{

this.loginRest(nombre,password);


 if(this.peticionid!=0&&this.peticionid!=undefined){
  
   let peticionstring=String(this.peticionid);
   sessionStorage.setItem('id',peticionstring);
   return true;
 }
   return false;
    
}
  async loginRest(nombre:string, password:string){
  password= btoa(password)
  let usuario=new UsuarioDto(nombre,password);
 
  await  this._http.post<number>(this.api_url+"usuarios/login",usuario).subscribe(respuesta=>{this.peticionid=respuesta
  
  });
  
  
}


changePassword(password:string){
  let userLogged:Usuario
  let idLogged:number=parseInt(sessionStorage.getItem("isLogged")||"0")
  
  this._http.get<Usuario>(this.api_url+"usuarios/"+idLogged).subscribe((res:Usuario)=> 
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
    let userLogged:Usuario
    let idLogged:number=parseInt(sessionStorage.getItem("isLogged")||"0")
    
    this._http.get<Usuario>(this.api_url+"usuarios/"+idLogged).subscribe((res:Usuario)=> 
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
    let atribute:Atributo
    this._http.get<Atributo>(this.api_url+"atributos/"+nombreActual).subscribe((res:Atributo)=> 
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


  createProject(proyecto:ProyectoAddDTO){
    
    return this._http.post(this.api_url+"proyectos/completo",proyecto).toPromise().then((res)=>{
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

  listAtributes():Observable<Atributo[]>{
    return this._http.get<Atributo[]>(this.api_url+"atributos/");
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

  busquedafiltrada(atributo:AtributoDTO):Observable<Proyecto[]>{
    return this._http.post<Proyecto[]>(this.api_url+'/atributos/busqueda/',atributo);
  }


  getlogueo():boolean{return this.logueado;}
  sessionServerstorage():boolean{
    let resultado;
    this._http.get<boolean>(this.api_url+'usuarios/session/'+sessionStorage.getItem("id")).subscribe(peticion=>resultado=peticion);
    return resultado;
  }
  mantenerSession():void{
    if(this.sessionServerstorage()){
      this.logueado=true;
    }
  }
    
    
    

 
}


