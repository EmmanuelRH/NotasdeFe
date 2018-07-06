package emmrdz.notasdefe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import emmrdz.notasdefe.Adaptadores.AdapPublicacion;
import emmrdz.notasdefe.Globales.Biblioteca;
import emmrdz.notasdefe.Objetos.Publicacion;

public class Publicaciones extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Publicacion> publicacionList;
    AdapPublicacion adapPublicacion;
    CollectionReference menuPublicaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicaciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView = (RecyclerView) findViewById(R.id.recicladorPublicaciones);
        recyclerView.setLayoutManager(new LinearLayoutManager(Publicaciones.this));

        publicacionList = new ArrayList<>();
        adapPublicacion = new AdapPublicacion(publicacionList);
        recyclerView.setAdapter(adapPublicacion);

        //agregar el menu con el Id del templo

        menuPublicaciones = FirebaseFirestore.getInstance().collection(Biblioteca.REF_PUB);
    }

    @Override
    protected void onStart() {
        super.onStart();

        query();
    }

    private void query() {

        menuPublicaciones.orderBy("date", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                    if (e != null){
                        Toast.makeText(Publicaciones.this, "Error al consultar", Toast.LENGTH_LONG).show();
                    }else{
                        if (documentSnapshots != null){
                            publicacionList.removeAll(publicacionList);
                            for (DocumentSnapshot documents: documentSnapshots.getDocuments()) {
                                Publicacion publicacion = documents.toObject(Publicacion.class);
                                publicacionList.add(publicacion);
                            }
                            adapPublicacion.notifyDataSetChanged();
                        }else{

                        }
                    }
            }
        });
    }
}

