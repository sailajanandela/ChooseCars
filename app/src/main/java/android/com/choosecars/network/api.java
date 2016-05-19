package android.com.choosecars.network;

import android.com.choosecars.model.Flower;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by ChandraIndukuri on 5/17/2016.
 */
public interface api {

    @GET("/feeds/flowers.json")
    void getData(Callback<List<Flower>> response);
}
