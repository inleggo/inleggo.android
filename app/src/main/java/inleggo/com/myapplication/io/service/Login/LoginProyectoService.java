package inleggo.com.myapplication.io.service.Login;

import inleggo.com.myapplication.io.model.Request.LoginProyectoRequest;
import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;
import inleggo.com.myapplication.io.model.Response.Login.LoginProyectoResponse;
import inleggo.com.myapplication.support.Constantes;

/**
 * Created by apurisaca on 28/11/2016.
 */

public interface LoginProyectoService {
    @POST(Constantes.URL_LOGIN_PROYECTO)
    Observable<LoginProyectoResponse> getProyectos(@Body LoginProyectoRequest parametros);
}
