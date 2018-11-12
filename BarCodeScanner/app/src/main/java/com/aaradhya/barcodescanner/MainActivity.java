package com.aaradhya.barcodescanner;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
ZXingScannerView zXingScannerView;
ArrayList<String> resultlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zXingScannerView=findViewById(R.id.scanner);
        resultlist=new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        MediaPlayer player= MediaPlayer.create(getApplicationContext(),R.raw.beep01a);
        player.start();
        Toast.makeText(this, result.getText()+" format "+result.getBarcodeFormat(), Toast.LENGTH_SHORT).show();
        resultlist.add(result.getText());
    }

    public void reusmeCamera(View view) {
        zXingScannerView.resumeCameraPreview(this);
    }

    public void viewResult(View view) {
        Intent intent=new Intent(MainActivity.this, com.aaradhya.barcodescanner.Result.class);
        intent.putStringArrayListExtra("scanned_result",resultlist);
        startActivity(intent);
    }
}
