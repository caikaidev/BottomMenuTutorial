package com.kcode.bottomlib;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.kcode.bottomlib.utils.AnimationUtils;

/**
 * Created by caik on 2017/3/20.
 */

public class BottomDialog extends DialogFragment {

    public static BottomDialog newInstance(String title, String[] items) {

        Bundle args = new Bundle();
        args.putString("title", title);
        args.putStringArray("items", items);
        BottomDialog fragment = new BottomDialog();
        fragment.setArguments(args);
        return fragment;
    }

    private String mTitle;
    private String[] items;
    private View mRootView;
    private OnClickListener mListener;

    public void setListener(OnClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        initData();
        mRootView = inflater.inflate(R.layout.bottom_lib_layout, container, false);
        AnimationUtils.slideToUp(mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView titleView = (TextView) view.findViewById(R.id.title);
        if (TextUtils.isEmpty(mTitle)) {
            view.findViewById(R.id.titleLayout).setVisibility(View.GONE);
        }else {
            titleView.setText(mTitle);
        }

        ListView listView = (ListView) view.findViewById(R.id.bottom_lib_listView);
        listView.setAdapter(new ArrayAdapter(getContext(),R.layout.bottom_lib_item,R.id.item,items));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mListener != null) {
                    mListener.click(position);
                }
            }
        });


        Button cancel = (Button) view.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationUtils.slideToDown(mRootView, new AnimationUtils.AnimationListener() {
                    @Override
                    public void onFinish() {
                        dismiss();
                    }
                });
            }
        });
    }

    private void initData() {
        mTitle = getArguments().getString("title");
        items = getArguments().getStringArray("items");
    }

    public interface OnClickListener {
        void click(int position);
    }
}
