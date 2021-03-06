package com.ironkitchen.ironkitchenmob.ik_view;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.ironkitchen.ironkitchenmob.R;
import com.ironkitchen.ironkitchenmob.ik_data.MobTabObjects;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * Created by jeretgoad on 1/25/18.
 */

class CustomViewHolderButton extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView textView1;

    public CustomViewHolderButton(View view) {
        super(view);
        this.imageView = view.findViewById(R.id.imageButton);
        this.textView1 = view.findViewById(R.id.textType);
    }
}

class CustomViewHolderImage extends RecyclerView.ViewHolder{
    ImageView imageView;

    public CustomViewHolderImage(View view) {
        super(view);
        this.imageView = view.findViewById(R.id.imageViewCard);
    }
}

class CustomViewHolderImageVideo extends RecyclerView.ViewHolder{
    ImageView imageView;
    VideoView videoView;
    ProgressBar progressBar;
    public CustomViewHolderImageVideo(View view) {
        super(view);
        this.imageView = view.findViewById(R.id.imageViewCard);
        this.videoView = view.findViewById(R.id.videoViewCard);
        this.progressBar = view.findViewById(R.id.progressBar);
    }
}

class MobAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int image_button = 0;
    public static final int image_view = 1;
    public static final int image_double = 2;

    Context context;
    private static ArrayList<MobTabObjects> mobObjects;


    public MobAdapter(Context context, ArrayList<MobTabObjects> mobObjects) {
        this.context = context;
        this.mobObjects = mobObjects;
    }

    @Override
    public int getItemViewType(int position)
    {
        if(mobObjects.get(position).getIsButton() == 0)
        {
            return image_button;
        }
        else if(mobObjects.get(position).getIsButton() == 1)
        {
            return image_view;
        }
        else
        {
            return image_double;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        this.context = parent.getContext();
        if(viewType == image_button)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            View daView0 = inflater.inflate(R.layout.home_row_image_button, parent,false);
            return new CustomViewHolderButton(daView0);
        }
        else if(viewType == image_view)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            View daView1 = inflater.inflate(R.layout.home_row_image, parent,false);
            return new CustomViewHolderImage(daView1);
        }
        else
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            View daView2 = inflater.inflate(R.layout.home_row_image_video, parent,false);
            return new CustomViewHolderImageVideo(daView2);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        switch (holder.getItemViewType())
        {
            case image_button:
            {
                CustomViewHolderButton viewHolder = (CustomViewHolderButton) holder;
                viewHolder.setIsRecyclable(false);
                GlideApp.with(context).
                        load(mobObjects.get(position).getImageID())
                        .apply(bitmapTransform(new RoundedCornersTransformation(45, 0,
                                RoundedCornersTransformation.CornerType.BOTTOM)))
                        .into(viewHolder.imageView);
                viewHolder.textView1.setPaintFlags(viewHolder.textView1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                viewHolder.textView1.setText(mobObjects.get(position).getMealType());
            }
            break;
            case image_view:
            {
                CustomViewHolderImage viewHolder = (CustomViewHolderImage) holder;
                viewHolder.setIsRecyclable(false);
                GlideApp.with(context).load(mobObjects.get(position).getImageID()).into(viewHolder.imageView);
            }
            break;
            case image_double:
            {
                CustomViewHolderImageVideo viewHolder = (CustomViewHolderImageVideo) holder;
                viewHolder.setIsRecyclable(false);
                GlideApp.with(context).load(mobObjects.get(position).getImageID()).into(viewHolder.imageView);
                VideoView video = viewHolder.videoView;
                MediaController media = new MediaController(this.context);
                String videoPath = "android.resource://com.ironkitchen.ironkitchenmob/"+R.raw.ik_intro;
                Uri uri = Uri.parse(videoPath);
                video.setVideoURI(uri);
                video.setMediaController(media);
                media.setAnchorView(video);
                viewHolder.progressBar.setVisibility(View.VISIBLE);
                video.start();
            }
            break;
            default:
                break;
        }
    }


    @Override
    public int getItemCount() {
        return mobObjects.size();
    }


}
