package uma.permission.endpoint.sample.client.impl;

import uma.permission.endpoint.sample.client.AbstractRestClient;
import uma.permission.endpoint.sample.client.PermissionClient;
import uma.permission.endpoint.sample.model.ErrorResponse;
import uma.permission.endpoint.sample.model.PermissionTicketResponse;
import uma.permission.endpoint.sample.model.Permissions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class PermissionClientImpl extends AbstractRestClient implements PermissionClient {

    public PermissionClientImpl(String targetServiceUrl, MultivaluedMap<String, Object> headers) {
        super(targetServiceUrl,headers);
    }


    @Override
    /*public PermissionTicketResponse saveResource(RequestPermission requestPermission) throws Exception {
        Response response = null;
        try {
            Entity<RequestPermission> entity = Entity.entity(requestPermission, MediaType.APPLICATION_JSON_TYPE);

            response = super.post(this.targetServiceUrl, entity);

            PermissionTicketResponse permissionTicketResponse = response.readEntity(PermissionTicketResponse.class);
            return permissionTicketResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            close(response);
        }
    }*/
    public PermissionTicketResponse saveResource(Permissions permissions) throws Exception {
        Response response = null;
        try {
            Entity<Permissions> entity = Entity.entity(permissions, MediaType.APPLICATION_JSON_TYPE);
            response = super.post(this.targetServiceUrl, entity);
            return response.readEntity(PermissionTicketResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            close(response);
        }
    }
}