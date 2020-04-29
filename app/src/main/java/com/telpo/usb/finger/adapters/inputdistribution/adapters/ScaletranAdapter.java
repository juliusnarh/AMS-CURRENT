package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.Declaration;
import com.telpo.usb.finger.entities.Scaletran;
import com.telpo.usb.finger.interfaces.ScaletranClickListener;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

import at.grabner.circleprogress.CircleProgressView;
import at.grabner.circleprogress.ColorUtils;
import de.hdodenhof.circleimageview.CircleImageView;

public class ScaletranAdapter extends RecyclerView.Adapter<ScaletranAdapter.MyViewHolder> implements Filterable {
    Resources res;
    private Context mContext;
    private List<Scaletran> scaletranList;
    private List<Scaletran> scaletranListFiltered;
    private ScaletranClickListener listener;

    public ScaletranAdapter(Context mContext, List<Scaletran> scaletranList, ScaletranClickListener listener) {
        this.mContext = mContext;
        this.scaletranList = scaletranList;
        this.scaletranListFiltered = scaletranList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ScaletranAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.agent_item, parent, false);
        return new ScaletranAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ScaletranAdapter.MyViewHolder holder, final int position) {
        res = holder.itemView.getContext().getResources();
        Scaletran scaletran = scaletranList.get(position);
        Double tendered = 0.00, payable = 0.00;
        if (scaletran != null) {
            List<Scaletran> allscaletranList = Scaletran.find(Scaletran.class, "farmerid = ?", scaletran.getFarmerid());
            List<Declaration> declarationList = Declaration.find(Declaration.class, "farmerid = ?", scaletran.getFarmerid());

            String[] farmerinfo = AndroidUtils.loadFarmerInformation(scaletran.getFarmerid());

            if (declarationList.size() > 0) {
                for (int i = 0; i < declarationList.size(); i++) {
//                    payable += 14 * Integer.parseInt(declaration.getAcreage());

                    String[] declarationparts = declarationList.get(i).getDeclaration().split(" ");


                    for (int x = 0; x < declarationparts.length; x++) {
                        if (declarationparts[x].equals("exchange")) {
                            payable += Double.parseDouble(declarationparts[x + 1]);
                            break;
                        }
                    }
                }
            }

            if (allscaletranList.size() > 0) {
                for (int i = 0; i < allscaletranList.size(); i++) {

                    if (allscaletranList.get(i).getTransid().equals(scaletran.getTransid())) {
                        if (i > 0) {
                            for (int y = 0; y <= i; y++) {
                                if (allscaletranList.get(y).getTransid().startsWith(AndroidUtils.RECOVERY)) {
                                    try {
                                        tendered += Double.parseDouble(allscaletranList.get(y).getTendered());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } else if (i == 0) {
                            tendered = Double.parseDouble(allscaletranList.get(i).getTendered());
                        }
                    }
                }

            }

            holder.farmerimg.setImageDrawable(AndroidUtils.arraytodrawable(AndroidUtils.loadFarmerImg(scaletran.getFarmerid(), res), mContext));
            holder.farmername.setText(farmerinfo[0]);
            holder.farmerid.setText(scaletran.getFarmerid());
            holder.farmernumber.setText(farmerinfo[5]);
            holder.farmerregcom.setText(res.getString(R.string.reg_com, farmerinfo[2], farmerinfo[4]));
            holder.farmerprogress.setBarColor(ColorUtils.getRGBGradient(res.getColor(R.color.bar1), res.getColor(R.color.bar4), 0.8f));


            if (scaletran.getTransid().startsWith(AndroidUtils.RECOVERY)) {


                holder.farmerprogress.setMaxValue(payable.floatValue());


                holder.farmerprogress.setValue(tendered.floatValue());

                holder.tendered.setText(res.getString(R.string._s10_20, res.getString(R.string.price, tendered), res.getString(R.string.price, payable)));
            } else {

                holder.farmerprogress.setMaxValue(Float.valueOf(scaletran.getTendered()));

                holder.farmerprogress.setValue(Float.valueOf(scaletran.getTendered()));

                holder.tendered.setText(res.getString(R.string._s10_20, res.getString(R.string.price, Double.parseDouble(scaletran.getTendered())), res.getString(R.string.price, Double.parseDouble(scaletran.getTendered()))));
            }


            ViewCompat.setTransitionName(holder.farmerimg, scaletran.scaleid);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.onScaletranClickListener(holder.getAdapterPosition(), scaletran, holder.farmerimg);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return scaletranListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    scaletranListFiltered = scaletranList;
                } else {
                    List<Scaletran> filteredList = new ArrayList<>();
                    for (Scaletran row : scaletranList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (
                                row.getTransid().toLowerCase().startsWith(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    scaletranListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = scaletranListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                scaletranListFiltered = (ArrayList<Scaletran>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView farmerimg;
        TextView farmername, farmerid, farmernumber, farmerregcom, tendered;
        CircleProgressView farmerprogress;

        public MyViewHolder(View view) {
            super(view);
            farmerimg = view.findViewById(R.id.farmerimg);
            farmername = view.findViewById(R.id.farmername);
            farmerid = view.findViewById(R.id.farmerid);
            farmernumber = view.findViewById(R.id.farmernumber);
            farmerregcom = view.findViewById(R.id.farmerreg_com);
            farmerprogress = view.findViewById(R.id.farmerprogress);
            tendered = view.findViewById(R.id.tendered);
        }
    }

}
