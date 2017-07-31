[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)
[![](https://jitpack.io/v/fccaikai/BottomMenuTutorial.svg)](https://jitpack.io/#fccaikai/BottomMenuTutorial)
[![](https://img.shields.io/badge/Author-caikai-brightgreen.svg)](https://github.com/fccaikai)
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
	compile 'com.github.fccaikai:BottomMenuTutorial:1.1.0'
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

#### Defalut

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
#### Custom
custom dialog text size & color if need.
in your app ```corlor.xml``` define :
```
    <color name="bottom_lib_dialog_item_text_color">your dialog item color</color>
    <color name="bottom_lib_dialog_title_text_color">your dialog title color</color>
    <color name="bottom_lib_dialog_cancel_text_color">your dialog cancel color1</color>
```

```dimen.xml``` define：

```
    <dimen name="bottom_lib_dialog_item_text">your dialog item text size,default 16sp</dimen>
    <dimen name="bottom_lib_dialog_title_text">your dialog title text title,default 18sp</dimen>
    <dimen name="bottom_lib_dialog_cancel_text">your dialog title cancel title,default 18sp</dimen>
```

custom dialog padding:

```
<dimen name="bottom_lib_dialog_padding_top">12dp</dimen>
    <dimen name="bottom_lib_dialog_padding_bottom">12dp</dimen>
    <dimen name="bottom_lib_dialog_padding_left">12dp</dimen>
    <dimen name="bottom_lib_dialog_padding_right">12dp</dimen>
```