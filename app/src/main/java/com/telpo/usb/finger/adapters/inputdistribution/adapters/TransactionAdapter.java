package com.telpo.usb.finger.adapters.inputdistribution.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.entities.InputTransaction;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;
    List<InputTransaction> inputTransactionList;
    Context context;

    public TransactionAdapter(List<InputTransaction> inputTransactionList, Context context) {
        this.inputTransactionList = inputTransactionList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return inputTransactionList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.transaction_card_header, parent, false);

                return new MyViewHolder(view);
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.transaction_card_list, parent, false);
                return new MyViewHolder(view);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                holder.mChart.setUsePercentValues(true);
//                holder.mChart.setExtraOffsets(5, 10, 5, 5);
                holder.mChart.setExtraTopOffset(10);
                holder.mChart.setDragDecelerationFrictionCoef(0.95f);
                holder.mChart.setDrawHoleEnabled(true);
                holder.mChart.setHoleColor(Color.WHITE);
                holder.mChart.setTransparentCircleColor(Color.WHITE);
                holder.mChart.setTransparentCircleAlpha(110);
                holder.mChart.setHoleRadius(55f);
                holder.mChart.setTransparentCircleRadius(61f);
                holder.mChart.setDrawCenterText(true);
                holder.mChart.setRotationAngle(0);
                holder.mChart.setRotationEnabled(true);
                holder.mChart.setHighlightPerTapEnabled(true);
                holder.mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
                holder.mChart.getDescription().setEnabled(false);
//                holder.mChart.getLegend().setEnabled(false);
                Legend l = holder.mChart.getLegend();
                l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
                l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
                l.setOrientation(Legend.LegendOrientation.VERTICAL);
                l.setDrawInside(false);

                int totalCreditCount = 0, totalPaidCount = 0, totalTransactions,
                        totalDebtorsCount, totalItemsStock;

                totalDebtorsCount = AndroidUtils.getDebtorCount() - 1;
                totalTransactions = AndroidUtils.getTransactionCount();
                totalItemsStock = AndroidUtils.getInputCount();

                for (int i = 1; i <= totalTransactions; i++) {
                    InputTransaction inputTransaction = InputTransaction.findById(InputTransaction.class, i);
                    if (inputTransaction != null) {
                        if (inputTransaction.getPayment_style().toLowerCase().equals("credit")) {
                            totalCreditCount += 1;
                        } else if (inputTransaction.getPayment_style().toLowerCase().equals("postpaid")) {
                            totalPaidCount += 1;
                        }
                    }
                }

                List<PieEntry> entries = new ArrayList<>();

                entries.add(new PieEntry((float) totalCreditCount, "Credit"));
                entries.add(new PieEntry((float) totalDebtorsCount, "Debtors"));
                entries.add(new PieEntry((float) totalItemsStock, "Stock"));
                entries.add(new PieEntry((float) totalPaidCount, "Paid"));
                entries.add(new PieEntry((float) totalTransactions, "Transactions"));
                PieDataSet set = new PieDataSet(entries, "Summary");
                set.setColors(new int[]{R.color.colorPrimaryDark, R.color.green4,
                        R.color.secondary_light, R.color.teal_800, R.color.teal_900, R.color.black,
                        R.color.cyan_400, R.color.grey_600, R.color.brown_900, R.color.lime_800}, context);
                PieData data = new PieData(set);
                holder.mChart.setData(data);
//                holder.mChart.notifyDataSetChanged();
//                holder.mChart.invalidate();
                break;

            case TYPE_CELL:
                final InputTransaction inputTransaction = inputTransactionList.get(position);
                holder.farmerID.setText(inputTransaction.getFarmer_id());
                if (inputTransaction.getFarmer_id().contains(":")) {
                    String partFarmerId[] = inputTransaction.getFarmer_id().split(":");
                    holder.farmerName.setText(AndroidUtils.loadFarmerName(partFarmerId[0]).toUpperCase());
                } else
                    holder.farmerName.setText(AndroidUtils.loadFarmerName(inputTransaction.getFarmer_id()).toUpperCase());
//                holder.farmerName.setText(db.loadFarmerName(inputTransaction.getFarmer_id()).toUpperCase());
                holder.paymentMethod.setText(inputTransaction.getPayment_method().toUpperCase());
                holder.paymentStyle.setText(inputTransaction.getPayment_style().toUpperCase());
                holder.paymentStatus.setText(inputTransaction.getDebtor_status().toUpperCase());
                setOrderAndQuantity(holder, inputTransaction);
                holder.total.setText(String.format(holder.res.getString(R.string.price_item), Double.parseDouble(inputTransaction.getItems_total())));
                holder.transaction_date.setText(AndroidUtils.formatDate(inputTransaction.getDate_created()));
                break;
        }
    }

    private void setOrderAndQuantity(MyViewHolder holder, InputTransaction inputTransaction) {

        StringBuilder newOrderDetails = new StringBuilder();
        String itemsPurchased = inputTransaction.getItems_purchased();
        String quantity = inputTransaction.getItems_quantity();
        if (!itemsPurchased.isEmpty()) {
            if (itemsPurchased.contains(",")) {
                String[] partsItems = itemsPurchased.split(",");
                String[] partsQuantity = quantity.split(",");

                for (int i = 0; i < partsItems.length; i++) {
                    if (!partsItems[i].contains("~")) {
                        String temp = holder.res.getString(R.string.actual_order_detail, partsItems[i], partsQuantity[i]);
                        newOrderDetails.append(temp).append("\n");
                    }
                }
            } else {
                if (!itemsPurchased.contains("~")) {
                    String temp = holder.res.getString(R.string.actual_order_detail, itemsPurchased, quantity);
                    newOrderDetails.append(temp);
                } else {
                    String[] partsItems = itemsPurchased.split("~");
                    String[] partsQuantity = quantity.split("~");
                    String temp = holder.res.getString(R.string.actual_order_detail, partsItems[0], partsQuantity[0]);
                    newOrderDetails.append(temp);
                }
            }
        }
        holder.itemsPurchased.setText(String.valueOf(newOrderDetails).toUpperCase());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        PieChart mChart;
        TextView farmerName, farmerID, itemsPurchased, total, paymentMethod, paymentStyle, paymentStatus, transaction_date;
        Resources res;

        public MyViewHolder(View itemView) {
            super(itemView);
            res = itemView.getContext().getResources();
            mChart = itemView.findViewById(R.id.transact_pie_chart);
            farmerName = itemView.findViewById(R.id.trans_farmer_name);
            farmerID = itemView.findViewById(R.id.trans_farmer_id);
            paymentMethod = itemView.findViewById(R.id.trans_payment_method);
            paymentStyle = itemView.findViewById(R.id.trans_payment_style);
            paymentStatus = itemView.findViewById(R.id.trans_payment_status);
            itemsPurchased = itemView.findViewById(R.id.trans_items_purchased);
            total = itemView.findViewById(R.id.trans_items_total);
            transaction_date = itemView.findViewById(R.id.trans_date);
        }
    }
}