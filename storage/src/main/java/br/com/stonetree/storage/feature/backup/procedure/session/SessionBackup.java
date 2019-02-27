package br.com.stonetree.storage.feature.backup.procedure.session;

import java.util.ArrayList;
import java.util.List;

import br.com.stonetree.storage.shared.abstracts.backup.Backup;
import br.com.stonetree.storage.shared.constants.Constants;

public class SessionBackup extends Backup {

    @Override
    public String parseToSave(String data) {
        return Constants.EMPTY;
    }

    @Override
    public List<String> parseToLoad(String data) {
        return new ArrayList<>();
    }

    @Override
    protected String encrypt(String data) {
        return Constants.EMPTY;
    }

    @Override
    protected String decrypt(String data) {
        return Constants.EMPTY;
    }

}
