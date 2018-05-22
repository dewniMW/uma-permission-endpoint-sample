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

    public static int httpStatusCode;

    public PermissionClientImpl(String targetServiceUrl, MultivaluedMap<String, Object> headers) {

        super(targetServiceUrl, headers);
    }

    @Override
    public void requestPermissions(Permissions permissions, HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Entity<Permissions> entity = Entity.entity(permissions, MediaType.APPLICATION_JSON_TYPE);
        Response response = super.post(this.targetServiceUrl, entity);
        httpStatusCode = response.getStatus();
        if (httpStatusCode == 201) {
            req.setAttribute("permissionRequest", response.readEntity(PermissionTicketResponse.class));
            RequestDispatcher dispatcher = req.getRequestDispatcher("request-permission.jsp");
            dispatcher.forward(req, resp);
        } else if (httpStatusCode == 400) {
            req.setAttribute("errorMessage", response.readEntity(ErrorResponse.class));
            RequestDispatcher dispatcher = req.getRequestDispatcher("request-permission.jsp");
            dispatcher.forward(req, resp);
        } /*else if (httpStatusCode == 401){
            throw new Exception("Invalid/ Expired token.");
        }*/else {
            throw new Exception("Error");
        }
    }

}
