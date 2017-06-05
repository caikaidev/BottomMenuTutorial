### ScreenShots

![](https://ww1.sinaimg.cn/large/006tNc79gy1fdua399ng7g308w0ftwk9.gif)

### SetUp
#### Gradle   


##### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
	...
		maven { url 'https://jitpack.io' }
	}
}
```
##### Step 2. Add the dependency

```
dependencies {
	compile 'com.github.fccaikai:BottomMenuTutorial:1.0.3'
}
```

#### Maven

##### Step 1. Add the JitPack repository to your build file


```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

##### Step 2. Add the dependency

```

<dependency>
	<groupId>com.github.fccaikai</groupId>
	<artifactId>BottomMenuTutorial</artifactId>
	<version>1.0.2</version>
</dependency>
```

### Usage

```
BottomDialog dialog = BottomDialog.newInstance("title",new String[]{"item1","item2"});
/**
*
* BottomDialog dialog = BottomDialog.newInstance("titleText","cancelText",new String[]{"item1","item2"});
*
* use public static BottomDialog newInstance(String titleText,String cancelText, String[] items)
* set cancel text
*/
dialog.show(getChildFragmentManager(),"dialog");
    //add item click listener
    dialog.setListener(new BottomDialog.OnClickListener() {
        @Override
        public void click(int position) {
            Toast.makeText(getContext(), "" + position, Toast.LENGTH_LONG).show();
        }
 });
```