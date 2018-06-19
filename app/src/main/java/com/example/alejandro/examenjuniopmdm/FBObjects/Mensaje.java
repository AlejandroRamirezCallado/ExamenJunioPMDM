package com.example.alejandro.examenjuniopmdm.FBObjects;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by alejandro on 19/6/18.
 */

@IgnoreExtraProperties
public class Mensaje {

    public String original;

    public Mensaje(){

    }

    public Mensaje(String original){
        this.original=original;
    }
}