import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.util.Date;

/**
 * @author fkjslee
 * @date 2017/4/2 at 16:26
 * Copyright (c) 2017 fkjslee. All rights reserved.
 */

@SuppressWarnings("Duplicates")
public class Manager {
    
    private static final FileSystemView FILE_SYSTEM_VIEW = FileSystemView.getFileSystemView();
    private static File[] files;
    private static Boolean isClickDown = false;
    private static Gui gui;
    
    public static void main(String[] args) {
        // show the file system roots.
        File[] roots = FILE_SYSTEM_VIEW.getRoots();
        for (File fileSystemRoot : roots) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileSystemRoot);
            files = FileSystemView.getFileSystemView().getFiles(fileSystemRoot, true);
            for (File file : files) {
                if (file.isDirectory()) {
                    node.add(new DefaultMutableTreeNode(file));
                }
            }
            //
        }
        gui = new Gui(files);
    
        JTable table = gui.getTable();
        /*
          打开操作, 左键按下的时候响应
         */
        ListSelectionListener listSelectionListener = lse -> {
            if(!lse.getValueIsAdjusting()) {
                isClickDown = false;
            } else {
                if(!isClickDown) {
                    isClickDown = true;
                    openFile(((Gui.FileTableModel)table.getModel()).getFile(
                            table.getSelectionModel().getLeadSelectionIndex()));
                }
            }
        };
        table.getSelectionModel().addListSelectionListener(listSelectionListener);
    }
    
    private static void openFile(File file) {
        if(file.isDirectory()){
            gui.setFiles(FileSystemView.getFileSystemView().getFiles(file, true));
        }
    }
}
