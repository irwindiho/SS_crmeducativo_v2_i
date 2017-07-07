package com.consultoraestrategia.ss_crmeducativo.login.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.util.Log;
import android.view.ViewGroup;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.google.zxing.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler, Transition.TransitionListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.content_frame_qr)
    ViewGroup contentFrame;
    private ZXingScannerView mScannerView;


    private static final String TAG = "QrScanner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner);
        ButterKnife.bind(this);
        initToolbar();
        mScannerView = new ZXingScannerView(QrScanner.this);
        contentFrame.addView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();



    }

    @Override
    protected void onPause() {


        if (mScannerView != null) {
            mScannerView.stopCamera();
            mScannerView = null;
            contentFrame.removeAllViews();

        }
        super.onPause();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("   Scan QR");
        getSupportActionBar().setIcon(R.drawable.ic_qr_code_scan);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // contentFrame.setTransitionName("view");
            getWindow().getSharedElementEnterTransition().addListener(this);
            toolbar.setTransitionName("view");
        }
    }


    @Override
    public void handleResult(Result result) {
        // Do something with the result here
        Log.v(TAG, result.getText()); // Prints scan results
        Log.v(TAG, result.getBarcodeFormat().name()); // Prints the scan format (qrcode, pdf417 etc.)

        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
        Intent data = new Intent();
        data.putExtra("data_qr", result.getText());
        setResult(Activity.RESULT_OK, data);
        finish();

    }

    @Override
    public void onBackPressed() {

        if (mScannerView != null) {
            mScannerView.stopCamera();
            mScannerView = null;
            contentFrame.removeAllViews();

        }

        super.onBackPressed();

    }


    @Override
    public void onTransitionStart(Transition transition) {

    }

    @Override
    public void onTransitionEnd(Transition transition) {
        if (mScannerView != null) {
            mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
            mScannerView.startCamera();      // Start camera on resume
        }
    }

    @Override
    public void onTransitionCancel(Transition transition) {

    }

    @Override
    public void onTransitionPause(Transition transition) {

    }

    @Override
    public void onTransitionResume(Transition transition) {

    }
}
