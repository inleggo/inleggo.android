package inleggo.com.myapplication.io.model.Response.Captura;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import inleggo.com.myapplication.data.Model.UsuarioInv;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class UsuarioInvResponse {
    @SerializedName(value = "usuario")
    private List<UsuarioInvResponse.Detalle> usuario;

    public List<Detalle> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Detalle> usuario) {
        this.usuario = usuario;
    }

    public class Detalle{
        String id;
        String dni;
        String nombre;
        String modalidad;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getModalidad() {
            return modalidad;
        }

        public void setModalidad(String modalidad) {
            this.modalidad = modalidad;
        }
    }

    public List<UsuarioInv> ToUsuario(String Label){

        List<UsuarioInv> l = new ArrayList<UsuarioInv>();
        UsuarioInv uIni = new UsuarioInv();
        uIni.setId("");
        uIni.setNombre(Label);
        l.add(uIni);
        if (this.getUsuario() != null) {
            for (int i = 0; i < this.getUsuario().size(); i++) {
                UsuarioInv u = new UsuarioInv();
                u.setId(this.getUsuario().get(i).getId());
                u.setDni(this.getUsuario().get(i).getDni());
                u.setNombre(this.getUsuario().get(i).getNombre());
                u.setModalidad(this.getUsuario().get(i).getModalidad());
                l.add(u);
            }
        }
        return  l;

    }
}
