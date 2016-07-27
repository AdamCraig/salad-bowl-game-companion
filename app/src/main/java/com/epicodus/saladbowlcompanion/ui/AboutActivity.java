package com.epicodus.saladbowlcompanion.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.epicodus.saladbowlcompanion.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.adamTextView) TextView mAdamTextView;
    @Bind(R.id.ashleyTextView) TextView mAshleyTextView;
    @Bind(R.id.lucaTextView) TextView mLucaTextView;
    @Bind(R.id.nadiyaTextView) TextView mNadiyaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        mAdamTextView.setOnClickListener(this);
        mAshleyTextView.setOnClickListener(this);
        mLucaTextView.setOnClickListener(this);
        mNadiyaTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mAdamTextView) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("https://github.com/AdamCraig"));
            startActivity(browserIntent);
        }
        if (view == mAshleyTextView) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("https://github.com/AshleyRayMaceli"));
            startActivity(browserIntent);
        }
        if (view == mLucaTextView) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("https://github.com/LucaIta"));
            startActivity(browserIntent);
        }
        if (view == mNadiyaTextView) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse("https://github.com/NadinYrosh"));
            startActivity(browserIntent);
        }
    }
}
