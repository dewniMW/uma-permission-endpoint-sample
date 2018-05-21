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
    static Permissions permissions = new Permissions();


    @Override
    public void init() throws ServletException {
        super.init();
        permissionClient = PermissionClientProxyPool.getInstance().getPermissionClient();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*try {
            PermissionTicketResponse permissionTicketResponse = permissionClient.savePermissions(getResource(req));
            req.setAttribute("permissionRequest", permissionTicketResponse);
            RequestDispatcher dispatcher = req.getRequestDispatcher("request-permission.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }*/

        /*try {
            PermissionTicketResponse permissionTicketResponse = permissionClient.savePermissions(getResource(req));
            req.setAttribute("permissionRequest", permissionTicketResponse);
            RequestDispatcher dispatcher = req.getRequestDispatcher("request-permission.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            try {
                ErrorResponse errorResponse = permissionClient.sendError(getResource(req));
                req.setAttribute("errorMessage", errorResponse);
                RequestDispatcher dispatcher1 = req.getRequestDispatcher("request-permission.jsp");
                dispatcher1.forward(req, resp);
            } catch (Exception e1) {
                throw new ServletException(e);
            }

        }*/
        String act = req.getParameter("act");
        if (act == null) {
            //no button has been selected
        } else if (act.equals("Add more permissions")) {
            //add button was pressed
            permissions.add(getResource(req));
            resp.sendRedirect("/request-permission.jsp");
        } else if (act.equals("Send request")) {
            //send button was pressed
            permissions.add(getResource(req));
            try {
                permissionClient.x(permissions, req, resp);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }

        } else {
            //someone has altered the HTML and sent a different value!
        }

        /*try {
            permissionClient.x(getResource(req), req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
*/

        /*try {
            ErrorResponse errorResponse = permissionClient.sendError(getResource(req));
            req.setAttribute("errorMessage", errorResponse);
            RequestDispatcher dispatcher = req.getRequestDispatcher("request-permission.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            //throw new ServletException(e);
        }*/
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


    /*private Permissions getResource(HttpServletRequest request){
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
        *//*Permissions permissions = new Permissions();*//*
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
    }*/
    private RequestPermission getResource(HttpServletRequest request){
        RequestPermission requestPermission = new RequestPermission();

        requestPermission.setResourceId(request.getParameter("resource_id"));
        String[] scopesList=request.getParameter("resource_scopes").split(",");
        List<String> scopes = new ArrayList<>();
        for (String s:scopesList){
            scopes.add(s);
        }
        requestPermission.setResource_scopes(scopes);


        return requestPermission;
    }

}
