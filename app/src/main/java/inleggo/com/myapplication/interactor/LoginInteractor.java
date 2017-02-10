package inleggo.com.myapplication.interactor;

import android.content.Context;
import android.util.Log;

import java.util.List;

import inleggo.com.myapplication.data.Model.LoginProyecto;
import inleggo.com.myapplication.data.Model.LoginUsuario;
import inleggo.com.myapplication.io.adapter.Login.LoginAdapter;
import inleggo.com.myapplication.io.adapter.Login.LoginProyectoAdapter;
import inleggo.com.myapplication.io.model.Request.LoginRequest;
import inleggo.com.myapplication.io.model.Response.Login.LoginResponse;
import inleggo.com.myapplication.io.model.Request.LoginProyectoRequest;
import inleggo.com.myapplication.io.model.Response.Login.LoginProyectoResponse;
import inleggo.com.myapplication.support.Constantes;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;


/**
 * Created by apurisaca on 25/11/2016.
 */

public class LoginInteractor {
    public final String TAG = getClass().getName();
    private Context mContext;
    List<LoginProyecto> mLoginProyectos;
    LoginResponse mLoginResponse;
    LoginUsuario mLoginUsuario;

    public LoginInteractor(Context context) {
        mContext = context;
        mLoginResponse = new LoginResponse();

    }


    public void validaLogin(LoginCallback callback, String proyect, String user, String pass){
        if (!proyect.isEmpty()){
            if (!user.isEmpty()){
                if (!pass.isEmpty()){
                    //LLAMAR AL SERVICIO DE LOGIN
                    serviceLogin(user, pass, proyect, callback);
                }else{
                    callback.mensajeError(3);
                }
            }else{
                callback.mensajeError(2);
            }
        }else{
            callback.mensajeError(1);
        }
    }

    public void serviceProyectos(final LoginCallback callback){
        LoginProyectoRequest request = new LoginProyectoRequest();
        request.setUser(Constantes.USUARIO);
        request.setPassword(Constantes.PASSWORD);
        request.setDb(Constantes.BASEDATOS);
        request.setOperation(Constantes.OPERATION_LIST);

        LoginProyectoAdapter.getApiService()
                .getProyectos(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (new Subscriber<LoginProyectoResponse>(){

                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted serviceProyectos");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(LoginProyectoResponse loginProyectoResponse) {
                        mLoginProyectos = loginProyectoResponse.ToProyecto("SELECCIONE EL PROYECTO");
                        callback.serviceProyectos(mLoginProyectos);
                    }
                });

    }

    public void serviceLogin(String usuario, String pass, String server, final LoginCallback callback){
        LoginRequest request = new LoginRequest();
        request.setUser(Constantes.USUARIO);
        request.setPassword(Constantes.PASSWORD);
        request.setOperation(Constantes.OPERATION_LOGIN);
        request.setDispositivo(Constantes.DISPOSITIVO);
        request.setDispositivo_so(Constantes.DISPOSITIVO_SO);
        request.setUsuario(usuario);
        request.setContraseña(pass);
        request.setServer(server);

        LoginAdapter.getApiService()
                .getLogin(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (new Subscriber<LoginResponse>(){

                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted serviceLogin");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                        e.printStackTrace();
                        callback.mensajeError(5);
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        Log.i(TAG, "onNext serviceLogin");
                        Log.i(TAG, "onNext serviceLogin---> getCode: " + loginResponse.getCode());
                        if(loginResponse.getCode().equals("1")){
                            setUser(loginResponse);
                            callback.loadMenuPrincipal(mLoginUsuario);
                        } else {
                            callback.mensajeError(4);
                        }
                    }
                });

    }

    public void setUser(LoginResponse loginResponse){

        Log.i(TAG, "onNext setUser  ");
        mLoginUsuario = new LoginUsuario();
        mLoginUsuario.setCode(loginResponse.getCode());

        mLoginUsuario.setResplogin(loginResponse.getResplogin());

        mLoginUsuario.setCliente(loginResponse.getCliente());

        mLoginUsuario.setCliente_c(loginResponse.getCliente_c());

        mLoginUsuario.setAño(loginResponse.getAño());

        mLoginUsuario.setEmpresa(loginResponse.getEmpresa());

        mLoginUsuario.setRuc(loginResponse.getRuc());

        mLoginUsuario.setWeb(loginResponse.getWeb());

        mLoginUsuario.setEmpresa_(loginResponse.getEmpresa_());

        mLoginUsuario.setDb(loginResponse.getDb());

        mLoginUsuario.setUser_db_temp(loginResponse.getUser_db_temp());

        mLoginUsuario.setPass_db_temp(loginResponse.getPass_db_temp());

        mLoginUsuario.setServer_activo(loginResponse.getServer_activo());

        mLoginUsuario.setFecha_inicio_c(loginResponse.getFecha_inicio_c());

        mLoginUsuario.setFecha_fin_c(loginResponse.getFecha_fin_c());

        mLoginUsuario.setTipo_empresa(loginResponse.getTipo_empresa());

        mLoginUsuario.setModelo(loginResponse.getModelo());

        mLoginUsuario.setLimite_cap(loginResponse.getLimite_cap());

        mLoginUsuario.setCod_def(loginResponse.getCod_def());

        mLoginUsuario.setCod_maxlength_inv(loginResponse.getCod_maxlength_inv());

        mLoginUsuario.setCod_barra_type(loginResponse.getCod_barra_type());
    }
}
