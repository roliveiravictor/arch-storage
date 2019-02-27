package br.com.stonetree.storage.app;

import br.com.stonetree.storage.shared.abstracts.environment.DataStorage;

public class Session {

    private static Session instance;

    private DataStorage storage;

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public DataStorage getStorage() {
        return storage;
    }

    protected void setStorage(DataStorage storage) {
        this.storage = storage;
    }

}
