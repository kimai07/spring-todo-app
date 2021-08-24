package com.kimai07.todoapp.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Todo
 */
@Validated

public class Todo implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long id = null;

    @JsonProperty("title")
    private String title = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("deadline")
    private String deadline = null;

    @JsonProperty("done")
    private Boolean done = null;

    public Todo id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * 
     * @return id
     **/
    @ApiModelProperty(example = "1", value = "")

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Todo title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     * 
     * @return title
     **/
    @ApiModelProperty(example = "買い物", value = "")

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Todo description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     * 
     * @return description
     **/
    @ApiModelProperty(example = "PCを買う", value = "")

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Todo deadline(String deadline) {
        this.deadline = deadline;
        return this;
    }

    /**
     * Get deadline
     * 
     * @return deadline
     **/
    @ApiModelProperty(example = "2021-12-31", value = "")

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Todo done(Boolean done) {
        this.done = done;
        return this;
    }

    /**
     * Get done
     * 
     * @return done
     **/
    @ApiModelProperty(example = "false", value = "")

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Todo todo = (Todo) o;
        return Objects.equals(this.id, todo.id) && Objects.equals(this.title, todo.title)
                && Objects.equals(this.description, todo.description) && Objects.equals(this.deadline, todo.deadline)
                && Objects.equals(this.done, todo.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, deadline, done);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Todo {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
        sb.append("    done: ").append(toIndentedString(done)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
