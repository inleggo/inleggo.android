package inleggo.com.myapplication.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amarilisis on 11/12/2016.
 */

public class Gerencia implements Parcelable{
    String id;
    String nombre;

    public Gerencia(Parcel in) {
        id = in.readString();
        nombre = in.readString();
    }

    public static final Creator<Gerencia> CREATOR = new Creator<Gerencia>() {
        @Override
        public Gerencia createFromParcel(Parcel in) {
            return new Gerencia(in);
        }

        @Override
        public Gerencia[] newArray(int size) {
            return new Gerencia[size];
        }
    };

    public Gerencia() {

    }

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
