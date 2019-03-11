package com.example.roompersistanceexample;


import android.os.Bundle;
import android.provider.ContactsContract;
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
public class AddUserFragment extends Fragment {

    //elementy interfejsu - jak na layoucie odpowiadajacym temu fragmentowi
    private EditText userId, userName, userEmail;
    private Button bnSave;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        userId = view.findViewById(R.id.txt_user_id);
        userName = view.findViewById(R.id.txt_name);
        userEmail = view.findViewById(R.id.txt_email);
        bnSave = view.findViewById(R.id.bn_save);

        bnSave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int userid = Integer.parseInt(userId.getText().toString());
                String username = userName.getText().toString();
                String useremail = userEmail.getText().toString();

                //obiekt klasy entity - powiazanej z baza danych
                User user = new User();
                user.setId(userid);
                user.setName(username);
                user.setEmail(useremail);

                MainActivity.myAppDatabase.myDAO().addUser(user);

                Toast.makeText(getActivity(),"User added successfully", Toast.LENGTH_SHORT).show();

                //wyczyszczenie pol formularza po dodani nnowego uzytkownika
                userId.setText("");
                userName.setText("");
                userEmail.setText("");

            }
        });

        return  view;

    }

}
