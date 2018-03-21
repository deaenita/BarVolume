package com.deaenita.barvolume;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLength;
    private EditText edtWidth;
    private EditText edtHeigh;
    private Button btnCalculate;
    private TextView tvResult;
    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btnCalculate.setOnClickListener(this);

        if(savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }
    }

    //TODO. Method untuk save agar saat dirotate hasil tetap tampil
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_HASIL, tvResult.getText().toString());
    }

    private void initView() {
        edtLength = (EditText) findViewById(R.id.edtLength);
        edtWidth = (EditText) findViewById(R.id.edtWidth);
        edtHeigh = (EditText) findViewById(R.id.edtHeigh);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    //TODO. Method yang dijalankan ketika button di klik.
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCalculate){
            String length = edtLength.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            String heigh = edtHeigh.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(length)){
                isEmptyFields = true;
                edtLength.setError("Field tidak boleh kosong");
            }
            if (TextUtils.isEmpty(width)){
                isEmptyFields = true;
                edtWidth.setError("Field tidak boleh kosong");
            }
            if (TextUtils.isEmpty(heigh)){
                isEmptyFields = true;
                edtHeigh.setError("Field tidak boleh kosong");
            }
            if(!isEmptyFields){
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(heigh);
                double volume = l * w * h ;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}
