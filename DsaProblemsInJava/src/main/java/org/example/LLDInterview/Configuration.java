package org.example.LLDInterview;

import java.util.List;

public class Configuration {
    private static final String NOT_ENOUGH_PRIVILEGE_MSG = "Not enough privileges";
    private String jsonObject;
    private List<version> versionList;
    private PermissionManager permissionManager;


    public void update(User user, String updatedString){
        if(permissionManager.isAllowed(user)){
            version version = new version(user.getID(), System.currentTimeMillis(),jsonObject);
            versionList.add(version);
            jsonObject = updatedString;
        }
        else {
            throw new RuntimeException(NOT_ENOUGH_PRIVILEGE_MSG);
        }
    }
    public String read(User user){
        // Check with permissionManager
        if(permissionManager.isAllowed(user)){
            return jsonObject;
        }
        throw new RuntimeException(NOT_ENOUGH_PRIVILEGE_MSG);
    }


}
