package br.com.stonetree.storage.shared.model;

import android.app.Activity;

import br.com.stonetree.storage.shared.enums.EnvironmentType;
import br.com.stonetree.storage.shared.enums.ProcedureType;

public interface IMetaDataBuilder {

    MetaData build();

    IMetaDataBuilder setEnvironment(@EnvironmentType String environment);

    IMetaDataBuilder setOperation(@ProcedureType String operation);

    IMetaDataBuilder setActivity(Activity activity);

    IMetaDataBuilder setId(String id);

}
