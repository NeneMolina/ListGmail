package com.movilespascual.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] idImagen = {
                R.drawable.img,
                R.drawable.img_1,
                R.drawable.img_2,
                R.drawable.img_3,
                R.drawable.img_4,
                R.drawable.img_5,
        };

        String[] nombre = {
               "Facebook",
               "Instagram",
                "Malcom",
                "Pascual Bravo",
                "Samsung",
                "Twitter"
        };

        String[] ultimoMensaje ={
                "Solicitud de amistad", "Me gusta tu estado","URGENTE","SICAU","Garantía","Nuevo retwitt"
        };

        String[] ultimoAsunto ={
                "Daniela quiere ser tu amiga en Facebook, porfavor no la ignores", "A jorge le gusta tu foto, estas muy lindo","No se te olvide el party de hoy, no podemos dejar a las chicas esperando","Nelson ha actualizado tus notas en SICAU por buen estudiante","Ven y recoge tu equipo ya esta listo y no nos vuelvas a molestar","laura ha retwitteado tu publicación, eres de lo que no hay"
        };

        String[] horaUltimoMensaje ={
                "10:30", "20:50","00:01","03:44","10:45","13:56"
        };


        String[] numeroTelefono ={
                "+573452222", "+344333444","'358976410","+578765243","+349087652","+577121298"
        };

        String[] pais ={
                "Colombia", "USA","Colombia","Perú","Alemania","Suiza"
        };




        ListAdapter listAdapter = new ListAdapter(MainActivity.this, nombre,ultimoMensaje,ultimoAsunto, horaUltimoMensaje,numeroTelefono,pais,idImagen);
        lista = (ListView) findViewById(R.id.listaView);
        lista.setAdapter(listAdapter);
        //agregar listener para cuando se hace click sobre el item
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                //Agregar el intent
                Intent irAinformacion = new Intent(MainActivity.this,UserActivity.class)
                        .putExtra("nombre",nombre[posicion])
                        .putExtra("asunto", ultimoAsunto[posicion])
                        .putExtra("mensaje", ultimoMensaje[posicion])
                        .putExtra("hora",horaUltimoMensaje[posicion])
                        .putExtra("telefono",numeroTelefono[posicion])
                        .putExtra("pais",pais[posicion])
                        .putExtra("imagen",idImagen[posicion]);

                startActivity(irAinformacion);
            }
        });

    }
}