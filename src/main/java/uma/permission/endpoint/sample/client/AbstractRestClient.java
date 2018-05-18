/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uma.permission.endpoint.sample.client;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import uma.permission.endpoint.sample.model.Permissions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * @author USER
 */
public class AbstractRestClient {

    protected String targetServiceUrl;
    private MultivaluedMap<String, Object> headers;

    public AbstractRestClient(String targetServiceUrl, MultivaluedMap<String, Object> headers) {
        this.targetServiceUrl = targetServiceUrl;
        this.headers = headers;
    }

    public ResteasyWebTarget createTarget(final String serviceUrl) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(serviceUrl);
        return target;
    }

    public Invocation.Builder createBuilder(final String serviceUrl) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(serviceUrl);

        return target.request();
    }

    public Response post(final String url, final Entity<?> entity) throws Exception {
        Response response = createTarget(url).request().headers(headers).post(entity);
        if (!isSuccess(response)) {
            processException(response);
        }
        return response;
    }

        public Response getJson(final String url) throws Exception {

        Response response = createTarget(url).request().accept(MediaType.APPLICATION_JSON_TYPE).get();
        if (!isSuccess(response)) {
            processException(response);
        }
        return response;
    }

    /**
     * Check the server response whether success or other failures.
     *
     * @param response Rest server response
     * @return true if server returns 200 as response code
     */
    public boolean isSuccess(final Response response) {
        /*return response.getStatus() == Response.Status.OK.getStatusCode() || response.getStatus() == Response.Status.CREATED.getStatusCode();*/
        return response.getStatus() == Response.Status.CREATED.getStatusCode();
    }

    /**
     * Close the response.
     *
     * @param response Response
     */
    public void close(final Response response) {

        if (response != null) {

            response.close();
        }
    }


    public void processException(Response response) throws Exception {
        if(response.getStatus()==401){
            throw new Exception("Invalid token.");
        }else if(response.getStatus()==500){
            throw new Exception("Server error.");
        }else if(response.getStatus()==400){
            throw new Exception("Bad request.");
        }else {
            throw new Exception("Exception occurred: "+response.getStatus());
        }
    }

}
