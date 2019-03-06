package com.example.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {

    private EditText update_id, update_name, update_email;
    private Button update_bn;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        // przypisanie do odpowiednich komponentow gui
        update_id = view.findViewById(R.id.txt_update_id);
        update_name = view.findViewById(R.id.txt_update_name);
        update_email = view.findViewById(R.id.txt_update_email);
        update_bn = view.findViewById(R.id.bn_update_save);

        update_bn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                updateContact();
            }
        });

        return view;
    }


    private void updateContact(){

        int id = Integer.parseInt(update_id.getText().toString());
        String name = update_name.getText().toString();
        String email = update_email.getText().toString();


        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
        SQLiteDatabase database = contactDBHelper.getWritableDatabase();


        // UWAGA !!! Poprawnie powinno sie przeprowadzac operacje na bazie danych w osobnym watku

        contactDBHelper.updateContact(id, name, email, database);

        contactDBHelper.close();

        //okno dialogowe z potwierdzeniem
        Toast.makeText(getActivity(), "Contact updated...", Toast.LENGTH_SHORT).show();


        //Wyczyszczenie pol formularza
        update_id.setText("");
        update_name.setText("");
        update_email.setText("");
    }


}
