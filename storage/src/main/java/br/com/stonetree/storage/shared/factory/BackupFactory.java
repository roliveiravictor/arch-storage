package br.com.stonetree.storage.shared.factory;


import br.com.stonetree.storage.feature.backup.procedure.instant.InstantBackup;
import br.com.stonetree.storage.shared.abstracts.backup.Backup;
import br.com.stonetree.storage.shared.abstracts.backup.Dummy;
import br.com.stonetree.storage.shared.enums.ProcedureType;
import br.com.stonetree.storage.shared.model.MetaData;

public class BackupFactory {

    public static Backup create() {
        @ProcedureType
        final String procedure = MetaData.getInstance().getProcedure();

        switch (procedure) {
            case ProcedureType.INSTANT:
                return new InstantBackup();

            default:
                return new Dummy();
        }
    }

}