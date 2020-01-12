# pagination-android
Simplest and fast Android RecyclerView pagination

## How to:

To get a Git project into your build:

### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```Gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

### Step 2. Add the dependency
```Gradle
dependencies {
	  implementation 'com.github.Tobibur:pagination-android:Tag'
}
```
> The latest version:
[![](https://jitpack.io/v/Tobibur/pagination-android.svg)](https://jitpack.io/#Tobibur/pagination-android)

### Usage
* Implement your activity or fragment with `PageListener` interface.
```kotlin
class MainActivity : AppCompatActivity(), PageListener {

  override fun onPagination(page: Int) {
    //page updates will be here
  }
}
```
* initialize your recyclerview with `PaginationUtils` object with `initPagination` funtion
```kotlin
PaginationUtils.initPagination(mRecyclerView, linearLayoutManager,
                this@MainActivity)
```
* That's it! Now just make api call in `onPagination` for pagination and add data from the reponse to the recyclerview adapter.

### Example:
```kotlin
override fun onPagination(page: Int) {
     getRepositories(page)
     Log.d(TAG, "onPagination: $page")
}

// Network call using coroutine example
private fun getRepositories(page: Int = 1) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repos = mService.getRepos("Android", page)
                withContext(Dispatchers.Main){
                    //added new data in the adapter
                    recyclerViewAdapter.addAll(repos.items)
                }
            }catch (e:Exception){
                Log.d(TAG, "getRepositories: ${e.message}")
            }

        }
}
```
Please refer to the sample app for full example source code.

## License & Copyright

Licensed under the [MIT License](LICENSE).
