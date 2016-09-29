package com.kcode.bottommenututorial.bottomsheet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kcode.bottommenututorial.R;

public class BottomSheetActivity extends AppCompatActivity {

    public static Intent newIntent(Context context){
        return new Intent(context,BottomSheetActivity.class);
    }

    private Button mShowBottomSheet;
    private Button mShowBottomSheetModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        //获取到Bottom Sheet对象
        View bottomSheet = findViewById(R.id.design_bottom_sheet);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        //默认设置为隐藏
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        mShowBottomSheet = (Button) findViewById(R.id.button);
        mShowBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet(behavior);
            }
        });

        mShowBottomSheetModel = (Button) findViewById(R.id.fragmentbutton);
        mShowBottomSheetModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialog();
            }
        });
    }

    private void showBottomSheet(BottomSheetBehavior behavior) {
        if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            mShowBottomSheet.setText(R.string.hide_bottom_sheet);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            mShowBottomSheet.setText(R.string.show_bottom_sheet);
        }
    }

    private void showBottomSheetDialog() {
        BottomSheetFragment fragment = BottomSheetFragment.newInstance();
        fragment.show(getSupportFragmentManager(),BottomSheetFragment.class.getSimpleName());
    }

}
