package inleggo.com.myapplication.io.model.Response.Captura;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import inleggo.com.myapplication.data.Model.Equipo;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class EquipoResponse {
    @SerializedName(value = "equipo")
    private List<EquipoResponse.Detalle> equipo;

    public List<Detalle> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Detalle> equipo) {
        this.equipo = equipo;
    }

    public class Detalle{
        String id;
        String area;
        String nombre;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

    public List<Equipo> ToEquipo(String Label){

        List<Equipo> l = new ArrayList<Equipo>();
        Equipo uIni = new Equipo();
        uIni.setId("");
        uIni.setNombre(Label);
        l.add(uIni);
        if (this.getEquipo() != null) {
            for (int i = 0; i < this.getEquipo().size(); i++) {
                Equipo u = new Equipo();
                u.setId(this.getEquipo().get(i).getId());
                u.setArea(this.getEquipo().get(i).getArea());
                u.setNombre(this.getEquipo().get(i).getNombre());
                l.add(u);
            }
        }
        return  l;

    }
}
