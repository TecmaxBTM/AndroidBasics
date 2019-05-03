package com.hotstar.corngenerator;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {
    EditText etName, etMobile, etEmail;
    Button btLogin;
    private SignUpListener mSignUpListener;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mUserName;
    private String mPassword;

    public SignUpFragment getInstance(String username, String password) {
        SignUpFragment myFragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, username);
        args.putString(ARG_PARAM2, password);
        myFragment.setArguments(args);
        return myFragment;
    }

    public SignUpFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUserName = getArguments().getString(ARG_PARAM1);
            mPassword = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_up, container, false);
        etName = v.findViewById(R.id.editText);
        etEmail = v.findViewById(R.id.editText2);
        etMobile = v.findViewById(R.id.editText3);
        btLogin = v.findViewById(R.id.btSIgnUp);

        etName.setText(mUserName);
        etMobile.setText(mPassword);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WhatsappActivity.replaceFrag(new LoginFragment(),false);
                WhatsappActivity.asdas.setVisibility(View.GONE);
//                mSignUpListener.onSignUpClicked(0);
            }
        });
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SignUpListener) {
            mSignUpListener = (SignUpListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement SignUpListener");
        }
    }
}
