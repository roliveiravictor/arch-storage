package br.com.stonetree.storage.shared.abstracts.environment;

import java.util.ArrayList;
import java.util.List;

public class DummyStorage extends DataStorage {

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
