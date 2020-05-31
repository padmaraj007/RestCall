
package com.jbpm.request;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "com.jbpm_workspace.api_calling.Employee"
})
public class Employee_ {

    @JsonProperty("com.jbpm_workspace.api_calling.Employee")
    private ComJbpmWorkspaceApiCallingEmployee comJbpmWorkspaceApiCallingEmployee;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("com.jbpm_workspace.api_calling.Employee")
    public ComJbpmWorkspaceApiCallingEmployee getComJbpmWorkspaceApiCallingEmployee() {
        return comJbpmWorkspaceApiCallingEmployee;
    }

    @JsonProperty("com.jbpm_workspace.api_calling.Employee")
    public void setComJbpmWorkspaceApiCallingEmployee(ComJbpmWorkspaceApiCallingEmployee comJbpmWorkspaceApiCallingEmployee) {
        this.comJbpmWorkspaceApiCallingEmployee = comJbpmWorkspaceApiCallingEmployee;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
