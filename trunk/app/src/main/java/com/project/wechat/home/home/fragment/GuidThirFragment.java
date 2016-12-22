package com.project.wechat.home.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.project.wechat.home.home.HomeActivity;

import appframework.com.mvpprojet.R;

/**
 * Created by hspcadmin on 2016/11/4.
 */
public class GuidThirFragment extends Fragment {

    public GuidThirFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_guide_thir, container, false);

        ImageView imgView = (ImageView) view.findViewById(R.id.start_main);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), HomeActivity.class));
            }
        });

        return view;
    }
}
