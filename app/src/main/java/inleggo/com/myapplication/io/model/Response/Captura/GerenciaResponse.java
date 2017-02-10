package inleggo.com.myapplication.io.model.Response.Captura;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import inleggo.com.myapplication.data.Model.Gerencia;

/**
 * Created by Amarilisis on 11/12/2016.
 */

public class GerenciaResponse {
    @SerializedName(value = "gerencia")
    private List<GerenciaResponse.Detalle> gerencia;

    public List<Detalle> getGerencia() {
        return gerencia;
    }

    public void setGerencia(List<Detalle> gerencia) {
        this.gerencia = gerencia;
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

    public List<Gerencia> ToGerencia(String Label){

        List<Gerencia> l = new ArrayList<Gerencia>();
        Gerencia uIni = new Gerencia();
        uIni.setId("");
        uIni.setNombre(Label);
        l.add(uIni);
        if (this.getGerencia() != null) {
            for (int i = 0; i < this.getGerencia().size(); i++) {
                Gerencia u = new Gerencia();

                u.setId(this.getGerencia().get(i).getId());
                u.setNombre(this.getGerencia().get(i).getNombre());

                l.add(u);
            }
        }
        return  l;

    }

}
