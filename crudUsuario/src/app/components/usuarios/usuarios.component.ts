import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario';
import { UsuariosService } from 'src/app/services/usuarios.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  usuarios: Usuario[] = [];

  constructor(private usuarioService : UsuariosService) { }

  ngOnInit(): void {

    this.usuarioService.getUsuario()
    .subscribe(response => this.usuarios=response);
  }

  eliminarUsuario(numero_identidad){
    this.usuarioService.eliminarUsuario(numero_identidad)
    .subscribe(response=>{
      if(response===true){
        this.usuarios.pop();
      }

      alert("Usuario eliminado con exito");
    })

  }

}
