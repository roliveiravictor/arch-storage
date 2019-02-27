package br.com.stonetree.storage.shared.abstracts.environment;

import android.app.Activity;

import java.util.List;

import br.com.stonetree.storage.shared.abstracts.backup.Backup;
import br.com.stonetree.storage.shared.constants.Constants;
import br.com.stonetree.storage.shared.model.MetaData;

public abstract class DataStorage {

    /**
     * Save all data
     **/
    public abstract void save(String bytes);

    /**
     * Load all data
     **/
    public abstract List<String> load();

    /**
     * Clear all data
     **/
    public abstract void clear();

    protected String loadRaw() {
        return Constants.EMPTY;
    }

    /**
     * Partially load data
     **/
    public void lazyLoad() {
    }

    /**
     * Dump data from ram to storage. Memory swap.
     **/
    public void dump() {
    }

    private Backup backup;

    protected final String TAG = MetaData.getInstance().getId();

    protected Backup getBackup() {
        return backup;
    }

    protected void setBackup(Backup backup) {
        this.backup = backup;
    }

    protected Activity getActivity() {
        return MetaData.getInstance().getActivity();
    }


}

