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
public class AddContactFragment extends Fragment {

    private Button bnSave;
    EditText txt_id, txt_name, txt_email;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        bnSave = view.findViewById(R.id.bn_save);
        txt_id = view.findViewById(R.id.txt_contact_id);
        txt_name = view.findViewById(R.id.txt_contact_name);
        txt_email = view.findViewById(R.id.txt_contact_email);

        bnSave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String id = txt_id.getText().toString();
                String name = txt_name.getText().toString();
                String email = txt_email.getText().toString();


                //dodanie kontaktu do bazy danych SQLite
                //operacje zapisu do bazy danych powinno sie wykonac w osobnym watku
                //tu dla uproszczenia aplikacji pomiija sie zastosowanie watkow
                ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
                SQLiteDatabase database = contactDBHelper.getWritableDatabase();
                contactDBHelper.addContact(Integer.parseInt(id), name, email, database);

                //zamkniecie polaczenia z baza danych
                contactDBHelper.close();

                // wyczyszczenie pol formularza
                txt_id.setText("");
                txt_name.setText("");
                txt_email.setText("");

                //okno dialogowe z informacja o dodaniu kontaktu do bazy danych
                Toast.makeText(getActivity(), "Contact Saved Succesfully", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

}
