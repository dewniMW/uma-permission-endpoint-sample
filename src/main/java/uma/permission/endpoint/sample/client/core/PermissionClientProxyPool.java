package uma.permission.endpoint.sample.client.core;

import org.jboss.resteasy.specimpl.MultivaluedMapImpl;
import uma.permission.endpoint.sample.client.PermissionClient;
import uma.permission.endpoint.sample.client.impl.PermissionClientImpl;

import javax.ws.rs.core.MultivaluedMap;

public class PermissionClientProxyPool {
    private static PermissionClientProxyPool instance = null;

    protected String targetBaseServiceURL = null;

    private PermissionClient permissionClient;

    protected PermissionClientProxyPool(final String targetBaseServiceURL) {
        this.targetBaseServiceURL = targetBaseServiceURL;
    }
    public static PermissionClientProxyPool getInstance() {
        String targetUrl = "https://localhost:9443/api/identity/oauth2/uma/permission/v1.0/permission";
        if (instance == null) {
            instance = new PermissionClientProxyPool(targetUrl);

        }
        return instance;
    }

    public PermissionClient getPermissionClient(){
        if(permissionClient == null){
            MultivaluedMap headers = new MultivaluedMapImpl();
            headers.add("Authorization", "Bearer b0e06b96-38eb-3b68-82eb-ff1cc805c3db");
            //headers.add("Content-Type", "application/json");
            permissionClient = new PermissionClientImpl(targetBaseServiceURL,headers);
        }
        return permissionClient;
    }
}
