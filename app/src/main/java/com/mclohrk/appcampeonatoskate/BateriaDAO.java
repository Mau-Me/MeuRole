package com.mclohrk.appcampeonatoskate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BateriaDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public BateriaDAO(Context context) {

        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();

    }


    public long inserirBateria(Bateria bateria) {

        ContentValues values = new ContentValues();
        values.put("nome", bateria.getNome());
        values.put("nomeSkatista", bateria.getSkatista());
        return banco.insert("bateria", null, values);
    }

/*
    public long addSkatistaBateria(Skatista skatista) {

        SkatistaDAO skatistaDAO = new SkatistaDAO();
        skatistaDAO.inserirSkatista(skatista);

        ContentValues values = new ContentValues();

        values.put("skatista", skatista.getId());
        values.put("paiz", skatista.getPaiz());
        values.put("nome", skatista.getNome());
        // Bateria bateria=new Bateria();
        //bateria.
        return banco.insert("skatista", null, values);
    }
*/

    public List<Bateria> listaBateria() {

        List<Bateria> baterias = new ArrayList<>();
        Cursor cursor = banco.query("bateria", new String[]{"id", "nome", "nomeSkatista"}, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Bateria bateria = new Bateria();
            bateria.setId(cursor.getInt(0));
            bateria.setNome(cursor.getString(1));
            bateria.setSkatista(cursor.getString(2));
            baterias.add(bateria);
        }
        return baterias;
    }

    public void excluirBateria(Bateria bateria) {
        banco.delete("bateria", "id =?", new String[]{bateria.getId().toString()});

    }
}
