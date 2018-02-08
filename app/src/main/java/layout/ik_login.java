package layout;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import com.ironkitchen.ironkitchenmob.HomeTabActivity;
import com.ironkitchen.ironkitchenmob.R;
import android.R.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class ik_login extends Fragment implements View.OnClickListener {

    View daView;
    Button logIn;
    EditText email;
    EditText pw;
    TextView regLink;


    public ik_login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        daView = inflater.inflate(R.layout.fragment_ik_login, container, false);
        logIn = (Button) daView.findViewById(R.id.logInB);
        email = (EditText) daView.findViewById(R.id.emailTxt);
        pw = (EditText) daView.findViewById(R.id.pwTxt);
        regLink = (TextView) daView.findViewById(R.id.link_for_register);
        logIn.setOnClickListener(this);
        regLink.setOnClickListener(this);
        return daView;

    }

    @Override
    public void onClick(View view) {
        final FragmentManager fm = getActivity().getSupportFragmentManager();
        Intent thisIntent = new Intent(getActivity(), HomeTabActivity.class);
        String emailS = email.getText().toString();
        if(view == logIn)
        {
            thisIntent.putExtra("email", emailS);
            startActivity(thisIntent);
        }
        else if(view == regLink)
        {
            fm.beginTransaction().replace(R.id.content, new ik_register()).commit();
        }

    }
}
