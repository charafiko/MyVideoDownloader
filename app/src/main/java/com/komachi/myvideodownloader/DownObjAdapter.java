package com.komachi.myvideodownloader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DownObjAdapter extends RecyclerView.Adapter<DownObjAdapter.ViewHolder> {
    private ArrayList<DownObj> dos;
    private Context mContext;

    public DownObjAdapter(Context context, ArrayList<DownObj> dos) {
        this.dos = dos;
        mContext = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView codec;
        public TextView size;
        public RelativeLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            codec = itemView.findViewById(R.id.codec);
            size = itemView.findViewById(R.id.size);
        }
    }


    @Override
    public int getItemCount() {
        return dos.size();
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public DownObjAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View noteView = inflater.inflate(R.layout.down_obj, parent, false);
        ViewHolder viewHolder = new ViewHolder(noteView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DownObjAdapter.ViewHolder viewHolder, int position) {
        DownObj downObj = dos.get(position);
        String size;
        viewHolder.codec.setText(downObj.format + "    Type: " + downObj.ext);
        if (downObj.filesize > 2000000){
            size = "Total size: " + Math.round(downObj.filesize/1048576.0*100)/100.0+" MB";
        } else if (downObj.filesize == 0){
            size = "Total size: " +"Unknown";
        } else {
            size = "Total size: " + downObj.filesize / 1024 + " kB";
        }
        viewHolder.size.setText(size);
    }
}
