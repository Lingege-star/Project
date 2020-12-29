package cn.jiguang.demo;

import android.app.Application;
import android.util.Log;

import java.io.File;

//jshare_import_start
import cn.jiguang.demo.jshare.FileTestCopy;
import cn.jiguang.share.android.api.JShareInterface;
import cn.jiguang.share.android.api.PlatformConfig;
//jshare_import_end




/**
 * For developer startup JIGUANG SDK
 * <p>
 * 一般建议在自定义 Application 类里初始化。也可以在主 Activity 里。
 */
public class ExampleApplication extends Application {
    private static final String TAG = "JIGUANG-Example";

    @Override
    public void onCreate() {
        super.onCreate();


        //jshare_init_start
        JShareInterface.setDebugMode(true);
        PlatformConfig platformConfig = new PlatformConfig()
                .setWechat("wxc40e16f3ba6ebabc", "dcad950cd0633a27e353477c4ec12e7a")
                .setQQ("1106011004", "YIbPvONmBQBZUGaN")
                .setSinaWeibo("374535501", "baccd12c166f1df96736b51ffbf600a2", "https://www.jiguang.cn")
                .setFacebook("1847959632183996", "JShareDemo")
                .setTwitter("fCm4SUcgYI1wUACGxB2erX5pL", "NAhzwYCgm15FBILWqXYDKxpryiuDlEQWZ5YERnO1D89VBtZO6q", "https://www.jiguang.cn/")
                .setJchatPro("1847959632183996");
        /**
         * since 1.5.0，1.5.0版本后增加API，支持在代码中设置第三方appKey等信息，当PlatformConfig为null时，或者使用JShareInterface.init(Context)时需要配置assets目录下的JGShareSDK.xml
         **/
        JShareInterface.init(this, platformConfig);

        new Thread() {
            @Override
            public void run() {
                File imageFile = FileTestCopy.copyResurces(getApplicationContext(), "jshare_jiguang_test_img.png", "jshare_jiguang_test_img.png", 0);
                File videoFile = FileTestCopy.copyResurces(getApplicationContext(), "jshare_jiguang_test.mp4", "jshare_jiguang_test.mp4", 0);
                if (imageFile != null) {
                    FileTestCopy.ImagePath = imageFile.getAbsolutePath();
                }

                if (videoFile != null) {
                    FileTestCopy.VideoPath = videoFile.getAbsolutePath();
                }

                super.run();
            }
        }.start();


    }
}
