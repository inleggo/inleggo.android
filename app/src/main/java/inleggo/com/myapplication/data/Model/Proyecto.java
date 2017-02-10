package inleggo.com.myapplication.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class Proyecto implements Parcelable{
    String id;
    String nombre;

    public Proyecto() {
    }

    protected Proyecto(Parcel in) {
        id = in.readString();
        nombre = in.readString();
    }

    public static final Creator<Proyecto> CREATOR = new Creator<Proyecto>() {
        @Override
        public Proyecto createFromParcel(Parcel in) {
            return new Proyecto(in);
        }

        @Override
        public Proyecto[] newArray(int size) {
            return new Proyecto[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(nombre);
    }
}
