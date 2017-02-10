package inleggo.com.myapplication.interactor;

import java.util.List;

import inleggo.com.myapplication.data.Model.LoginProyecto;
import inleggo.com.myapplication.data.Model.LoginUsuario;

/**
 * Created by apurisaca on 25/11/2016.
 */

public interface LoginCallback {
    void mensajeError(int nroEdt);
    void loadMenuPrincipal (LoginUsuario loginUsuario);
    void serviceProyectos(List<LoginProyecto> loginProyecto);
    void onMessageCustom(String message);
}
