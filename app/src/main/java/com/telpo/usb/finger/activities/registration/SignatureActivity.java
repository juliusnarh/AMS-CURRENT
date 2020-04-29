package com.telpo.usb.finger.activities.registration;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.telpo.usb.finger.R;
import com.telpo.usb.finger.databinding.ActivitySignatureBinding;
import com.telpo.usb.finger.utils.AndroidUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import es.dmoral.toasty.Toasty;

public class SignatureActivity extends AppCompatActivity implements SignaturePad.OnSignedListener {

    ActivitySignatureBinding binding;
    Uri contentUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signature);
        binding.signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {
            }

            @Override
            public void onSigned() {
                binding.saveButton.setEnabled(true);
                binding.clearButton.setEnabled(true);
            }

            @Override
            public void onClear() {
                binding.saveButton.setEnabled(false);
                binding.clearButton.setEnabled(false);
            }
        });
    }

    public void onClear(View view) {
        binding.signaturePad.clear();
    }

    public void onSave(View view) {
        Bitmap signatureBitmap = binding.signaturePad.getTransparentSignatureBitmap();
        if (addJpgSignatureToGallery(signatureBitmap)) {
            String signatureString = AndroidUtils.byteArrayToBase64(AndroidUtils.uriToByteArray(contentUri, getBaseContext()));
            AndroidUtils.savePreferenceData(this, AndroidUtils.SIGPREF, signatureString);
            Toasty.success(this, "Signature saved into the Gallery").show();
        } else {
            Toasty.error(this, "Unable to store the signature").show();
        }
//        if (addSvgSignatureToGallery(binding.signaturePad.getSignatureSvg())) {
//            Toasty.success(this, "SVG Signature saved into the Gallery").show();
//        } else {
//            Toasty.error(this, "Unable to store the SVG signature").show();
//        }

        Intent intent = new Intent();
        intent.putExtra("signature", true);
        setResult(RESULT_OK, intent);
        finish();
    }

    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("SignaturePad", "Directory not created");
        }
        return file;
    }

    public void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap, 0, 0, null);
        OutputStream stream = new FileOutputStream(photo);
        newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
        stream.close();
    }

    public boolean addJpgSignatureToGallery(Bitmap signature) {
        boolean result = false;
        try {
            File photo = new File(getAlbumStorageDir("SignaturePad"), String.format("Signature_%d.jpg", System.currentTimeMillis()));
            saveBitmapToJPG(signature, photo);
            scanMediaFile(photo);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void scanMediaFile(File photo) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        contentUri = Uri.fromFile(photo);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    public boolean addSvgSignatureToGallery(String signatureSvg) {
        boolean result = false;
        try {
            File svgFile = new File(getAlbumStorageDir("SignaturePad"), String.format("Signature_%d.svg", System.currentTimeMillis()));
            OutputStream stream = new FileOutputStream(svgFile);
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            writer.write(signatureSvg);
            writer.close();
            stream.flush();
            stream.close();
            scanMediaFile(svgFile);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void onStartSigning() {
        System.out.println("hello");
    }

    @Override
    public void onSigned() {

    }

    @Override
    public void onClear() {

    }
}
