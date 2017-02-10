package inleggo.com.myapplication.presenter;

import java.util.List;

import inleggo.com.myapplication.data.Model.LoginProyecto;
import inleggo.com.myapplication.data.Model.LoginUsuario;
import inleggo.com.myapplication.interactor.LoginCallback;
import inleggo.com.myapplication.interactor.LoginInteractor;
import inleggo.com.myapplication.view.LoginView;

/**
 * Created by apurisaca on 25/11/2016.
 */

public class LoginPresenter implements Presenter<LoginView>, LoginCallback{
    LoginView mLoginView;
    LoginInteractor mLoginInteractor;

    public void inicializar(){
        mLoginInteractor.serviceProyectos(this);
    }

    public void validaLogin(String proyect, String user, String pass) {
        mLoginView.showLoading();
        mLoginInteractor.validaLogin(this,proyect,user,pass);
        mLoginView.hideLoading();
    }

    @Override
    public void mensajeError(int nroEdt) {
        mLoginView.mensajeError(nroEdt);
    }

    @Override
    public void loadMenuPrincipal(LoginUsuario loginUsuario) {
        mLoginView.loadMenuPrincipal(loginUsuario);
    }

    @Override
    public void serviceProyectos(List<LoginProyecto> loginProyecto) {
        mLoginView.hideLoading();
        mLoginView.loadProyecto(loginProyecto);
    }



    @Override
    public void onMessageCustom(String message) {

    }

    @Override
    public void setView(LoginView view) {
        mLoginView = view;
        mLoginInteractor = new LoginInteractor(view.getContext());
    }

    @Override
    public void detachView() {

    }
}
