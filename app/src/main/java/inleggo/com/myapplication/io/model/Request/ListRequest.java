package inleggo.com.myapplication.io.model.Request;

import com.google.gson.annotations.SerializedName;

import inleggo.com.myapplication.io.JsonKeysRequest;

/**
 * Created by apurisaca on 29/11/2016.
 */

public class ListRequest {
    @SerializedName(JsonKeysRequest.USER)
    String user;
    @SerializedName(JsonKeysRequest.PASSWORD)
    String password;
    @SerializedName(JsonKeysRequest.DB)
    String db;
    @SerializedName(JsonKeysRequest.OPERATION)
    String operation;
    @SerializedName(JsonKeysRequest.GERENCIA)
    String gerencia;
    @SerializedName(JsonKeysRequest.AREA)
    String area;
    @SerializedName(JsonKeysRequest.SEDE)
    String sede;
    @SerializedName(JsonKeysRequest.PISO)
    String piso;
    @SerializedName(JsonKeysRequest.LOCAL)
    String local;

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

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
