package com.project.wechat.home.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.project.wechat.home.bean.ComBody;

import appframework.com.mvpprojet.R;

/**
 * Created by hspcadmin on 2016/11/4.
 */
public class ComViewHolder extends RecyclerView.ViewHolder {

    private TextView titleView,contentView;


    public ComViewHolder(View itemView) {
        super(itemView);

        titleView = (TextView) itemView.findViewById(R.id.item_title);
        contentView = (TextView) itemView.findViewById(R.id.item_content);
    }

    public void bindView(ComBody comBody){
        titleView.setText(comBody.title);
        contentView.setText(comBody.content);
    }
}
