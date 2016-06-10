package com.origin.ueliton.bulltrail.util;

import android.net.Uri;
import android.os.Environment;
import android.support.annotation.VisibleForTesting;

import java.io.File;
import java.io.IOException;

/**
 * Created by ueliton on 5/29/16.
 */
public class ImageFileImpl implements ImageFile{

    @VisibleForTesting
    File mImageFile;

    @Override
    public void create(String name, String extension) throws IOException {
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);

        mImageFile = File.createTempFile(
                name,  /* prefix */
                extension,        /* suffix */
                storageDir      /* directory */
        );
    }

    @Override
    public boolean exists() {
        return null != mImageFile && mImageFile.exists();
    }

    @Override
    public void delete() {
        mImageFile = null;
    }

    @Override
    public String getPath() {
        return Uri.fromFile(mImageFile).toString();
    }
}
