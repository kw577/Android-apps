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
public class DeleteContactFragment extends Fragment {

    private EditText txt_id;
    private Button button_delete;


    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_contact, container, false);

        txt_id = view.findViewById(R.id.txt_delete_id);
        button_delete = view.findViewById(R.id.delete_contact_bn);

        button_delete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });

        return view;

    }


    private void deleteContact(){
        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());

        //dla uproszczenia operacja na bazie danych w tym ssamym watku
        SQLiteDatabase database = contactDBHelper.getWritableDatabase();

        int id = Integer.parseInt(txt_id.getText().toString());

        contactDBHelper.deleteContact(id, database);
        contactDBHelper.close();

        txt_id.setText("");
        Toast.makeText(getActivity(), "Contact Removed Succesfully...", Toast.LENGTH_SHORT).show();

    }

}
