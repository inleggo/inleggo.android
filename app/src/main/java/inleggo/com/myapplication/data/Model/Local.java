package inleggo.com.myapplication.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class Local implements Parcelable{
    String id;
    String localidad;
    String nombre;

    public Local() {
    }

    protected Local(Parcel in) {
        id = in.readString();
        localidad = in.readString();
        nombre = in.readString();
    }

    public static final Creator<Local> CREATOR = new Creator<Local>() {
        @Override
        public Local createFromParcel(Parcel in) {
            return new Local(in);
        }

        @Override
        public Local[] newArray(int size) {
            return new Local[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(localidad);
        parcel.writeString(nombre);
    }
}
