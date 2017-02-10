package inleggo.com.myapplication.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amarilisis on 11/12/2016.
 */

public class TipoCaptura implements Parcelable{
    String id;
    String nombre;

    public TipoCaptura() {
    }

    public TipoCaptura(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    protected TipoCaptura(Parcel in) {
        id = in.readString();
        nombre = in.readString();
    }

    public static final Creator<TipoCaptura> CREATOR = new Creator<TipoCaptura>() {
        @Override
        public TipoCaptura createFromParcel(Parcel in) {
            return new TipoCaptura(in);
        }

        @Override
        public TipoCaptura[] newArray(int size) {
            return new TipoCaptura[size];
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
