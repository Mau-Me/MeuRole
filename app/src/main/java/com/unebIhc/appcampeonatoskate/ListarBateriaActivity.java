package com.unebIhc.appcampeonatoskate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListarBateriaActivity extends AppCompatActivity {

    public final static String LISTAR_BAT_ACTVTY = "ListarBateriaActivity";
    private ListView listview;
    private BateriaDAO bateriaDAO;
    private List<Bateria> baterias;
    private List<Bateria> bateriasFiltrado = new ArrayList<Bateria>();
    private SkatistaDAO skatistaDAO;
    private List<Skatista> skatistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_bateria);
        listview = findViewById(R.id.listaBaterias);
        bateriaDAO = new BateriaDAO(this);
        baterias = bateriaDAO.listaBateria();
        bateriasFiltrado.addAll(baterias);
        ArrayAdapter<Bateria> adapter = new ArrayAdapter<Bateria>(this, android.R.layout.simple_list_item_1, bateriasFiltrado);
        listview.setAdapter(adapter);
        registerForContextMenu(listview);
/*        Intent it = new Intent(this, BateriaSkatistListActivity.class);
        it.putExtra("bat", (Parcelable) baterias);*/
    }

    @Override
    public void onResume() {
        super.onResume();
        baterias = bateriaDAO.listaBateria();
        bateriasFiltrado.clear();
        bateriasFiltrado.addAll(baterias);
        listview.invalidate();
    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contexto_bateria, menu);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), baterias.get(position).getNome(), Toast.LENGTH_SHORT).show();

                ArrayList<Bateria> bt = new ArrayList<>();
                Intent intent = new Intent(ListarBateriaActivity.this, BateriaSkatistListActivity.class);
                BateriaSkatistListActivity.bt = baterias.get(position);
                startActivity(intent);
/*

                Bateria bateria = new Bateria();
                bateria = baterias.get((position));
                intent.putExtra("bateria", bateria.getId());
                Toast.makeText(getBaseContext(), baterias.get((int) id).getNome(), Toast.LENGTH_SHORT).show();*/
                /*
                abre lista de skatista
                pega id da bateria
                joga id no metodo buscarbateria
                busca skatista com id bateria
                retorna lista de skatistas
                retorna lista em view
                .2 click em skatista para add
                * */
            }
        });

    }

    public void cadastrarBat(MenuItem item) {
        Intent intent = new Intent(this, BateriaActivity.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bateria, menu);
        return true;
    }

    public void buscaBateriaId(Integer i) {


        for (Bateria bateria : baterias) {
            if (bateria.getId() == i) {
                bateriasFiltrado.add(bateria);
            }
        }
        listview.invalidateViews();

    }


}
