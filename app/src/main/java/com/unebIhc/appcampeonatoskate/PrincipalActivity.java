package com.unebIhc.appcampeonatoskate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Button btnTelaSkatista = findViewById(R.id.btnSkatista);
        btnTelaSkatista.setOnClickListener(this);
        Button btnTelaBateria = findViewById(R.id.btnBateriasav);
        btnTelaBateria.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSkatista:
                Intent intentSkatist = new Intent(this, ListarSkatistaActivity.class);
                startActivity(intentSkatist);
                break;
            case R.id.btnBateriasav:
                Intent intentBat = new Intent(this,ListarBateriaActivity.class);
                startActivity(intentBat);
                break;
        }


    }

}
