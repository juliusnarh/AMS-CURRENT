package com.telpo.usb.finger.inputdistributions_fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.ServiceProviders;
import com.telpo.usb.finger.entities.ServiceType;
import com.telpo.usb.finger.registration.fragments.ListDialogFragment;

import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class ServiceProvidersDialogFragment extends BottomSheetDialogFragment implements ListDialogFragment.OnListDialogItemSelect {

    private static final String ARG_PARAM1 = "param1";
    // TODO: Customize parameter argument names
    static List<ServiceProviders> providersList;
    static List<ServiceType> typeList;
    ServiceType servicet = null;
    ServiceProviders servicep = null;
    int pos;
    ListDialogFragment dialogFragment;
    FragmentManager fm;
    String[] listitems;
    EditText providername, contact, desc, name;
    ItemAdapter adapter;
    private String mParam1;

    // TODO: Customize parameters
    public static ServiceProvidersDialogFragment newInstance(List<ServiceType> types, List<ServiceProviders> providers, String param) {
        final ServiceProvidersDialogFragment fragment = new ServiceProvidersDialogFragment();
        providersList = providers;
        typeList = types;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getTheme() {
        return R.style.BaseBottomSheetDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_service_providers_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.list);
        ImageView close = view.findViewById(R.id.close);
        TextView service = view.findViewById(R.id.service);
        TextView norecord = view.findViewById(R.id.norecord);

        if (providersList == null) {
            service.setText("Service Types");
        } else
            service.setText("Service Providers");

        close.setOnClickListener(v -> getDialog().dismiss());


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        if (providersList == null) {
            if (typeList.size() > 0) {
                adapter = new ItemAdapter(null, typeList);
                recyclerView.setAdapter(adapter);
                if (norecord.getVisibility() == View.VISIBLE) norecord.setVisibility(View.GONE);
            } else norecord.setVisibility(View.VISIBLE);
        } else {
            if (providersList.size() > 0) {
                adapter = new ItemAdapter(providersList, null);
                recyclerView.setAdapter(adapter);
                if (norecord.getVisibility() == View.VISIBLE) norecord.setVisibility(View.GONE);
            } else norecord.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onListItemSelected(String selection) {
        String componentname = (String) dialogFragment.getArguments().get("componentname");
        if (componentname.equalsIgnoreCase("provider")) {
            if (selection.equalsIgnoreCase("edit")) {
                if (servicep != null) {
                    updateprovider(servicep);
                }
            } else if (selection.equalsIgnoreCase("delete")) {
                if (servicep != null) {
                    servicep.delete();
                    providersList.remove(pos);
                    adapter.notifyDataSetChanged();
                    Toasty.success(getContext(), "Service Provider deleted!").show();
                }
            }
        } else {
            if (selection.equalsIgnoreCase("edit")) {
                if (servicet != null) {
                    updateservicetype(servicet);
                }
            } else if (selection.equalsIgnoreCase("delete")) {
                if (servicet != null) {
                    servicet.delete();
                    typeList.remove(pos);
                    adapter.notifyDataSetChanged();
                    Toasty.success(getContext(), "Service Type deleted!").show();
                }
            }
        }
    }

    private void updateservicetype(ServiceType servicet) {
        MaterialDialog serviceForm = new MaterialDialog.Builder(getContext())
                .title("Update Service Type")
                .customView(R.layout.custom_service_type_form, true)
                .positiveText("Ok")
                .negativeText(R.string.negative)
                .cancelable(false)
                .onPositive((dialog, which) -> {
                    if (!name.getText().toString().isEmpty()) {
                        ServiceType type = ServiceType.findById(ServiceType.class, servicet.getId());

                        if (type != null) {

                            type.servicetype = name.getText().toString();
                            type.save();
                            typeList.remove(pos);
                            typeList.add(pos, type);
                            adapter.notifyDataSetChanged();
                        }
                        Toasty.success(getContext(), "Service Type updated!").show();

                    } else {
                        Toasty.error(getContext(), "An error occurred").show();
                    }
                })
                .show();
        assert serviceForm.getCustomView() != null;
        name = serviceForm.getCustomView().findViewById(R.id.name);
        name.setText(servicet.getServicetype());
    }

    private void updateprovider(ServiceProviders servicep) {
        MaterialDialog serviceForm = new MaterialDialog.Builder(getContext())
                .title("Update Service Provider")
                .customView(R.layout.custom_service_provider_form, true)
                .positiveText("Ok")
                .negativeText(R.string.negative)
                .cancelable(false)
                .onPositive((dialog, which) -> {
                    if (!providername.getText().toString().isEmpty() && !desc.getText().toString().isEmpty() && !contact.getText().toString().isEmpty()) {


                        ServiceProviders providers = ServiceProviders.findById(ServiceProviders.class, servicep.getId());

                        if (providers != null) {

                            providers.provider = providername.getText().toString();
                            providers.contact = contact.getText().toString();
                            providers.servicedesc = desc.getText().toString();

                            adapter.notifyItemChanged(pos, providers);

                            providersList.remove(pos);
                            providersList.add(pos, providers);
                            adapter.notifyDataSetChanged();
                            providers.save();
                            Toasty.success(getContext(), "Service Provider updated!").show();
                        }


                    } else {
                        Toasty.error(getContext(), "An error occurred").show();
                    }
                })
                .show();
        assert serviceForm.getCustomView() != null;
        providername = serviceForm.getCustomView().findViewById(R.id.provider_name);
        desc = serviceForm.getCustomView().findViewById(R.id.desc);
        contact = serviceForm.getCustomView().findViewById(R.id.contact);

        providername.setText(servicep.getProvider());
        desc.setText(servicep.getServicedesc());
        contact.setText(servicep.getContact());
    }

    private void showOptionDialog(String[] array, String title, String componentname) {
        fm = getChildFragmentManager();
        dialogFragment = new ListDialogFragment(this, array, title, componentname);
        dialogFragment.show(fm, componentname);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        final TextView servicename;
        final TextView servicedesc;
        final TextView contact;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.fragment_service_list_dialog_item, parent, false));
            servicename = itemView.findViewById(R.id.servicename);
            servicedesc = itemView.findViewById(R.id.servicdesc);
            contact = itemView.findViewById(R.id.contact);
        }

    }

    private class ItemAdapter extends RecyclerView.Adapter<ViewHolder> {

        List<ServiceProviders> providersList;
        List<ServiceType> typeList;

        ItemAdapter(List<ServiceProviders> providers, List<ServiceType> type) {
            typeList = type;
            providersList = providers;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            listitems = getResources().getStringArray(R.array.editdelete);

            if (providersList == null) {

                ServiceType serviceType = typeList.get(position);
                holder.servicedesc.setVisibility(View.GONE);
                holder.contact.setVisibility(View.GONE);
                holder.servicename.setText(serviceType.getServicetype());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showOptionDialog(listitems, "Select Option", "type");
                        servicet = serviceType;
                        pos = position;
                    }
                });
            } else {
                ServiceProviders serviceProviders = providersList.get(position);
                holder.servicedesc.setVisibility(View.VISIBLE);
                holder.contact.setVisibility(View.VISIBLE);
                holder.servicename.setText(serviceProviders.getProvider());
                holder.servicedesc.setText(serviceProviders.getServicedesc());
                holder.contact.setText(serviceProviders.getContact());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showOptionDialog(listitems, "Select Option", "provider");
                        servicep = serviceProviders;
                        pos = position;
                    }
                });
            }

        }

        @Override
        public int getItemCount() {
            if (providersList == null) {
                return typeList.size();
            } else
                return providersList.size();
        }

    }

}
