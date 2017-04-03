import javax.swing.*;

/**
 * @author fkjslee
 * @date 2017/4/3 at 21:31
 * Copyright (c) 2017 fkjslee. All rights reserved.
 */

public class MyToolBar {
    private JToolBar menu;
    private JButton newFile;
    private JButton newDirectory;
    private JButton deleteFile;
    private JButton copyFile;
    private JButton pasteFile;
    
    MyToolBar() {
        menu.setFloatable(true);
        initView();
    }
    
    private void initView() {
        newFile = new JButton("newFile");
    }
}
