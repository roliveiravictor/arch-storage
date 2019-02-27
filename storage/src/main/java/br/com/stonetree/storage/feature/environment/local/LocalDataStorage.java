package br.com.stonetree.storage.feature.environment.local;

import android.content.SharedPreferences;

import java.util.List;

import br.com.stonetree.storage.shared.Collections;
import br.com.stonetree.storage.shared.abstracts.backup.Backup;
import br.com.stonetree.storage.shared.abstracts.environment.DataStorage;
import br.com.stonetree.storage.shared.constants.Constants;
import br.com.stonetree.storage.shared.factory.BackupFactory;

import static android.content.Context.MODE_PRIVATE;

public class LocalDataStorage extends DataStorage {

    private SharedPreferences preferences;

    public LocalDataStorage() {
        setSharedPreferences();
        setBackupType();
    }

    private void setSharedPreferences() {
        preferences = getActivity().getSharedPreferences(TAG, MODE_PRIVATE);
    }

    private void setBackupType() {
        final Backup backup = BackupFactory.create();
        setBackup(backup);
    }

    @Override
    public void save(String data) {
        final SharedPreferences.Editor editor = preferences.edit();

        final String rawRecords = loadRaw();
        if (Collections.isNotNullOrEmpty(rawRecords))
            data = rawRecords + Constants.DATA_BREAKER + data;

        final String parsedData = getBackup().parseToSave(data);
        if (Collections.isNotNullOrEmpty(parsedData)) {
            editor.putString(TAG, parsedData);
            editor.apply();
        }
    }

    @Override
    public List<String> load() {
        final String data = preferences.getString(TAG, Constants.EMPTY);
        return getBackup().parseToLoad(data);
    }

    @Override
    public void clear() {
        preferences.edit().clear().apply();
    }


    @Override
    protected String loadRaw() {
        final String data = preferences.getString(TAG, Constants.EMPTY);

        /** Prevent dictionary duplications **/
        clear();

        return data;
    }

}
