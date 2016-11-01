package com.example.hola.devfestlp2016.fragmentos;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hola.devfestlp2016.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MensajeFragment extends Fragment implements View.OnClickListener{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public MensajeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mensaje, container, false);

        Button enviar = (Button) view.findViewById(R.id.mensaje_boton_enviar);
        enviar.setOnClickListener(this);

        return view;
    }
    private void limpiarTexto(){
        View view = getView();
        EditText editText = (EditText) view.findViewById(R.id.mensaje_texto);
        editText.getText().clear();
    }
    private void enviarMensaje(){
        View view = getView();
        String mensaje = "";
        String nombre = "";
        EditText editText = (EditText) view.findViewById(R.id.mensaje_texto);
        mensaje = editText.getText().toString();

        editText = (EditText) view.findViewById(R.id.mensaje_nombre);
        nombre = editText.getText().toString();
        if(editText.getText().toString().equals("")&&!mensaje.equals("")){
            Toast.makeText(getContext(),R.string.nombre_introducir, Toast.LENGTH_LONG).show();
        }else if(mensaje.length()<15&&!editText.getText().toString().equals("")){
            Toast.makeText(getContext(),R.string.mensaje_mas_de, Toast.LENGTH_LONG).show();
        }else if(!editText.getText().toString().equals("")){
            String [] emailAdress = {"gdg.bolivia@gmail.com"};

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            //Direccion a quien se envia el Email.
            intent.putExtra(Intent.EXTRA_EMAIL, emailAdress);
            //Asunto del Email.
            intent.putExtra(Intent.EXTRA_SUBJECT, "Mensaje: "+nombre);
            //Mensaje del Email.
            intent.putExtra(Intent.EXTRA_TEXT,mensaje);
            // Verifica si exiten aplicaciones que puedan aceptar este intent de enviar un correo.
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                limpiarTexto();
                startActivity(intent);
            }
        }else{
            Toast.makeText(getContext(), "Por favor introduzca sus Nombre y escriba su mensaje mensaje.", Toast.LENGTH_LONG).show();
        }


    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mensaje_boton_enviar:
                enviarMensaje();
                break;
        }
    }
    @Override
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    getActivity().setTitle("INICIO");
                    fragmentManager = getFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    FragmentInicio inicio = new FragmentInicio();
                   // fragmentTransaction.setCustomAnimations(R.anim.right_in, R.anim.right_out);
                    fragmentTransaction.replace(R.id.contenedor_principal, inicio);
                    //fragmentTransaction.addToBackStack("tag");
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });
    }
}
