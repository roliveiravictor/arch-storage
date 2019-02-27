package br.com.stonetree.storage.shared.enums;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static br.com.stonetree.storage.shared.enums.ProcedureType.INSTANT;
import static br.com.stonetree.storage.shared.enums.ProcedureType.LIFECYCLE;
import static br.com.stonetree.storage.shared.enums.ProcedureType.SESSION;

@StringDef({INSTANT, LIFECYCLE, SESSION})
@Retention(RetentionPolicy.SOURCE)
public @interface ProcedureType {

    String INSTANT = "INSTANT";
    String LIFECYCLE = "LIFECYCLE";
    String SESSION = "SESSION";

}
