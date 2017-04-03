import javax.swing.*;
import java.io.File;
import java.net.FileNameMap;

/**
 * @author fkjslee
 * @date 2017/4/3 at 11:28
 * Copyright (c) 2017 fkjslee. All rights reserved.
 */

public class FileDetails {
    File currentFile;
    JLabel fileName;
    JTextField path;
    JLabel date;
    JLabel size;
    JCheckBox readable;
    JCheckBox writable;
    JCheckBox executable;
    JRadioButton isDirectory;
    JRadioButton isFile;
    
    public File getCurrentFile() {
        return currentFile;
    }
    
    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }
    
    public JLabel getFileName() {
        return fileName;
    }
    
    public void setFileName(JLabel fileName) {
        this.fileName = fileName;
    }
    
    public JTextField getPath() {
        return path;
    }
    
    public void setPath(JTextField path) {
        this.path = path;
    }
    
    public JLabel getDate() {
        return date;
    }
    
    public void setDate(JLabel date) {
        this.date = date;
    }
    
    public JLabel getSize() {
        return size;
    }
    
    public void setSize(JLabel size) {
        this.size = size;
    }
    
    public JCheckBox getReadable() {
        return readable;
    }
    
    public void setReadable(JCheckBox readable) {
        this.readable = readable;
    }
    
    public JCheckBox getWritable() {
        return writable;
    }
    
    public void setWritable(JCheckBox writable) {
        this.writable = writable;
    }
    
    public JCheckBox getExecutable() {
        return executable;
    }
    
    public void setExecutable(JCheckBox executable) {
        this.executable = executable;
    }
    
    public JRadioButton getIsDirectory() {
        return isDirectory;
    }
    
    public void setIsDirectory(JRadioButton isDirectory) {
        this.isDirectory = isDirectory;
    }
    
    public JRadioButton getIsFile() {
        return isFile;
    }
    
    public void setIsFile(JRadioButton isFile) {
        this.isFile = isFile;
    }
}
