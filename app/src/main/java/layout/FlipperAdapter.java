package layout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.content.Context;
import com.bumptech.glide.Glide;
import com.ironkitchen.ironkitchenmob.R;

import java.util.ArrayList;

/**
 * Created by jeretgoad on 12/15/17.
 */

public class FlipperAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Integer> images;

    public FlipperAdapter(Context con, ArrayList<Integer> imgs)
    {
        this.context = con;
        this.images = imgs;
    }
    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.flipper_items, null);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        Glide.with(context).load(images.get(position)).into(imageView);
        return view;
    }
}
