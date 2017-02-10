package inleggo.com.myapplication.io.model.Response.Captura;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import inleggo.com.myapplication.data.Model.Ubicacion;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class UbicacionResponse {
    @SerializedName(value = "ubicacion")
    private List<UbicacionResponse.Detalle> ubicacion;

    public List<Detalle> getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(List<Detalle> ubicacion) {
        this.ubicacion = ubicacion;
    }

    public class Detalle{
        String id;
        String local;
        String piso;
        String nombre;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLocal() {
            return local;
        }

        public void setLocal(String local) {
            this.local = local;
        }

        public String getPiso() {
            return piso;
        }

        public void setPiso(String piso) {
            this.piso = piso;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

    public List<Ubicacion> ToUbicacion(String Label){

        List<Ubicacion> l = new ArrayList<Ubicacion>();
        Ubicacion uIni = new Ubicacion();
        uIni.setId("");
        uIni.setNombre(Label);
        l.add(uIni);
        if (this.getUbicacion() != null) {
            for (int i = 0; i < this.getUbicacion().size(); i++) {
                Ubicacion u = new Ubicacion();
                u.setId(this.getUbicacion().get(i).getId());
                u.setLocal(this.getUbicacion().get(i).getLocal());
                u.setPiso(this.getUbicacion().get(i).getPiso());
                u.setNombre(this.getUbicacion().get(i).getNombre());
                l.add(u);
            }
        }
        return  l;

    }
}
