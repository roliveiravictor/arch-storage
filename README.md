[![MKT](https://img.shields.io/badge/version-v1.0.2-blue.svg)](https://img.shields.io/badge/version-v1.0.0-blue.svg)
[![MKT](https://img.shields.io/badge/language-Java-orange.svg)](https://img.shields.io/badge/language-Java-orange.svg)
[![MKT](https://img.shields.io/badge/platform-Android-lightgrey.svg)](https://img.shields.io/badge/platform-Android-lightgrey.svg)
[![MKT](https://img.shields.io/badge/license-Copyleft-red.svg)](./LICENSE)

# Content

[1 - Description](#description)

[2 - IDE](#ide)

[3 - Objective](#objective)

[4 - Composition](#composition)

[5 - Run](#run)

[6 - Requirements](#requirements)

[7 - Usage](#usage)

[8 - Singletons](#singletons)

[9 - References](#references)

[10 - Forthcoming Work](#forthcoming)

# Description

-   Storage. Android Architecture SDK.

# IDE

-   Android Studio 3.2.1
-   Build #AI-181.5540.7.32.5056338, built on October 8, 2018
-   JRE: 1.8.0_152-release-1136-b06 x86_64
-   JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
-   macOS 10.14

# Objective

  - Store client data in different types of storage

# Overview

   * N/A

# Composition

  - Permissions: 1.0.1-RELEASE
  - OSCrypto: 1.0.1-RELEASE

# Run

  - Clone this repository and open build.gradle with Android Studio

# Requirements

  - minSdkVersion 19
  - targetSdkVersion 26
  - compileSdkVersion 26
  - buildToolsVersion 26.0.3

# Usage

### 1 - Request Write & Read permission

```
final Device device = new Device.Builder()
                .setPermission(WRITE_EXTERNAL_STORAGE)
                .setCallback(getManifestCallback())
                .setActivity(this)
                .build();

        Manifest.request(device);
```

### 2 - Create storage instance

**Environment -** Environment to store data: Local, API, Database.

1. Till this moment only local storage is implemented.
2. Local: Data will be stored by Android's Shared Preferences.
3. API: Data will be stored by an HTTP Request.
4. Database: Data will be directly stored by Databases (e.g. ORMLite).

**Operation -** Storage procedure: Instant, Lifecycle, Session.

1. Till this moment, only Instant procedure is implemented.
2. Instant: Data will be stored immediately whenever a saving routine is triggered.
3. Lifecycle: Every lifecycle method in android (onCreate, onDestroy, etc) should trigger a saving routine.
2. Session: Ended up session by user should trigger a saving routine.

**Id -** Application id using this sdk.

1. Till this moment, id is only used to key store data inside Shared Preferences. Since it's a dictionary, without it, it would be impossible to save any references.


```
final MetaData metaData = new MetaData.Builder()
                .setEnvironment(EnvironmentType.LOCAL)
                .setOperation(ProcedureType.INSTANT)
                .setActivity(this)
                .setId("appId")
                .build();

        final DataStorage dataStorage = StorageFactory.create(metaData);
```

- After generating storage (e.g. first call inside onCreate), you may freely call step 3 and 4.

### 3 - Push data

```
dataStorage.save("<My JSON, Base64, etc goes here>");
```

### 4 - Pull data

```
final List<String> data = dataStorage.load();
```

###   *NOTE*: DataStorage instance should be hosted as Singleton.

# Singletons

* N/A

#   References:

- N/A

#   Forthcoming Work:

- Implement API storage
- Implement Database storage
- Implement Android lifecycle procedure
- Implement User session procedure