package org.example.RandomQuestions;

import java.util.ArrayList;
import java.util.List;

public class RandomFile {
    String nameIdentifier;
    String content;
    List<RandomFile> childrenFiles;

    RandomFile(String nameIdentifier, String content) {
        this.nameIdentifier = nameIdentifier;
        this.content = content;
        this.childrenFiles = new ArrayList<>();
    }

    public void addPath(String[] fileNames, int startIndex) {
        if(startIndex==fileNames.length){
            return;
        }
        int found = 0;
        for(RandomFile fl : childrenFiles){
            if(fl.nameIdentifier.equals(fileNames[startIndex])){
                fl.addPath(fileNames,startIndex+1);
                found = 1;
            }
        }
        if (found==0){
            RandomFile fl1 = new RandomFile(fileNames[startIndex],"");
            childrenFiles.add(fl1);

            fl1.addPath(fileNames, startIndex+1);
        }
    }

    public List<RandomFile> getFilesAtThisFolder(String[] path,int startIndex) {
        if(path.length==0){
            return childrenFiles;
        }
        if (path.length==startIndex){
            return childrenFiles;
        }

        for(RandomFile fl: childrenFiles){
            if(fl.nameIdentifier.equals(path[startIndex])){
                return fl.getFilesAtThisFolder(path,startIndex+1);
            }
        }
        return new ArrayList<>();
    }

    public void addContentToFile(String[] fileNames,String content,int startIndex) {
        if (fileNames.length==0){
            this.content = content;
        }
        if (fileNames.length==startIndex){
            this.content = content;
        }
        boolean found = false;
        for(RandomFile fl: childrenFiles){
            if(fl.nameIdentifier.equals(fileNames[startIndex])){
                found = true;
                fl.addContentToFile(fileNames,content,startIndex+1);
            }
        }
        if(!found && fileNames.length-1==startIndex){
            RandomFile fl = new RandomFile(fileNames[startIndex],content);
            childrenFiles.add(fl);
            found = true;
        }
        if(!found){
            throw new RuntimeException("Path does not exist");
        }
    }
    public String readContentFromFile(String[] fileNames, int startIndex){
        if(fileNames.length==0){
            return content;
        }
        if (fileNames.length==startIndex){
            return content;
        }


        for(RandomFile fl: childrenFiles){
            if(fl.nameIdentifier.equals(fileNames[startIndex])){
                return fl.readContentFromFile(fileNames,startIndex+1);
            }
        }

        throw new RuntimeException("File Not found");
    }

}
