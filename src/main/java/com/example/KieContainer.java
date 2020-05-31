
package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "container-id",
    "release-id",
    "resolved-release-id",
    "status",
    "scanner",
    "config-items",
    "messages",
    "container-alias"
})
public class KieContainer {

    @JsonProperty("container-id")
    private String containerId;
    @JsonProperty("release-id")
    private ReleaseId releaseId;
    @JsonProperty("resolved-release-id")
    private ResolvedReleaseId resolvedReleaseId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("scanner")
    private Scanner scanner;
    @JsonProperty("config-items")
    private List<ConfigItem> configItems = null;
    @JsonProperty("messages")
    private List<Message> messages = null;
    @JsonProperty("container-alias")
    private String containerAlias;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("container-id")
    public String getContainerId() {
        return containerId;
    }

    @JsonProperty("container-id")
    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    @JsonProperty("release-id")
    public ReleaseId getReleaseId() {
        return releaseId;
    }

    @JsonProperty("release-id")
    public void setReleaseId(ReleaseId releaseId) {
        this.releaseId = releaseId;
    }

    @JsonProperty("resolved-release-id")
    public ResolvedReleaseId getResolvedReleaseId() {
        return resolvedReleaseId;
    }

    @JsonProperty("resolved-release-id")
    public void setResolvedReleaseId(ResolvedReleaseId resolvedReleaseId) {
        this.resolvedReleaseId = resolvedReleaseId;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("scanner")
    public Scanner getScanner() {
        return scanner;
    }

    @JsonProperty("scanner")
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @JsonProperty("config-items")
    public List<ConfigItem> getConfigItems() {
        return configItems;
    }

    @JsonProperty("config-items")
    public void setConfigItems(List<ConfigItem> configItems) {
        this.configItems = configItems;
    }

    @JsonProperty("messages")
    public List<Message> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @JsonProperty("container-alias")
    public String getContainerAlias() {
        return containerAlias;
    }

    @JsonProperty("container-alias")
    public void setContainerAlias(String containerAlias) {
        this.containerAlias = containerAlias;
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
