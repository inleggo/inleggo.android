package inleggo.com.myapplication.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apurisaca on 28/11/2016.
 */

public class LoginProyecto implements Parcelable {
    String id;
    String empresa;

    public LoginProyecto() {

    }

    protected LoginProyecto(Parcel in) {
        id = in.readString();
        empresa = in.readString();
    }

    public static final Creator<LoginProyecto> CREATOR = new Creator<LoginProyecto>() {
        @Override
        public LoginProyecto createFromParcel(Parcel in) {
            return new LoginProyecto(in);
        }

        @Override
        public LoginProyecto[] newArray(int size) {
            return new LoginProyecto[size];
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
