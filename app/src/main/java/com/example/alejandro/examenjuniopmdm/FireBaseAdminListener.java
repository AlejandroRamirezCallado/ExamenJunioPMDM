package com.example.alejandro.examenjuniopmdm;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by alejandro on 19/6/18.
 */

interface FireBaseAdminListener {
    public void fireBaseAdmin_RegisterOK(boolean blOK);
    public void fireBaseAdmin_LoginOK(boolean blOK);
    public void fireBaseAdmin_RamaDescargargada(String rama, DataSnapshot dataSnapshot);
}
