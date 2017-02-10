package inleggo.com.myapplication.io.model.Request;

import com.google.gson.annotations.SerializedName;

import inleggo.com.myapplication.io.JsonKeysRequest;

/**
 * Created by apurisaca on 28/11/2016.
 */

public class LoginProyectoRequest {
    @SerializedName(JsonKeysRequest.USER)
    String user;
    @SerializedName(JsonKeysRequest.PASSWORD)
    String password;
    @SerializedName(JsonKeysRequest.DB)
    String db;
    @SerializedName(JsonKeysRequest.OPERATION)
    String operation;

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
}
