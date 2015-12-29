package com.vanniktech.onactivityresult.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForResultActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_for_result);
        ButterKnife.bind(this);

        this.setSupportActionBar(toolbar);
    }

    @OnClick(R.id.close_with_resultcode_ok)
    void onResultCodeOkClicked() {
        this.setResult(Activity.RESULT_OK);
        this.finish();
    }

    @OnClick(R.id.close_with_resultcode_cancel)
    void onResultCodeCanceledClicked() {
        this.setResult(Activity.RESULT_CANCELED);
        this.finish();
    }
}
