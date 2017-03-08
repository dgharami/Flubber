package com.appolica.sample.ui.editor.pager.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.appolica.flubber.AnimationBody;
import com.appolica.sample.ui.editor.AnimationBodyHolder;
import com.appolica.sample.ui.editor.pager.BaseFragment;

public class SettingsFragment
        extends BaseFragment<SettingsRVAdapter>
        implements SettingsRVAdapter.OnModelChangedCallback,
        AnimationBodyHolder {

    public static final String TAG = "SettingsFragment";

    private OnFieldChangedListener fieldChangedListener;
    private AnimationBody animationBody;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getAdapter().setAnimationBody(animationBody);
        getAdapter().setModelChangedCallback(this);
    }

    @Override
    protected SettingsRVAdapter getAdapterInstance() {
        return new SettingsRVAdapter(getContext());
    }

    @Override
    public void onModelChanged(SeekBarModel model) {
        if (fieldChangedListener != null) {
            fieldChangedListener.onFieldChanged(model);
        }
    }

    public void setFieldChangedListener(OnFieldChangedListener fieldChangedListener) {
        this.fieldChangedListener = fieldChangedListener;
    }

    @Override
    public void setAnimationBody(AnimationBody animationBody) {
        this.animationBody = animationBody;
    }
}
