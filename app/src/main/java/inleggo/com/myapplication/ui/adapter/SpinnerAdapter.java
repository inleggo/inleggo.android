package inleggo.com.myapplication.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import inleggo.com.myapplication.R;


/**
 * Created by apurisaca on 28/11/2016.
 */
public class SpinnerAdapter<T> extends ArrayAdapter<T> {

    public Context mContext;
    public List<T> mObjects;
    public LayoutInflater mInflater;
    public TextView textView;

    public SpinnerAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
        mContext = context;
        mObjects = objects;
        mInflater = LayoutInflater.from(mContext);
    }

    public String getDescripcion(int position){
        return "text";
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public T getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public int getPosition(T item) {
        return mObjects.indexOf(item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        /*TextView*/ textView = new TextView(mContext);
        textView.setTextColor(Color.BLACK);
        textView.setPadding(10, 10, 0, 10);
        textView.setTextSize(12);
        textView.setText(getDescripcion(position));
        return  textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        textView = new TextView(mContext);
        textView.setTextColor(Color.BLACK);
        textView.setPadding(10, 10, 0, 10);
        textView.setTextSize(16f);
        textView.setText(getDescripcion(position));
        return textView;
    }


}
