package com.telpo.usb.finger.inputdistributions_fragment;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.interfaces.ModifyRecoveryClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.List;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class ModifyRecoveryDialogFragment extends BottomSheetDialogFragment {
    // TODO: Customize parameter argument names
    static List<Declaration> list;
    private static ModifyRecoveryClickListener clicklistener;

    // TODO: Customize parameters
    public static ModifyRecoveryDialogFragment newInstance(List<Declaration> declarations, ModifyRecoveryClickListener listener) {
        final ModifyRecoveryDialogFragment fragment = new ModifyRecoveryDialogFragment();
        list = declarations;
        clicklistener = listener;
        return fragment;
    }

    @Override
    public int getTheme() {
        return R.style.BaseBottomSheetDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_modify_recovery_list_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = view.findViewById(R.id.list);
        ImageView close = view.findViewById(R.id.close);

        close.setOnClickListener(v -> getDialog().dismiss());


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new DecAdapter(list));
    }


    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView transid, bagspayable, tendered, date;

        ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            // TODO: Customize the item layout
            super(inflater.inflate(R.layout.fragment_modify_recovery_dialog_item, parent, false));
            transid = itemView.findViewById(R.id.transid);
            bagspayable = itemView.findViewById(R.id.bagspayable);
            tendered = itemView.findViewById(R.id.tendered);
            date = itemView.findViewById(R.id.date);
        }

    }

    private class DecAdapter extends RecyclerView.Adapter<ViewHolder> {

        List<Declaration> declarations;
        String[] declarationparts;

        DecAdapter(List<Declaration> list) {
            declarations = list;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Declaration declaration = declarations.get(position);
            Resources res = holder.itemView.getResources();
            Double bagspayable = null, tendered = null;
            int index = 0;
            holder.transid.setText(declaration.getTransactionid());
            holder.date.setText(AndroidUtils.dateToFormattedString(declaration.getDatecreated(), "MMM dd, yyyy hh:mm:ss a"));
            declarationparts = declaration.getDeclaration().split(" ");


            for (int i = 0; i < declarationparts.length; i++) {
                if (declarationparts[i].equals("exchange")) {
                    bagspayable = Double.parseDouble(declarationparts[i + 1]);
                    index = i + 1;
                    break;
                }
            }

            try {
                holder.bagspayable.setText(res.getString(R.string.expected, bagspayable));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            if (bagspayable != null) tendered = bagspayable - declaration.getNorecoverybags();

            holder.tendered.setText(getResources().getString(R.string.expected, tendered));

            Double finalTendered = tendered;
            int finalIndex = index;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateRecovery(declaration, finalTendered, finalIndex);
                }
            });
        }

        private void updateRecovery(Declaration declaration, double tendered, int index) {
            final MaterialDialog progDialog = new MaterialDialog.Builder(getContext())
                    .content(R.string.please_wait)
                    .progress(true, 0)
                    .cancelable(false)
                    .build();
            progDialog.show();
            new Handler().postDelayed(() -> {
                        progDialog.dismiss();
                        new MaterialDialog.Builder(getContext())
                                .title("Update Recovery")
                                .titleColorRes(R.color.grey_600)
                                .content("Kindly enter no. of recovery bags owing")
                                .theme(Theme.LIGHT)
                                .inputType(InputType.TYPE_CLASS_NUMBER)
                                .input("", null, false, (dialog, input) -> {
                                    declaration.norecoverybags = Double.parseDouble(input.toString()) - tendered;
                                    declarationparts[index] = getResources().getString(R.string.price, Double.parseDouble(input.toString()));
                                    String[] farmer = AndroidUtils.loadFarmerInformation(declaration.getFarmerid());

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                        declaration.declaration = String.join(" ", declarationparts);
                                    } else declaration.declaration = TextUtils.join(" ", declarationparts);

                                    if (declaration.getStatus().equals("redeemed")) {
                                        declaration.status = "owing";
                                    }
                                    AndroidUtils.sendMessage(getContext(), "0546473945", "Please send YES to authorize change or NO to cancel change");
                                    clicklistener.OnModifyRecoveryClickListener(declaration);

                                    dismiss();


                                })
                                .show();

                    }
                    , 1000);
        }

        @Override
        public int getItemCount() {
            return declarations.size();
        }

    }
}
