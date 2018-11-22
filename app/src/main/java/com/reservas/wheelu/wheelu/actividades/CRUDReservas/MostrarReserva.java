package com.reservas.wheelu.wheelu.actividades.CRUDReservas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.reservas.wheelu.wheelu.R;
import com.reservas.wheelu.wheelu.actividades.CRUDReservas.modificar.ModificarActivity;
import com.reservas.wheelu.wheelu.actividades.MenuActivity;
import com.reservas.wheelu.wheelu.entidades.Reserva;

public class MostrarReserva extends AppCompatActivity {
    TextView textviewNombreReserva, textviewIDRuta, textviewCorreoPasajero,tituloMostrarReserva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_reserva);

        Reserva reservaActualizada = (Reserva) getIntent().getExtras().getSerializable(ModificarActivity.RESERVA_KEY);



        tituloMostrarReserva = findViewById(R.id.tituloMostrarReserva);
        textviewCorreoPasajero = findViewById(R.id.textViewCorreoM);
        textviewNombreReserva= findViewById(R.id.textViewNombreM);
        textviewIDRuta = findViewById(R.id.textViewIdRutaM);

        tituloMostrarReserva.setText(getIntent().getExtras().getString(MenuActivity.TITULO_KEY));
        textviewIDRuta.setText(reservaActualizada.getIDRutaReservada());
        textviewCorreoPasajero.setText(reservaActualizada.getCorreoPasajero());
        textviewNombreReserva.setText(reservaActualizada.getNombreReserva());

    }

}
