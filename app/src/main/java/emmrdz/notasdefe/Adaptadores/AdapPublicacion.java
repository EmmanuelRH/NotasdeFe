package emmrdz.notasdefe.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import emmrdz.notasdefe.Objetos.Publicacion;
import emmrdz.notasdefe.R;

public class AdapPublicacion extends RecyclerView.Adapter<AdapPublicacion.AdapPublicacionViewHolder>{

    List<Publicacion> publicacionList;

    public AdapPublicacion(List<Publicacion> publicacionList) {
        this.publicacionList = publicacionList;
    }

    @NonNull
    @Override
    public AdapPublicacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_publicacion, parent, false);
        AdapPublicacionViewHolder holder = new AdapPublicacionViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapPublicacionViewHolder holder, int position) {
            Publicacion publicacion = publicacionList.get(position);

            holder.titulo.setText(publicacion.getTitulo());
            holder.fecha.setText(publicacion.getFecha());
            holder.contenido.setText(publicacion.getContenido());
            holder.referencia.setText(publicacion.getReferencia());

            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


    }

    @Override
    public int getItemCount() {
        return publicacionList.size();
    }

    public static class AdapPublicacionViewHolder extends RecyclerView.ViewHolder {

        private CardView cv;
        private TextView titulo, fecha, contenido,  referencia;
        private Button add;
        private Context context;

        public AdapPublicacionViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            cv = (CardView) itemView.findViewById(R.id.cv_publicacion);
            titulo = (TextView) itemView.findViewById(R.id.pub_titulo);
            fecha = (TextView) itemView.findViewById(R.id.pub_fecha);
            contenido = (TextView) itemView.findViewById(R.id.pub_contenido);
            referencia = (TextView) itemView.findViewById(R.id.pub_referencia);
            add = (Button) itemView.findViewById(R.id.pub_btn_agregar);
        }
    }
}
