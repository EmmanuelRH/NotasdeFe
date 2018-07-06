package emmrdz.notasdefe.Fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import emmrdz.notasdefe.Adaptadores.AdapPublicacion;
import emmrdz.notasdefe.Globales.Biblioteca;
import emmrdz.notasdefe.Objetos.Publicacion;
import emmrdz.notasdefe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Screen_Publicacion extends Fragment {

    RecyclerView recyclerView;
    List<Publicacion> publicacionList;
    AdapPublicacion adapPublicacion;
    CollectionReference menuPublicaciones;

    public Screen_Publicacion() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_screen_publicacion, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recicladorPublicaciones);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        publicacionList = new ArrayList<>();
        adapPublicacion = new AdapPublicacion(publicacionList);
        recyclerView.setAdapter(adapPublicacion);

        //agregar el menu con el Id del templo
        return v;
    }

}
