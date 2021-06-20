import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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
import { HeaderComponent } from './header/header.component';
import { GeneralComponent } from './general/general.component';
import { ListProjectsComponent } from './list-projects/list-projects.component';
import { ProjectComponent } from './project/project.component';
import { BuscadorComponent } from './buscador/buscador.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    ChangePasswordComponent,
    ChangeUsernameComponent,
    DeleteUserComponent,
    CreateAtributeComponent,
    ModifyAtributeComponent,
    CreateProjectComponent,
    ModifyProjectComponent,
    ListAtributesComponent,
    HeaderComponent,
    GeneralComponent,
    ListProjectsComponent,
    ProjectComponent,
    BuscadorComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
