package emmrdz.notasdefe.Fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import emmrdz.notasdefe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pantalla_two extends Fragment {


    public Pantalla_two() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pantalla_two, container, false);

        return v;
    }

}
