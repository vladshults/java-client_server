package javafxapplication4;

import java.io.File;
import java.util.*;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class FindTask extends Task<Void> {
    final private int    SIZE=200;
    final private ObservableList<String> items1;
    final private String path;
    final private String end;
    
    final private List<String> list=new LinkedList<>();

    public FindTask(ObservableList<String> items, String path, String end) {
        this.items1 = items;
        this.path = path;
        this.end = end;
    }

//    //only in synk version
//    public void doWork() {
//        File file=new File(path);
//        if (file.isDirectory()) findIn(file);
//    }
    
    private void findIn(File fi) {
        File[] files=fi.listFiles((f)->f.getName().endsWith(end) || f.isDirectory());
        
        if (isCancelled())                  return;
        if (files!=null && items1.size()<SIZE)
            for(File f : files)
                if (f.isDirectory())        findIn(f);  
                else    list.add(f.getAbsolutePath());
        updateProgress(list.size(), SIZE);
    }                

    @Override
    protected Void call() throws Exception {
        File file=new File(path);
        if (file.isDirectory()) findIn(file);
        return null;
    }

    @Override
    protected void cancelled() {
        items1.add("canceled by user....");
	updateScene();
    }

    @Override
    protected void succeeded() {
        items1.addAll(list);
	items1.add("finded "+items1.size()+" files");
	updateScene();
    }
    private void updateScene(){
        updateProgress(SIZE, SIZE);
    }
}
