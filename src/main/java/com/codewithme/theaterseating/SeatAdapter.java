package mytheater.android.com.theaterseating;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by cdlee on 2/13/18.
 */

public class SeatAdapter extends BaseAdapter {
    private Context context;
    private int [][] seating;

    public SeatAdapter(Context context, int [][] seating) {
        this.context = context;
        this.seating = seating;
    }


    @Override
    public int getCount() {
        return 16;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        View view;
        if (convertView == null) {
            view = new View(context);
            view.setBackgroundColor(context.getResources().getColor(android.R.color.holo_green_light));
            imageView = new ImageView(context);
            view.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        }else {
            view = convertView;
        }
        return view;
    }
}
