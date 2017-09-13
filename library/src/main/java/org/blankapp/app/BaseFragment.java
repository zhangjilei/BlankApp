package org.blankapp.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import org.blankapp.util.ViewUtils;

public class BaseFragment extends Fragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewUtils.inject(this, view);
    }

}
