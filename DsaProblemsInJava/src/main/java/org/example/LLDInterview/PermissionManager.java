package org.example.LLDInterview;

import java.util.List;
import java.util.Map;

public class PermissionManager {
    Map<String, List<String>> userPermissions;
    Map<String,List<String>> groupPermission;

    PermissionManager(){

    }

    public boolean isAllowed(User user) {
        return false;
    }
    // Methods for adding removing permission

}
