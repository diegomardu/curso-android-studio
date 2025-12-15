package com.example.cursoudemy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toogleSenha;
    private Switch aSwitch;
    private TextView textResultado;

    private CheckBox checkBoxSenha;

    private ProgressBar progressBarHorizontal;

    private ProgressBar progressBarCircular;

    private TextView resultado;

    private SeekBar seekBar;

    private int progresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.progressBarCircular = findViewById(R.id.progressBarCircular);
        this.progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        this.resultado = findViewById(R.id.textViewResultado);
        this.seekBar = findViewById(R.id.seekBarEscala);

        progressBarCircular.setVisibility(View.GONE);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                resultado.setText("Progresso: " + progress + " / " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void recuperarProgresso(View view){
        resultado.setText("Escolhido: " + seekBar.getProgress());
    }



    public void enviar(View view){

        /*if(aSwitch.isChecked()){
            textResultado.setText("Switch ligado");
        }else{
            textResultado.setText("Switch desligado");
        }*/

        if(checkBoxSenha.isChecked()){
            textResultado.setText("checkBox ligado");
        }else{
            textResultado.setText("checkBox desligado");
        }

        adicionarListener();

        /*if(toogleSenha.isChecked()){
            textResultado.setText("toogle ligado");
        }else{
            textResultado.setText("toogle desligado");
        }*/

    }

    public void abrirToast(View view){

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(android.R.drawable.star_big_off);

        TextView view1 = new TextView( getApplicationContext());
        view1.setBackgroundResource(com.google.android.material.R.color.design_default_color_primary);
        view1.setText("Ola toast!");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        //toast.setView(imageView);
        toast.setView(view1);
        toast.show();


        /*
        Toast.makeText(
                getApplicationContext(),
                "Ação realizada com sucesso!",
                Toast.LENGTH_LONG
        ).show();

         */
    }

    public void abrirDialog(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder( this );

        alert.setTitle("Titulo da dialog");
        alert.setMessage("Mensagem da dialog");
        alert.setCancelable(false);
        alert.setIcon(android.R.drawable.ic_dialog_dialer);

        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(
                        getApplicationContext(),
                        "Boa meu garoto!",
                        Toast.LENGTH_LONG).show();
            }
        });

        alert.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(
                        getApplicationContext(),
                        "Ma rapaz tu escolheu não",
                        Toast.LENGTH_LONG).show();
            }
        });

        alert.create().show();
    }

    public void adicionarListener(){
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textResultado.setText("ligado");
                }else{
                    textResultado.setText("desligado");
                }
            }
        });
    }

    public void carregarProgressBar(View view){
        this.progresso += 1;
        progressBarHorizontal.setProgress(progresso);

        progressBarCircular.setVisibility(View.VISIBLE);

        if (progresso == 10){
            progressBarCircular.setVisibility(View.GONE);
        }

    }

}