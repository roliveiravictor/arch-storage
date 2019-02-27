package br.com.stonetree.storage.feature.backup.procedure.instant;

import java.util.Arrays;
import java.util.List;

import br.com.stonetree.oscrypto.helper.OSCryptoHelper;
import br.com.stonetree.storage.BuildConfig;
import br.com.stonetree.storage.shared.abstracts.backup.Backup;
import br.com.stonetree.storage.shared.constants.Constants;

public class InstantBackup extends Backup {

    @Override
    public String parseToSave(String data) {
        if (data.contains(Constants.DATA_BREAKER)) {
            final String[] parsedData = data.split(Constants.DATA_BREAKER);
            final String encryption = parsedData[Constants.FIRST_INDEX];
            final String newData = parsedData[Constants.SECOND_INDEX];
            data = decrypt(encryption) + newData;
        }

        data = encrypt(data);
        return data;

    }

    @Override
    protected String encrypt(String data) {
        if (BuildConfig.IS_PRO)
            return OSCryptoHelper.encrypt(data + Constants.DATA_BREAKER);
        else
            return data;
    }

    @Override
    protected String decrypt(String data) {
        if (BuildConfig.IS_PRO)
            return OSCryptoHelper.decrypt(data);
        else
            return data;
    }

    @Override
    public List<String> parseToLoad(String data) {
        data = decrypt(data);
        final String[] parsedData = data.split(Constants.DATA_BREAKER);
        return Arrays.asList(parsedData);
    }

}
