package inleggo.com.myapplication.io.adapter.Login;

import inleggo.com.myapplication.io.service.Login.LoginProyectoService;
import inleggo.com.myapplication.support.Constantes;
import retrofit.RestAdapter;

/**
 * Created by apurisaca on 28/11/2016.
 */

public class LoginProyectoAdapter {
    private static LoginProyectoService API_SERVICE;
    public static LoginProyectoService getApiService(){
        if (API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(Constantes.BASE_URL_CONS)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            API_SERVICE = adapter.create(LoginProyectoService.class);
        }
        return API_SERVICE;
    }
}
