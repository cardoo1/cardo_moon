plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.cardo_moon"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.cardo_moon"
        minSdk = 29
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)

    // Glide untuk menampilkan gambar dari URL
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // GridLayout
    implementation("androidx.gridlayout:gridlayout:1.0.0")

    // Pertemuan 11: TabLayout, ViewPager2, RecyclerView, Glide, dan DotsIndicator
    implementation("androidx.viewpager2:viewpager2:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("com.tbuonomo:dotsindicator:5.1.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}