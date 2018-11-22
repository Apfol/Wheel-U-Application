package com.reservas.wheelu.wheelu.actividades.CRUDReservas.modificar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.reservas.wheelu.wheelu.R;
import com.reservas.wheelu.wheelu.actividades.MenuActivity;
import com.reservas.wheelu.wheelu.entidades.Pasajero;
import com.reservas.wheelu.wheelu.entidades.Reserva;

public class ModificarRealizadoActivity extends AppCompatActivity {

    TextView textviewNombreReserva, textviewIDRuta, textviewCorreoPasajero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_realizado);

        Reserva reservaActualizada = (Reserva) getIntent().getExtras().getSerializable(ModificarActivity.RESERVA_KEY);

        textviewCorreoPasajero = findViewById(R.id.textViewCorreo);
        textviewNombreReserva= findViewById(R.id.textViewNombre);
        textviewIDRuta = findViewById(R.id.textViewIDRuta);

        textviewIDRuta.setText(reservaActualizada.getIDRutaReservada());
        textviewCorreoPasajero.setText(reservaActualizada.getCorreoPasajero());
        textviewNombreReserva.setText(reservaActualizada.getNombreReserva());

    }
}
