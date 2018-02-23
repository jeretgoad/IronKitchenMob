import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import android.R.*;
import com.bumptech.glide.Glide;
import com.ironkitchen.ironkitchenmob.MealTabOjects;

import java.util.ArrayList;

/**
 * Created by user on 2/22/18.
 */

public class MealAdapters{

    class OuterRVAdapter extends RecyclerView.Adapter<OuterRVAdapter.ViewHolder> {

        Context context;
        private ArrayList<MealTabOjects> mealObjects;



        @Override
        public OuterRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(OuterRVAdapter.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
