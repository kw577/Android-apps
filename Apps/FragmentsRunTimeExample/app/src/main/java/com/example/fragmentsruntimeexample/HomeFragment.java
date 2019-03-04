package com.example.fragmentsruntimeexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button button;

    //konstruktor
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        button = view.findViewById(R.id.b1); // przycisk b1 zdefiniowany w fragment_home.xml

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new FirstFragment(), null)
                        .addToBackStack(null).commit();//addToBackStack - dzieki temu po wcisneciu przycisku powrotu w telefonie - uzytkownik zostanie ponownie przeniesiony na strone startowa aplikacji
            }
        });

        return view;
    }

}
