# Add project specific ProGuard rules here.
# By default, the flags in this file are applied to all build types.

# ProGuard rules for standard Android applications.
# -optimizationpasses 5
# -dontusemixedcaseclassnames
# -dontskipnonpubliclibraryclasses
# -dontpreverify
# -verbose
# -optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-keepattributes *Annotation*
-keepattributes Signature
-keepattributes InnerClasses

# Retain R class members
-keep class **.R$* {
    *;
}

# Keep application classes that are entry points
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

# Keep any native methods
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep classes that are referenced from XML layouts
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

# Keep static inner classes of R class (e.g. R.drawable, R.string)
-keep public class **.R$* {
    public static final int *;
}

# Keep parcelable classes
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# Keep enums
-keepclassmembers enum * {
  public static **[] values();
  public static ** valueOf(java.lang.String);
}

# Glide specific rules (if you were to use Glide)
# -keep public class com.bumptech.glide.module.*
# -keep public class * implements com.bumptech.glide.module.GlideModule
# -keep public enum com.bumptech.glide.load.ImageHeaderParser$ImageType
# -keepresourcexmlelements manifest/application/meta-data@value=GlideModule

# Add any other specific rules your application needs
