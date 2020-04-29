package com.telpo.usb.finger.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.telpo.usb.finger.databinding.ScandocItemLayoutBinding;
import com.telpo.usb.finger.entities.SupportDocs;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * Created by Junior on 1/11/2018.
 */

public class ScanDocAdapter extends RecyclerView.Adapter<ScanDocAdapter.MyViewHolder> {
    ScandocItemLayoutBinding databinding;
    private List<SupportDocs> docsList;
    private Context context;
    private LayoutInflater inflater;
    private FragmentManager fragmentManager;


    public ScanDocAdapter(List<SupportDocs> docsList, Context context) {
        this.context = context;
        this.docsList = docsList;
    }

    public static Bitmap rotateBitmap(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        databinding = ScandocItemLayoutBinding.inflate(inflater, parent, false);
        return new MyViewHolder(databinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final SupportDocs docs = docsList.get(position);
        holder.bind(docs);

        databinding.btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] img = docs.getDocument();
                Bitmap bmp = rotateBitmap(AndroidUtils.byteArrayToBitmap(img), 90f);

                docs.setDocument(AndroidUtils.bitmapToByteArray(bmp));
                notifyItemChanged(position);
            }
        });
        databinding.btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                docsList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, docsList.size());

                Toasty.success(context, "Document removed successfully").show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return docsList.size();
    }

    public void notifyaddeddata() {
        notifyItemInserted(0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ScandocItemLayoutBinding databinding;

        MyViewHolder(ScandocItemLayoutBinding databinding) {
            super(databinding.getRoot());
            this.databinding = databinding;
            databinding.executePendingBindings();
        }

        public void bind(SupportDocs registy) {
            this.databinding.setScan(registy);
        }

        public ScandocItemLayoutBinding getDatabinding() {
            return databinding;
        }
    }
}
