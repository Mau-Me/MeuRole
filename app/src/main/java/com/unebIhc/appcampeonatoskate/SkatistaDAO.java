package com.unebIhc.appcampeonatoskate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SkatistaDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;


    public SkatistaDAO(Context context) {

        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();

    }

    public long inserirSkatista(Skatista skatista) {

        ContentValues values = new ContentValues();
        values.put("nome", skatista.getNome());
        values.put("paiz", skatista.getPaiz());
        return banco.insert("skatista", null, values);

    }

    public List<Skatista> listaSkatistas() {

        List<Skatista> skatistas = new ArrayList<>();
        Cursor cursor = banco.query("skatista", new String[]{"id", "nome", "paiz"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            Skatista skatista = new Skatista();
            skatista.setId(cursor.getInt(0));
            skatista.setNome(cursor.getString(1));
            skatista.setPaiz(cursor.getString(2));
            skatistas.add(skatista);
        }
        return skatistas;
    }

    public List<Skatista> listaSkatistas(Integer idSkatista) {
        //SQLiteDatabase selectDb = getReadableDatabase();
        List<Skatista> skatistas = new ArrayList<>();
        Skatista skatista = new Skatista();
        String id = null;

        Cursor cursor = banco.query("skatista", new String[]{"id", "nome", "paiz"}, "idSkatista" + " = ?", new String[]{String.valueOf(idSkatista)}, null, null, null);

        while (cursor.moveToNext()) {
            skatista.setId(cursor.getInt(0));
            skatista.setNome(cursor.getString(1));
            skatista.setPaiz(cursor.getString(2));
            skatistas.add(skatista);
        }
        return skatistas;
    }

    public void excluirSkatista(Skatista skatista) {
        banco.delete("skatista", "id =?", new String[]{skatista.getId().toString()});

    }
}

