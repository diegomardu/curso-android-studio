package com.example.cursoudemy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cursoudemy.R;
import com.example.cursoudemy.activity.adapter.Adapter;
import com.example.cursoudemy.activity.model.Filme;
import com.example.cursoudemy.activity.model.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListView listLocais;
    private String[] itens = {
            "Angra dos Reis", "Caldas novas",
            "Campos do Jordão","Costa do Sauipe","Tiradentes",
            "Ilhéus","Porto Seguro","Praga", "Zurique","Caribe",
            "Buenos Aires","Budapeste", "Cancun", "Aruba","Campina Grande",
            "Cancun","João Pessoa", "São Paulo","Sei mais não.","Paris",
            "Lisboa","Alagoas","Fortaleza","Arapiraca","Natal"
    };

    private List<Filme> listaFilmes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.recyclerView = findViewById(R.id.recyclerView);
        /*this.listLocais = findViewById(R.id.listLocais);

        //cria adaptador para a lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        //adiciona adaptador para a lista
        listLocais.setAdapter(adaptador);

        //adiciona clique na lista
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = listLocais.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),
                        valorSelecionado,
                        Toast.LENGTH_SHORT).show();
            }
        });

         */
        //Listagem de filmes;
        this.criarFilmes();


        //configurar adapter
        Adapter adapter = new Adapter(listaFilmes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click longo: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );


    }

    public void criarFilmes(){
        Filme filme = new Filme("Homen Aranha - De volta ao lar","Aventura","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Mulher maravilha","Fantasia","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("liga da justica","Ficção","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Capitão America","Ficção","2016");
        this.listaFilmes.add(filme);

        filme = new Filme("It: A coisa","Terror","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("pica-pau: O filme","Comédia/Animação","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Múmia","Terror","2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A bela e a fera","Romance","2022");
        this.listaFilmes.add(filme);

        filme = new Filme("O Filme do Pelé","Comédia","1975");
        this.listaFilmes.add(filme);

        filme = new Filme("Meu Malvado Favorito 3","Comédia","2045");
        this.listaFilmes.add(filme);

        filme = new Filme("O grande dragão branco","Ação","1985");
        this.listaFilmes.add(filme);

        filme = new Filme("Carros 23","Animação","xxxx");
        this.listaFilmes.add(filme);

        filme = new Filme("It: A coisa 2","Terror","2020");
        this.listaFilmes.add(filme);

        filme = new Filme("007 um novo dia para morrer","Ação","2000");
        this.listaFilmes.add(filme);

        filme = new Filme("Carros ","Animação","2001");
        this.listaFilmes.add(filme);
    }

}