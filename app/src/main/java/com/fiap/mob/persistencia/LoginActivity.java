package com.fiap.mob.persistencia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    CheckBox chkConectado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        checkConectado();
    }

    public void logar(View v){

        String usuario = ((EditText) findViewById(R.id.edtUsuario)).getText().toString();
        String senha = ((EditText) findViewById(R.id.edtSenha)).getText().toString();
        chkConectado = (CheckBox) findViewById(R.id.chkConectado);

        Boolean continuarLogado = chkConectado.isChecked();

        if(usuario.equals("admin") && senha.equals("123")){

            salvarPreferencias(usuario,continuarLogado);
            abrirTela();

        }


    }
    private void abrirTela(){

        startActivity(new Intent(this,LivrosActivity.class));
        finish();
    }

    private void checkConectado(){

        SharedPreferences settings = getSharedPreferences("PREFERENCIAS",MODE_PRIVATE);

        if(settings.getBoolean("manterConectado",false)){

            abrirTela();
        }
    }
    private void salvarPreferencias(String usuario, Boolean isConectado){
        SharedPreferences settings = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();
        editor.putString("usuario", usuario);
        editor.putBoolean("manterConectado",isConectado);
        editor.commit();

    }
}
