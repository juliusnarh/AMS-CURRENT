package com.telpo.usb.finger.events;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.telpo.usb.finger.entities.ActivityInfo;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.FarmAssessment;
import com.telpo.usb.finger.entities.Farmeridcard;
import com.telpo.usb.finger.entities.Farmers;
import com.telpo.usb.finger.entities.Farms;
import com.telpo.usb.finger.entities.Household;
import com.telpo.usb.finger.entities.LocationCoordinates;
import com.telpo.usb.finger.entities.Products;
import com.telpo.usb.finger.entities.Sales;
import com.telpo.usb.finger.entities.Salestran;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.entities.SupportDocs;
import com.telpo.usb.finger.entities.Userbiometrics;
import com.telpo.usb.finger.entities.Userfingerprint;
import com.telpo.usb.finger.pojo.Feedback;
import com.telpo.usb.finger.pojo.SuccessPojo;
import com.telpo.usb.finger.utils.AndroidUtils;

import net.gotev.uploadservice.ServerResponse;
import net.gotev.uploadservice.UploadInfo;
import net.gotev.uploadservice.UploadServiceBroadcastReceiver;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * This implementation is empty on purpose, just to show how it's possible to intercept
 * all the upload events app-wise with a global broadcast receiver registered in the manifest.
 *
 * @author Aleksandar Gotev
 */

public class UploadReceiver extends UploadServiceBroadcastReceiver {
    boolean delmsg;
    Userbiometrics bio;
    LocationCoordinates loc;
    Household household;
    Farms farms;
    Farmers farmers;
    ActivityInfo activityInfo;
    Farmeridcard idcard;
    Userfingerprint fprint;
    SupportDocs doc;
    Sales sales;
    Salestran salestran;
    Declaration declaration;
    Products products;
    Scaletran scaletran;
    FarmAssessment assessment;

    @Override
    public void onProgress(Context context, UploadInfo uploadInfo) {
        super.onProgress(context, uploadInfo);
    }

    @Override
    public void onError(Context context, UploadInfo uploadInfo, ServerResponse serverResponse, Exception exception) {
        super.onError(context, uploadInfo, serverResponse, exception);
    }

    @Override
    public void onCompleted(Context context, UploadInfo uploadInfo, ServerResponse serverResponse) {
        System.out.println("Resposonse: " + serverResponse.toString() + " Body: " + serverResponse.getBodyAsString());
        Log.d("SERVERRESPONSE0", "Resposonse: " + serverResponse.toString() + " Body: " + serverResponse.getBodyAsString());
        try {
            SuccessPojo servermsg = new Gson().fromJson(serverResponse.getBodyAsString(), SuccessPojo.class);

            if (servermsg.getStatus().trim().equalsIgnoreCase("success")) {
                if (updateTables(servermsg.getFeedbacklist())) {
                    delmsg = FileUtils.deleteQuietly(new File(AndroidUtils.uploadDirectoryPath() + File.separator + servermsg.getFilename()));
                    if (delmsg == true) {
                        Toasty.success(context, "Server Message Success!!");
                    } else {
                        delmsg = FileUtils.deleteQuietly(new File(AndroidUtils.uploadTempDirectoryPath() + File.separator + servermsg.getFilename()));
                        Toasty.error(context, "Server Message Error!!");
                    }
                }
            } else if (servermsg.getStatus().trim().equalsIgnoreCase("error")) {
                Toasty.error(context, "Error Saving Records On Server!!");
                Log.d("SERVERRESPONSE1", "SERVERRESPONSE: " + servermsg.getStatus());

            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("SERVERRESPONSE2", "SERVERRESPONSE: " + e.toString());
            Toasty.error(context, "Server Didn't Return Proper Input!!!");
        }

    }

    @Override
    public void onCancelled(Context context, UploadInfo uploadInfo) {
        super.onCancelled(context, uploadInfo);
    }

    //method to update database using records from the server
    public boolean updateTables(List<Feedback> feedbackList) {
        try {
            for (Feedback feedback : feedbackList) {
                bio = new Userbiometrics();
                loc = new LocationCoordinates();
                household = new Household();
                farms = new Farms();
                farmers = new Farmers();
                activityInfo = new ActivityInfo();
                idcard = new Farmeridcard();
                fprint = new Userfingerprint();
                doc = new SupportDocs();
                sales = new Sales();
                salestran = new Salestran();
                declaration = new Declaration();
                products = new Products();
                scaletran = new Scaletran();
                assessment = new FarmAssessment();

                if (feedback.getTablename().trim().equalsIgnoreCase("biometrics")) {
                    bio = Userbiometrics.findById(Userbiometrics.class, feedback.getMobileid());
                    if (bio != null) {
                        bio.setServerid(feedback.getId());
                        bio.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("locationcoords")) {
                    loc = LocationCoordinates.findById(LocationCoordinates.class, feedback.getMobileid());
                    if (loc != null) {
                        loc.setServerid(feedback.getId());
                        bio.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("household")) {
                    household = Household.findById(Household.class, feedback.getMobileid());
                    if (household != null) {
                        household.setServerid(feedback.getId());
                        household.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("farm")) {
                    farms = Farms.findById(Farms.class, feedback.getMobileid());
                    if (farms != null) {
                        farms.setServerid(feedback.getId());
                        farms.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("farmerinfo")) {
                    farmers = Farmers.findById(Farmers.class, feedback.getMobileid());
                    if (farmers != null) {
                        farmers.setServerid(feedback.getId());
                        farmers.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("activityinfo")) {
                    activityInfo = ActivityInfo.findById(ActivityInfo.class, feedback.getMobileid());
                    if (activityInfo != null) {
                        activityInfo.setServerid(feedback.getId());
                        activityInfo.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("idcard")) {
                    idcard = Farmeridcard.findById(Farmeridcard.class, feedback.getMobileid());
                    if (idcard != null) {
                        idcard.setServerid(feedback.getId());
                        idcard.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("fingerprint")) {
                    fprint = Userfingerprint.findById(Userfingerprint.class, feedback.getMobileid());
                    if (fprint != null) {
                        fprint.setServerid(feedback.getId());
                        fprint.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("supportdocs")) {
                    doc = SupportDocs.findById(SupportDocs.class, feedback.getMobileid());
                    if (doc != null) {
                        doc.setServerid(feedback.getId());
                        doc.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("sales")) {
                    sales = Sales.findById(Sales.class, feedback.getMobileid());
                    if (sales != null) {
                        sales.setServerid(feedback.getId());
                        sales.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("salestran")) {
                    salestran = Salestran.findById(Salestran.class, feedback.getMobileid());
                    if (salestran != null) {
                        salestran.setServerid(feedback.getId());
                        salestran.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("declaration")) {
                    declaration = Declaration.findById(Declaration.class, feedback.getMobileid());
                    if (declaration != null) {
                        declaration.setServerid(feedback.getId());
                        declaration.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("products")) {
                    products = Products.findById(Products.class, feedback.getMobileid());
                    if (products != null) {
                        products.setServerid(feedback.getId());
                        products.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("scaletran")) {
                    scaletran = Scaletran.findById(Scaletran.class, feedback.getMobileid());
                    if (scaletran != null) {
                        scaletran.setServerid(feedback.getId());
                        scaletran.save();
                    }
                } else if (feedback.getTablename().trim().equalsIgnoreCase("farmassessment")) {
                    assessment = FarmAssessment.findById(FarmAssessment.class, feedback.getMobileid());
                    if (assessment != null) {
                        assessment.setServerid(feedback.getId());
                        assessment.save();
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d("SERVERRESPONSE3", "SERVERRESPONSE: " + ex.toString());
            return false;
        }
    }
}


