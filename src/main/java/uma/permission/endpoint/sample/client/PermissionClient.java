package uma.permission.endpoint.sample.client;

import uma.permission.endpoint.sample.model.ErrorResponse;
import uma.permission.endpoint.sample.model.PermissionTicketResponse;
import uma.permission.endpoint.sample.model.Permissions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PermissionClient {

    void requestPermissions(Permissions permissions, HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
