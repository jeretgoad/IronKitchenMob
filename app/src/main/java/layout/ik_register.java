package layout;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ironkitchen.ironkitchenmob.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ik_register extends Fragment implements View.OnClickListener{

    View daView;
    Button regBut;
    EditText name;
    EditText pw;
    EditText pwVer;
    EditText email;
    EditText emailVer;
    TextView ik;

    public ik_register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        daView =  inflater.inflate(R.layout.fragment_ik_register, container, false);
        ik = (TextView)daView.findViewById(R.id.ikTitle);
        Typeface customFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/UrbanJungleDEMO.ttf");
        regBut = (Button) daView.findViewById(R.id.registerB);
        regBut.setOnClickListener(this);
        return daView;
    }

    @Override
    public void onClick(View view) {
        final FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.content, new ik_login()).commit();
    }
}
