import { ProyectoAtributoDTO } from "./ProyectoAtributoDTO";
import { ProyectoDTO } from "./ProyectoDTO";

export class ProyectoAddDTO{
    constructor(nombre:string,Equipo:string,atributos:ProyectoAtributoDTO[]){
        this.nombre=nombre;
        this.equipo=Equipo;
        this.atributos=atributos;
    }
    nombre:string;
    equipo:string;
    atributos:ProyectoAtributoDTO[];

}