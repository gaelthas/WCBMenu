# WCBMenu

在 Android 上模仿 iOS 微信的底部菜单。

<img src="/screenshots/wcbmenu_demo.png" alt="wcbmenu_demo" title="wcbmenu_demo" width="360" height="640" />

### 使用方法：

#### Gradle

```groovy
dependencies {
    compile 'fv.galois:wcbmenu:1.0.0'
}
```

#### 示例代码

```java
final WCBMenu wcbMenu = new WCBMenu(this);
wcbMenu.setTitle("标题\n标题")
        .setCancel("取消")
        .setStringList(mList)
        .setItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wcbMenu.dismiss();
                Toast.makeText(MainActivity.this, mList.get(position), Toast.LENGTH_SHORT).show();
            }
        })
        .show();
```

---

感谢 [drakeet](https://github.com/drakeet)

---

License
============

[WTFPL](https://github.com/gaelthas/WCBMenu/blob/master/LICENSE)
