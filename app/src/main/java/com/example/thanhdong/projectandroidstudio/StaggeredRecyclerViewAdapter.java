package com.example.thanhdong.projectandroidstudio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thanhdong.projectandroidstudio.retrofitmain.Highlight;
import com.example.thanhdong.projectandroidstudio.retrofitmain.Highlights;
import com.example.thanhdong.projectandroidstudio.retrofitmain.Statements;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.List;

public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Highlight> mDataList;

    public StaggeredRecyclerViewAdapter(Context context, List<Highlight> dataList) {
        this.mContext = context;
        this.mDataList = dataList;
    }

    public class TopWordCloudViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        TextView txtStatements;
        ImageView imgUsername;
        TextView txtUserName;
        TextView txtTitle;
        Button btnBookmarked;

        public TopWordCloudViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;

            txtStatements = mView.findViewById(R.id.txt_opiyn_statement);
            imgUsername = mView.findViewById(R.id.img_username);
            txtUserName = mView.findViewById(R.id.txt_username);
            txtTitle = mView.findViewById(R.id.txt_title);

        }

        public void bindView(Highlight highlight) {
            txtStatements.setText((CharSequence) highlight.getStatements());

            Picasso.Builder builderUserImage = new Picasso.Builder(mContext);
            builderUserImage.downloader(new OkHttp3Downloader(mContext));
            builderUserImage.build().load(highlight.getUserImageURL())
                    .placeholder((R.drawable.unknown_img_username))
                    .error(R.drawable.unknown_img_username)
                    .into(imgUsername);

            txtUserName.setText(highlight.getUsername());

            txtTitle.setText(highlight.getPageTitle());
        }
    }

    public class OpiynWithPhotoViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        ImageView imgTitle;
        TextView txtOpiynStatement;
        ImageView imgUsername;
        TextView txtUserName;
        TextView txtTitle;

        public OpiynWithPhotoViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;

            imgTitle = mView.findViewById(R.id.img_widget);
            txtOpiynStatement = mView.findViewById(R.id.txt_opiyn_statement);
            imgUsername = mView.findViewById(R.id.img_username);
            txtUserName = mView.findViewById(R.id.txt_username);
            txtTitle = mView.findViewById(R.id.txt_title);
        }

        public void bindView(Highlight highlight) {
            Picasso.Builder builderPageImage = new Picasso.Builder(mContext);
            builderPageImage.downloader(new OkHttp3Downloader(mContext));
            builderPageImage.build().load(highlight.getPageImageURL())
                    .placeholder((R.drawable.ic_launcher_loading))
                    .error(R.drawable.ic_launcher_loading)
                    .into(imgTitle);

            txtOpiynStatement.setText(highlight.getOpiynStatement());

            Picasso.Builder builderUserImage = new Picasso.Builder(mContext);
            builderUserImage.downloader(new OkHttp3Downloader(mContext));
            builderUserImage.build().load(highlight.getUserImageURL())
                    .placeholder((R.drawable.unknown_img_username))
                    .error(R.drawable.unknown_img_username)
                    .into(imgUsername);

            txtUserName.setText(highlight.getUsername());

            txtTitle.setText(highlight.getPageTitle());
        }
    }

    public class TopStoryViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        ImageView imgTitle;
        TextView txtTitle;
        TextView txtSubTitle;
        ImageView imgUsername;
        TextView txtUserName;
        TextView txtViewCount;
        Button btnBookmarked;

        public TopStoryViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;

            imgTitle = mView.findViewById(R.id.img_widget);
            txtTitle = mView.findViewById(R.id.txt_title);
            txtSubTitle = mView.findViewById(R.id.txt_sub_title);
            imgUsername = mView.findViewById(R.id.img_username);
            txtUserName = mView.findViewById(R.id.txt_username);
            txtViewCount = mView.findViewById(R.id.txt_view);
        }

        public void bindView(Highlight highlight) {
            Picasso.Builder builderPageImage = new Picasso.Builder(mContext);
            builderPageImage.downloader(new OkHttp3Downloader(mContext));
            builderPageImage.build().load(highlight.getPageImageURL())
                    .placeholder((R.drawable.ic_launcher_loading))
                    .error(R.drawable.ic_launcher_loading)
                    .into(imgTitle);

            txtTitle.setText(highlight.getPageTitle());

            txtSubTitle.setText(highlight.getPageSubTitle());

            Picasso.Builder builderUserImage = new Picasso.Builder(mContext);
            builderUserImage.downloader(new OkHttp3Downloader(mContext));
            builderUserImage.build().load(highlight.getUserImageURL())
                    .placeholder((R.drawable.unknown_img_username))
                    .error(R.drawable.unknown_img_username)
                    .into(imgUsername);

            txtUserName.setText(highlight.getUsername());

            txtViewCount.setText(highlight.getPageViewCounts());

        }
    }

    public int getItemViewType(int position) {
        Highlight highlight = mDataList.get(position);
        if (highlight.getHighlightType().equalsIgnoreCase("top_word_cloud")) {
            return 0;
        } else if (highlight.getHighlightType().equalsIgnoreCase("opiyn_with_photo")) {
            return 1;
        } else if (highlight.getHighlightType().equalsIgnoreCase("top_story")) {
            return 2;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.items_staggered_grid_view_top_word_cloud, parent, false);

        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.items_staggered_grid_view_top_word_cloud, parent, false);
            return new TopWordCloudViewHolder(view);
        } else if (viewType == 1) {
            view = layoutInflater.inflate(R.layout.items_staggered_grid_view_opyin_with_photo, parent, false);
            return new OpiynWithPhotoViewHolder(view);
        } else if (viewType == 2) {
            view = layoutInflater.inflate(R.layout.items_staggered_grid_view_top_story, parent, false);
            return new TopStoryViewHolder(view);
        }
        return new TopWordCloudViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Highlight highlight = mDataList.get(position);
        if (highlight.getHighlightType().equalsIgnoreCase("top_word_cloud")) {
            ((TopWordCloudViewHolder) holder).bindView(highlight);
        } else if (highlight.getHighlightType().equalsIgnoreCase("opiyn_with_photo")) {
            ((OpiynWithPhotoViewHolder) holder).bindView(highlight);
        } else if (highlight.getHighlightType().equalsIgnoreCase("top_story")) {
            ((TopStoryViewHolder) holder).bindView(highlight);
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

}