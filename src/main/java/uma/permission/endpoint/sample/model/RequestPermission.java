package uma.permission.endpoint.sample.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;


public class RequestPermission implements Serializable {

    private List<String> resource_scopes = new ArrayList<String>();
    private String resource_id = null;

    @XmlElement(name = "resource_id")
    public String getResourceId() {

        return resource_id;
    }

    @XmlElement(name = "resource_id")
    public void setResourceId(String resource_id) {

        this.resource_id = resource_id;
    }

    public List<String> getResource_scopes() {

        return resource_scopes;
    }

    public void setResource_scopes(List<String> resource_scopes) {

        this.resource_scopes = resource_scopes;
    }

}
