package inleggo.com.myapplication.view;

import java.util.List;

import inleggo.com.myapplication.data.Model.LoginProyecto;
import inleggo.com.myapplication.data.Model.LoginUsuario;

/**
 * Created by apurisaca on 25/11/2016.
 */

public interface LoginView extends MvpView{
    void showLoading();
    void hideLoading();
    void hideKeyboard();
    void mensajeError(int nroEdt);
    void loadProyecto(List<LoginProyecto> loginProyectos);
    void loadMenuPrincipal(LoginUsuario loginUsuario);
}
