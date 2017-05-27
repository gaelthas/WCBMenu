# WCBMenu

在 Android 上模仿 iOS 微信的底部菜单。

使用方法：

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

---
感谢 [drakeet](https://github.com/drakeet)
