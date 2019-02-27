package br.com.stonetree.storage.shared.enums;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static br.com.stonetree.storage.shared.enums.EnvironmentType.API;
import static br.com.stonetree.storage.shared.enums.EnvironmentType.DATABASE;
import static br.com.stonetree.storage.shared.enums.EnvironmentType.HYBRID_LOCAL_WITH_API;
import static br.com.stonetree.storage.shared.enums.EnvironmentType.LOCAL;

@StringDef({LOCAL, API, DATABASE, HYBRID_LOCAL_WITH_API})
@Retention(RetentionPolicy.SOURCE)
public @interface EnvironmentType {

    String LOCAL = "LOCAL";
    String API = "API";
    String DATABASE = "DATABASE";
    String HYBRID_LOCAL_WITH_API = "HYBRID_LOCAL_WITH_API";

}
