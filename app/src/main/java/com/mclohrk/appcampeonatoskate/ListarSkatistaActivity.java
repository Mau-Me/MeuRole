package com.mclohrk.appcampeonatoskate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class ListarSkatistaActivity extends AppCompatActivity {

    private ListView listview;
    private SkatistaDAO skatistaDAO;
    private List<Skatista> skatistas;
    private List<Skatista> SkatistasFiltrado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__skatista_);
        listview = findViewById(R.id.listarSkatistas);
        skatistaDAO = new SkatistaDAO(this);
        skatistas = skatistaDAO.listaSkatistas();
        SkatistasFiltrado.addAll(skatistas);
        ArrayAdapter<Skatista> adapter = new ArrayAdapter<Skatista>(this, android.R.layout.simple_list_item_1, SkatistasFiltrado);
        listview.setAdapter(adapter);
        registerForContextMenu(listview);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                buscaSkatista(newText);
                return false;
            }
        });
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contexto, menu);

    }

    public void buscaSkatista(String str) {
        SkatistasFiltrado.clear();
        for (Skatista skatista : skatistas) {
            if (skatista.getPaiz().toLowerCase().contains(str.toLowerCase())) {
                SkatistasFiltrado.add(skatista);
            }
        }
        listview.invalidateViews();
    }

    public void cadastrar(MenuItem item) {
        Intent intent = new Intent(this, SkatistaActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        skatistas = skatistaDAO.listaSkatistas();
        SkatistasFiltrado.clear();
        SkatistasFiltrado.addAll(skatistas);
        listview.invalidate();
    }

    public List<Skatista> getSkatistas(Integer idSkatista) {
        skatistas = skatistaDAO.listaSkatistas();
        SkatistasFiltrado.clear();
        SkatistasFiltrado.addAll(skatistas);
        return skatistas;
    }

    public void excl(MenuItem mItem) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) mItem.getMenuInfo();
        final Skatista exclSkatista = SkatistasFiltrado.get(menuInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Atencion =/").setMessage("vou excluir o cara,  viu?")
                .setNegativeButton("NO", null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SkatistasFiltrado.remove(exclSkatista);
                        skatistas.remove(exclSkatista);
                        skatistaDAO.excluirSkatista(exclSkatista);
                        listview.invalidateViews();
                    }
                }).create();
        dialog.show();

    }

}
