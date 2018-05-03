package com.sanna.clinica.clinicasanna;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean bandera = false;
    private Button btnIngreso;
    private EditText txt_usuario, txt_clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIngreso = (Button) findViewById(R.id.btn_ingreso);
        txt_usuario = (EditText) findViewById(R.id.txt_usuario);
        txt_clave = (EditText) findViewById(R.id.txt_clave);

        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bandera == false) {
                    bandera = true;
                    String user = txt_usuario.getText().toString();
                    boolean validator = true;

                    if (user.equals("") /* ||  pass.equals("")*/) {
                       /* Toast.makeText(getApplication(), "Ingrese su DNI", Toast.LENGTH_SHORT).show();*/
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                        builder.setMessage("Ingrese DNI");
                        builder.setTitle("Advertencia");
                        builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog dialog=builder.create();
                        dialog.show();

                        txt_usuario.setFocusable(true);
                        validator = false;
                        bandera = false;
                    }

                    if (validator == true) {
                       /* ValidarLogin login = new ValidarLogin();
                        login.execute(user, pass);*/
                        Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }


            }
        });
    }
}
