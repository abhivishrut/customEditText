# CodewatiET - Custom EditText Library for Android
```
CodewatiET is a customizable EditText library for Android that provides built-in validation for
"Email", "Phone Number", "PAN Card", and "Aadhaar Number". It also supports:

✅ Character Length Restriction (setMaxLength())
✅ Password Toggle Visibility (enablePasswordToggle())
✅ Error Animation (Shake Effect) on Invalid Input
✅ Custom End Icon with Click Listener
```


> Step 1. Add the JitPack repository to your build file.
> Add it in your settings.gradle.kts at the end of repositories:

```gradle
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url = uri("https://jitpack.io") }
		}
	}
```
> Step 2. Add the dependency.
# Dependency version : [![](https://jitpack.io/v/abhivishrut/customEditText.svg)](https://jitpack.io/#abhivishrut/customEditText)

```gradle
dependencies {
	        implementation("com.github.abhivishrut:customEditText:1.0.1")
	}
```

# XML Code
```xml
<com.codewati.abhiedittext.CodewatiET
        android:id="@+id/emailEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Email"
        android:textColorHint="#888"
        android:padding="12dp"/>
```
# For Kotlin
```kotlin
// Use setMaxLength() for limiting the input length
        emailEditText.setMaxLength(50)
        phoneEditText.setMaxLength(10)
        panEditText.setMaxLength(10)
        aadhaarEditText.setMaxLength(12);

        // Use Enable Password Toggle for hiding the password
        panEditText.enablePasswordToggle()

        validateButton.setOnClickListener {
            if (emailEditText.isValidEmail() &&     // Use isValidEmail() for email validation
                phoneEditText.isValidPhone() &&     // Use isValidPhone() for phone number validation
                panEditText.isValidPan() &&         // Use isValidPan() for PAN validation
                aadhaarEditText.isValidAadhaar()) {     // Use isValidAadhaar() for Aadhaar validation

                Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show()

            }
        }
```

# For Java
```java
// Set max length for inputs
        emailEditText.setMaxLength(50);
        phoneEditText.setMaxLength(10);
        panEditText.setMaxLength(10);
        aadhaarEditText.setMaxLength(12);

        // Enable password toggle for PAN EditText
        panEditText.enablePasswordToggle();

        validateButton.setOnClickListener(v -> {
            if (emailEditText.isValidEmail() &&  // Email validation
                phoneEditText.isValidPhone() &&  // Phone number validation
                panEditText.isValidPan() &&      // PAN validation
                aadhaarEditText.isValidAadhaar()) { // Aadhaar validation
                
                Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show();
            }
        });
```
