# Implementation Plan - Fix Class Name Mismatch

The goal is to fix the Java compilation error where the public class `PilihMakananActivity` is declared in a file named `MainActivity3.java`. Additionally, I will fix the missing layout resource reference and update the manifest to reflect these changes.

## User Review Required

> [!IMPORTANT]
> I am assuming that `activity_main3.xml` is the intended layout for `PilihMakananActivity` because its content displays "Pilih Makanan" and the activity code attempts to use `R.layout.activity_pilih_makanan`.

> [!NOTE]
> The code in `PilihMakananActivity` references a `PilihMinumanActivity` class which does not currently exist in the project. This will likely cause a secondary compilation error. If `MainActivity4` was intended to be this activity, please let me know.

## Proposed Changes

### Android Manifest

#### [MODIFY] [AndroidManifest.xml](file:///D:/SMKN 2 Surakarta/XI%20PPLG%20A/PPB/Projek%20Android%20Studio/KantinKu/app/src/main/AndroidManifest.xml)
- Rename `.MainActivity3` to `.PilihMakananActivity`.

### Java Components

#### [RENAME] `app/src/main/java/com/example/kantinku/MainActivity3.java` -> [PilihMakananActivity.java](file:///D:/SMKN%202%20Surakarta/XI%20PPLG%20A/PPB/Projek%20Android%20Studio/KantinKu/app/src/main/java/com/example/kantinku/PilihMakananActivity.java)
- Rename the file to match the public class name.

### Resource Files

#### [RENAME] `app/src/main/res/layout/activity_main3.xml` -> [activity_pilih_makanan.xml](file:///D:/SMKN%202%20Surakarta/XI%20PPLG%20A/PPB/Projek%20Android%20Studio/KantinKu/app/src/main/res/layout/activity_pilih_makanan.xml)
- Rename the layout file to match the reference in `PilihMakananActivity.java`.
- Update `tools:context` inside the layout to point to `.PilihMakananActivity`.

## Verification Plan

### Automated Tests
- Run `./gradlew :app:compileDebugJavaWithJavac` to verify that the reported error is resolved.

### Manual Verification
- Verify in the IDE that `R.layout.activity_pilih_makanan` is correctly resolved.
