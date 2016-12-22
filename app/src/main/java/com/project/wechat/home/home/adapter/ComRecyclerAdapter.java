package com.project.wechat.home.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.wechat.home.bean.ComBody;

import java.util.List;

import appframework.com.mvpprojet.R;

/**
 * Created by hspcadmin on 2016/11/4.
 */
public class ComRecyclerAdapter extends RecyclerView.Adapter<ComViewHolder>{

    private Context context;
    private List<ComBody> comBodies;

    public ComRecyclerAdapter(Context context, List<ComBody> bodies){
        this.context = context;
        this.comBodies = bodies;
    }

    public void setComBodies(List<ComBody> bodies){
        this.comBodies = bodies;
    }

    @Override
    public ComViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recycler_list_item, parent, false);

        return new ComViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComViewHolder holder, int position) {

        ComBody comBody = comBodies.get(position);
        holder.bindView(comBody);
    }

    @Override
    public int getItemCount() {
        return comBodies.size();
    }
}
