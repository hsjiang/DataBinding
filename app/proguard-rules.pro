# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/riven_chris/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#Specifies the number of optimization passes to be performed.
-optimizationpasses 5
#Specifies not to generate mixed-case class names while obfuscating
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclassmembers
-dontskipnonpubliclibraryclasses
#-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-keepattributes EnclosingMethod
-keepattributes Signature
-keepattributes InnerClasses
-keepattributes *Annotation*
-keepattributes Exceptions

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements java.io.Serializable{
    static final long serialVersionUID;
    private <fields>;
    public <methods>;
}

-dontwarn android.support.v4.**

#okhttp
-dontwarn okhttp3.**
-dontnote okhttp3.**

#okio
-dontwarn okio.**
-dontnote okio.**

#retrofit
# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
-dontwarn retrofit2.**

#butterknife
# Retain generated class which implement Unbinder.
-keep public class * implements butterknife.Unbinder { public <init>(**, android.view.View); }
# Prevent obfuscation of types which use ButterKnife annotations since the simple name
# is used to reflectively look up the generated ViewBinding.
-keep class butterknife.*
-keepclasseswithmembernames class * { @butterknife.* <methods>; }
-keepclasseswithmembernames class * { @butterknife.* <fields>; }

#realm
-keep class io.realm.annotations.RealmModule
-keep @io.realm.annotations.RealmModule class *
-keep class io.realm.internal.Keep
-keep @io.realm.internal.Keep class * { *; }
-dontwarn javax.**
-dontwarn io.realm.**
-dontnote io.realm.**

#fresco
-dontwarn com.facebook.**
-keep,allowobfuscation @interface com.facebook.common.internal.DoNotStrip
# Do not strip any method/class that is annotated with @DoNotStrip
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}

# Gson配置
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.** { *; }
-keep class com.antew.redditinpictures.library.imgur.** { *; }
-keep class com.antew.redditinpictures.library.reddit.** { *; }

#rxjava
-dontwarn io.reactivex.**
-dontnote io.reactivex.**