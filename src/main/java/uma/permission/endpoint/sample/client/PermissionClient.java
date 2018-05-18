package uma.permission.endpoint.sample.client;

import uma.permission.endpoint.sample.model.ErrorResponse;
import uma.permission.endpoint.sample.model.Permissions;
import uma.permission.endpoint.sample.model.PermissionTicketResponse;

public interface PermissionClient {

    /*PermissionTicketResponse saveResource(RequestPermission requestPermission) throws Exception;*/
    PermissionTicketResponse saveResource(Permissions permissions) throws Exception;

}
