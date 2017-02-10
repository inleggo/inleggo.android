package inleggo.com.myapplication.io.adapter.Captura;

import inleggo.com.myapplication.io.service.Captura.EquipoService;
import inleggo.com.myapplication.support.Constantes;
import retrofit.RestAdapter;

/**
 * Created by apurisaca on 13/12/2016.
 */

public class EquipoAdapter {
    private static EquipoService API_SERVICE;
    public static EquipoService getApiService(){
        if (API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(Constantes.BASE_URL_CONS)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            API_SERVICE = adapter.create(EquipoService.class);
        }
        return API_SERVICE;
    }
}
