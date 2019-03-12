package com.example.roompersistanceexample;


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

    private EditText txt_userId, txt_userName, txt_userEmail;
    private Button bnUpdate;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  =  inflater.inflate(R.layout.fragment_update, container, false);

        txt_userId = view.findViewById(R.id.txt_update_id);
        txt_userName = view.findViewById(R.id.txt_update_name);
        txt_userEmail = view.findViewById(R.id.txt_update_email);
        bnUpdate = view.findViewById(R.id.bn_update_save);

        bnUpdate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                int userid = Integer.parseInt(txt_userId.getText().toString());
                String username = txt_userName.getText().toString();
                String useremail = txt_userEmail.getText().toString();

                User user = new User();
                user.setId(userid);
                user.setName(username);
                user.setEmail(useremail);

                MainActivity.myAppDatabase.myDAO().updateUser(user);

                Toast.makeText(getActivity(),"User updated successfully", Toast.LENGTH_SHORT).show();

                //wyczyszczenie pol formularza po dodani nnowego uzytkownika
                txt_userId.setText("");
                txt_userName.setText("");
                txt_userEmail.setText("");
            }
        });


        return view;
    }

}
