package inleggo.com.myapplication.io.service.Login;

import inleggo.com.myapplication.io.model.Request.LoginRequest;
import inleggo.com.myapplication.io.model.Response.Login.LoginResponse;
import inleggo.com.myapplication.support.Constantes;
import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by Amarilisis on 4/12/2016.
 */

public interface LoginService {
    @POST(Constantes.URL_LOGIN)
    Observable<LoginResponse> getLogin(@Body LoginRequest parametros);
}
