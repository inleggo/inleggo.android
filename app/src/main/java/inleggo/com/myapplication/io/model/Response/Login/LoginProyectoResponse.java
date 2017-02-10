package inleggo.com.myapplication.io.model.Response.Login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import inleggo.com.myapplication.data.Model.LoginProyecto;

/**
 * Created by apurisaca on 28/11/2016.
 */

public class LoginProyectoResponse implements Parcelable{
    @SerializedName(value = "server")
    private List<Detalle> mProyectos;


    public LoginProyectoResponse() {
    }

    public LoginProyectoResponse(Parcel in) {
        in.readTypedList(mProyectos,Detalle.CREATOR);
    }

    public static final Creator<LoginProyectoResponse> CREATOR = new Creator<LoginProyectoResponse>() {
        @Override
        public LoginProyectoResponse createFromParcel(Parcel in) {
            return new LoginProyectoResponse(in);
        }

        @Override
        public LoginProyectoResponse[] newArray(int size) {
            return new LoginProyectoResponse[size];
        }
    };

    public List<Detalle> getProyectos() {
        return mProyectos;
    }

    public void setProyectos(List<Detalle> proyectos) {
        mProyectos = proyectos;
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(mProyectos);
    }


    public static class Detalle implements Parcelable{
        private String id;
        private String empresa;

        public Detalle() {
        }

        public Detalle(Parcel in) {
            id = in.readString();
            empresa = in.readString();
        }

        public static final Creator<Detalle> CREATOR = new Creator<Detalle>() {
            @Override
            public Detalle createFromParcel(Parcel in) {
                return new Detalle(in);
            }

            @Override
            public Detalle[] newArray(int size) {
                return new Detalle[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmpresa() {
            return empresa;
        }

        public void setEmpresa(String empresa) {
            this.empresa = empresa;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(empresa);
        }

    }

    public List<LoginProyecto> ToProyecto(String Label){

        List<LoginProyecto> l = new ArrayList<LoginProyecto>();
        LoginProyecto uIni = new LoginProyecto();
        uIni.setId("");
        uIni.setEmpresa(Label);
        l.add(uIni);
        if (this.getProyectos() != null) {
            for (int i = 0; i < this.getProyectos().size(); i++) {
                LoginProyecto u = new LoginProyecto();

                u.setId(this.getProyectos().get(i).getId());
                u.setEmpresa(this.getProyectos().get(i).getEmpresa());

                l.add(u);
            }
        }
        return  l;

    }

}
