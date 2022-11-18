import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ciudad } from '../models/ciudad';
import { Ocupacion } from '../models/ocupacion';
import { Usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  url: String = 'http://localhost:8083/usuario';

  constructor(private http: HttpClient) { }

  getUsuario(): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(this.url+'/listar');
  }

  getCiudades(): Observable<Ciudad[]>{
    return this.http.get<Ciudad[]>(this.url+'/ciudades');
  }

  getOcupaciones(): Observable<Ocupacion[]>{
    return this.http.get<Ocupacion[]>(this.url+'/ocupaciones');
  }

  crearUsuario(usuario: Usuario): Observable<Usuario>{
    return this.http.post<Usuario>(this.url+'/crear', usuario);
  }

  obtenerUsuario(numero_identidad: number): Observable<Usuario>{
    return this.http.get<Usuario>(this.url+'/'+numero_identidad);
  }

  actualizarUsuario(usuario: Usuario): Observable<Usuario>{
    return this.http.put<Usuario>(this.url+'/actualizar/'+usuario.numero_identidad, usuario);
  }

  eliminarUsuario(numero_identidad: number): Observable<any>{
    return this.http.delete<any>(this.url+'/eliminar/'+numero_identidad);
  }


}
