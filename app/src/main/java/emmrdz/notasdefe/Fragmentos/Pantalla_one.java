package emmrdz.notasdefe.Fragmentos;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import emmrdz.notasdefe.Adaptadores.AdapTemplo;
import emmrdz.notasdefe.Globales.Biblioteca;
import emmrdz.notasdefe.Objetos.Templo;
import emmrdz.notasdefe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pantalla_one extends Fragment {

    public Pantalla_one() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    AdapTemplo adapTemplo;
    List<Templo> temploList;
    SwipeRefreshLayout swipeRefreshLayout;
    CollectionReference menuTemplos;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pantalla_one, container, false);

        progressBar = (ProgressBar) v.findViewById(R.id.progressTemplos);

        recyclerView = (RecyclerView) v.findViewById(R.id.recicladorTemplos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        temploList = new ArrayList<>();
        adapTemplo = new AdapTemplo(temploList);
        recyclerView.setAdapter(adapTemplo);

        menuTemplos = FirebaseFirestore.getInstance().collection(Biblioteca.REF_TEMPLOS);

        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.refreshTemplos);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                new Handler(Looper.myLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        query();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1500);
            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        query();
    }

    private void query() {

        menuTemplos.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    temploList.removeAll(temploList);
                    for (DocumentSnapshot documentSnapshot : task.getResult()){
                        Templo templo = documentSnapshot.toObject(Templo.class);
                        temploList.add(templo);
                    }
                    adapTemplo.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }else{
                    Toast.makeText(getActivity(), "Hubo un error al obtener informacion", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
