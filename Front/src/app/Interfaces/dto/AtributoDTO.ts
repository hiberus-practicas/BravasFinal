import { Atributo } from "../Atributo";

export class AtributoDTO{
    
constructor(atributo:string,valor:string){
    this.atributo=atributo;
    this.valor=valor;
}
    atributo:string;
    valor:string;
}