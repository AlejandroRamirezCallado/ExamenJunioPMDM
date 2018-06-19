package com.example.alejandro.examenjuniopmdm;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    LoginFragment loginFragment;
    RegisterFragment registerFragment;
    FireBaseAdmin fireBaseAdmin;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment=(LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentLogin);
        registerFragment=(RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentRegister);
        MainActivityEvents mainActivityEvents=new MainActivityEvents(this);

        fireBaseAdmin = new FireBaseAdmin();

        loginFragment.setListener(mainActivityEvents);
        registerFragment.setListener(mainActivityEvents);
        fireBaseAdmin.setListener(mainActivityEvents);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(loginFragment);
        transaction.hide(registerFragment);
        transaction.commit();




    }
}
class MainActivityEvents implements LoginFragmentListener, RegisterFragmentListener, FireBaseAdminListener {

    MainActivity mainActivity;
    public MainActivityEvents(MainActivity mainActivity){

        this.mainActivity=mainActivity;
    }

    @Override
    public void loginFragmentLoginButtonClicked(String sUser, String sPassword) {

    }

    @Override
    public void loginFragmentRegisterButtonClicked() {
        FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.hide(mainActivity.loginFragment);
        transaction.show(mainActivity.registerFragment);
        transaction.commit();

    }

    @Override
    public void registerFragmentBtnAceptarClicked(String sUser, String sPass) {
        mainActivity.fireBaseAdmin.registerConEmailYPassword(sUser,sPass, mainActivity);

    }

    @Override
    public void registerFragmentBtnCancelarClicked() {

    }

    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {
        Log.v("MAINACTIVITYEVENTS", "RESULTADO DE REGISTER" + blOK);

    }

    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {

    }
}
