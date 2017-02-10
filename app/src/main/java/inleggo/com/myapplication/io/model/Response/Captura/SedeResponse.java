package inleggo.com.myapplication.io.model.Response.Captura;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import inleggo.com.myapplication.data.Model.Sede;

/**
 * Created by apurisaca on 13/12/2016.
 */
//servicio se llama localidad
public class SedeResponse {
    @SerializedName(value = "localidad")
    private List<SedeResponse.Detalle> sede;

    public List<Detalle> getSede() {
        return sede;
    }

    public void setSede(List<Detalle> sede) {
        this.sede = sede;
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

    public List<Sede> ToSede(String Label){

        List<Sede> l = new ArrayList<Sede>();
        Sede uIni = new Sede();
        uIni.setId("");
        uIni.setNombre(Label);
        l.add(uIni);
        if (this.getSede() != null) {
            for (int i = 0; i < this.getSede().size(); i++) {
                Sede u = new Sede();
                u.setId(this.getSede().get(i).getId());
                u.setNombre(this.getSede().get(i).getNombre());
                l.add(u);
            }
        }
        return  l;

    }
}
