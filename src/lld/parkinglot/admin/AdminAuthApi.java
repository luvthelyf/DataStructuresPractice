package lld.parkinglot.admin;

import lld.parkinglot.admin.Administrator;
import lld.parkinglot.exceptions.AdminAlreadyRegisteredException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AdminAuthApi {
    Map<Administrator, String> tokenAdminMap;
    private static AdminAuthApi authApi = null;
    private AdminAuthApi() {
        tokenAdminMap = new HashMap<>();
    }

    public static AdminAuthApi getInstance() {
        if(authApi == null) {
            authApi = new AdminAuthApi();
        }
        return authApi;
    }
    public void registerAdmin(Administrator administrator) {
        String token = UUID.randomUUID().toString();
        if(tokenAdminMap.containsKey(administrator))
            throw new AdminAlreadyRegisteredException();
        tokenAdminMap.put(administrator, token);

    }

    public boolean verifyAdmin(Administrator administrator) {
        if(administrator == null) return false;
        return tokenAdminMap.containsKey(administrator);
    }
}
