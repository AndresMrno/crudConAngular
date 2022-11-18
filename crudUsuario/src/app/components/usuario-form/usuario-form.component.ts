import { DatePipe, DATE_PIPE_DEFAULT_TIMEZONE, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { retry } from 'rxjs';
import { Ciudad } from 'src/app/models/ciudad';
import { Ocupacion } from 'src/app/models/ocupacion';
import { Usuario } from 'src/app/models/usuario';
import { UsuariosService } from 'src/app/services/usuarios.service';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
  styleUrls: ['./usuario-form.component.css']
})
export class UsuarioFormComponent implements OnInit {

  usuario: Usuario = new Usuario();

  ciudades: Ciudad[] = [];

  ocupaciones: Ocupacion[] = [];

  public fechaMinima : Date;
  public fechaMaxima : Date;




  constructor(private usuarioService: UsuariosService, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {




    this.fechaMaxima = new Date(new Date().getFullYear()-18,new Date().getMonth()-9,new Date().getDay()-17);
    this.fechaMinima = new Date(new Date().getFullYear()-65,new Date().getMonth()-9,new Date().getDay()-17);
    this.usuarioService.getCiudades()
    .subscribe(response=> this.ciudades=response);

    this.usuarioService.getOcupaciones()
    .subscribe(response=> this.ocupaciones=response);


    this.activatedRoute.params
    .subscribe(params=>{
      let numero_identidad : number = params['numero_identidad'];
      if(numero_identidad){
        this.usuarioService.obtenerUsuario(numero_identidad)
        .subscribe(response => this.usuario = response)
      }
    })


  }

  crearUsuario(){
    this.usuarioService.crearUsuario(this.usuario)
    .subscribe(response => {

      if (this.usuario.fecha_nacimiento >= this.fechaMinima && this.usuario.fecha_nacimiento <= this.fechaMinima) {
        alert("Usuario agregado esta preparado para trabajar");
        
      } else {
        alert("Usuario agregado no esta preparado para trabajar");
      }
  })
}

  actualizarUsuario(){
    this.usuarioService.actualizarUsuario(this.usuario)
    .subscribe(response => alert("Usuario editado con exito"))
  }

}


