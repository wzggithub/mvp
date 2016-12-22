package com.gostcry.tool.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.File;

/**
 * 图片加载工具类
 * Created by hspcadmin on 2016/8/24.
 */
public class ImageLoaderUtil {

    public static void init(Context context){

        //缓存文件目录
        File cacheDir = StorageUtils.getCacheDirectory(context);
        //构建配置
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                //默认屏幕的大小
                .memoryCacheExtraOptions(480, 800)
                // 内存缓存的设置选项 (最大图片宽度,最大图片高度) 默认当前屏幕分辨率
                .diskCacheExtraOptions(480, 800, null)
                // 设置自定义加载和显示图片的线程池
                .taskExecutor(DefaultConfigurationFactory.createExecutor(3, Thread.NORM_PRIORITY, QueueProcessingType.LIFO))
                // 设置自定义加载和显示内存缓存或者硬盘缓存图片的线程池
                .taskExecutorForCachedImages(DefaultConfigurationFactory.createExecutor(3, Thread.NORM_PRIORITY, QueueProcessingType.LIFO))
                // 设置显示图片线程池大小，默认为3
                // 注:如果设置了taskExecutor或者taskExecutorForCachedImages 此设置无效
                .threadPoolSize(3)
                // 设置图片加载线程的优先级,默认为Thread.NORM_PRIORITY-1
                // 注:如果设置了taskExecutor或者taskExecutorForCachedImages 此设置无效
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                // 设置图片加载和显示队列处理的类型 默认为QueueProcessingType.FIFO
                // 注:如果设置了taskExecutor或者taskExecutorForCachedImages 此设置无效
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                // 设置拒绝缓存在内存中一个图片多个大小 默认为允许,(同一个图片URL)根据不同大小的imageView保存不同大小图片
                .denyCacheImageMultipleSizesInMemory()
                // 设置内存缓存 默认为一个当前应用可用内存的1/8大小的LruMemoryCache
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                // 设置内存缓存的最大大小 默认为一个当前应用可用内存的1/8
                .memoryCacheSize(2 * 1024 * 1024)
                // 设置内存缓存最大大小占当前应用可用内存的百分比 默认为一个当前应用可用内存的1/8
                .memoryCacheSizePercentage(13

                ) // default
                // 设置硬盘缓存
                .diskCache(new UnlimitedDiskCache(cacheDir)) //缓存路径
                // 设置硬盘缓存的最大大小
                .diskCacheSize(50 * 1024 * 1024)
                // 设置硬盘缓存的文件的最多个数
                .diskCacheFileCount(100)
                // 设置硬盘缓存文件名生成规范
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                // 设置图片下载器
                .imageDownloader(new BaseImageDownloader(context)) // default
                // 设置图片解码器
                .imageDecoder(DefaultConfigurationFactory.createImageDecoder(false))
                // 设置默认的图片显示选项
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                // 打印DebugLogs
                .writeDebugLogs()
                //万事俱备 执行构造
                .build();
        //初始化配置文件
        ImageLoader.getInstance().init(config);
    }

    public static DisplayImageOptions imageOptions(){

        /**
         * DisplayImageOptions所有配置简介
         */
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                // 设置图片加载时的默认图片
//                .showImageOnLoading(R.drawable.login_face)
                // 设置图片加载失败的默认图片
//                .showImageOnFail(R.drawable.login_face)
                // 设置图片URI为空时默认图片
//                .showImageForEmptyUri(R.drawable.login_face)
                // 设置是否将View在加载前复位
                .resetViewBeforeLoading(false)
                // 设置延迟部分时间才开始加载
                // 默认为0
                .delayBeforeLoading(100)
                // 设置添加到内存缓存
                // 默认为false
                .cacheInMemory(true)
                // 设置规模类型的解码图像
                // 默认为ImageScaleType.IN_SAMPLE_POWER_OF_2
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                // 设置位图图像解码配置
                // 默认为Bitmap.Config.ARGB_8888
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                // 设置选项的图像解码
                .decodingOptions(new BitmapFactory.Options())
                // 设置自定义显示器
                // 默认为DefaultConfigurationFactory.createBitmapDisplayer()
                .displayer(new FadeInBitmapDisplayer(300))
                // 设置自定义的handler
                // 默认为new Handler()
//                .handler(new Handler())
                // 建立
                .build();
        return options;
    }
}
