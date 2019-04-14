package xyz.berby.im;

import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.io.File;

public class FileUtilTest {

    @Test
    public void test() {
        String dir = "F:\\logs\\upload\\ee";
        File file = FileUtil.mkParentDirs(dir);
        System.out.println(file);
    }
}
