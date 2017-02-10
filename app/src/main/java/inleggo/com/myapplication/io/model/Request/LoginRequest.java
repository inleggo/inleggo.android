package inleggo.com.myapplication.io.model.Request;

import com.google.gson.annotations.SerializedName;

import inleggo.com.myapplication.io.JsonKeysRequest;

/**
 * Created by apurisaca on 29/11/2016.
 */

public class LoginRequest {
    @SerializedName(JsonKeysRequest.USER)
    String user;
    @SerializedName(JsonKeysRequest.PASSWORD)
    String password;
    @SerializedName(JsonKeysRequest.OPERATION)
    String operation;
    @SerializedName(JsonKeysRequest.SERVER)
    String server;
    @SerializedName(value = "usuario")
    String usuario;
    @SerializedName(value = "contraseña")
    String contraseña;
    @SerializedName(JsonKeysRequest.DISPOSITIVO)
    String dispositivo;
    @SerializedName(JsonKeysRequest.DISPOSITIVO_SO)
    String dispositivo_so;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getDispositivo_so() {
        return dispositivo_so;
    }

    public void setDispositivo_so(String dispositivo_so) {
        this.dispositivo_so = dispositivo_so;
    }
}
