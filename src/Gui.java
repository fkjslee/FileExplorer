import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

/**
 * @author fkjslee
 * @date 2017/4/1 at 21:01
 * Copyright (c) 2017 fkjslee. All rights reserved.
 */

@SuppressWarnings("Duplicates")
public class Gui{
    private JPanel panel = new JPanel();
    private JTable table;
    private JTree leftFileTree;
    private Boolean cellSizesSet = false;
    private JSplitPane splitPane;
    private JScrollPane treeScroll;
    private File[] files;
    private FileDetails fileDetails;
    private FileTableModel fileTableModel;
    private JFrame frame;
    
    Gui(File[] files) {
        setFiles(files);
        
        initView();
        
    }
    
    public void setFiles(File[] files) {
        this.files = files;
        if(null == fileTableModel) {
            fileTableModel = new FileTableModel();
            table.setModel(fileTableModel);
        }
        fileTableModel.setFiles(files);
    }
    
    public JTable getTable() {
        return table;
    }
    
    /** Update the File details view with the details of this File. */
    private void setFileDetails(File file) {
    
    }
    
    private void initView() {
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        table.setShowVerticalLines(false);
        
        JScrollPane tableScroll = new JScrollPane(table);
        JPanel detailView = new JPanel(new BorderLayout(3,3));
        Dimension d = tableScroll.getPreferredSize();
        tableScroll.setPreferredSize(new Dimension((int)d.getWidth(), (int)d.getHeight()/2));
        detailView.add(tableScroll, BorderLayout.CENTER);
        
        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                treeScroll,
                detailView);
    
        frame = new JFrame("");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setMinimumSize(new Dimension(1000, 1000));
        frame.setVisible(true);
        frame.setContentPane(splitPane);
    }
    
    private void setColumnWidth(int column, int width) {
        TableColumn tableColumn = table.getColumnModel().getColumn(column);
        if (width<0) {
            // use the preferred width of the header..
            JLabel label = new JLabel( (String)tableColumn.getHeaderValue() );
            Dimension preferred = label.getPreferredSize();
            // altered 10->14 as per camickr comment.
            width = (int)preferred.getWidth()+14;
        }
        tableColumn.setPreferredWidth(width);
        tableColumn.setMaxWidth(width);
        tableColumn.setMinWidth(width);
    }
    
    class FileTableModel extends AbstractTableModel {
        
        public File[] files;
        private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        private String[] columns = {
                "Icon",
                "File",
                "Path/name",
                "Size",
                "Last Modified",
                "R",
                "W",
                "E",
                "D",
                "F",
        };
        
        FileTableModel() {
            this(new File[0]);
        }
        
        private FileTableModel(File[] files) {
            this.files = files;
        }
        
        public Object getValueAt(int row, int column) {
            File file = files[row];
            switch (column) {
                case 0:
                    return fileSystemView.getSystemIcon(file);
                case 1:
                    return fileSystemView.getSystemDisplayName(file);
                case 2:
                    return file.getPath();
                case 3:
                    return file.length();
                case 4:
                    return file.lastModified();
                case 5:
                    return file.canRead();
                case 6:
                    return file.canWrite();
                case 7:
                    return file.canExecute();
                case 8:
                    return file.isDirectory();
                case 9:
                    return file.isFile();
                default:
                    System.err.println("Logic Error");
            }
            return "";
        }
        
        public int getColumnCount() {
            return columns.length;
        }
        
        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 0:
                    return ImageIcon.class;
                case 3:
                    return Long.class;
                case 4:
                    return Date.class;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return Boolean.class;
            }
            return String.class;
        }
        
        public String getColumnName(int column) {
            return columns[column];
        }
        
        public int getRowCount() {
            return files.length;
        }
        
        File getFile(int row) {
            int x = 1;
            return files[row];
        }
        
        void setFiles(File[] files) {
            this.files = files;
            fireTableDataChanged();
        }
    }
    
}


