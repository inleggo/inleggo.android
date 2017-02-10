package inleggo.com.myapplication.presenter;

/**
 * Created by apurisaca on 25/11/2016.
 */

public interface Presenter<V> {
    void setView(V view);
    void detachView();
}
