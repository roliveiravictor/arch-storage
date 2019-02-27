package br.com.stonetree.storage.shared.model;

import android.app.Activity;

import br.com.stonetree.storage.shared.enums.EnvironmentType;
import br.com.stonetree.storage.shared.enums.ProcedureType;

public class MetaData {

    private static MetaData instance;

    @EnvironmentType
    private String environment;

    @ProcedureType
    private String procedure;

    private Activity activity;

    private String id;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static MetaData getInstance() {
        if (instance == null)
            instance = new MetaData();

        return instance;
    }

    public static class Builder implements IMetaDataBuilder {

        private MetaData build;

        public Builder() {
            this.build = new MetaData();
        }

        @Override
        public MetaData build() {
            return this.build;
        }

        @Override
        public IMetaDataBuilder setEnvironment(String environment) {
            this.build.setEnvironment(environment);
            return this;
        }

        @Override
        public IMetaDataBuilder setOperation(String operation) {
            this.build.setProcedure(operation);
            return this;
        }

        @Override
        public IMetaDataBuilder setActivity(Activity activity) {
            this.build.setActivity(activity);
            return this;
        }

        @Override
        public IMetaDataBuilder setId(String id) {
            this.build.setId(id);
            return this;
        }

    }

}
