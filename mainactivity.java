apply plugin: 'com.android.application'

android {
    compileSdkVersion 19
    buildToolsVersion "28.0.3"

    defaultConfig {
        applicationId "com.nikai.sportstv"
        minSdkVersion 19
        targetSdkVersion 19
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"

        // Disable features not supported in API 19
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = false
    }

    buildTypes {
        release {
            minifyEnabled true
            shrinkResources true
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
        debug {
            minifyEnabled false
            debuggable true
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_7
        targetCompatibility JavaVersion.VERSION_1_7
    }

    // Hardware acceleration for video playback
    packagingOptions {
        exclude 'META-INF/proguard/androidx-*.pro'
        exclude 'META-INF/CHANGES.txt'
    }
}

dependencies {
    // Legacy support for API 19
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support:support-v4:28.0.0'
    implementation 'com.android.support:leanback-v17:28.0.0'

    // Lightweight JSON parsing
    implementation 'com.google.code.gson:gson:2.8.5'

    // Networking (lightweight)
    implementation 'com.squareup.okhttp3:okhttp:3.12.12'

    // Video playback (legacy ExoPlayer)
    implementation 'com.google.android.exoplayer:exoplayer:2.9.6'
    implementation 'com.google.android.exoplayer:exoplayer-hls:2.9.6'

    // Testing
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test:runner:1.1.1'
}