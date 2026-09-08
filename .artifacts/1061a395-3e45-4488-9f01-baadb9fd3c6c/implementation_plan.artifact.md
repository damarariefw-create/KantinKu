# Fix PilihMakananActivity naming inconsistency

The user is encountering a Java compilation error because the public class `PilihMakananActivity` is defined in a file named `MainActivity3.java`. In Java, a public class must reside in a file that matches its name. Additionally, the `AndroidManifest.xml` refers to this activity as `.MainActivity3`, which is inconsistent with the class name.

## User Review Required

> [!IMPORTANT]
> This plan involves renaming both the source file and updating the `AndroidManifest.xml`. If any other part of the system relies on the name `MainActivity3` via string-based reflection or deep links, those might need manual updates.

## Proposed Changes

### Java Source Code

#### [MOVE] [MainActivity3.java](file:///D:/SMKN 2 Surakarta/XI PPLG A/PPB/Projek Android Studio/KantinKu/app/src/main/java/com/example/kantinku/MainActivity3.java) to [PilihMakananActivity.java](file:///D:/SMKN 2 Surakarta/XI PPLG A/PPB/Projek Android Studio/KantinKu/app/src/main/java/com/example/kantinku/PilihMakananActivity.java)

Rename the file to match the public class name to satisfy Java compilation requirements.

### Resources

#### [MOVE] [activity_main3.xml](file:///D:/SMKN 2 Surakarta/XI PPLG A/PPB/Projek Android Studio/KantinKu/app/src/main/res/layout/activity_main3.xml) to [activity_pilih_makanan.xml](file:///D:/SMKN 2 Surakarta/XI PPLG A/PPB/Projek Android Studio/KantinKu/app/src/main/res/layout/activity_pilih_makanan.xml)

The code in `MainActivity3.java` already attempts to use `R.layout.activity_pilih_makanan`. Renaming this layout file ensures the resource can be found.

### Android Manifest

#### [MODIFY] [AndroidManifest.xml](file:///D:/SMKN 2 Surakarta/XI PPLG A/PPB/Projek Android Studio/KantinKu/app/src/main/AndroidManifest.xml)

Update the activity declaration to use the correct class name `.PilihMakananActivity` instead of `.MainActivity3`.

## Verification Plan

### Automated Tests
- Run `./gradlew :app:compileDebugJavaWithJavac` to verify that the reported error is resolved.

### Manual Verification
- Verify that the IDE no longer shows a red underline for the class declaration.
- Verify that the layout reference `R.layout.activity_pilih_makanan` is resolved after renaming the XML file.
