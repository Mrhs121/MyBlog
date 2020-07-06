package com.my.blog.website.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by @author yihui in 19:53 18/9/10.
 */
public class BasicFileUtil {

    public static boolean isAbsFile(String fileName) {
            // mac or linux
            return fileName.startsWith("/");
    }

    /**
     * 将用户目录下地址~/xxx 转换为绝对地址
     *
     * @param path
     * @return
     */
    public static String parseHomeDir2AbsDir(String path) {
        String homeDir = System.getProperties().getProperty("user.home");
        return StringUtils.replace(path, "~", homeDir);
    }
}