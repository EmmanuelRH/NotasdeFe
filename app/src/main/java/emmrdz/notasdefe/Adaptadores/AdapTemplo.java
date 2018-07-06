package emmrdz.notasdefe.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import emmrdz.notasdefe.Objetos.Templo;
import emmrdz.notasdefe.Publicaciones;
import emmrdz.notasdefe.R;

public class AdapTemplo extends RecyclerView.Adapter<AdapTemplo.AdapTemploViewHolder>{

    List<Templo> temploList;

    public AdapTemplo(List<Templo> temploList) {
        this.temploList = temploList;
    }

    @NonNull
    @Override
    public AdapTemploViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_templos, parent, false);
        AdapTemploViewHolder holder = new AdapTemploViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapTemploViewHolder holder, int position) {
            Templo templo = temploList.get(position);

            holder.nombre.setText(templo.getNombre());
            holder.direccion.setText(templo.getDireccion());
            holder.agrupacion.setText(templo.getAgrupacion());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(holder.context, Publicaciones.class);
                    holder.context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return temploList.size();
    }

    public static class AdapTemploViewHolder extends RecyclerView.ViewHolder{

        TextView nombre, agrupacion, direccion;
        CardView cardView;
        Context context;

        public AdapTemploViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            cardView = (CardView) itemView.findViewById(R.id.cv_templo);
            nombre = (TextView) itemView.findViewById(R.id.templo_nombre);
            agrupacion = (TextView) itemView.findViewById(R.id.templo_agrupacion);
            direccion = (TextView) itemView.findViewById(R.id.templo_direccion);
        }
    }
}
