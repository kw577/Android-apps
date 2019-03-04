package com.example.fragmentscommunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private EditText editText;
    private Button button;
    OnMessageReadListener onMessageReadListener;

    public MessageFragment() {
        // Required empty public constructor
    }

    //definiujemy listener - mozna tez w osobnym pliku
    public interface OnMessageReadListener{
        public void onMessageRead(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        //text_message i bn to komponenty zdefinioiwane w fragment_message.xml
        editText = view.findViewById(R.id.text_message);
        button = view.findViewById(R.id.bn);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();

                onMessageReadListener.onMessageRead(message);
            }
        });


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try{
            onMessageReadListener = (OnMessageReadListener) activity;
        } catch (ClassCastException e){
            throw  new ClassCastException(activity.toString() + " must override OnMessegeRead...");
        }
    }
}
