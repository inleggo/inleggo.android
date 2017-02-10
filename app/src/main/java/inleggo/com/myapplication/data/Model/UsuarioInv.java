package inleggo.com.myapplication.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class UsuarioInv implements Parcelable{
    String id;
    String dni;
    String nombre;
    String modalidad;

    public UsuarioInv() {
    }

    protected UsuarioInv(Parcel in) {
        id = in.readString();
        dni = in.readString();
        nombre = in.readString();
        modalidad = in.readString();
    }

    public static final Creator<UsuarioInv> CREATOR = new Creator<UsuarioInv>() {
        @Override
        public UsuarioInv createFromParcel(Parcel in) {
            return new UsuarioInv(in);
        }

        @Override
        public UsuarioInv[] newArray(int size) {
            return new UsuarioInv[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(dni);
        parcel.writeString(nombre);
        parcel.writeString(modalidad);
    }
}
