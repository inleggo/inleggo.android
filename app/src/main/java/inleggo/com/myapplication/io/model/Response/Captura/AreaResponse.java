package inleggo.com.myapplication.io.model.Response.Captura;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import inleggo.com.myapplication.data.Model.Area;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class AreaResponse {
    @SerializedName(value = "area")
    private List<AreaResponse.Detalle> area;

    public List<Detalle> getArea() {
        return area;
    }

    public void setArea(List<Detalle> area) {
        this.area = area;
    }

    public class Detalle{
        String id;
        String gerencia;
        String nombre;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGerencia() {
            return gerencia;
        }

        public void setGerencia(String gerencia) {
            this.gerencia = gerencia;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

    public List<Area> ToArea(String Label){

        List<Area> l = new ArrayList<Area>();
        Area uIni = new Area();
        uIni.setId("");
        uIni.setNombre(Label);
        l.add(uIni);
        if (this.getArea() != null) {
            for (int i = 0; i < this.getArea().size(); i++) {
                Area u = new Area();
                u.setId(this.getArea().get(i).getId());
                u.setGerencia(this.getArea().get(i).getGerencia());
                u.setNombre(this.getArea().get(i).getNombre());
                l.add(u);
            }
        }
        return  l;

    }
}
