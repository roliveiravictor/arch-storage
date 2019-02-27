package br.com.stonetree.storage.shared.factory;

import android.app.Activity;

import br.com.stonetree.storage.feature.environment.local.LocalDataStorage;
import br.com.stonetree.storage.shared.Collections;
import br.com.stonetree.storage.shared.abstracts.environment.DataStorage;
import br.com.stonetree.storage.shared.abstracts.environment.DummyStorage;
import br.com.stonetree.storage.shared.enums.EnvironmentType;
import br.com.stonetree.storage.shared.exception.StorageException;
import br.com.stonetree.storage.shared.model.MetaData;

public class StorageFactory {

    public static DataStorage create(MetaData metaData) {
        setSingleton(metaData);

        @EnvironmentType final String environment = metaData.getEnvironment();

        switch (environment) {

            case EnvironmentType.LOCAL:
                return new LocalDataStorage();

            default:
                return new DummyStorage();
        }
    }

    private static void setSingleton(MetaData metaData) {
        final String environment = metaData.getEnvironment();
        final String operation = metaData.getProcedure();
        final Activity activity = metaData.getActivity();
        final String id = metaData.getId();
        try {

            if (environment == null)
                throw new StorageException("Environment can't be null!");

            if (operation == null)
                throw new StorageException("Operation can't be null!");

            if (activity == null)
                throw new StorageException("Activity can't be null!");

            if (Collections.isNullOrEmpty(id))
                throw new StorageException("Id can't be null!");

        } catch (StorageException exception) {

            System.exit(-1);

        }

        MetaData.getInstance().setEnvironment(environment);
        MetaData.getInstance().setProcedure(operation);
        MetaData.getInstance().setActivity(activity);
        MetaData.getInstance().setId(id);
    }

}