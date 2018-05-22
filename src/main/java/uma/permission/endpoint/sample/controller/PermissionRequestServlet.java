package uma.permission.endpoint.sample.controller;

import uma.permission.endpoint.sample.client.PermissionClient;
import uma.permission.endpoint.sample.client.core.PermissionClientProxyPool;
import uma.permission.endpoint.sample.model.Permissions;
import uma.permission.endpoint.sample.model.RequestPermission;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RequestPermission" , urlPatterns = "/permission")
public class PermissionRequestServlet extends HttpServlet {

    private PermissionClient permissionClient;
    private Permissions permissions = new Permissions();

    @Override
    public void init() throws ServletException {

        super.init();
        permissionClient = PermissionClientProxyPool.getInstance().getPermissionClient();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String act = req.getParameter("act");
        if (act.equals("Add more permissions")) {
            //add button was pressed
            permissions.add(getResource(req));
            resp.sendRedirect("/request-permission.jsp");
        } else if (act.equals("Send request")) {
            //send button was pressed
            permissions.add(getResource(req));
            try {
                permissionClient.requestPermissions(permissions, req, resp);
                permissions = new Permissions();
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        }
    }

    private RequestPermission getResource(HttpServletRequest request) {

        RequestPermission requestPermission = new RequestPermission();

        requestPermission.setResourceId(request.getParameter("resource_id"));
        String[] scopesList = request.getParameter("resource_scopes").split(",");
        List<String> scopes = new ArrayList<>();
        for (String s : scopesList) {
            if (!s.equals(""))
                scopes.add(s);

        }
        requestPermission.setResource_scopes(scopes);

        return requestPermission;
    }

}
