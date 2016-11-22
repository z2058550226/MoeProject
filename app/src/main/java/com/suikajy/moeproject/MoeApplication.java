package com.suikajy.moeproject;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.cpacm.core.CoreApplication;
import com.cpacm.core.bean.AccountBean;
import com.cpacm.core.cache.SettingManager;
import com.cpacm.core.cache.SongManager;
import com.cpacm.core.db.CollectionManager;
import com.cpacm.core.db.dao.AccountDao;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/21.
 */

public class MoeApplication extends CoreApplication {
    private static MoeApplication instance;

    public static MoeApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mList = new LinkedList<>();//链表?
        // TODO: 2016/11/21 开启音乐服务
//        SongManager.getInstance();
//        CollectionManager.getInstance();
    }

    private List<Activity> mList;

    private AccountBean accountBean;

    public AccountBean getAccountBean() {
        if (accountBean == null) {
            int uid = SettingManager.getInstance().getSetting(SettingManager.ACCOUNT_ID, -1);
            AccountDao accountDao = new AccountDao();
            accountBean = accountDao.query(uid);
            accountDao.close();
        }
        return accountBean;
    }

    public void setAccountBean(AccountBean accountBean) {
        this.accountBean = accountBean;
    }

    /**
     * 添加一个Activity到列表中
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    /**
     * 移除Activity
     * 每当一个Activity实例将要移除回退栈的时候需要调用一次该方法
     * @param activity
     */
    public void removeActivity(Activity activity) {
        try {
            mList.remove(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断mList中是否存在某个Activity
     * 通过判断可以知道某个Activity是否还存在于回退栈中
     * @param activity
     * @return
     */
    public boolean containActivity(Class activity) {
        for (Activity act :
                mList) {
            if (act.getClass() == activity) {
                return true;
            }
        }
        return false;
    }

    public Activity getActivity(Class activity) {
        for (Activity act :
                mList) {
            if (act.getClass() == activity) {
                return act;
            }
        }
        return null;
    }

    /**
     * 关闭所有Activity
     */
    public void closeAllActivity() {
        try {
            for (Activity act :
                    mList) {
                if (act != null && !act.isFinishing()) {
                    act.finish();
                }
            }
            mList.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Activity getCurActivity() {
        if (mList.size() > 0) {
            return mList.get(mList.size() - 1);
        }
        return null;
    }

    /**
     * 退出App,一般在主界面的返回按钮点击事件中触发
     */
    public void exit(){
        closeAllActivity();
    }

    /**
     * 获取App内存大小,一般是16MB,大一点的手机是24MB,Samsung Note3 是256MB
     * @return
     */
    public int getMemSize(){
        return ((ActivityManager)getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
    }
}
