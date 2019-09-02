package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.adapter.NossoAdapter;
import com.example.listview.modelos.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Tarefa> tarefas = new ArrayList<>();
    private ArrayAdapter<Tarefa> arrayAdapterTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        criarTarefas();
        listView = findViewById(R.id.list_view_tarefas);
        arrayAdapterTarefa = new NossoAdapter(MainActivity.this,
                (ArrayList<Tarefa>) tarefas);
        listView.setAdapter(arrayAdapterTarefa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //faz alguma coisa quando clica na lista
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Teste",
                        Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
    public void criarTarefas(){
        this.tarefas.add(new Tarefa("1", "Estudar android", false));
        this.tarefas.add(new Tarefa("2", "Projeto Integrador", false));
        this.tarefas.add(new Tarefa("3", "Warframe", true));
        this.tarefas.add(new Tarefa("4", "League of Legends", true));
    }
}
