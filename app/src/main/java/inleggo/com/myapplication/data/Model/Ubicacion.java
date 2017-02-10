package inleggo.com.myapplication.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class Ubicacion implements Parcelable{
    String id;
    String local;
    String piso;
    String nombre;

    public Ubicacion() {
    }

    protected Ubicacion(Parcel in) {
        id = in.readString();
        local = in.readString();
        piso = in.readString();
        nombre = in.readString();
    }

    public static final Creator<Ubicacion> CREATOR = new Creator<Ubicacion>() {
        @Override
        public Ubicacion createFromParcel(Parcel in) {
            return new Ubicacion(in);
        }

        @Override
        public Ubicacion[] newArray(int size) {
            return new Ubicacion[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(local);
        parcel.writeString(piso);
        parcel.writeString(nombre);
    }
}
