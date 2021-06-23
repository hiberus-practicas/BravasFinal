export class FechasDto{
    limiteinferior:string;
    limitesuperior:string;
    nombreatributo:string;

    constructor(limiteinferior:string,limitesuperior:string,nombreatributo){
        this.limiteinferior=limiteinferior;
        this.limitesuperior=limitesuperior;
        this.nombreatributo=nombreatributo;
    }
}