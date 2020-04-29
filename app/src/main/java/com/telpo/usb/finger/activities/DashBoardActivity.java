package com.telpo.usb.finger.activities;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.registration.RegistrationActivity;
import com.telpo.usb.finger.databinding.ActivityDashBoardBinding;
import com.telpo.usb.finger.utils.AndroidUtils;

public class DashBoardActivity extends AppCompatActivity {

    ActivityDashBoardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dash_board);

        binding.logoutcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), LoginActivityAlt.class);
                startActivity(intent);
                finish();
            }
        });

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoadFragmentTask().execute();
//                Intent intent = new Intent(getBaseContext(), RegistrationActivity.class);
//                startActivity(intent);
            }
        });

        binding.registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), RegisteredActivity.class);
                startActivity(intent);
            }
        });

    }

    private class LoadFragmentTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            AndroidUtils.showProgressDialog(DashBoardActivity.this, "Loading...");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Intent intent = new Intent(getBaseContext(), RegistrationActivity.class);
            startActivity(intent);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            AndroidUtils.dismissProgressDialog();
            super.onPostExecute(result);
        }
    }

}
