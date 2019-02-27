package br.com.stonetree.storage.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import br.com.stonetree.storage.shared.abstracts.environment.DataStorage;
import br.com.stonetree.storage.shared.abstracts.environment.DummyStorage;
import br.com.stonetree.storage.shared.constants.Constants;
import br.com.stonetree.storage.shared.enums.EnvironmentType;
import br.com.stonetree.storage.shared.enums.ProcedureType;
import br.com.stonetree.storage.shared.factory.StorageFactory;
import br.com.stonetree.storage.shared.model.MetaData;
import manifest.stonetree.com.br.permissions.constants.Permission;
import manifest.stonetree.com.br.permissions.feature.IManifestCallback;
import manifest.stonetree.com.br.permissions.feature.Manifest;
import manifest.stonetree.com.br.permissions.feature.model.Device;

import static manifest.stonetree.com.br.permissions.constants.Permission.WRITE_EXTERNAL_STORAGE;

public class StorageActivity extends AppCompatActivity {

    private TextView decrypted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        requestStoragePermission();
        findViews();
    }

    private void findViews() {
        decrypted = findViewById(R.id.decrypted);
    }

    private void requestStoragePermission() {
        final Device device = new Device.Builder()
                .setPermission(WRITE_EXTERNAL_STORAGE)
                .setCallback(getManifestCallback())
                .setActivity(this)
                .build();

        Manifest.request(device);
    }

    private IManifestCallback getManifestCallback() {
        return new IManifestCallback() {
            @Override
            public void onPermissionGranted(Permission permission) {
                if (WRITE_EXTERNAL_STORAGE.equals(permission)) {
                    Session.getInstance().setStorage(createStorage());
                    triggerDatabaseProcedures();
                }
            }

            @Override
            public void onPermissionDenied(Permission permission) {
                Session.getInstance().setStorage(new DummyStorage());
            }
        };
    }

    private void triggerDatabaseProcedures() {
        write();
        read();
    }

    private void read() {
        final StringBuilder builder = new StringBuilder();
        for (String message : Session.getInstance().getStorage().load()) {
            builder.append(message + Constants.DOUBLE_LINE_BREAKER);
        }
        decrypted.setText("### Text below should be seen decrypted ###" + Constants.DOUBLE_LINE_BREAKER + builder.toString());
    }

    private void write() {
        Session.getInstance().getStorage().save(getFirstJSon());
    }

    private DataStorage createStorage() {
        final MetaData metaData = new MetaData.Builder()
                .setEnvironment(EnvironmentType.LOCAL)
                .setOperation(ProcedureType.INSTANT)
                .setActivity(this)
                .setId("My App Id")
                .build();

        return StorageFactory.create(metaData);
    }

    public static String getFirstJSon() {
        return "My Decrypted Text";
    }

}
