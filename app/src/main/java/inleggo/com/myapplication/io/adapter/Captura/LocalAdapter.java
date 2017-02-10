package inleggo.com.myapplication.io.adapter.Captura;

import inleggo.com.myapplication.io.service.Captura.LocalService;
import inleggo.com.myapplication.support.Constantes;
import retrofit.RestAdapter;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class LocalAdapter {
    private static LocalService API_SERVICE;
    public static LocalService getApiService(){
        if (API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(Constantes.BASE_URL_CONS)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            API_SERVICE = adapter.create(LocalService.class);
        }
        return API_SERVICE;
    }
}
