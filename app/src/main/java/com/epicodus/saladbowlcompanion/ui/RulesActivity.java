package com.epicodus.saladbowlcompanion.ui;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.epicodus.saladbowlcompanion.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RulesActivity extends AppCompatActivity {

    @Bind(R.id.rulesTitleTextView) TextView mRulesTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        ButterKnife.bind(this);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf");
        mRulesTitleTextView.setTypeface(font);

    }
}
