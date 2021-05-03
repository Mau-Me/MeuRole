package com.unebIhc.appcampeonatoskate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SkatistaActivity extends AppCompatActivity {
    private EditText nome;
    private EditText paiz;
    private SkatistaDAO skatistaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skatista);
        nome = findViewById(R.id.editTextNome);
        paiz = findViewById(R.id.editTextPaiz);
        skatistaDAO = new SkatistaDAO(this);
    }

    public void Salvar(View view) {
        Skatista skatista = new Skatista();
        skatista.setNome(nome.getText().toString());
        skatista.setPaiz(paiz.getText().toString());
        skatistaDAO.inserirSkatista(skatista);
        long id = skatistaDAO.inserirSkatista(skatista);
        Toast.makeText(this, "Skatista inserido com  sucesso  "+id, Toast.LENGTH_SHORT).show();
    }
}
