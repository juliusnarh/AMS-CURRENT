package com.telpo.usb.finger.activities;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.activities.input.distribution.FarmAssessmentForm;
import com.telpo.usb.finger.activities.input.distribution.InputDistMainActivity;
import com.telpo.usb.finger.activities.input.distribution.RecoveryActivity;
import com.telpo.usb.finger.activities.profile.ProfileActivity;
import com.telpo.usb.finger.databinding.ActivityFarmerSearchServerDetailsBinding;
import com.telpo.usb.finger.entities.ActivityInfo;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Farms;
import com.telpo.usb.finger.entities.GetSingleFarmerInfoServer;
import com.telpo.usb.finger.entities.LocationCoordinates;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.entities.SupportDocs;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.utils.AndroidUtils;
import com.telpo.usb.finger.utils.Constants;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class FarmerSearchServerDetailsActivity extends AppCompatActivity {
    ActivityFarmerSearchServerDetailsBinding binding;
    GetSingleFarmerInfoServer farmerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_farmer_search_server_details);
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        String imageTransitionName = intent.getStringExtra("transname");
        farmerInfo = new Gson().fromJson(AndroidUtils.getPreferenceData(this, Constants.DETAILS, ""), GetSingleFarmerInfoServer.class);
        String pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS";
        binding.farmerid.setText(farmerInfo.getFarmerid());
        binding.farmcount.setText(getResources().getString(R.string.farm_count, farmerInfo.getFarms().size()));
        binding.community.setText(farmerInfo.getCommunity());
        binding.contact.setText(farmerInfo.getTel());
        binding.farmername.setText(farmerInfo.getName());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.farmerimg.setTransitionName(imageTransitionName);
            Glide.with(this)
                    .load(convertToDrawable(image))
                    .apply(RequestOptions.circleCropTransform())
                    .into(binding.farmerimg);
        }

        List<Farmers> farmer = Farmers.find(Farmers.class, "farmerid = ?", farmerInfo.getFarmerid());

        if (farmer.size() <= 0) {
            String farmersSaved = AndroidUtils.getPreferenceData(FarmerSearchServerDetailsActivity.this, Constants.SAVED_SERVER_FARMER, "");
            if (AndroidUtils.getPreferenceData(FarmerSearchServerDetailsActivity.this, Constants.SAVED_SERVER_FARMER, "").length() > 0) {
                AndroidUtils.savePreferenceData(FarmerSearchServerDetailsActivity.this, Constants.SAVED_SERVER_FARMER, farmersSaved + "," + farmerInfo.getFarmerid());
            } else
                AndroidUtils.savePreferenceData(FarmerSearchServerDetailsActivity.this, Constants.SAVED_SERVER_FARMER, farmerInfo.getFarmerid());

            try {
                Farmers farmers = new Farmers();
                farmers.farmerid = farmerInfo.getFarmerid();
                farmers.surname = farmerInfo.getSurname();
                farmers.othername = farmerInfo.getOthernames();
                farmers.placeofbirth = farmerInfo.getPlaceofbirth();
                farmers.dateofbirth = AndroidUtils.dateStringToDate(farmerInfo.getDateofbirth().getDate(), pattern);
                farmers.age = AndroidUtils.datetoage(farmers.dateofbirth);
                farmers.gender = farmerInfo.getGender();
                farmers.hometown = farmerInfo.getHometowm();
                farmers.address = farmerInfo.getAddress();
                farmers.district = farmerInfo.getDistrict();
                farmers.region = farmerInfo.getRegion();
                farmers.country = farmerInfo.getCountry();
                farmers.idcardtype = farmerInfo.getIdcardtype();
                farmers.idcardno = String.valueOf(farmerInfo.getIdcardnumber());
                farmers.community = farmerInfo.getCommunity();
                farmers.levelofeducation = farmerInfo.getLevelofeducation();
                farmers.religion = farmerInfo.getReligion();
                farmers.maritalstatus = farmerInfo.getMaritalstatus();
                farmers.email = farmerInfo.getEmail();
                farmers.levelofeducation = farmerInfo.getLevelofeducation();
                farmers.postbox = farmerInfo.getPostbox();
                farmers.tel = farmerInfo.getTel();
                farmers.macaddress = farmerInfo.getMacaddress();
                farmers.imei = farmerInfo.getImei();
                farmers.uniqueuid = farmerInfo.getUniqueuid();
                farmers.agentname = farmerInfo.getAgentname();
                farmers.agentid = farmerInfo.getAgentid();
                farmers.save();


                ActivityInfo info = new ActivityInfo();
                info.farmerid = farmerInfo.getFarmerid();
                info.groupname = farmerInfo.getFarmergroup();
                info.coopname = farmerInfo.getCooperative();
                info.incomesource = farmerInfo.getIncomesource();
                info.fundingsource = String.valueOf(farmerInfo.getFundingsource());
                info.macaddress = farmerInfo.getMacaddress();
                info.imei = farmerInfo.getImei();
                info.uniqueuid = farmerInfo.getUniqueuid();
                info.agentname = farmerInfo.getAgentname();
                info.agentid = farmerInfo.getAgentid();
                info.save();

                List<GetSingleFarmerInfoServer.FarmsBean> farmsBeanList = farmerInfo.getFarms();
                for (GetSingleFarmerInfoServer.FarmsBean xyz : farmsBeanList) {
                    Farms farms = new Farms();
                    farms.farmid = xyz.getFarmid();
                    farms.farmerid = farmerInfo.getFarmerid();
                    farms.district = xyz.getDistrict();
                    farms.region = xyz.getRegion();
                    farms.community = xyz.getCommunity();
                    farms.yearofestablishment = xyz.getYearofestablishment();
                    farms.totalarea = String.valueOf(xyz.getTotalarea());
                    farms.cultivatedarea = String.valueOf(xyz.getCultivatedarea());
                    farms.shadetrees = String.valueOf(xyz.getShadetrees());
                    farms.ownership = xyz.getOwnershipmethod();
                    farms.typeoffarm = xyz.getTypeoffarm();
                    farms.plantingmaterial = xyz.getMaterialsource();
                    farms.othersource = xyz.getOthersource();
                    farms.labour = xyz.getLaboursource();
                    farms.extension = xyz.getExtension();
                    farms.organisation = xyz.getOrganization();
                    farms.activities = String.valueOf(xyz.getOtheractivities());
                    farms.uniqueuid = xyz.getUniqueuid();
                    farms.cropvariety = xyz.getCropvariety();
                    farms.cropprotection = xyz.getCropprotection();
                    farms.farmyield = xyz.getFarmyield();
                    farms.fertilizerused = xyz.getFertilizerused();
                    farms.chemicalused = xyz.getChemicalused();
                    farms.organisation = xyz.getOrganization();
                    farms.macaddress = farmerInfo.getMacaddress();
                    farms.imei = farmerInfo.getImei();
                    farms.agentid = farmerInfo.getAgentid();
                    farms.agentname = farmerInfo.getAgentname();
                    farms.save();
                }

                List<GetSingleFarmerInfoServer.LocationsBean> locationsBeanList = farmerInfo.getLocations();
                for (GetSingleFarmerInfoServer.LocationsBean x : locationsBeanList) {
                    LocationCoordinates locds = new LocationCoordinates();
                    locds.setLocationtype(checkForNull(x.getLocationtype()));
                    locds.setFarmerid(farmerInfo.getFarmerid());
                    locds.setFarmid(x.getFarmid());
                    locds.setLatitude(checkForNull(x.getLatitude()));//String.valueOf(loc.getLatitude()));
                    locds.setLongitude(checkForNull(x.getLongitude()));//String.valueOf(loc.getLongitude()));
                    locds.setJsoncoord(checkForNull(x.getJsoncoord()));
                    locds.setStreetname(checkForNull(x.getStreetname()));
                    locds.setCity(checkForNull(x.getCity()));
                    locds.setRegion(checkForNull(x.getRegion()));
                    locds.setAssembly(checkForNull(x.getAssembly()));
                    locds.setArea(x.getArea());
                    locds.setLength(x.getLength());
                    locds.setDatecreated(AndroidUtils.dateStringToDate(x.getDatecreated().getDate(), pattern));
                    locds.macaddress = farmerInfo.getMacaddress();
                    locds.imei = farmerInfo.getImei();
                    locds.uniqueuid = x.getUniqueuid();
                    locds.agentname = farmerInfo.getAgentname();
                    locds.agentid = farmerInfo.getAgentid();
                    locds.save();

                }

                Userbiometrics bio = new Userbiometrics();
                bio.farmerid = farmerInfo.getFarmerid();
                bio.picture = AndroidUtils.base64ToByteArray(image);
                bio.signature = AndroidUtils.base64ToByteArray(farmerInfo.getSignature());
                bio.createdDate = AndroidUtils.dateStringToDate(farmerInfo.getDatecreated().getDate(), pattern);
                bio.placeOfRegistered = "";
                bio.macaddress = farmerInfo.getMacaddress();
                bio.imei = farmerInfo.getImei();
                bio.uniqueuid = farmerInfo.getUniqueuid();
                bio.agentname = farmerInfo.getAgentname();
                bio.agentid = farmerInfo.getAgentid();
                bio.save();

                try {
                    if (!farmerInfo.getSupportdocs().isEmpty()) {
                        for (GetSingleFarmerInfoServer.SupportDocsBean docsx : farmerInfo.getSupportdocs()) {
                            SupportDocs docs = new SupportDocs();
                            docs.farmerid = farmerInfo.getFarmerid();
                            docs.macaddress = farmerInfo.getMacaddress();
                            docs.imei = farmerInfo.getImei();
                            docs.uniqueuid = docsx.getUniqueuid();
                            docs.agentname = farmerInfo.getAgentname();
                            docs.agentid = farmerInfo.getAgentid();
                            docs.documenttype = docsx.getDoctype();
                            docs.document = AndroidUtils.base64ToByteArray(docsx.getDocfile());
                            docs.save();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                List<GetSingleFarmerInfoServer.ScaletranBean> scaletranBeanList = farmerInfo.getScaletran();
                for (GetSingleFarmerInfoServer.ScaletranBean x : scaletranBeanList) {
                    Scaletran scaletran = new Scaletran();
                    scaletran.transid = x.getTransid();
                    scaletran.farmerid = farmerInfo.getFarmerid();
                    scaletran.scaleid = x.getScaleid();
                    scaletran.pcid = x.getPcid();
                    scaletran.bcid = x.getBcid();
                    scaletran.name = farmerInfo.getName();
                    scaletran.phone = farmerInfo.getTel();
                    scaletran.payable = x.getPayable();
                    scaletran.tendered = x.getTendered();
                    scaletran.count = x.getCount();
                    scaletran.weight = x.getWeight();
                    scaletran.moisturecontent = x.getMoisturecontent();
                    scaletran.amount = x.getAmount();
                    scaletran.uniqueuid = x.getUniqueuid();
                    scaletran.datecreated = AndroidUtils.dateStringToDate(x.getDatecreated().getDate(), pattern);
                    scaletran.macaddress = farmerInfo.getMacaddress();
                    scaletran.imei = farmerInfo.getImei();
                    scaletran.agentname = farmerInfo.getAgentname();
                    scaletran.agentid = farmerInfo.getAgentid();
                    scaletran.save();
                }


                List<GetSingleFarmerInfoServer.SalestranBean> salestranBeanList = farmerInfo.getSalestran();

                for (GetSingleFarmerInfoServer.SalestranBean x : salestranBeanList) {
                    Salestran salestran = new Salestran();
                    salestran.farmerid = farmerInfo.getFarmerid();
                    salestran.transactionid = x.getTransid();
                    salestran.totalCost = x.getTotalcost();
                    salestran.couponcode = x.getCouponcode();
                    salestran.appliedsub = x.getAppliedsub();
                    salestran.payableamt = x.getPayableamt();
                    salestran.paymentmethod = x.getPaymentmethod();
                    salestran.tendered = x.getTendered();
                    salestran.norecoverybags = x.getNorecoverybags();
                    salestran.community = farmerInfo.getCommunity();
                    salestran.district = farmerInfo.getDistrict();
                    salestran.region = farmerInfo.getRegion();
                    salestran.acreage = x.getAcreage();
                    salestran.datecreated = AndroidUtils.dateStringToDate(x.getDatecreated().getDate(), pattern);
                    salestran.uniqueuid = farmerInfo.getUniqueuid();
                    salestran.macaddress = farmerInfo.getMacaddress();
                    salestran.imei = farmerInfo.getImei();
                    salestran.agentname = farmerInfo.getAgentname();
                    salestran.agentid = farmerInfo.getAgentid();
                    salestran.save();

                    List<GetSingleFarmerInfoServer.SalestranBean.SalesBean> salesBeanList = x.getSales();
                    for (GetSingleFarmerInfoServer.SalestranBean.SalesBean y : salesBeanList) {
                        Sales sales = new Sales();
                        sales.farmerid = farmerInfo.getFarmerid();
                        sales.transactionid = y.getTransid();
                        sales.category = y.getCategory();
                        sales.pid = y.getPid();
                        sales.pname = y.getPname();
                        sales.uprice = y.getUprice();
                        sales.quantity = y.getQuantity();
                        sales.totalcost = y.getTotalcost();
                        sales.uniqueuid = y.getUniqueuid();
                        sales.datecreated = AndroidUtils.dateStringToDate(x.getDatecreated().getDate(), pattern);
                        sales.macaddress = farmerInfo.getMacaddress();
                        sales.imei = farmerInfo.getImei();
                        sales.agentid = farmerInfo.getAgentid();
                        sales.agentname = farmerInfo.getAgentname();
                        sales.save();
                    }
                }

                List<GetSingleFarmerInfoServer.DeclarationsBean> declarationsBeanList = farmerInfo.getDeclarations();
                for (GetSingleFarmerInfoServer.DeclarationsBean x : declarationsBeanList) {
                    Declaration dec = new Declaration();
                    dec.farmerid = farmerInfo.getFarmerid();
                    dec.transactionid = x.getTransid();
                    dec.totalCost = x.getTotalcost();
                    dec.couponcode = x.getCouponcode();
                    dec.appliedsub = x.getAppliedsub();
                    dec.norecoverybags = x.getNorecoverybags();
                    dec.paymentmethod = x.getPaymentmethod();
                    dec.declaration = x.getDeclaration();
                    dec.community = farmerInfo.getCommunity();
                    dec.district = farmerInfo.getDistrict();
                    dec.region = farmerInfo.getRegion();
                    dec.acreage = x.getAcreage();
                    dec.uniqueuid = x.getUniqueuid();
                    dec.datecreated = AndroidUtils.dateStringToDate(x.getDatecreated().getDate(), pattern);
                    dec.macaddress = farmerInfo.getMacaddress();
                    dec.imei = farmerInfo.getImei();
                    dec.agentid = farmerInfo.getAgentid();
                    dec.agentname = farmerInfo.getAgentname();
                    dec.save();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("SAVING SERVER FARMER", e.getMessage());
            }
        }

        binding.back.setOnClickListener(v -> onBackPressed());

        binding.btnExtensionServices.setOnClickListener(v -> loadFarmAssessment(farmerInfo.getFarmerid()));

        binding.btnInputDistribution.setOnClickListener(v -> loadInputDistribution(farmerInfo.getFarmerid()));

        binding.btnInputRecovery.setOnClickListener(v -> loadRecovery(farmerInfo.getFarmerid()));

        binding.btnPurchases.setOnClickListener(v -> loadPurchases(farmerInfo.getFarmerid()));

        binding.btnViewAll.setOnClickListener(v -> loadAllTransactions(farmerInfo.getFarmerid()));

        binding.btnViewProfile.setOnClickListener(v -> loadFarmerProfile(farmerInfo.getFarmerid()));

        binding.btnServices.setOnClickListener(v -> loadServices(farmerInfo.getFarmerid()));
    }

    private Drawable convertToDrawable(String img) {
        byte[] imgbyte = Base64.decode(img.getBytes(), Base64.DEFAULT);
        return new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(imgbyte, 0, imgbyte.length));
    }


    //method to load profile page
    public void loadFarmerProfile(String farmerid) {
        Intent intent = new Intent(FarmerSearchServerDetailsActivity.this, ProfileActivity.class);
        intent.putExtra("farmerid", farmerid);
        startActivity(intent);
//        finish();
    }

    private void loadInputDistribution(String farmer_id) {
        Intent intent = new Intent(FarmerSearchServerDetailsActivity.this, InputDistMainActivity.class);
        intent.putExtra("farmerid", farmer_id);
        intent.putExtra("type", "0");
        startActivity(intent);
    }

    private void loadRecovery(String farmer_id) {
        Intent intent = new Intent(FarmerSearchServerDetailsActivity.this, RecoveryActivity.class);
        intent.putExtra("farmerid", farmer_id);
        intent.putExtra("type", "0");
        startActivity(intent);
    }

    private void loadPurchases(String farmer_id) {
        Intent intent = new Intent(FarmerSearchServerDetailsActivity.this, RecoveryActivity.class);
        intent.putExtra("farmerid", farmer_id);
        intent.putExtra("type", "1");
        startActivity(intent);
    }

    public void loadFarmAssessment(String farmerid) {
        Intent intent = new Intent(FarmerSearchServerDetailsActivity.this, FarmAssessmentForm.class);
        intent.putExtra("farmerid", farmerid);
        startActivity(intent);
    }

    public void loadAllTransactions(String farmerid) {
        Intent intent = new Intent(FarmerSearchServerDetailsActivity.this, FarmerTransaction.class);
        intent.putExtra("farmerid", farmerid);
        startActivity(intent);
    }

    public void loadServices(String farmerid) {
        Intent intent = new Intent(FarmerSearchServerDetailsActivity.this, InputDistMainActivity.class);
        intent.putExtra("farmerid", farmerid);
        intent.putExtra("type", "1");
        startActivity(intent);
    }

    public String checkForNull(String x) {
        return StringUtils.isBlank(x) ? "" : x;
    }
}
