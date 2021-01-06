package com.telpo.usb.finger.activities;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Telephony;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.ProdFromDealerAdapter;
import com.telpo.usb.finger.databinding.ActivityReceiveInputsBinding;
import com.telpo.usb.finger.entities.AvailablePackages;
import com.telpo.usb.finger.entities.ProductsFromDealer;
import com.telpo.usb.finger.interfaces.Constants;
import com.telpo.usb.finger.service.BluetoothChatService;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.GridSpacingItemDecoration;
import com.telpo.usb.finger.utils.SmsBroadcastReceiver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class ReceiveInputsActivity extends AppCompatActivity {
    private static final String TAG = "BluetoothChatFragment";
    // Intent request codes
    private static final int REQUEST_CONNECT_DEVICE_SECURE = 1;
    private static final int REQUEST_CONNECT_DEVICE_INSECURE = 2;
    private static final int REQUEST_ENABLE_BT = 3;
    ActivityReceiveInputsBinding binding;
    ProdFromDealerAdapter adapter;
    List<ProductsFromDealer> fromDealerList;
    String senderadd = "";
    String contract = "";
    StringBuilder parts;
    int msglength = 0;
    boolean firstin = false;
    private SmsBroadcastReceiver smsBroadcastReceiver;
    /**
     * Name of the connected device
     */
    private String mConnectedDeviceName = null;
    /**
     * The Handler that gets information back from the BluetoothChatService
     */
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constants.MESSAGE_STATE_CHANGE:
                    switch (msg.arg1) {
                        case BluetoothChatService.STATE_CONNECTED:
                            Toasty.normal(getApplicationContext(), getString(R.string.title_connected_to, mConnectedDeviceName)).show();


                            break;
                        case BluetoothChatService.STATE_CONNECTING:
                            Toasty.normal(getApplicationContext(), getString(R.string.title_connecting));
                            break;
                        case BluetoothChatService.STATE_LISTEN:
                        case BluetoothChatService.STATE_NONE:
                            Toasty.normal(getApplicationContext(), getString(R.string.title_not_connected));
                            break;
                    }
                    break;
                case Constants.MESSAGE_WRITE:
                    byte[] writeBuf = (byte[]) msg.obj;
                    // construct a string from the buffer
                    String writeMessage = new String(writeBuf);
                    //TODO:
                    break;
                case Constants.MESSAGE_READ:
                    byte[] readBuf = (byte[]) msg.obj;
                    // construct a string from the valid bytes in the buffer
                    String readMessage = new String(readBuf, 0, msg.arg1);
                    Toasty.success(getApplicationContext(), readMessage).show();

                    if (readMessage.contains("UCLMSG"))
                        manipulateandsaveinputs(readMessage);
                    //TODO:
                    break;
                case Constants.MESSAGE_DEVICE_NAME:
                    // save the connected device's name
                    mConnectedDeviceName = msg.getData().getString(Constants.DEVICE_NAME);
                    if (null != getApplicationContext()) {
                        Toast.makeText(getApplicationContext(), "Connected to "
                                + mConnectedDeviceName, Toast.LENGTH_SHORT).show();
                    }
                    break;
                case Constants.MESSAGE_TOAST:
                    if (null != getApplicationContext()) {
                        Toast.makeText(getApplicationContext(), msg.getData().getString(Constants.TOAST),
                                Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };
    /**
     * Array adapter for the conversation thread
     */
    private ArrayAdapter<String> mConversationArrayAdapter;
    /**
     * String buffer for outgoing messages
     */
    private StringBuffer mOutStringBuffer;
    /**
     * Local Bluetooth adapter
     */
    private BluetoothAdapter mBluetoothAdapter = null;
    /**
     * Member object for the chat services
     */
    private BluetoothChatService mChatService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_receive_inputs);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fromDealerList = new ArrayList<>();
        parts = new StringBuilder();

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBluetoothAdapter == null) {
            Toasty.error(getApplicationContext(), "Bluetooth not supported").show();
        }

        setuprecycler();
        smsBroadcastReceiver = new SmsBroadcastReceiver();
        smsBroadcastReceiver.setListener(new SmsBroadcastReceiver.Listener() {
            @Override
            public void onTextReceived(String text, String senderaddress) {
                senderadd = senderaddress;
                if (text.startsWith("*^")) {
                    String length = text.split(" ")[0];

                    msglength = Integer.parseInt(length.replace("*^", " ").trim());
                    Log.d("SPLITTING", "" + msglength);
                    Toasty.normal(getApplicationContext(), "" + msglength).show();
                    firstin = true;
                }
                if (text.startsWith("*")) {
                    if (text.startsWith("*^")) {
                        parts.append(text.replace("*^", " "));
                    } else if (text.startsWith("*"))
                        parts.append(text.replace('*', ' '));

                    msglength--;
                    Toasty.normal(getApplicationContext(), "" + msglength).show();
                    if (msglength == 0) {
                        binding.content.accept.setVisibility(View.VISIBLE);
                        binding.content.recycler.setVisibility(View.VISIBLE);

                        if (binding.content.animationView.isAnimating())
                            binding.content.animationView.pauseAnimation();
                        binding.content.animationView.setVisibility(View.GONE);
                        binding.content.text.setVisibility(View.GONE);

                        Log.d("SPLITTING", parts.toString());
                        manipulateandsaveinputs(parts.toString());
                        parts = new StringBuilder();
                        firstin = false;
                    }
                } else {
                    binding.content.accept.setVisibility(View.VISIBLE);
                    binding.content.recycler.setVisibility(View.VISIBLE);

                    if (binding.content.animationView.isAnimating())
                        binding.content.animationView.pauseAnimation();
                    binding.content.animationView.setVisibility(View.GONE);
                    binding.content.text.setVisibility(View.GONE);

                    Log.d("SPLITTING", text);
                    manipulateandsaveinputs(text);
                }
            }
        });

        binding.content.acceptbtn.setOnClickListener(v -> {
            final MaterialDialog progDialog = new MaterialDialog.Builder(this)
                    .content("Sending Confirmation. Please wait...")
                    .progress(true, 0)
                    .cancelable(false)
                    .build();
            progDialog.show();

            mHandler.postDelayed(() -> {
                progDialog.dismiss();
                sendMessage("ACCEPTED");
                savetoinventory();
                Toasty.success(getApplicationContext(), "Transaction successful").show();
            }, 1000);
        });

        binding.content.declinebtn.setOnClickListener(v -> {
            final MaterialDialog progDialog = new MaterialDialog.Builder(this)
                    .content("Declining inputs. Please wait...")
                    .progress(true, 0)
                    .cancelable(false)
                    .build();
            progDialog.show();

            mHandler.postDelayed(() -> {
                progDialog.dismiss();
                sendMessage("DECLINED");
            }, 1000);
        });
    }

    private void manipulateandsaveinputs(String text) {

        String[] generalsplit = text.split(" ");
        String dealername = "input dealer";

        if (!generalsplit[3].equalsIgnoreCase("acknowledge")) {
            try {
                StringBuilder pkgname = new StringBuilder();

                String[] init = text.split("\\[");

                Log.d("SPLITTING", "fIRST SPLIT: " + init[1]);

                //GET TOTAL COST
                String[] pricesplit = init[0].split(" ");
                Log.d("SPLITTING", "fIRST SPLIT get price: " + pricesplit[12]);

                String[] _2ndsplit = init[1].split("]");
                Log.d("SPLITTING", "SECOND SPLIT: " + _2ndsplit[0]);
                Log.d("SPLITTING", "SECOND SPLIT 2: " + _2ndsplit[1]);

                //GET PACKAGENAME
                String[] pkgnamesplit = _2ndsplit[1].split(" ");
                dealername = pkgnamesplit[pkgnamesplit.length - 1];

                for (int i = 7; i < pkgnamesplit.length; i++) {

                    if (!pkgnamesplit[i].toLowerCase().contains("package")) {
                        pkgname.append(pkgnamesplit[i]).append(" ");
                    } else break;
//                        else {
//                            contract = pkgnamesplit[i].split("~")[1];
//                        }
                }
                for (int i = 7; i < pkgnamesplit.length; i++) {

                    if (pkgnamesplit[i].toLowerCase().contains("package"))
                        contract = pkgnamesplit[i].split("~")[1].split("\\.")[0];
                }

                Log.d("SPLITTING", "SECOND SPLIT 2 package name: " + pkgname.toString());
                Log.d("SPLITTING", "SECOND SPLIT 2 delearname: " + dealername);
                Log.d("SPLITTING", "SECOND SPLIT 2 contract: " + contract);

                String[] _3rdsplit = _2ndsplit[0].split(",");
                for (String temp : _3rdsplit) {
                    ProductsFromDealer products = new ProductsFromDealer();
                    Log.d("SPLITTING", "THIRD SPLIT products: " + temp);
                    String[] productsplit_1 = temp.split("\\(");
                    String[] productsplit_2 = productsplit_1[1].split("\\)");
                    Log.d("SPLITTING", "THIRD SPLIT product name: " + productsplit_1[0]);
                    Log.d("SPLITTING", "THIRD SPLIT price: " + productsplit_2[1].trim());
                    Log.d("SPLITTING", "THIRD SPLIT quantity: " + productsplit_2[0].replace('x', ' ').trim());

                    products.pname = productsplit_1[0];
                    products.item_img = AndroidUtils.getimg(productsplit_1[0], getResources());
                    products.subprice = productsplit_2[1].replaceAll("\\s+", "");
                    products.agentid = AndroidUtils.getPreferenceData(ReceiveInputsActivity.this, AndroidUtils.AGENTID, "");
                    products.agentname = AndroidUtils.getPreferenceData(ReceiveInputsActivity.this, AndroidUtils.AGENTNAME, "");
                    products.imei = AndroidUtils.getIMEI(getApplicationContext());
                    products.uniqueuid = AndroidUtils.getUUID();
                    products.macaddress = AndroidUtils.getMacAddress(getApplicationContext());
                    products.datecreated = new Date();
                    products.supplier = dealername;
                    products.price = "0.00";
                    products.pid = AndroidUtils.COUPOUNORDERID + products.getUniqueuid();
                    products.quantity = productsplit_2[0].replace('x', ' ').replaceAll("\\s+", "");
                    products.packagename = pkgname.toString().trim();
                    products.category = AndroidUtils.getcategory(productsplit_1[0]);
                    products.pdesc = " ";
                    fromDealerList.add(products);
                }
                binding.content.accept.setVisibility(View.VISIBLE);
                binding.content.recycler.setVisibility(View.VISIBLE);

                if (binding.content.animationView.isAnimating())
                    binding.content.animationView.pauseAnimation();
                binding.content.animationView.setVisibility(View.GONE);
                binding.content.text.setVisibility(View.GONE);
                adapter.additems();
            } catch (Exception e) {
                e.printStackTrace();
                Toasty.error(getApplicationContext(), "An error occurred").show();
            }
        }
    }

    private void savetoinventory() {
        boolean found = false;
        List<AvailablePackages> availablePackagesList = AvailablePackages.listAll(AvailablePackages.class);
        if (availablePackagesList.size() > 0) {
            for (AvailablePackages availablePackages : availablePackagesList) {
                if (fromDealerList.get(0).getPackagename().toLowerCase().equals(availablePackages.getPackagename().toLowerCase())) {
                    found = true;
                    List<ProductsFromDealer> list = ProductsFromDealer.find(ProductsFromDealer.class, "packagename=?", fromDealerList.get(0).getPackagename());

                    if (list.size() > 0){
                        for (ProductsFromDealer fromDealer: list){
                            for (int i = 0; i < fromDealerList.size(); i++){
                                if (fromDealer.getPname().equalsIgnoreCase(fromDealerList.get(i).getPname())){
                                    int sum = Integer.parseInt(fromDealer.getQuantity()) + Integer.parseInt(fromDealerList.get(i).getQuantity());
                                    fromDealerList.get(i).quantity =String.valueOf(sum);
                                    ProductsFromDealer.delete(fromDealer);
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }

        if (!found) {
            AvailablePackages availablePackages1 = new AvailablePackages();
            availablePackages1.datecreated = new Date();
            availablePackages1.packagename = fromDealerList.get(0).getPackagename();
            availablePackages1.contract = contract.split(":")[0];
            availablePackages1.recoverybagsperacre = contract.split(":")[1];
            try {
                availablePackages1.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (ProductsFromDealer products : fromDealerList) {
            try {
                products.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        binding.content.accept.setVisibility(View.GONE);
        binding.content.recycler.setVisibility(View.GONE);
        fromDealerList = new ArrayList<>();
        adapter.additems();
        if (!binding.content.animationView.isAnimating())
            binding.content.animationView.playAnimation();
        binding.content.animationView.setVisibility(View.VISIBLE);
        binding.content.text.setVisibility(View.VISIBLE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CONNECT_DEVICE_SECURE:
                // When DeviceListActivity returns with a device to connect
                if (resultCode == Activity.RESULT_OK) {
                    connectDevice(data, true);
                }
                break;
            case REQUEST_CONNECT_DEVICE_INSECURE:
                // When DeviceListActivity returns with a device to connect
                if (resultCode == Activity.RESULT_OK) {
                    connectDevice(data, false);
                }
                break;
            case REQUEST_ENABLE_BT:
                // When the request to enable Bluetooth returns
                if (resultCode == Activity.RESULT_OK) {
                    // Bluetooth is now enabled, so set up a chat session

                    Intent discoverableIntent =
                            new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
                    startActivity(discoverableIntent);

                    setupChat();
                } else {
                    // User did not enable Bluetooth or an error occurred
                    Log.d(TAG, "BT not enabled");
                    Toasty.error(getApplicationContext(), getString(R.string.bt_not_enabled_leaving),
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    private void setupChat() {

        // Initialize the BluetoothChatService to perform bluetooth connections
        mChatService = new BluetoothChatService(ReceiveInputsActivity.this, mHandler);

        // Initialize the buffer for outgoing messages
        mOutStringBuffer = new StringBuffer();
    }

    /**
     * Sends a message.
     *
     * @param message A string of text to send.
     */
    public void sendMessage(String message) {
        // Check that we're actually connected before trying anything
        if (mChatService.getState() != BluetoothChatService.STATE_CONNECTED) {
            Toasty.error(getApplicationContext(), getString(R.string.not_connected)).show();
            return;
        }

        // Check that there's actually something to send
        if (message.length() > 0) {
            // Get the message bytes and tell the BluetoothChatService to write
            byte[] send = message.getBytes();
            mChatService.write(send);

            // Reset out string buffer to zero and clear the edit text field
            mOutStringBuffer.setLength(0);
        }
    }

    /**
     * Establish connection with other device
     *
     * @param data   An {@link Intent} with {@link DeviceListActivity#EXTRA_DEVICE_ADDRESS} extra.
     * @param secure Socket Security type - Secure (true) , Insecure (false)
     */
    private void connectDevice(Intent data, boolean secure) {
        // Get the device MAC address
        String address = data.getExtras()
                .getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);
        // Get the BluetoothDevice object
        BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        // Attempt to connect to the device
        mChatService.connect(device, secure);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(1000);
        filter.addAction(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        registerReceiver(smsBroadcastReceiver, filter);
        if (mChatService != null) {
            // Only if the state is STATE_NONE, do we know that we haven't started already
            if (mChatService.getState() == BluetoothChatService.STATE_NONE) {
                // Start the Bluetooth chat services
                mChatService.start();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mChatService != null) {
            mChatService.stop();
        }
        unregisterReceiver(smsBroadcastReceiver);
    }

    @Override
    public void onStart() {
        super.onStart();
        // If BT is not on, request that it be enabled.
        // setupChat() will then be called during onActivityResult
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
            // Otherwise, setup the chat session
        } else if (mChatService == null) {
            setupChat();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bluetooth_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.secure_connect_scan: {
                // Launch the DeviceListActivity to see devices and do scan
                Intent serverIntent = new Intent(ReceiveInputsActivity.this, DeviceListActivity.class);
                startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE_SECURE);
                return true;
            }
            case R.id.insecure_connect_scan: {
                // Launch the DeviceListActivity to see devices and do scan
                Intent serverIntent = new Intent(ReceiveInputsActivity.this, DeviceListActivity.class);
                startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE_INSECURE);
                return true;
            }
            case R.id.discoverable: {
                // Ensure this device is discoverable by others
                ensureDiscoverable();
                return true;
            }
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void ensureDiscoverable() {
        if (mBluetoothAdapter.getScanMode() !=
                BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
            Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivity(discoverableIntent);
        }
    }

    private void setuprecycler() {
        adapter = new ProdFromDealerAdapter(this, fromDealerList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        binding.content.recycler.setLayoutManager(mLayoutManager);
        binding.content.recycler.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        binding.content.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.content.recycler.setAdapter(adapter);
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
