package inleggo.com.myapplication.io.model.Response.Captura;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import inleggo.com.myapplication.data.Model.Proyecto;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class ProyectoResponse {
    @SerializedName(value = "proyecto")
    private List<ProyectoResponse.Detalle> proyecto;

    public List<Detalle> getProyecto() {
        return proyecto;
    }

    public void setProyecto(List<Detalle> proyecto) {
        this.proyecto = proyecto;
    }

    public class Detalle{
        String id;
        String nombre;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

    public List<Proyecto> ToProyecto(String Label){

        List<Proyecto> l = new ArrayList<Proyecto>();
        Proyecto uIni = new Proyecto();
        uIni.setId("");
        uIni.setNombre(Label);
        l.add(uIni);
        if (this.getProyecto() != null) {
            for (int i = 0; i < this.getProyecto().size(); i++) {
                Proyecto u = new Proyecto();
                u.setId(this.getProyecto().get(i).getId());
                u.setNombre(this.getProyecto().get(i).getNombre());
                l.add(u);
            }
        }
        return  l;

    }
}
