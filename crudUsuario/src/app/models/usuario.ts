
import { Ciudad } from "./ciudad";
import { Ocupacion } from "./ocupacion";

export class Usuario {

    numero_identidad: number;
    nombre: String;
    apellido: String;
    fecha_nacimiento: Date;
    id_ciudad_fk: Ciudad;
    correo_electronico: String;
    telefono: string;
    id_ocupacion_fk: Ocupacion;


}
