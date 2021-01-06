package com.telpo.usb.finger;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.telpo.usb.finger.databinding.ActivityAgentBindingImpl;
import com.telpo.usb.finger.databinding.ActivityAggregatorTestBindingImpl;
import com.telpo.usb.finger.databinding.ActivityDashBoardBindingImpl;
import com.telpo.usb.finger.databinding.ActivityDataBindingImpl;
import com.telpo.usb.finger.databinding.ActivityDetailsBindingImpl;
import com.telpo.usb.finger.databinding.ActivityExportFarmersAssignedAggBindingImpl;
import com.telpo.usb.finger.databinding.ActivityFarmMapPolygonBindingImpl;
import com.telpo.usb.finger.databinding.ActivityFarmSearchViewBindingImpl;
import com.telpo.usb.finger.databinding.ActivityFarmer2BindingImpl;
import com.telpo.usb.finger.databinding.ActivityFarmerSearchAggregatorBindingImpl;
import com.telpo.usb.finger.databinding.ActivityFarmerSearchServerBindingImpl;
import com.telpo.usb.finger.databinding.ActivityFarmerSearchServerDetailsBindingImpl;
import com.telpo.usb.finger.databinding.ActivityFarmerTransactionBindingImpl;
import com.telpo.usb.finger.databinding.ActivityFingerEnrollBindingImpl;
import com.telpo.usb.finger.databinding.ActivityFingerVerifyBindingImpl;
import com.telpo.usb.finger.databinding.ActivityHouseholdRelationshipBindingImpl;
import com.telpo.usb.finger.databinding.ActivityInputdistMainBindingImpl;
import com.telpo.usb.finger.databinding.ActivityLoginAltBindingImpl;
import com.telpo.usb.finger.databinding.ActivityPackagesBindingImpl;
import com.telpo.usb.finger.databinding.ActivityReceiveInputsBindingImpl;
import com.telpo.usb.finger.databinding.ActivityRecoveryBindingImpl;
import com.telpo.usb.finger.databinding.ActivityResidentialMapBindingImpl;
import com.telpo.usb.finger.databinding.ActivitySaletrandetailsBindingImpl;
import com.telpo.usb.finger.databinding.ActivityScanDocsBindingImpl;
import com.telpo.usb.finger.databinding.ActivitySendBulkSmsBindingImpl;
import com.telpo.usb.finger.databinding.ActivitySignatureBindingImpl;
import com.telpo.usb.finger.databinding.CartBottomSheetBindingImpl;
import com.telpo.usb.finger.databinding.ContentExportFarmersAssignedAggBindingImpl;
import com.telpo.usb.finger.databinding.ContentFarmerSearchAggregatorBindingImpl;
import com.telpo.usb.finger.databinding.ContentPackagesBindingImpl;
import com.telpo.usb.finger.databinding.ContentReceiveInputsBindingImpl;
import com.telpo.usb.finger.databinding.ContentRemoteSearchBindingImpl;
import com.telpo.usb.finger.databinding.DialogAddinputBindingImpl;
import com.telpo.usb.finger.databinding.DialogAddpackageBindingImpl;
import com.telpo.usb.finger.databinding.DialogPackagedetailsBindingImpl;
import com.telpo.usb.finger.databinding.DialogSelectAggregatorBindingImpl;
import com.telpo.usb.finger.databinding.FarmDataBindingImpl;
import com.telpo.usb.finger.databinding.FarmerBottomsheetBindingImpl;
import com.telpo.usb.finger.databinding.FarmerProfileFragmentBindingImpl;
import com.telpo.usb.finger.databinding.FarmerSearchAggBottomsheetBindingImpl;
import com.telpo.usb.finger.databinding.FragmentActionsBindingImpl;
import com.telpo.usb.finger.databinding.FragmentAddAnotherActivityBindingImpl;
import com.telpo.usb.finger.databinding.FragmentAddAnotherFarmBindingImpl;
import com.telpo.usb.finger.databinding.FragmentAddressBindingImpl;
import com.telpo.usb.finger.databinding.FragmentAssignFarmerAggregatorDialogBindingImpl;
import com.telpo.usb.finger.databinding.FragmentAutomaticRecoveryBindingImpl;
import com.telpo.usb.finger.databinding.FragmentBasicInfoBindingImpl;
import com.telpo.usb.finger.databinding.FragmentBiometricsBindingImpl;
import com.telpo.usb.finger.databinding.FragmentChartBindingImpl;
import com.telpo.usb.finger.databinding.FragmentChartbackupBindingImpl;
import com.telpo.usb.finger.databinding.FragmentEditActivityProfileBindingImpl;
import com.telpo.usb.finger.databinding.FragmentEditFarminfoBindingImpl;
import com.telpo.usb.finger.databinding.FragmentEditPersonalProfileBindingImpl;
import com.telpo.usb.finger.databinding.FragmentEditSupportdocsBindingImpl;
import com.telpo.usb.finger.databinding.FragmentFaf1BindingImpl;
import com.telpo.usb.finger.databinding.FragmentFaf2BindingImpl;
import com.telpo.usb.finger.databinding.FragmentFaf3BindingImpl;
import com.telpo.usb.finger.databinding.FragmentFarmInfoBindingImpl;
import com.telpo.usb.finger.databinding.FragmentFarmerActivityInfoBindingImpl;
import com.telpo.usb.finger.databinding.FragmentFarmerProfileServicesBindingImpl;
import com.telpo.usb.finger.databinding.FragmentFarmerProfileSummaryBindingImpl;
import com.telpo.usb.finger.databinding.FragmentFarmsBindingImpl;
import com.telpo.usb.finger.databinding.FragmentHomeBindingImpl;
import com.telpo.usb.finger.databinding.FragmentHouseholdRelationBindingImpl;
import com.telpo.usb.finger.databinding.FragmentIpsettingsBindingImpl;
import com.telpo.usb.finger.databinding.FragmentLocationInfoBindingImpl;
import com.telpo.usb.finger.databinding.FragmentManualRecoveryBindingImpl;
import com.telpo.usb.finger.databinding.FragmentMapRegAddressBindingImpl;
import com.telpo.usb.finger.databinding.FragmentMapRegFarmBindingImpl;
import com.telpo.usb.finger.databinding.FragmentNoFarmBindingImpl;
import com.telpo.usb.finger.databinding.FragmentRegPreviewBindingImpl;
import com.telpo.usb.finger.databinding.FragmentReportBindingImpl;
import com.telpo.usb.finger.databinding.FragmentSearchTimelineDialogBindingImpl;
import com.telpo.usb.finger.databinding.FragmentTemplateDialogBindingImpl;
import com.telpo.usb.finger.databinding.FragmentViewServiceProvidersBindingImpl;
import com.telpo.usb.finger.databinding.HouseholdDatabindingImpl;
import com.telpo.usb.finger.databinding.HouseholdSearchActivityBindingImpl;
import com.telpo.usb.finger.databinding.HouseholdsDataBindingImpl;
import com.telpo.usb.finger.databinding.PhotoHeaderBindingImpl;
import com.telpo.usb.finger.databinding.RecyclerItemsBindingImpl;
import com.telpo.usb.finger.databinding.RecyclerItemsBindingSw600dpImpl;
import com.telpo.usb.finger.databinding.RecyclerServiceBindingImpl;
import com.telpo.usb.finger.databinding.RecyclerServiceBindingSw600dpImpl;
import com.telpo.usb.finger.databinding.ScandocItemLayoutBindingImpl;
import com.telpo.usb.finger.databinding.ScandocProfileItemLayoutBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYAGENT = 1;

  private static final int LAYOUT_ACTIVITYAGGREGATORTEST = 2;

  private static final int LAYOUT_ACTIVITYDASHBOARD = 3;

  private static final int LAYOUT_ACTIVITYDETAILS = 4;

  private static final int LAYOUT_ACTIVITYEXPORTFARMERSASSIGNEDAGG = 5;

  private static final int LAYOUT_ACTIVITYFARMMAPPOLYGON = 6;

  private static final int LAYOUT_ACTIVITYFARMSEARCHVIEW = 7;

  private static final int LAYOUT_ACTIVITYFARMER2 = 8;

  private static final int LAYOUT_ACTIVITYFARMERSEARCHAGGREGATOR = 9;

  private static final int LAYOUT_ACTIVITYFARMERSEARCHSERVER = 10;

  private static final int LAYOUT_ACTIVITYFARMERSEARCHSERVERDETAILS = 11;

  private static final int LAYOUT_ACTIVITYFARMERTRANSACTION = 12;

  private static final int LAYOUT_ACTIVITYFINGERENROLL = 13;

  private static final int LAYOUT_ACTIVITYFINGERVERIFY = 14;

  private static final int LAYOUT_ACTIVITYHOUSEHOLDRELATIONSHIP = 15;

  private static final int LAYOUT_ACTIVITYINPUTDISTMAIN = 16;

  private static final int LAYOUT_ACTIVITYITEMLAYOUT = 17;

  private static final int LAYOUT_ACTIVITYLOGINALT = 18;

  private static final int LAYOUT_ACTIVITYPACKAGES = 19;

  private static final int LAYOUT_ACTIVITYRECEIVEINPUTS = 20;

  private static final int LAYOUT_ACTIVITYRECOVERY = 21;

  private static final int LAYOUT_ACTIVITYRESIDENTIALMAP = 22;

  private static final int LAYOUT_ACTIVITYSALETRANDETAILS = 23;

  private static final int LAYOUT_ACTIVITYSCANDOCS = 24;

  private static final int LAYOUT_ACTIVITYSENDBULKSMS = 25;

  private static final int LAYOUT_ACTIVITYSIGNATURE = 26;

  private static final int LAYOUT_CARTBOTTOMSHEET = 27;

  private static final int LAYOUT_CONTENTEXPORTFARMERSASSIGNEDAGG = 28;

  private static final int LAYOUT_CONTENTFARMERSEARCHAGGREGATOR = 29;

  private static final int LAYOUT_CONTENTPACKAGES = 30;

  private static final int LAYOUT_CONTENTRECEIVEINPUTS = 31;

  private static final int LAYOUT_CONTENTREMOTESEARCH = 32;

  private static final int LAYOUT_DIALOGADDINPUT = 33;

  private static final int LAYOUT_DIALOGADDPACKAGE = 34;

  private static final int LAYOUT_DIALOGPACKAGEDETAILS = 35;

  private static final int LAYOUT_DIALOGSELECTAGGREGATOR = 36;

  private static final int LAYOUT_FARMITEMLAYOUT = 37;

  private static final int LAYOUT_FARMERBOTTOMSHEET = 38;

  private static final int LAYOUT_FARMERPROFILEFRAGMENT = 39;

  private static final int LAYOUT_FARMERSEARCHAGGBOTTOMSHEET = 40;

  private static final int LAYOUT_FRAGMENTACTIONS = 41;

  private static final int LAYOUT_FRAGMENTADDANOTHERACTIVITY = 42;

  private static final int LAYOUT_FRAGMENTADDANOTHERFARM = 43;

  private static final int LAYOUT_FRAGMENTADDRESS = 44;

  private static final int LAYOUT_FRAGMENTASSIGNFARMERAGGREGATORDIALOG = 45;

  private static final int LAYOUT_FRAGMENTAUTOMATICRECOVERY = 46;

  private static final int LAYOUT_FRAGMENTBASICINFO = 47;

  private static final int LAYOUT_FRAGMENTBIOMETRICS = 48;

  private static final int LAYOUT_FRAGMENTCHART = 49;

  private static final int LAYOUT_FRAGMENTCHARTBACKUP = 50;

  private static final int LAYOUT_FRAGMENTEDITACTIVITYPROFILE = 51;

  private static final int LAYOUT_FRAGMENTEDITFARMINFO = 52;

  private static final int LAYOUT_FRAGMENTEDITPERSONALPROFILE = 53;

  private static final int LAYOUT_FRAGMENTEDITSUPPORTDOCS = 54;

  private static final int LAYOUT_FRAGMENTFAF1 = 55;

  private static final int LAYOUT_FRAGMENTFAF2 = 56;

  private static final int LAYOUT_FRAGMENTFAF3 = 57;

  private static final int LAYOUT_FRAGMENTFARMINFO = 58;

  private static final int LAYOUT_FRAGMENTFARMERACTIVITYINFO = 59;

  private static final int LAYOUT_FRAGMENTFARMERPROFILESERVICES = 60;

  private static final int LAYOUT_FRAGMENTFARMERPROFILESUMMARY = 61;

  private static final int LAYOUT_FRAGMENTFARMS = 62;

  private static final int LAYOUT_FRAGMENTHOME = 63;

  private static final int LAYOUT_FRAGMENTHOUSEHOLDRELATION = 64;

  private static final int LAYOUT_FRAGMENTIPSETTINGS = 65;

  private static final int LAYOUT_FRAGMENTLOCATIONINFO = 66;

  private static final int LAYOUT_FRAGMENTMANUALRECOVERY = 67;

  private static final int LAYOUT_FRAGMENTMAPREGADDRESS = 68;

  private static final int LAYOUT_FRAGMENTMAPREGFARM = 69;

  private static final int LAYOUT_FRAGMENTNOFARM = 70;

  private static final int LAYOUT_FRAGMENTREGPREVIEW = 71;

  private static final int LAYOUT_FRAGMENTREPORT = 72;

  private static final int LAYOUT_FRAGMENTSEARCHTIMELINEDIALOG = 73;

  private static final int LAYOUT_FRAGMENTTEMPLATEDIALOG = 74;

  private static final int LAYOUT_FRAGMENTVIEWSERVICEPROVIDERS = 75;

  private static final int LAYOUT_HOUSEHOLDITEMLAYOUT = 76;

  private static final int LAYOUT_HOUSEHOLDSEARCHACTIVITY = 77;

  private static final int LAYOUT_HOUSEHOLDSEARCHITEM = 78;

  private static final int LAYOUT_PHOTOHEADER = 79;

  private static final int LAYOUT_RECYCLERITEMS = 80;

  private static final int LAYOUT_RECYCLERSERVICE = 81;

  private static final int LAYOUT_SCANDOCITEMLAYOUT = 82;

  private static final int LAYOUT_SCANDOCPROFILEITEMLAYOUT = 83;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(83);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_agent, LAYOUT_ACTIVITYAGENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_aggregator_test, LAYOUT_ACTIVITYAGGREGATORTEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_dash_board, LAYOUT_ACTIVITYDASHBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_details, LAYOUT_ACTIVITYDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_export_farmers_assigned_agg, LAYOUT_ACTIVITYEXPORTFARMERSASSIGNEDAGG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_farm_map_polygon, LAYOUT_ACTIVITYFARMMAPPOLYGON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_farm_search_view, LAYOUT_ACTIVITYFARMSEARCHVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_farmer2, LAYOUT_ACTIVITYFARMER2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_farmer_search_aggregator, LAYOUT_ACTIVITYFARMERSEARCHAGGREGATOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_farmer_search_server, LAYOUT_ACTIVITYFARMERSEARCHSERVER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_farmer_search_server_details, LAYOUT_ACTIVITYFARMERSEARCHSERVERDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_farmer_transaction, LAYOUT_ACTIVITYFARMERTRANSACTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_finger_enroll, LAYOUT_ACTIVITYFINGERENROLL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_finger_verify, LAYOUT_ACTIVITYFINGERVERIFY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_household_relationship, LAYOUT_ACTIVITYHOUSEHOLDRELATIONSHIP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_inputdist_main, LAYOUT_ACTIVITYINPUTDISTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_item_layout, LAYOUT_ACTIVITYITEMLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_login_alt, LAYOUT_ACTIVITYLOGINALT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_packages, LAYOUT_ACTIVITYPACKAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_receive_inputs, LAYOUT_ACTIVITYRECEIVEINPUTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_recovery, LAYOUT_ACTIVITYRECOVERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_residential_map, LAYOUT_ACTIVITYRESIDENTIALMAP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_saletrandetails, LAYOUT_ACTIVITYSALETRANDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_scan_docs, LAYOUT_ACTIVITYSCANDOCS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_send_bulk_sms, LAYOUT_ACTIVITYSENDBULKSMS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.activity_signature, LAYOUT_ACTIVITYSIGNATURE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.cart_bottom_sheet, LAYOUT_CARTBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.content_export_farmers_assigned_agg, LAYOUT_CONTENTEXPORTFARMERSASSIGNEDAGG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.content_farmer_search_aggregator, LAYOUT_CONTENTFARMERSEARCHAGGREGATOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.content_packages, LAYOUT_CONTENTPACKAGES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.content_receive_inputs, LAYOUT_CONTENTRECEIVEINPUTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.content_remote_search, LAYOUT_CONTENTREMOTESEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.dialog_addinput, LAYOUT_DIALOGADDINPUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.dialog_addpackage, LAYOUT_DIALOGADDPACKAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.dialog_packagedetails, LAYOUT_DIALOGPACKAGEDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.dialog_select_aggregator, LAYOUT_DIALOGSELECTAGGREGATOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.farm_item_layout, LAYOUT_FARMITEMLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.farmer_bottomsheet, LAYOUT_FARMERBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.farmer_profile_fragment, LAYOUT_FARMERPROFILEFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.farmer_search_agg_bottomsheet, LAYOUT_FARMERSEARCHAGGBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_actions, LAYOUT_FRAGMENTACTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_add_another_activity, LAYOUT_FRAGMENTADDANOTHERACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_add_another_farm, LAYOUT_FRAGMENTADDANOTHERFARM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_address, LAYOUT_FRAGMENTADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_assign_farmer_aggregator_dialog, LAYOUT_FRAGMENTASSIGNFARMERAGGREGATORDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_automatic_recovery, LAYOUT_FRAGMENTAUTOMATICRECOVERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_basic_info, LAYOUT_FRAGMENTBASICINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_biometrics, LAYOUT_FRAGMENTBIOMETRICS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_chart, LAYOUT_FRAGMENTCHART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_chartbackup, LAYOUT_FRAGMENTCHARTBACKUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_edit_activity_profile, LAYOUT_FRAGMENTEDITACTIVITYPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_edit_farminfo, LAYOUT_FRAGMENTEDITFARMINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_edit_personal_profile, LAYOUT_FRAGMENTEDITPERSONALPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_edit_supportdocs, LAYOUT_FRAGMENTEDITSUPPORTDOCS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_faf_1, LAYOUT_FRAGMENTFAF1);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_faf_2, LAYOUT_FRAGMENTFAF2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_faf_3, LAYOUT_FRAGMENTFAF3);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_farm_info, LAYOUT_FRAGMENTFARMINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_farmer_activity_info, LAYOUT_FRAGMENTFARMERACTIVITYINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_farmer_profile_services, LAYOUT_FRAGMENTFARMERPROFILESERVICES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_farmer_profile_summary, LAYOUT_FRAGMENTFARMERPROFILESUMMARY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_farms, LAYOUT_FRAGMENTFARMS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_household_relation, LAYOUT_FRAGMENTHOUSEHOLDRELATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_ipsettings, LAYOUT_FRAGMENTIPSETTINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_location_info, LAYOUT_FRAGMENTLOCATIONINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_manual_recovery, LAYOUT_FRAGMENTMANUALRECOVERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_map_reg_address, LAYOUT_FRAGMENTMAPREGADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_map_reg_farm, LAYOUT_FRAGMENTMAPREGFARM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_no_farm, LAYOUT_FRAGMENTNOFARM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_reg_preview, LAYOUT_FRAGMENTREGPREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_report, LAYOUT_FRAGMENTREPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_search_timeline_dialog, LAYOUT_FRAGMENTSEARCHTIMELINEDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_template_dialog, LAYOUT_FRAGMENTTEMPLATEDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.fragment_view_service_providers, LAYOUT_FRAGMENTVIEWSERVICEPROVIDERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.household_item_layout, LAYOUT_HOUSEHOLDITEMLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.household_search_activity, LAYOUT_HOUSEHOLDSEARCHACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.household_search_item, LAYOUT_HOUSEHOLDSEARCHITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.photo_header, LAYOUT_PHOTOHEADER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.recycler_items, LAYOUT_RECYCLERITEMS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.recycler_service, LAYOUT_RECYCLERSERVICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.scandoc_item_layout, LAYOUT_SCANDOCITEMLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.telpo.usb.finger.R.layout.scandoc_profile_item_layout, LAYOUT_SCANDOCPROFILEITEMLAYOUT);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYAGENT: {
        if ("layout/activity_agent_0".equals(tag)) {
          return new ActivityAgentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_agent is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYAGGREGATORTEST: {
        if ("layout/activity_aggregator_test_0".equals(tag)) {
          return new ActivityAggregatorTestBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_aggregator_test is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDASHBOARD: {
        if ("layout/activity_dash_board_0".equals(tag)) {
          return new ActivityDashBoardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_dash_board is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDETAILS: {
        if ("layout/activity_details_0".equals(tag)) {
          return new ActivityDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_details is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYEXPORTFARMERSASSIGNEDAGG: {
        if ("layout/activity_export_farmers_assigned_agg_0".equals(tag)) {
          return new ActivityExportFarmersAssignedAggBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_export_farmers_assigned_agg is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFARMMAPPOLYGON: {
        if ("layout/activity_farm_map_polygon_0".equals(tag)) {
          return new ActivityFarmMapPolygonBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_farm_map_polygon is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFARMSEARCHVIEW: {
        if ("layout/activity_farm_search_view_0".equals(tag)) {
          return new ActivityFarmSearchViewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_farm_search_view is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFARMER2: {
        if ("layout/activity_farmer2_0".equals(tag)) {
          return new ActivityFarmer2BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_farmer2 is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFARMERSEARCHAGGREGATOR: {
        if ("layout/activity_farmer_search_aggregator_0".equals(tag)) {
          return new ActivityFarmerSearchAggregatorBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_farmer_search_aggregator is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFARMERSEARCHSERVER: {
        if ("layout/activity_farmer_search_server_0".equals(tag)) {
          return new ActivityFarmerSearchServerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_farmer_search_server is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFARMERSEARCHSERVERDETAILS: {
        if ("layout/activity_farmer_search_server_details_0".equals(tag)) {
          return new ActivityFarmerSearchServerDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_farmer_search_server_details is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFARMERTRANSACTION: {
        if ("layout/activity_farmer_transaction_0".equals(tag)) {
          return new ActivityFarmerTransactionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_farmer_transaction is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFINGERENROLL: {
        if ("layout/activity_finger_enroll_0".equals(tag)) {
          return new ActivityFingerEnrollBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_finger_enroll is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFINGERVERIFY: {
        if ("layout/activity_finger_verify_0".equals(tag)) {
          return new ActivityFingerVerifyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_finger_verify is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYHOUSEHOLDRELATIONSHIP: {
        if ("layout/activity_household_relationship_0".equals(tag)) {
          return new ActivityHouseholdRelationshipBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_household_relationship is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYINPUTDISTMAIN: {
        if ("layout/activity_inputdist_main_0".equals(tag)) {
          return new ActivityInputdistMainBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_inputdist_main is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYITEMLAYOUT: {
        if ("layout/activity_item_layout_0".equals(tag)) {
          return new ActivityDataBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_item_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLOGINALT: {
        if ("layout/activity_login_alt_0".equals(tag)) {
          return new ActivityLoginAltBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_login_alt is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPACKAGES: {
        if ("layout/activity_packages_0".equals(tag)) {
          return new ActivityPackagesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_packages is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRECEIVEINPUTS: {
        if ("layout/activity_receive_inputs_0".equals(tag)) {
          return new ActivityReceiveInputsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_receive_inputs is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRECOVERY: {
        if ("layout/activity_recovery_0".equals(tag)) {
          return new ActivityRecoveryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_recovery is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRESIDENTIALMAP: {
        if ("layout/activity_residential_map_0".equals(tag)) {
          return new ActivityResidentialMapBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_residential_map is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSALETRANDETAILS: {
        if ("layout/activity_saletrandetails_0".equals(tag)) {
          return new ActivitySaletrandetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_saletrandetails is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSCANDOCS: {
        if ("layout/activity_scan_docs_0".equals(tag)) {
          return new ActivityScanDocsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_scan_docs is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSENDBULKSMS: {
        if ("layout/activity_send_bulk_sms_0".equals(tag)) {
          return new ActivitySendBulkSmsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_send_bulk_sms is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSIGNATURE: {
        if ("layout/activity_signature_0".equals(tag)) {
          return new ActivitySignatureBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_signature is invalid. Received: " + tag);
      }
      case  LAYOUT_CARTBOTTOMSHEET: {
        if ("layout/cart_bottom_sheet_0".equals(tag)) {
          return new CartBottomSheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for cart_bottom_sheet is invalid. Received: " + tag);
      }
      case  LAYOUT_CONTENTEXPORTFARMERSASSIGNEDAGG: {
        if ("layout/content_export_farmers_assigned_agg_0".equals(tag)) {
          return new ContentExportFarmersAssignedAggBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for content_export_farmers_assigned_agg is invalid. Received: " + tag);
      }
      case  LAYOUT_CONTENTFARMERSEARCHAGGREGATOR: {
        if ("layout/content_farmer_search_aggregator_0".equals(tag)) {
          return new ContentFarmerSearchAggregatorBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for content_farmer_search_aggregator is invalid. Received: " + tag);
      }
      case  LAYOUT_CONTENTPACKAGES: {
        if ("layout/content_packages_0".equals(tag)) {
          return new ContentPackagesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for content_packages is invalid. Received: " + tag);
      }
      case  LAYOUT_CONTENTRECEIVEINPUTS: {
        if ("layout/content_receive_inputs_0".equals(tag)) {
          return new ContentReceiveInputsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for content_receive_inputs is invalid. Received: " + tag);
      }
      case  LAYOUT_CONTENTREMOTESEARCH: {
        if ("layout/content_remote_search_0".equals(tag)) {
          return new ContentRemoteSearchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for content_remote_search is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGADDINPUT: {
        if ("layout/dialog_addinput_0".equals(tag)) {
          return new DialogAddinputBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_addinput is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGADDPACKAGE: {
        if ("layout/dialog_addpackage_0".equals(tag)) {
          return new DialogAddpackageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_addpackage is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGPACKAGEDETAILS: {
        if ("layout/dialog_packagedetails_0".equals(tag)) {
          return new DialogPackagedetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_packagedetails is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGSELECTAGGREGATOR: {
        if ("layout/dialog_select_aggregator_0".equals(tag)) {
          return new DialogSelectAggregatorBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_select_aggregator is invalid. Received: " + tag);
      }
      case  LAYOUT_FARMITEMLAYOUT: {
        if ("layout/farm_item_layout_0".equals(tag)) {
          return new FarmDataBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for farm_item_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_FARMERBOTTOMSHEET: {
        if ("layout/farmer_bottomsheet_0".equals(tag)) {
          return new FarmerBottomsheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for farmer_bottomsheet is invalid. Received: " + tag);
      }
      case  LAYOUT_FARMERPROFILEFRAGMENT: {
        if ("layout/farmer_profile_fragment_0".equals(tag)) {
          return new FarmerProfileFragmentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for farmer_profile_fragment is invalid. Received: " + tag);
      }
      case  LAYOUT_FARMERSEARCHAGGBOTTOMSHEET: {
        if ("layout/farmer_search_agg_bottomsheet_0".equals(tag)) {
          return new FarmerSearchAggBottomsheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for farmer_search_agg_bottomsheet is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTACTIONS: {
        if ("layout/fragment_actions_0".equals(tag)) {
          return new FragmentActionsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_actions is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTADDANOTHERACTIVITY: {
        if ("layout/fragment_add_another_activity_0".equals(tag)) {
          return new FragmentAddAnotherActivityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_add_another_activity is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTADDANOTHERFARM: {
        if ("layout/fragment_add_another_farm_0".equals(tag)) {
          return new FragmentAddAnotherFarmBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_add_another_farm is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTADDRESS: {
        if ("layout/fragment_address_0".equals(tag)) {
          return new FragmentAddressBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_address is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTASSIGNFARMERAGGREGATORDIALOG: {
        if ("layout/fragment_assign_farmer_aggregator_dialog_0".equals(tag)) {
          return new FragmentAssignFarmerAggregatorDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_assign_farmer_aggregator_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTAUTOMATICRECOVERY: {
        if ("layout/fragment_automatic_recovery_0".equals(tag)) {
          return new FragmentAutomaticRecoveryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_automatic_recovery is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTBASICINFO: {
        if ("layout/fragment_basic_info_0".equals(tag)) {
          return new FragmentBasicInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_basic_info is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTBIOMETRICS: {
        if ("layout/fragment_biometrics_0".equals(tag)) {
          return new FragmentBiometricsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_biometrics is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCHART: {
        if ("layout/fragment_chart_0".equals(tag)) {
          return new FragmentChartBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_chart is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCHARTBACKUP: {
        if ("layout/fragment_chartbackup_0".equals(tag)) {
          return new FragmentChartbackupBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_chartbackup is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_FRAGMENTEDITACTIVITYPROFILE: {
        if ("layout/fragment_edit_activity_profile_0".equals(tag)) {
          return new FragmentEditActivityProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_edit_activity_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTEDITFARMINFO: {
        if ("layout/fragment_edit_farminfo_0".equals(tag)) {
          return new FragmentEditFarminfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_edit_farminfo is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTEDITPERSONALPROFILE: {
        if ("layout/fragment_edit_personal_profile_0".equals(tag)) {
          return new FragmentEditPersonalProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_edit_personal_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTEDITSUPPORTDOCS: {
        if ("layout/fragment_edit_supportdocs_0".equals(tag)) {
          return new FragmentEditSupportdocsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_edit_supportdocs is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFAF1: {
        if ("layout/fragment_faf_1_0".equals(tag)) {
          return new FragmentFaf1BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_faf_1 is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFAF2: {
        if ("layout/fragment_faf_2_0".equals(tag)) {
          return new FragmentFaf2BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_faf_2 is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFAF3: {
        if ("layout/fragment_faf_3_0".equals(tag)) {
          return new FragmentFaf3BindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_faf_3 is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFARMINFO: {
        if ("layout/fragment_farm_info_0".equals(tag)) {
          return new FragmentFarmInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_farm_info is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFARMERACTIVITYINFO: {
        if ("layout/fragment_farmer_activity_info_0".equals(tag)) {
          return new FragmentFarmerActivityInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_farmer_activity_info is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFARMERPROFILESERVICES: {
        if ("layout/fragment_farmer_profile_services_0".equals(tag)) {
          return new FragmentFarmerProfileServicesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_farmer_profile_services is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFARMERPROFILESUMMARY: {
        if ("layout/fragment_farmer_profile_summary_0".equals(tag)) {
          return new FragmentFarmerProfileSummaryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_farmer_profile_summary is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFARMS: {
        if ("layout/fragment_farms_0".equals(tag)) {
          return new FragmentFarmsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_farms is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTHOME: {
        if ("layout/fragment_home_0".equals(tag)) {
          return new FragmentHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTHOUSEHOLDRELATION: {
        if ("layout/fragment_household_relation_0".equals(tag)) {
          return new FragmentHouseholdRelationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_household_relation is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTIPSETTINGS: {
        if ("layout/fragment_ipsettings_0".equals(tag)) {
          return new FragmentIpsettingsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_ipsettings is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTLOCATIONINFO: {
        if ("layout/fragment_location_info_0".equals(tag)) {
          return new FragmentLocationInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_location_info is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMANUALRECOVERY: {
        if ("layout/fragment_manual_recovery_0".equals(tag)) {
          return new FragmentManualRecoveryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_manual_recovery is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMAPREGADDRESS: {
        if ("layout/fragment_map_reg_address_0".equals(tag)) {
          return new FragmentMapRegAddressBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_map_reg_address is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTMAPREGFARM: {
        if ("layout/fragment_map_reg_farm_0".equals(tag)) {
          return new FragmentMapRegFarmBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_map_reg_farm is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTNOFARM: {
        if ("layout/fragment_no_farm_0".equals(tag)) {
          return new FragmentNoFarmBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_no_farm is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTREGPREVIEW: {
        if ("layout/fragment_reg_preview_0".equals(tag)) {
          return new FragmentRegPreviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_reg_preview is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTREPORT: {
        if ("layout/fragment_report_0".equals(tag)) {
          return new FragmentReportBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_report is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSEARCHTIMELINEDIALOG: {
        if ("layout/fragment_search_timeline_dialog_0".equals(tag)) {
          return new FragmentSearchTimelineDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_search_timeline_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTTEMPLATEDIALOG: {
        if ("layout/fragment_template_dialog_0".equals(tag)) {
          return new FragmentTemplateDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_template_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTVIEWSERVICEPROVIDERS: {
        if ("layout/fragment_view_service_providers_0".equals(tag)) {
          return new FragmentViewServiceProvidersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_view_service_providers is invalid. Received: " + tag);
      }
      case  LAYOUT_HOUSEHOLDITEMLAYOUT: {
        if ("layout/household_item_layout_0".equals(tag)) {
          return new HouseholdsDataBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for household_item_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_HOUSEHOLDSEARCHACTIVITY: {
        if ("layout/household_search_activity_0".equals(tag)) {
          return new HouseholdSearchActivityBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for household_search_activity is invalid. Received: " + tag);
      }
      case  LAYOUT_HOUSEHOLDSEARCHITEM: {
        if ("layout/household_search_item_0".equals(tag)) {
          return new HouseholdDatabindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for household_search_item is invalid. Received: " + tag);
      }
      case  LAYOUT_PHOTOHEADER: {
        if ("layout/photo_header_0".equals(tag)) {
          return new PhotoHeaderBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for photo_header is invalid. Received: " + tag);
      }
      case  LAYOUT_RECYCLERITEMS: {
        if ("layout/recycler_items_0".equals(tag)) {
          return new RecyclerItemsBindingImpl(component, view);
        }
        if ("layout-sw600dp/recycler_items_0".equals(tag)) {
          return new RecyclerItemsBindingSw600dpImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for recycler_items is invalid. Received: " + tag);
      }
      case  LAYOUT_RECYCLERSERVICE: {
        if ("layout/recycler_service_0".equals(tag)) {
          return new RecyclerServiceBindingImpl(component, view);
        }
        if ("layout-sw600dp/recycler_service_0".equals(tag)) {
          return new RecyclerServiceBindingSw600dpImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for recycler_service is invalid. Received: " + tag);
      }
      case  LAYOUT_SCANDOCITEMLAYOUT: {
        if ("layout/scandoc_item_layout_0".equals(tag)) {
          return new ScandocItemLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for scandoc_item_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_SCANDOCPROFILEITEMLAYOUT: {
        if ("layout/scandoc_profile_item_layout_0".equals(tag)) {
          return new ScandocProfileItemLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for scandoc_profile_item_layout is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(21);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "farmgeo");
      sKeys.put(2, "recov");
      sKeys.put(3, "activity");
      sKeys.put(4, "basicreg");
      sKeys.put(5, "farmreg");
      sKeys.put(6, "ip");
      sKeys.put(7, "faf3");
      sKeys.put(8, "faf2");
      sKeys.put(9, "scan");
      sKeys.put(10, "bio");
      sKeys.put(11, "faf1");
      sKeys.put(12, "bioinfo");
      sKeys.put(13, "home");
      sKeys.put(14, "search");
      sKeys.put(15, "resaddr");
      sKeys.put(16, "report");
      sKeys.put(17, "household");
      sKeys.put(18, "chart");
      sKeys.put(19, "basicinfo");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(85);

    static {
      sKeys.put("layout/activity_agent_0", com.telpo.usb.finger.R.layout.activity_agent);
      sKeys.put("layout/activity_aggregator_test_0", com.telpo.usb.finger.R.layout.activity_aggregator_test);
      sKeys.put("layout/activity_dash_board_0", com.telpo.usb.finger.R.layout.activity_dash_board);
      sKeys.put("layout/activity_details_0", com.telpo.usb.finger.R.layout.activity_details);
      sKeys.put("layout/activity_export_farmers_assigned_agg_0", com.telpo.usb.finger.R.layout.activity_export_farmers_assigned_agg);
      sKeys.put("layout/activity_farm_map_polygon_0", com.telpo.usb.finger.R.layout.activity_farm_map_polygon);
      sKeys.put("layout/activity_farm_search_view_0", com.telpo.usb.finger.R.layout.activity_farm_search_view);
      sKeys.put("layout/activity_farmer2_0", com.telpo.usb.finger.R.layout.activity_farmer2);
      sKeys.put("layout/activity_farmer_search_aggregator_0", com.telpo.usb.finger.R.layout.activity_farmer_search_aggregator);
      sKeys.put("layout/activity_farmer_search_server_0", com.telpo.usb.finger.R.layout.activity_farmer_search_server);
      sKeys.put("layout/activity_farmer_search_server_details_0", com.telpo.usb.finger.R.layout.activity_farmer_search_server_details);
      sKeys.put("layout/activity_farmer_transaction_0", com.telpo.usb.finger.R.layout.activity_farmer_transaction);
      sKeys.put("layout/activity_finger_enroll_0", com.telpo.usb.finger.R.layout.activity_finger_enroll);
      sKeys.put("layout/activity_finger_verify_0", com.telpo.usb.finger.R.layout.activity_finger_verify);
      sKeys.put("layout/activity_household_relationship_0", com.telpo.usb.finger.R.layout.activity_household_relationship);
      sKeys.put("layout/activity_inputdist_main_0", com.telpo.usb.finger.R.layout.activity_inputdist_main);
      sKeys.put("layout/activity_item_layout_0", com.telpo.usb.finger.R.layout.activity_item_layout);
      sKeys.put("layout/activity_login_alt_0", com.telpo.usb.finger.R.layout.activity_login_alt);
      sKeys.put("layout/activity_packages_0", com.telpo.usb.finger.R.layout.activity_packages);
      sKeys.put("layout/activity_receive_inputs_0", com.telpo.usb.finger.R.layout.activity_receive_inputs);
      sKeys.put("layout/activity_recovery_0", com.telpo.usb.finger.R.layout.activity_recovery);
      sKeys.put("layout/activity_residential_map_0", com.telpo.usb.finger.R.layout.activity_residential_map);
      sKeys.put("layout/activity_saletrandetails_0", com.telpo.usb.finger.R.layout.activity_saletrandetails);
      sKeys.put("layout/activity_scan_docs_0", com.telpo.usb.finger.R.layout.activity_scan_docs);
      sKeys.put("layout/activity_send_bulk_sms_0", com.telpo.usb.finger.R.layout.activity_send_bulk_sms);
      sKeys.put("layout/activity_signature_0", com.telpo.usb.finger.R.layout.activity_signature);
      sKeys.put("layout/cart_bottom_sheet_0", com.telpo.usb.finger.R.layout.cart_bottom_sheet);
      sKeys.put("layout/content_export_farmers_assigned_agg_0", com.telpo.usb.finger.R.layout.content_export_farmers_assigned_agg);
      sKeys.put("layout/content_farmer_search_aggregator_0", com.telpo.usb.finger.R.layout.content_farmer_search_aggregator);
      sKeys.put("layout/content_packages_0", com.telpo.usb.finger.R.layout.content_packages);
      sKeys.put("layout/content_receive_inputs_0", com.telpo.usb.finger.R.layout.content_receive_inputs);
      sKeys.put("layout/content_remote_search_0", com.telpo.usb.finger.R.layout.content_remote_search);
      sKeys.put("layout/dialog_addinput_0", com.telpo.usb.finger.R.layout.dialog_addinput);
      sKeys.put("layout/dialog_addpackage_0", com.telpo.usb.finger.R.layout.dialog_addpackage);
      sKeys.put("layout/dialog_packagedetails_0", com.telpo.usb.finger.R.layout.dialog_packagedetails);
      sKeys.put("layout/dialog_select_aggregator_0", com.telpo.usb.finger.R.layout.dialog_select_aggregator);
      sKeys.put("layout/farm_item_layout_0", com.telpo.usb.finger.R.layout.farm_item_layout);
      sKeys.put("layout/farmer_bottomsheet_0", com.telpo.usb.finger.R.layout.farmer_bottomsheet);
      sKeys.put("layout/farmer_profile_fragment_0", com.telpo.usb.finger.R.layout.farmer_profile_fragment);
      sKeys.put("layout/farmer_search_agg_bottomsheet_0", com.telpo.usb.finger.R.layout.farmer_search_agg_bottomsheet);
      sKeys.put("layout/fragment_actions_0", com.telpo.usb.finger.R.layout.fragment_actions);
      sKeys.put("layout/fragment_add_another_activity_0", com.telpo.usb.finger.R.layout.fragment_add_another_activity);
      sKeys.put("layout/fragment_add_another_farm_0", com.telpo.usb.finger.R.layout.fragment_add_another_farm);
      sKeys.put("layout/fragment_address_0", com.telpo.usb.finger.R.layout.fragment_address);
      sKeys.put("layout/fragment_assign_farmer_aggregator_dialog_0", com.telpo.usb.finger.R.layout.fragment_assign_farmer_aggregator_dialog);
      sKeys.put("layout/fragment_automatic_recovery_0", com.telpo.usb.finger.R.layout.fragment_automatic_recovery);
      sKeys.put("layout/fragment_basic_info_0", com.telpo.usb.finger.R.layout.fragment_basic_info);
      sKeys.put("layout/fragment_biometrics_0", com.telpo.usb.finger.R.layout.fragment_biometrics);
      sKeys.put("layout/fragment_chart_0", com.telpo.usb.finger.R.layout.fragment_chart);
      sKeys.put("layout/fragment_chartbackup_0", com.telpo.usb.finger.R.layout.fragment_chartbackup);
      sKeys.put("layout/fragment_edit_activity_profile_0", com.telpo.usb.finger.R.layout.fragment_edit_activity_profile);
      sKeys.put("layout/fragment_edit_farminfo_0", com.telpo.usb.finger.R.layout.fragment_edit_farminfo);
      sKeys.put("layout/fragment_edit_personal_profile_0", com.telpo.usb.finger.R.layout.fragment_edit_personal_profile);
      sKeys.put("layout/fragment_edit_supportdocs_0", com.telpo.usb.finger.R.layout.fragment_edit_supportdocs);
      sKeys.put("layout/fragment_faf_1_0", com.telpo.usb.finger.R.layout.fragment_faf_1);
      sKeys.put("layout/fragment_faf_2_0", com.telpo.usb.finger.R.layout.fragment_faf_2);
      sKeys.put("layout/fragment_faf_3_0", com.telpo.usb.finger.R.layout.fragment_faf_3);
      sKeys.put("layout/fragment_farm_info_0", com.telpo.usb.finger.R.layout.fragment_farm_info);
      sKeys.put("layout/fragment_farmer_activity_info_0", com.telpo.usb.finger.R.layout.fragment_farmer_activity_info);
      sKeys.put("layout/fragment_farmer_profile_services_0", com.telpo.usb.finger.R.layout.fragment_farmer_profile_services);
      sKeys.put("layout/fragment_farmer_profile_summary_0", com.telpo.usb.finger.R.layout.fragment_farmer_profile_summary);
      sKeys.put("layout/fragment_farms_0", com.telpo.usb.finger.R.layout.fragment_farms);
      sKeys.put("layout/fragment_home_0", com.telpo.usb.finger.R.layout.fragment_home);
      sKeys.put("layout/fragment_household_relation_0", com.telpo.usb.finger.R.layout.fragment_household_relation);
      sKeys.put("layout/fragment_ipsettings_0", com.telpo.usb.finger.R.layout.fragment_ipsettings);
      sKeys.put("layout/fragment_location_info_0", com.telpo.usb.finger.R.layout.fragment_location_info);
      sKeys.put("layout/fragment_manual_recovery_0", com.telpo.usb.finger.R.layout.fragment_manual_recovery);
      sKeys.put("layout/fragment_map_reg_address_0", com.telpo.usb.finger.R.layout.fragment_map_reg_address);
      sKeys.put("layout/fragment_map_reg_farm_0", com.telpo.usb.finger.R.layout.fragment_map_reg_farm);
      sKeys.put("layout/fragment_no_farm_0", com.telpo.usb.finger.R.layout.fragment_no_farm);
      sKeys.put("layout/fragment_reg_preview_0", com.telpo.usb.finger.R.layout.fragment_reg_preview);
      sKeys.put("layout/fragment_report_0", com.telpo.usb.finger.R.layout.fragment_report);
      sKeys.put("layout/fragment_search_timeline_dialog_0", com.telpo.usb.finger.R.layout.fragment_search_timeline_dialog);
      sKeys.put("layout/fragment_template_dialog_0", com.telpo.usb.finger.R.layout.fragment_template_dialog);
      sKeys.put("layout/fragment_view_service_providers_0", com.telpo.usb.finger.R.layout.fragment_view_service_providers);
      sKeys.put("layout/household_item_layout_0", com.telpo.usb.finger.R.layout.household_item_layout);
      sKeys.put("layout/household_search_activity_0", com.telpo.usb.finger.R.layout.household_search_activity);
      sKeys.put("layout/household_search_item_0", com.telpo.usb.finger.R.layout.household_search_item);
      sKeys.put("layout/photo_header_0", com.telpo.usb.finger.R.layout.photo_header);
      sKeys.put("layout/recycler_items_0", com.telpo.usb.finger.R.layout.recycler_items);
      sKeys.put("layout-sw600dp/recycler_items_0", com.telpo.usb.finger.R.layout.recycler_items);
      sKeys.put("layout/recycler_service_0", com.telpo.usb.finger.R.layout.recycler_service);
      sKeys.put("layout-sw600dp/recycler_service_0", com.telpo.usb.finger.R.layout.recycler_service);
      sKeys.put("layout/scandoc_item_layout_0", com.telpo.usb.finger.R.layout.scandoc_item_layout);
      sKeys.put("layout/scandoc_profile_item_layout_0", com.telpo.usb.finger.R.layout.scandoc_profile_item_layout);
    }
  }
}
