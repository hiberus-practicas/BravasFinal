import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ChangeUsernameComponent } from './change-username/change-username.component';
import { DeleteUserComponent } from './delete-user/delete-user.component';
import { CreateAtributeComponent } from './create-atribute/create-atribute.component';
import { ModifyAtributeComponent } from './modify-atribute/modify-atribute.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { ModifyProjectComponent } from './modify-project/modify-project.component';
import { ListAtributesComponent } from './list-atributes/list-atributes.component';
import { ListProjectsComponent } from './list-projects/list-projects.component';
import { ProjectComponent } from './project/project.component';
import { BuscadorComponent } from './buscador/buscador.component';
import { DetallesusuarioComponent } from './detallesusuario/detallesusuario.component';


const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "change-password", component: ChangePasswordComponent},
  {path: "change-username", component: ChangeUsernameComponent},
  {path: "delete-user", component: DeleteUserComponent},
  {path: "create-atribute", component: CreateAtributeComponent},
  {path: "modify-atribute", component: ModifyAtributeComponent},
  {path: "create-project", component: CreateProjectComponent},
  {path: "modify-project/:id", component: ModifyProjectComponent},
  {path: "list-atributes", component: ListAtributesComponent},
  {path: "list-projects/:e", component: ListProjectsComponent},
  {path: "project/:e", component: ProjectComponent},
  {path:"buscador",component:BuscadorComponent},
  {path:"detallesusuario/:e",component:DetallesusuarioComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
