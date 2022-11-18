import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioFormComponent } from './components/usuario-form/usuario-form.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';

const routes: Routes = [

  {path: '', component: UsuariosComponent},
  {path: 'formulario', component: UsuarioFormComponent},
  {path: 'formulario/:numero_identidad', component: UsuarioFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
