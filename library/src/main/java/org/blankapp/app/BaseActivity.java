package org.blankapp.app;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import org.blankapp.util.ViewUtils;

public class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ViewUtils.inject(this);
    }

}
