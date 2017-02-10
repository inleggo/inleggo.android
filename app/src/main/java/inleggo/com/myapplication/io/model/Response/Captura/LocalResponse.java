package inleggo.com.myapplication.io.model.Response.Captura;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import inleggo.com.myapplication.data.Model.Local;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class LocalResponse {
    @SerializedName(value = "local")
    private List<LocalResponse.Detalle> local;

    public List<Detalle> getLocal() {
        return local;
    }

    public void setLocal(List<Detalle> local) {
        this.local = local;
    }

    public class Detalle{
        String id;
        String localidad;
        String nombre;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLocalidad() {
            return localidad;
        }

        public void setLocalidad(String localidad) {
            this.localidad = localidad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

    public List<Local> ToLocal(String Label){

        List<Local> l = new ArrayList<Local>();
        Local uIni = new Local();
        uIni.setId("");
        uIni.setNombre(Label);
        l.add(uIni);
        if (this.getLocal() != null) {
            for (int i = 0; i < this.getLocal().size(); i++) {
                Local u = new Local();
                u.setId(this.getLocal().get(i).getId());
                u.setLocalidad(this.getLocal().get(i).getLocalidad());
                u.setNombre(this.getLocal().get(i).getNombre());
                l.add(u);
            }
        }
        return  l;

    }
}
