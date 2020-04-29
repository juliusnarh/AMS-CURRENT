package com.telpo.usb.finger.activities;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.AggregatorAdapter;
import com.telpo.usb.finger.databinding.ActivityAggregatorTestBinding;
import com.telpo.usb.finger.pojo.Aggregator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AggregatorTest extends AppCompatActivity {

    private static final String URL_AGGREGATORS = "https://uclgroupgh.com/UCLAMS/main/Registration/androidGetAggregator.php";
    List<Aggregator> aggregatorList;
    ActivityAggregatorTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_aggregator_test);
        binding.recycler.setHasFixedSize(true);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        aggregatorList = new ArrayList<>();

        loadAggregators();

    }

    private void loadAggregators() {

        /*
         * Creating a String Request
         * The request type is GET defined by first parameter
         * The URL is defined in the second parameter
         * Then we have a Response Listener and a Error Listener
         * In response listener we will get the JSON response as a String
         * */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_AGGREGATORS,
                response -> {
                    try {
                        //converting the string to json array object
                        JSONArray array = new JSONArray(response);

                        //traversing through all the object
                        for (int i = 0; i < array.length(); i++) {

                            //getting product object from json array
                            JSONObject aggregator = array.getJSONObject(i);

                            //adding the product to product list
                            aggregatorList.add(new Aggregator(
                                    aggregator.getString("aggregatorid"),
                                    aggregator.getString("names"),
                                    aggregator.getString("telephone"),
                                    aggregator.getString("address"),
                                    aggregator.getString("contactperson"),
                                    "",
                                    aggregator.getString("role"),
                                    aggregator.getString("region"),
                                    aggregator.getString("district"),
                                    aggregator.getString("croptype")
                            ));
                        }

                        //creating adapter object and setting it to recyclerview
                        AggregatorAdapter adapter = new AggregatorAdapter(AggregatorTest.this, aggregatorList);
                        binding.recycler.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.d("VOLLEY", error.getMessage()));

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
