package android.com.choosecars;

import android.app.Activity;
import android.com.choosecars.model.Flower;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ChandraIndukuri on 5/17/2016.
 */
public class Adapter extends ArrayAdapter<Flower> {

    String url="http://services.hanselandpetal.com/photos/";
    private Context context;
    private List<Flower> flowerList;
    public Adapter(Context context, int resource, List<Flower> objects) {
        super(context, resource, objects);
        this.context = context;
        this.flowerList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.flower_item,parent,false);
        Flower flower = flowerList.get(position);
        TextView tv = (TextView) view.findViewById(R.id.name);
        tv.setText(flower.getName());
        ImageView img = (ImageView) view.findViewById(R.id.img);
        Picasso.with(getContext()).load(url+flower.getPhoto()).resize(200,200).into(img);
//        img = null;
        return view;
    }
}
