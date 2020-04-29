package com.telpo.usb.finger.activities;

import android.animation.LayoutTransition;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.telpo.usb.finger.MainNavigationDrawerAlt;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.ActivityLoginAltBinding;
import com.telpo.usb.finger.editfragments.IPSettingsFragment;
import com.telpo.usb.finger.entities.ServiceProviders;
import com.telpo.usb.finger.entities.ServiceType;
import com.telpo.usb.finger.entities.Templates;
import com.telpo.usb.finger.pojo.LoginSuccessPojo;
import com.telpo.usb.finger.pojo.Message;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.AsyncRequest;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

import br.com.ilhasoft.support.validation.Validator;
import es.dmoral.toasty.Toasty;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivityAlt extends AppCompatActivity implements AsyncRequest.OnAsyncRequestComplete {

    public static final String PREF = "prepare_inputs";
    ActivityLoginAltBinding binding;
    LoginSuccessPojo loginSuccessPojo;
    Validator validator;
    AnimationDrawable anim;
    String[] listitems;
    boolean runsaves = false;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            binding.cover.setVisibility(View.VISIBLE);
            binding.form.setVisibility(View.VISIBLE);
        }
    };
    Map<String, String> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_alt);
        validator = new Validator(binding);

        AndroidUtils.checkPermissions(this);
//        ProductsFromDealer.deleteAll(ProductsFromDealer.class);
//        AvailablePackages.deleteAll(AvailablePackages.class);
//        Products.deleteAll(Products.class);

        ViewGroup layout = binding.emailLoginForm;
        LayoutTransition layoutTransition = layout.getLayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);

//        binding.container.setBackgroundResource(R.drawable.animation_list);
//        anim = (AnimationDrawable) binding.container.getBackground();
//        anim.setEnterFadeDuration(6000);
//        anim.setExitFadeDuration(4000);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash
        binding.btnlogin.setOnClickListener(view -> {
            //Intent intent = new Intent(getBaseContext(), DashBoardActivity.class);
            AndroidUtils.hideKeyboard(LoginActivityAlt.this);
            try {
                if (validator.validate()) {
                    if (AndroidUtils.getPreferenceData(LoginActivityAlt.this, AndroidUtils.IPCOMPLETEPREF, "").isEmpty()) {
                        runsaves = true;
                        FragmentManager fm = getSupportFragmentManager();
                        IPSettingsFragment ipSettingsFragment = new IPSettingsFragment();
                        ipSettingsFragment.show(fm, "Dialog Fragment");
                        String agentid = AndroidUtils.getPreferenceData(LoginActivityAlt.this, AndroidUtils.AGENTID, "");
                        String agentname = AndroidUtils.getPreferenceData(LoginActivityAlt.this, AndroidUtils.AGENTNAME, "");

//                        AndroidUtils.insertInput(
//                                "insecticides",
//                                "Lumax",
//                                "Lumax weedicides",
//                                AndroidUtils.INSECTICIDE + AndroidUtils.getUUID(),
//                                "2000",
//                                "65.00",
//                                "MOFA",
//                                "52.00",
//                                AndroidUtils.drawableToArray(R.drawable.lumax, getResources()),
//                                AndroidUtils.getUUID(),
//                                new Date(),
//                                AndroidUtils.getMacAddress(LoginActivityAlt.this),
//                                AndroidUtils.getIMEI(LoginActivityAlt.this),
//                                agentname,
//                                agentid,
//                                "l"
//                        );
//                        AndroidUtils.insertInput(
//                                "weedicide",
//                                "Landlord",
//                                "LandLord weedicides",
//                                AndroidUtils.WEEDICIDE + AndroidUtils.getUUID(),
//                                "2000",
//                                "20.00",
//                                "AGRA",
//                                "16.00",
//                                AndroidUtils.drawableToArray(R.drawable.landlord, getResources()),
//                                AndroidUtils.getUUID(),
//                                new Date(),
//                                AndroidUtils.getMacAddress(LoginActivityAlt.this),
//                                AndroidUtils.getIMEI(LoginActivityAlt.this),
//                                agentname,
//                                agentid,
//                                "l"
//                        );
//                        AndroidUtils.insertInput(
//                                "seed",
//                                "Lake 601 White Maize",
//                                "Lake 601 White Maize",
//                                AndroidUtils.SEED + AndroidUtils.getUUID(),
//                                "2000",
//                                "250",
//                                "UCL USA",
//                                "30.00",
//                                AndroidUtils.drawableToArray(R.drawable.lake, getResources()),
//                                AndroidUtils.getUUID(),
//                                new Date(),
//                                AndroidUtils.getMacAddress(LoginActivityAlt.this),
//                                AndroidUtils.getIMEI(LoginActivityAlt.this),
//                                agentname,
//                                agentid,
//                                "bag(s)"
//                        );
                    } else {
                        new UserLoginTask().execute();
                        AndroidUtils.hideKeyboard(LoginActivityAlt.this);
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
    }

    public void loginRequest() {
        params = new HashMap<>();
        params.put("username", binding.username.getText().toString());
        params.put("password", binding.password.getText().toString());
        AsyncRequest getPosts = new AsyncRequest(LoginActivityAlt.this, "GET", params);
        getPosts.execute(AndroidUtils.SERVER_URL + "/login");
    }

    @Override
    public void asyncResponse(String response) {
        if (StringUtils.isNotBlank(response) && !StringUtils.endsWithIgnoreCase(response, "empty")) {
            try {
                loginSuccessPojo = new Gson().fromJson(response, LoginSuccessPojo.class);
            } catch (Exception ex) {
                try {
                    Message msg = new Gson().fromJson(response, Message.class);
                    Toasty.error(this, msg.getMsg()).show();
                    ex.printStackTrace();
                } catch (Exception e) {

                }
            }

            if (loginSuccessPojo != null) {
                if (loginSuccessPojo.getStatus() != null) {
                    if (loginSuccessPojo.getStatus().equalsIgnoreCase("success")) {
                        AndroidUtils.savePreferenceData(LoginActivityAlt.this, AndroidUtils.AGENTID, loginSuccessPojo.getStaffid());
                        AndroidUtils.savePreferenceData(LoginActivityAlt.this, AndroidUtils.AGENTNAME, loginSuccessPojo.getLoginname());
                        AndroidUtils.savePreferenceData(LoginActivityAlt.this, AndroidUtils.PASSWORD, binding.password.getText().toString());

                        Intent intent = new Intent(getBaseContext(), MainNavigationDrawerAlt.class);
                        startActivity(intent);
                        finish();
                    } else {
                        binding.loginProgress.setVisibility(View.GONE);
                        binding.loginForm.setVisibility(View.VISIBLE);
                        Toasty.error(this, "Username or Password Incorrect!").show();
                    }
                } else {
                    binding.loginProgress.setVisibility(View.GONE);
                    binding.loginForm.setVisibility(View.VISIBLE);
                    Toasty.error(this, "Login Error!").show();
                }

            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (anim != null && !anim.isRunning())
//            anim.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (anim != null && anim.isRunning())
//            anim.stop();
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private String mEmail;
        private String mPassword;

        UserLoginTask() {
        }

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }


        @Override
        protected void onPreExecute() {
            binding.loginProgress.setVisibility(View.VISIBLE);
            binding.loginForm.setVisibility(View.GONE);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {

                if (runsaves) {
                    listitems = getResources().getStringArray(R.array.serviceprovider);

                    for (String list : listitems) {
                        try {
                            new ServiceProviders(AndroidUtils.genserviceproviderID(), list, list, "").save();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    listitems = getResources().getStringArray(R.array.servicetype);

                    for (String list : listitems) {
                        try {
                            new ServiceType(list, AndroidUtils.genservicetypeID(), AndroidUtils.getUUID()).save();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    listitems = getResources().getStringArray(R.array.templates);

                    for (String list : listitems) {
                        try {
                            new Templates(list).save();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    runsaves = false;
                }

                String agentid = AndroidUtils.getPreferenceData(LoginActivityAlt.this, AndroidUtils.AGENTID, "");
                String agentname = AndroidUtils.getPreferenceData(LoginActivityAlt.this, AndroidUtils.AGENTNAME, "");
                String password = AndroidUtils.getPreferenceData(LoginActivityAlt.this, AndroidUtils.PASSWORD, "");
                if (StringUtils.isNotBlank(agentid) && StringUtils.isNotBlank(agentname) && StringUtils.isNotBlank(password)) {
                    if (binding.username.getText().toString().trim().equals(agentname) && binding.password.getText().toString().trim().equals(password)) {
                        Intent intent = new Intent(getBaseContext(), MainNavigationDrawerAlt.class);
                        startActivity(intent);
                        finish();
                    } else {
                        loginRequest();
                    }
                } else {
                    loginRequest();
                }
            } catch (Exception e) {
                return false;

            }
            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            //mAuthTask = null;
            //showProgress(false);

            if (success) {
                // finish();
            } else {
//                mPasswordView.setError(getString(R.string.error_incorrect_password));
//                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            //mAuthTask = null;
            //showProgress(false);
        }
    }
}

