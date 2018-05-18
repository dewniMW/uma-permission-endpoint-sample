package uma.permission.endpoint.sample.controller;

import uma.permission.endpoint.sample.client.PermissionClient;
import uma.permission.endpoint.sample.client.core.PermissionClientProxyPool;
import uma.permission.endpoint.sample.model.ErrorResponse;
import uma.permission.endpoint.sample.model.Permissions;
import uma.permission.endpoint.sample.model.RequestPermission;
import uma.permission.endpoint.sample.model.PermissionTicketResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RequestPermission" , urlPatterns = "/permission")
public class PermissionRequestServlet extends HttpServlet {

    private PermissionClient permissionClient;


    @Override
    public void init() throws ServletException {
        super.init();
        permissionClient = PermissionClientProxyPool.getInstance().getPermissionClient();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PermissionTicketResponse permissionTicketResponse = permissionClient.saveResource(getResource(req));
            req.setAttribute("permissionRequest", permissionTicketResponse);
            RequestDispatcher dispatcher = req.getRequestDispatcher("request-permission.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
    /*private RequestPermission getResource(HttpServletRequest request){
        RequestPermission requestPermission = new RequestPermission();
        requestPermission.setResourceId(request.getParameter("resource_id"));
        String[] scopesList=request.getParameter("resource_scopes").split(",");
        List<String> scopes = new ArrayList<>();
        for (String s:scopesList){
            scopes.add(s);
        }
        requestPermission.setResourceScopes(scopes);
        return requestPermission;
    }*/


    private Permissions getResource(HttpServletRequest request){
//        Permissions permissions = new Permissions();
//        for(RequestPermission requestPermission: permissions){
//            requestPermission.setResourceId(request.getParameter("resource_id"));
//            String[] scopesList=request.getParameter("resource_scopes").split(",");
//            List<String> scopes = new ArrayList<>();
//            for (String s:scopesList){
//                scopes.add(s);
//            }
//            requestPermission.setResourceScopes(scopes);
//            permissions.add(requestPermission);
//        }
//       return permissions;
        Permissions permissions = new Permissions();
        RequestPermission requestPermission = new RequestPermission();

            requestPermission.setResourceId(request.getParameter("resource_id"));
            String[] scopesList=request.getParameter("resource_scopes").split(",");
            List<String> scopes = new ArrayList<>();
            for (String s:scopesList){
                scopes.add(s);
            }
            requestPermission.setResource_scopes(scopes);
            permissions.add(requestPermission);

        return permissions;
    }

}
