package inleggo.com.myapplication.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class Piso implements Parcelable{
    String id;
    String nombre;

    public Piso() {
    }

    public Piso(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    protected Piso(Parcel in) {
        id = in.readString();
        nombre = in.readString();
    }

    public static final Creator<Piso> CREATOR = new Creator<Piso>() {
        @Override
        public Piso createFromParcel(Parcel in) {
            return new Piso(in);
        }

        @Override
        public Piso[] newArray(int size) {
            return new Piso[size];
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
