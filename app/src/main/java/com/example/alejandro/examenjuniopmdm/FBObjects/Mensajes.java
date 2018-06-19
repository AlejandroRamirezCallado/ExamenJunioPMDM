package com.example.alejandro.examenjuniopmdm.FBObjects;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;

/**
 * Created by alejandro on 19/6/18.
 */
@IgnoreExtraProperties
public class Mensajes {
    public String original;

    public HashMap<String,Mensajes> msgs;


    public Mensajes(HashMap<String,Mensajes>msgs){

        this.msgs=msgs;
    }
}
