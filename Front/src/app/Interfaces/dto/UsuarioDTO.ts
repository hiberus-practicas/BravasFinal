export class UsuarioDto{
    constructor(username:string,pass:string){
        this.username=username;
        this.pass=pass;
    }
    username:string;
    pass:string;
}