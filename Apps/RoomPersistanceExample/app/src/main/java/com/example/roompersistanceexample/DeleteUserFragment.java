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
public class DeleteUserFragment extends Fragment {

    private EditText txtUserId;
    private Button deleteButton;


    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        txtUserId = view.findViewById(R.id.txt_delete_id);
        deleteButton = view.findViewById(R.id.delete_user_bn);

        deleteButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(txtUserId.getText().toString());
                User user = new User();

                user.setId(id);
                MainActivity.myAppDatabase.myDAO().deleteUser(user);

                Toast.makeText(getActivity(), "User succesfully removed...", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

}
