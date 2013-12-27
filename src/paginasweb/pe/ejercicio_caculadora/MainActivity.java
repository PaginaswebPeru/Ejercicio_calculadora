package paginasweb.pe.ejercicio_caculadora;

import java.awt.font.NumericShaper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsuma, btnresta, btnmultiplicar, btndividir, btnenter, btnc;
	EditText texto;
	
	Double num1, num2, res;
	int contador=0;
	String  cadena="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		texto = (EditText) findViewById(R.id.texto);
		
		btn0 = (Button) findViewById(R.id.btn0);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 = (Button) findViewById(R.id.btn5);
		btn6 = (Button) findViewById(R.id.btn6);
		btn7 = (Button) findViewById(R.id.btn7);
		btn8 = (Button) findViewById(R.id.btn8);
		btn9 = (Button) findViewById(R.id.btn9);
		
		btnsuma = (Button) findViewById(R.id.btnsuma);
		btnresta = (Button) findViewById(R.id.btnresta);
		btnmultiplicar = (Button) findViewById(R.id.btnmultiplicar);
		btndividir = (Button) findViewById(R.id.btndividir);
		btnenter = (Button) findViewById(R.id.btnenter);
		btnc = (Button) findViewById(R.id.btnc);
		
		btn0.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btnsuma.setOnClickListener(this);
		btnresta.setOnClickListener(this);
		btnmultiplicar.setOnClickListener(this);
		btndividir.setOnClickListener(this);
		btnenter.setOnClickListener(this);
		btnc.setOnClickListener(this);
		
		deshabilitaroperaciones();
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btn0:
			escribirnumero("0");
			break;
		case R.id.btn1:
			escribirnumero("1");
			break;
		case R.id.btn2:
			escribirnumero("2");
			break;
		case R.id.btn3:
			escribirnumero("3");
			break;
		case R.id.btn4:
			escribirnumero("4");
			break;
		case R.id.btn5:
			escribirnumero("5");
			break;
		case R.id.btn6:
			escribirnumero("6");
			break;
		case R.id.btn7:
			escribirnumero("7");
			break;
		case R.id.btn8:
			escribirnumero("8");
			break;
		case R.id.btn9:
			escribirnumero("9");
			break;
		case R.id.btnsuma:
			res = num1 + num2;
			texto.setText(num1.toString() + "\n" + num2 + "\n" + res);
			deshabilitaroperaciones();
			break;
		case R.id.btnresta:
			res = num1 - num2;
			texto.setText(num1.toString() + "\n" + num2 + "\n" + res);
			deshabilitaroperaciones();
			break;
		case R.id.btnmultiplicar:
			res = num1 * num2;
			texto.setText(num1.toString() + "\n" + num2 + "\n" + res);
			deshabilitaroperaciones();
			break;
		case R.id.btndividir:
			if(num2 == 0){
				Toast.makeText(getApplicationContext(), "operacion no aceptada", Toast.LENGTH_SHORT).show();
			}
			else{
				res = num1 / num2;
				texto.setText(num1.toString() + "\n" + num2 + "\n" + res);
				deshabilitaroperaciones();
			}
			break;
		case R.id.btnenter:
			switch(contador){
			case 0:
				if(cadena.equals("")){
					Toast.makeText(getApplicationContext(), "Ingrese un numero", Toast.LENGTH_SHORT).show();
				}
				else{
					contador++;
					num1 = Double.parseDouble(cadena);
					texto.setText(num1.toString() + "\n");
					cadena = "";
				}
				break;
			case 1:
				if(cadena.equals("")){
					Toast.makeText(getApplicationContext(), "Ingrese un numero", Toast.LENGTH_SHORT).show();
				}
				else{
					contador++;
					num2 = Double.parseDouble(cadena);
					texto.setText(num1.toString() + "\n" + num2 + "\n");
					cadena = "";
					habilitarOperaciones();
					deshabilitarNumero();
					btnenter.setEnabled(false);
				}
			}
			break;
		case R.id.btnc:
			limpiar();
			break;
		}
	}
	public void escribirnumero(String num){
		switch(contador){
		case 0:
			cadena = cadena + num;
			texto.setText(cadena);
			break;
		case 1:
			cadena = cadena + num;
			texto.setText(num1.toString() + "\n" + cadena);
			break;
		}
	}
	public void deshabilitarNumero(){
		btn0.setEnabled(false);
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
		btn8.setEnabled(false);
		btn9.setEnabled(false);
	}
	public void deshabilitaroperaciones(){
		btnsuma.setEnabled(false);
		btnresta.setEnabled(false);
		btnmultiplicar.setEnabled(false);
		btndividir.setEnabled(false);
	}
	public void habilitarOperaciones(){
		btnsuma.setEnabled(true);
		btnresta.setEnabled(true);
		btnmultiplicar.setEnabled(true);
		btndividir.setEnabled(true);
	}
	public void habilitarnumeros(){
		btn0.setEnabled(true);
		btn1.setEnabled(true);
		btn2.setEnabled(true);
		btn3.setEnabled(true);
		btn4.setEnabled(true);
		btn5.setEnabled(true);
		btn6.setEnabled(true);
		btn7.setEnabled(true);
		btn8.setEnabled(true);
		btn9.setEnabled(true);
	}
	public void limpiar(){
		texto.setText("");
		contador = 0;
		cadena = "";
		num1 = 0.0;
		num2 = 0.0;
		res = 0.0;
		deshabilitaroperaciones();
		habilitarnumeros();
		btnenter.setEnabled(true);
	}

}
