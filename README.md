# WCBMenu

在 Android 上模仿 iOS 微信的底部菜单。

<img src="/screenshots/wcbmenu_demo.png" alt="wcbmenu_demo" title="wcbmenu_demo" width="360" height="640" />

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

---

License
============

    Copyright 2017 gaelthas

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
