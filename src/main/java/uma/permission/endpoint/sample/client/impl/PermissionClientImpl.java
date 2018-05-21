package uma.permission.endpoint.sample.client.impl;

import uma.permission.endpoint.sample.client.AbstractRestClient;
import uma.permission.endpoint.sample.client.PermissionClient;
import uma.permission.endpoint.sample.model.ErrorResponse;
import uma.permission.endpoint.sample.model.PermissionTicketResponse;
import uma.permission.endpoint.sample.model.Permissions;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class PermissionClientImpl extends AbstractRestClient implements PermissionClient {

    public PermissionClientImpl(String targetServiceUrl, MultivaluedMap<String, Object> headers) {
        super(targetServiceUrl,headers);
    }

    @Override
    public PermissionTicketResponse savePermissions(Permissions permissions) throws Exception {
        Response response = null;
        try {
            Entity<Permissions> entity = Entity.entity(permissions, MediaType.APPLICATION_JSON_TYPE);
            response = super.post(this.targetServiceUrl, entity);
            return response.readEntity(PermissionTicketResponse.class);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new Exception(e);
        } finally {
            close(response);
        }
    }

    public void x(Permissions permissions, HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Entity<Permissions> entity = Entity.entity(permissions, MediaType.APPLICATION_JSON_TYPE);
        Response response  = super.post(this.targetServiceUrl, entity);
        if(response.getStatus() == 201){
            req.setAttribute("permissionRequest",response.readEntity(PermissionTicketResponse.class));
            RequestDispatcher dispatcher = req.getRequestDispatcher("request-permission.jsp");
            dispatcher.forward(req, resp);
        } else if (response.getStatus() == 400){
            req.setAttribute("errorMessage",response.readEntity(ErrorResponse.class));
            RequestDispatcher dispatcher = req.getRequestDispatcher("request-permission.jsp");
            dispatcher.forward(req, resp);
        } else {
            throw new Exception("Error");
        }
    }


    @Override
    public ErrorResponse sendError(Permissions permissions) throws Exception {
        Response response = null;
        try {
            Entity<Permissions> entity = Entity.entity(permissions, MediaType.APPLICATION_JSON_TYPE);
            response = super.post(this.targetServiceUrl, entity);
            return response.readEntity(ErrorResponse.class);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new Exception(e);
        } finally {
            close(response);
        }
    }
}