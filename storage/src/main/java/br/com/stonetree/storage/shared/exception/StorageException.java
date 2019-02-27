package br.com.stonetree.storage.shared.exception;

import android.util.Log;

public class StorageException extends Exception {

    public StorageException(String message) {
        Log.e(StorageException.class.getName(), message);
    }

}
