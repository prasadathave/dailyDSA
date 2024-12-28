package org.example.RandomQuestions;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private static FileSystem fileSystem = new FileSystem();
    private static RandomFile rootFile = new RandomFile("/","");

    private FileSystem(){

    }
    public void mkdir(String path){
        String[] fileNames = path.split("/");
        rootFile.addPath(fileNames,1);
    }
    public List<String> ls(String path){
        String[] fileNames = path.split("/");
        List<RandomFile> flList = rootFile.getFilesAtThisFolder(fileNames,1);
        List<String> files = new ArrayList<>();
        for(RandomFile fl:flList){
            files.add(fl.nameIdentifier);
        }
        return files;
    }
    public static FileSystem getInstance(){
        return fileSystem;
    }
    public void addContent(String path,String content){
        String[] fileNames = path.split("/");
        rootFile.addContentToFile(fileNames,content,1);
    }
    public String readContent(String path){
        String[] fileNames = path.split("/");
        return rootFile.readContentFromFile(fileNames,1);
    }
}
