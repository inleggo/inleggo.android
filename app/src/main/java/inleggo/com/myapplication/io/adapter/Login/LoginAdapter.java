package inleggo.com.myapplication.io.adapter.Login;

import inleggo.com.myapplication.io.service.Login.LoginService;
import inleggo.com.myapplication.support.Constantes;
import retrofit.RestAdapter;

/**
 * Created by Amarilisis on 4/12/2016.
 */

public class LoginAdapter {
    private static LoginService API_SERVICE;
    public static LoginService getApiService(){
        if (API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(Constantes.BASE_URL_CONS)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            API_SERVICE = adapter.create(LoginService.class);
        }
        return API_SERVICE;
    }
}
