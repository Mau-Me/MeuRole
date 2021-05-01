package com.mclohrk.appcampeonatoskate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BateriaSkatistListActivity extends AppCompatActivity {

    static Bateria bt;
    private ListView listview;
    private SkatistaDAO skatistaDAO;
    private List<Skatista> skatistas;
    private List<Skatista> SkatistasFiltrado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Bateria> bt = new ArrayList<>();
        setContentView(R.layout.activity_bateria_skatist_list);
        Intent intent = getIntent();
        String parametro = (String) intent.getSerializableExtra("Bateria: ");
        TextView nome = findViewById(R.id.textView2);
        nome.setText(parametro);
        Intent intent2 = getIntent();
        startActivity(intent2);

        listview = findViewById(R.id.listaSkatistaBateria);
        skatistaDAO = new SkatistaDAO(this);
        Bateria bat = BateriaSkatistListActivity.bt;
        skatistas = skatistaDAO.listaSkatistas();
        SkatistasFiltrado.addAll(skatistas);

        ArrayAdapter<Skatista> adapter = new ArrayAdapter<Skatista>(this, android.R.layout.simple_list_item_1, SkatistasFiltrado);
        listview.setAdapter(adapter);
        registerForContextMenu(listview);

    }
}
