package com.telpo.usb.finger.utils;

import com.telpo.usb.finger.entities.Aggregator;
import com.telpo.usb.finger.entities.FarmersUrl;
import com.telpo.usb.finger.entities.GetServerSearchFarmerInfo;
import com.telpo.usb.finger.entities.GetSingleFarmerInfoServer;
import com.telpo.usb.finger.pojo.SuccessFarmerAssignPojo;

import java.util.List;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by ravi on 31/01/18.
 */

public interface ApiService {

    @GET("androidGetFarmer.php")
    Single<List<GetServerSearchFarmerInfo>> getFarmers(@Query("source") String source, @Query("search") String query);

    @GET("androidGetFarmerFull.php")
    Single<List<GetSingleFarmerInfoServer>> getFarmerDetails(@Query("source") String source, @Query("search") String query);

    @GET("androidGetAggregator.php")
    Single<List<Aggregator>> getAllAggregators(@Query("source") String source, @Query("role") String aggregator);

    @GET("androidGetAggFarmer.php")
    Single<List<FarmersUrl>> getAllFarmersAssignedToAgg(@Query("source") String source, @Query("aggregatorid") String aggregator, @Query("agent") String agentid);

    @GET("androidAssignAggFarmer.php")
    Call<SuccessFarmerAssignPojo> getAssignFarmerToAgg(@Query("source") String source, @Query("aggregatorid") String aggregator, @Query("farmerid") String farmerid);

    @GET("androidDeleteFile.php")
    Call<ResponseBody> deleteDownloadedFile(@Query("source") String source, @Query("filename") String fileName);

    @Streaming
    @GET
    Call<ResponseBody> downloadFarmerJsonFiles(@Url String fileUrl);
}
