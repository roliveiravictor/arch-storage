package br.com.stonetree.storage.shared.abstracts.backup;

import java.util.List;

import br.com.stonetree.oscrypto.helper.OSCryptoHelper;
import br.com.stonetree.storage.shared.model.MetaData;

public abstract class Backup {

    public Backup() {
        OSCryptoHelper.start(MetaData.getInstance().getActivity());
    }

    /**
     * Convert data to be stored
     **/
    public abstract String parseToSave(String data);

    /**
     * Convert data to be loaded
     *
     * @param data
     */
    public abstract List<String> parseToLoad(String data);

    /**
     * Encrypt data to be stored
     **/
    protected abstract String encrypt(String data);

    /**
     * Encrypt data to be stored
     **/
    protected abstract String decrypt(String data);

    /**
     * Stack data until its push cycle
     **/
    protected void stack(String data) {

    }

}
