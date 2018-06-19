package com.example.alejandro.examenjuniopmdm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.alejandro.examenjuniopmdm.Adapters.ListaCochesAdapters;
import com.example.alejandro.examenjuniopmdm.FBObjects.FBCoche;
import com.example.alejandro.examenjuniopmdm.FBObjects.Mensaje;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    public ListaMensajesFragment listaMensajesFragment, listaFragmentCoches;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondActivityEvents events = new SecondActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);

        listaMensajesFragment=(ListaMensajesFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListaMensajes);
        listaFragmentCoches=(ListaMensajesFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListaCoches);

        DataHolder.instance.fireBaseAdmin.descargarYObservarRama("messages");
        DataHolder.instance.fireBaseAdmin.descargarYObservarRama("Coches");



//        Log.v("SecondActivity", "-----Email usuario" +  DataHolder.instance.fireBaseAdmin);

    }
}

class SecondActivityEvents implements FireBaseAdminListener{

    SecondActivity secondActivity;

    public SecondActivityEvents(SecondActivity secondActivity){
        this.secondActivity=secondActivity;
    }


    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {

    }

    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {

    }

    @Override
    public void fireBaseAdmin_RamaDescargargada(String rama, DataSnapshot dataSnapshot) {

        Log.v("SecondActivity", rama + "--------"+dataSnapshot);

        if(rama.equals("messages")){
            GenericTypeIndicator<Map<String,Mensaje>> indicator = new GenericTypeIndicator<Map<String,Mensaje>>(){};
            Map<String,Mensaje> msgs=dataSnapshot.getValue(indicator);
            Log.v("SecondActivity", "OBJETO MENSAJE TIENE: " + msgs);

            ListaMensajesAdapter listaMensajesAdapter = new ListaMensajesAdapter(new ArrayList<Mensaje>(msgs.values()));
            secondActivity.listaMensajesFragment.recyclerView.setAdapter(listaMensajesAdapter);

        }else if(rama.equals("Coches")){
            GenericTypeIndicator<Map<String,FBCoche>> indicator = new GenericTypeIndicator<Map<String,FBCoche>>(){};
            Map<String,FBCoche> coches=dataSnapshot.getValue(indicator);
            Log.v("SecondActivity", "coches MENSAJE TIENE: " + coches);

            ListaCochesAdapters listaCochesAdapter = new ListaCochesAdapters(coches);
            secondActivity.listaFragmentCoches.recyclerView.setAdapter(listaCochesAdapter);

        }



        //Mensaje mensaje = dataSnapshot.getValue(Mensaje.class);




    }
}