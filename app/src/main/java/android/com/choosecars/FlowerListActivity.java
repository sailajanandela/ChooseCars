package android.com.choosecars;

import android.com.choosecars.model.Flower;
import android.com.choosecars.network.api;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FlowerListActivity extends android.app.ListActivity {

    private RestAdapter restAdapter;
    List<Flower> flowerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

//        http://services.hanselandpetal.com/feeds/flowers.json

        final RestAdapter restAdapter =  new RestAdapter.Builder().setEndpoint("http://services.hanselandpetal.com").build();
        api flowerApi = restAdapter.create(api.class);
        flowerApi.getData(new Callback<List<Flower>>(){

            @Override
            public void success(List<Flower> flowers, Response response) {
               flowerList = flowers;
                Adapter adapter = new Adapter(getApplicationContext(),R.layout.flower_item, flowerList);
                setListAdapter(adapter);


            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
