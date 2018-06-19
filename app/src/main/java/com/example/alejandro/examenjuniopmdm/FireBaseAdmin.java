package com.example.alejandro.examenjuniopmdm;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by alejandro on 19/6/18.
 */

public class FireBaseAdmin {
    private FirebaseAuth mAuth;
    public FireBaseAdminListener listener;

    public FireBaseAdmin(){

        mAuth = FirebaseAuth.getInstance();

    }

    public void setListener(FireBaseAdminListener listener){

        this.listener=listener;
    }
    public void loginConEmailYPassword(String email, String pass, Activity activity){
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Log.d("FirebaseAdmin", "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {

                        }
                        else {
                            
                        }


                    }
                });
    }
}
