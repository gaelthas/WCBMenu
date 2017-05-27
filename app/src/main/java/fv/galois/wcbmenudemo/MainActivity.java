package fv.galois.wcbmenudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fv.galois.wcbmenu.WCBMenu;

public class MainActivity extends AppCompatActivity {
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = new ArrayList<>();
        mList.add("选项1");
        mList.add("选项2");
        mList.add("选项3");
        mList.add("选项4");
    }

    public void onClick(View view) {
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

    }
}
