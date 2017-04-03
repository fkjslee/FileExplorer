import java.io.File;

/**
 * @author fkjslee
 * @date 2017/4/1 at 17:37
 * Copyright (c) 2017 fkjslee. All rights reserved.
 */

public class TestSomeFunction {
    public static void main(String[] args) {
        String userName = System.getProperty("user.name");
        System.out.println(userName);
        String path = System.getProperty("user.dir");//得到当前路径

        File file = new File(path);//得到路径下的所有文件和文件夹
        File[] fileList = file.listFiles();
        for(File i : fileList) {
            System.out.println(i);
        }


    }
}
