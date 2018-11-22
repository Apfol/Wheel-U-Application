
package com.reservas.wheelu.wheelu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reservas.wheelu.wheelu.entidades.Reserva;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Reserva> userModelList;

    public Adapter(List<Reserva> userModelList) {
        this.userModelList = userModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementos_lista, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String nombreReserva = userModelList.get(position).getNombreReserva();
        String idRuta = userModelList.get(position).getIDRutaReservada();
        holder.nombreReserva.setText(nombreReserva);
        holder.idRuta.setText(idRuta);
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreReserva;
        private TextView idRuta;
        public ViewHolder(View v) {
            super(v);
            nombreReserva = v.findViewById(R.id.textViewReservaName);
            idRuta = v.findViewById(R.id.textViewReservaRoute);
        }
    }

}
