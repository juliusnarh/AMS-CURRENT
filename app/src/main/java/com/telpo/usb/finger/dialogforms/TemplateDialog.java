package com.telpo.usb.finger.dialogforms;


import android.app.Dialog;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.FragmentTemplateDialogBinding;
import com.telpo.usb.finger.entities.Templates;
import com.telpo.usb.finger.interfaces.GetTemplateClickListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TemplateDialog extends DialogFragment implements GetTemplateClickListener {
    public static String TAG = "FullScreenDialog";
    public static GetTemplateClickListener listener;
    FragmentTemplateDialogBinding binding;

    public static TemplateDialog newInstance(GetTemplateClickListener templateClickListener) {
        TemplateDialog templateDialog = new TemplateDialog();
        listener = templateClickListener;
        Bundle args = new Bundle();
        templateDialog.setArguments(args);
        return templateDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_template_dialog, container, false);
        View view = binding.getRoot();
        List<Templates> templatesList = Templates.listAll(Templates.class);
        binding.close.setOnClickListener(v -> dismiss());
        binding.templateRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.templateRecycler.setAdapter(new TemplateDialog.TemplateAdapter(templatesList, this));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        dialog.setCancelable(false);
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().getAttributes().windowAnimations = R.style.traininganimate;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public void ongetTemplateClickListener(String template) {
        listener.ongetTemplateClickListener(template);
    }


    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView template;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.item_template, parent, false));
            template = itemView.findViewById(R.id.template);
        }

    }

    private class TemplateAdapter extends RecyclerView.Adapter<TemplateDialog.ViewHolder> {

        List<Templates> templatesList;
        GetTemplateClickListener listener;

        TemplateAdapter(List<Templates> temp, GetTemplateClickListener templateClickListener) {
            templatesList = temp;
            listener = templateClickListener;
        }

        @Override
        public TemplateDialog.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TemplateDialog.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(TemplateDialog.ViewHolder holder, int position) {
            Templates templates = templatesList.get(position);
            holder.template.setText(templates.getTemplate());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.ongetTemplateClickListener(templates.getTemplate());
                }
            });
        }

        @Override
        public int getItemCount() {
            return templatesList.size();
        }

    }
}
