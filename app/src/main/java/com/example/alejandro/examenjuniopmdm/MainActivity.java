package com.example.alejandro.examenjuniopmdm;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    LoginFragment loginFragment;
    RegisterFragment registerFragment;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment=(LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentLogin);
        registerFragment=(RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentRegister);
        MainActivityEvents mainActivityEvents=new MainActivityEvents(this);

        loginFragment.setListener(mainActivityEvents);
        registerFragment.setListener(mainActivityEvents);

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

    }

    @Override
    public void registerFragmentBtnCancelarClicked() {

    }
}
