package inleggo.com.myapplication.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class Equipo implements Parcelable{
    String id;
    String area;
    String nombre;

    public Equipo() {
    }

    protected Equipo(Parcel in) {
        id = in.readString();
        area = in.readString();
        nombre = in.readString();
    }

    public static final Creator<Equipo> CREATOR = new Creator<Equipo>() {
        @Override
        public Equipo createFromParcel(Parcel in) {
            return new Equipo(in);
        }

        @Override
        public Equipo[] newArray(int size) {
            return new Equipo[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
        parcel.writeString(area);
        parcel.writeString(nombre);
    }
}
