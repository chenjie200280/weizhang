package com.ttsofts.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.qq.e.ads.banner.ADSize;
import com.qq.e.ads.banner.AbstractBannerADListener;
import com.qq.e.ads.banner.BannerView;
import com.qq.e.ads.interstitial.AbstractInterstitialADListener;
import com.qq.e.ads.interstitial.InterstitialAD;

/**
 * Created by chenjie on 2016/12/20.
 */
public class GdtAdvertUtil {

    private  String appid = "1104927196";
    private String bannerid = "2040503604128584";
    private String interid = "2020300634720585";

    Activity activity;

    InterstitialAD iad;

    BannerView banner;
    public GdtAdvertUtil(Activity activity){
        this.activity = activity;
        initBannerAd();
    }

    private void initBannerAd(){
        banner = new BannerView(activity, ADSize.BANNER,appid,bannerid);
        banner.setRefresh(30);
        banner.setADListener(new AbstractBannerADListener() {
            @Override
            public void onNoAD(int i) {
                Log.i("AD_DEMO", "BannerNoAD，eCode=" + i);
            }
            @Override
            public void onADReceiv() {
                Log.i("AD_DEMO", "ONBannerReceive");
            }
        });
        banner.loadAD();
    }

    public void loadBannerAd(ViewGroup viewGroup){
        viewGroup.addView(banner);
    }

    public void loadInterstitialAd(){
        if(iad!=null){
            iad.show();
        }
        iad = new InterstitialAD(activity, appid, interid);
        iad.setADListener(new AbstractInterstitialADListener() {
            @Override
            public void onADReceive() {
                iad.show();
            }
            @Override
            public void onNoAD(int i) {}
        });
        iad.loadAD();
    }
}
