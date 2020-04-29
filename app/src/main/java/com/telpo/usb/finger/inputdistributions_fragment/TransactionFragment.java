package com.telpo.usb.finger.inputdistributions_fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.RecyclerViewMaterialAdapter;
import com.telpo.usb.finger.adapters.inputdistribution.adapters.TransactionAdapter;
import com.telpo.usb.finger.entities.InputTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class TransactionFragment extends Fragment {

    private List<InputTransaction> inputTransactionList = new ArrayList<>();

    public static TransactionFragment newInstance() {
        return new TransactionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transaction, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView mRecyclerView = view.findViewById(R.id.transaction_recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        InputTransaction inputTransaction = new InputTransaction();
        inputTransactionList.add(inputTransaction);
        inputTransactionList.addAll(InputTransaction.listAll(InputTransaction.class));
        RecyclerView.Adapter mAdapter = new RecyclerViewMaterialAdapter(new TransactionAdapter(inputTransactionList, getActivity()));
        mRecyclerView.setAdapter(mAdapter);


        MaterialViewPagerHelper.registerRecyclerView(getActivity(), mRecyclerView);
    }
}
