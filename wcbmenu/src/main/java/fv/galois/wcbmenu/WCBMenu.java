package fv.galois.wcbmenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by galois on 2017/5/27.
 */

public class WCBMenu {

    private Context mContext;
    private WCBMenu.Builder mBuilder;
    private List<String> mStringList = new ArrayList<>();
    private String mTitle;
    private int mTitleResId;
    private String mCancel;
    private int mCancelResId;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    public WCBMenu(Context context) {
        mContext = context;
    }

    public WCBMenu setTitle(String title) {
        mTitle = title;
        if (mBuilder != null) {
            mBuilder.setTitle(title);
        }
        return this;
    }

    public WCBMenu setTitle(int resId) {
        mTitleResId = resId;
        if (mBuilder != null) {
            mBuilder.setTitle(resId);
        }
        return this;
    }

    public WCBMenu setCancel(String cancel) {
        mCancel = cancel;
        if (mBuilder != null) {
            mBuilder.setCancel(cancel);
        }
        return this;
    }

    public WCBMenu setCancel(int resId) {
        mCancelResId = resId;
        if (mBuilder != null) {
            mBuilder.setCancel(resId);
        }
        return this;
    }

    public WCBMenu setStringList(List<String> list) {
        mStringList.clear();
        mStringList.addAll(list);
        if (mBuilder != null) {
            mBuilder.setStringList();
        }
        return this;
    }

    public WCBMenu setItemClickListener(AdapterView.OnItemClickListener listener) {
        mOnItemClickListener = listener;
        if (mBuilder != null) {
            mBuilder.setItemClickListener(listener);
        }
        return this;
    }

    public void show() {
        if (mBuilder == null) {
            mBuilder = new Builder();
        } else {
            mBuilder.show();
        }
    }

    public void dismiss() {
        if (mBuilder != null) {
            mBuilder.mPopupWindow.dismiss();
        }
    }

    private class Builder {
        private MenuListAdapter mMenuListAdapter;
        private ListView mListView;
        private TextView mTvTitle;
        private TextView mTvCancel;
        private View mVCancelDivider;
        private PopupWindow mPopupWindow;
        private View popupView;

        private Builder() {
            popupView = LayoutInflater.from(mContext).inflate(R.layout.layout_wcb_menu, null);
            mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
            mPopupWindow.setTouchable(true);
            mPopupWindow.setOutsideTouchable(true);
            mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x77777777));
            popupView.setBackgroundColor(Color.WHITE);
            mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
                    lp.alpha = 1f;
                    ((Activity) mContext).getWindow().setAttributes(lp);
                }
            });
            mListView = (ListView) popupView.findViewById(R.id.lv_wcb_menu_list);
            mMenuListAdapter = new MenuListAdapter();
            mListView.setAdapter(mMenuListAdapter);
            mListView.setOnItemClickListener(mOnItemClickListener);
            mTvTitle = (TextView) popupView.findViewById(R.id.tv_wcb_menu_title);
            mTvTitle.setTextSize(16);
            mTvCancel = (TextView) popupView.findViewById(R.id.tv_wcb_menu_cancel);
            mTvCancel.setTextSize(20);
            mVCancelDivider = popupView.findViewById(R.id.v_cancel_divider);
            mTvCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

            if (mTitleResId != 0) {
                mTvTitle.setText(mTitleResId);
            }
            if (mTitle != null) {
                mTvTitle.setText(mTitle);
            }

            if (mTitleResId == 0 && mTitle == null) {
                mTvTitle.setVisibility(View.GONE);
            }

            if (mCancelResId != 0) {
                mTvCancel.setText(mCancelResId);
            }
            if (mCancel != null) {
                mTvCancel.setText(mCancel);
            }

            if (mCancelResId == 0 && mCancel == null) {
                mTvCancel.setVisibility(View.GONE);
                mVCancelDivider.setVisibility(View.GONE);
            }
            WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
            lp.alpha = 0.6f;
            ((Activity) mContext).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            ((Activity) mContext).getWindow().setAttributes(lp);
            mPopupWindow.setAnimationStyle(R.style.popwindow_anim_style);
            mPopupWindow.showAtLocation(popupView.getRootView(), Gravity.BOTTOM, 0, 0);
        }

        public void show() {
            if (!mPopupWindow.isShowing()) {
                mPopupWindow.showAtLocation(popupView.getRootView(), Gravity.BOTTOM, 0, 0);
            }
        }

        public void setTitle(String title) {
            mTvTitle.setText(title);
            if (mTvTitle.getVisibility() != View.VISIBLE) {
                mTvTitle.setVisibility(View.VISIBLE);
            }
        }

        public void setTitle(int resId) {
            mTvTitle.setText(resId);
            if (mTvTitle.getVisibility() != View.VISIBLE) {
                mTvTitle.setVisibility(View.VISIBLE);
            }
        }

        public void setCancel(String cancel) {
            mTvCancel.setText(cancel);
            if (mTvCancel.getVisibility() != View.VISIBLE) {
                mTvCancel.setVisibility(View.VISIBLE);
                mVCancelDivider.setVisibility(View.VISIBLE);
            }
        }

        public void setCancel(int resId) {
            mTvCancel.setText(resId);
            if (mTvCancel.getVisibility() != View.VISIBLE) {
                mTvCancel.setVisibility(View.VISIBLE);
                mVCancelDivider.setVisibility(View.VISIBLE);
            }
        }

        public void setStringList() {
            mMenuListAdapter.notifyDataSetChanged();
        }

        public void setItemClickListener(AdapterView.OnItemClickListener listener) {
            mListView.setOnItemClickListener(listener);
        }
    }

    private class MenuListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mStringList.size();
        }

        @Override
        public Object getItem(int position) {
            return mStringList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_option, null);
                viewHolder = new ViewHolder();
                viewHolder.mTextView = (TextView) convertView.findViewById(R.id.tv_option);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.mTextView.setText(mStringList.get(position));
            viewHolder.mTextView.setTextSize(20);

            return convertView;
        }

        class ViewHolder {
            public TextView mTextView;
        }
    }
}

