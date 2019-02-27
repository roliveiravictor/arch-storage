package br.com.stonetree.storage.feature.environment.database;

import java.util.ArrayList;
import java.util.List;

import br.com.stonetree.storage.shared.abstracts.environment.DataStorage;

public class DatabaseDataStorage extends DataStorage {

    @Override
    public void save(String bytes) {

    }

    @Override
    public List<String> load() {
        return new ArrayList<>();
    }

    @Override
    public void clear() {

    }

}
