package com.example.alejandro.examenjuniopmdm;

/**
 * Created by alejandro on 19/6/18.
 */

public class DataHolder {

    public static DataHolder instance= new DataHolder();

    public FireBaseAdmin fireBaseAdmin;

    public DataHolder(){
        fireBaseAdmin = new FireBaseAdmin();
    }

}
