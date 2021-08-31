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
 * UpdateTodoBody
 */
@Validated

public class UpdateTodoBody implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("title")
    private String title = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("deadline")
    private String deadline = null;

    @JsonProperty("done")
    private Boolean done = null;

    public UpdateTodoBody title(String title) {
        this.title = title;
        return this;
    }

    /**
     * タイトル
     * 
     * @return title
     **/
    @ApiModelProperty(example = "ショッピング", value = "タイトル")

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UpdateTodoBody description(String description) {
        this.description = description;
        return this;
    }

    /**
     * 説明
     * 
     * @return description
     **/
    @ApiModelProperty(example = "PCを買う", value = "説明")

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UpdateTodoBody deadline(String deadline) {
        this.deadline = deadline;
        return this;
    }

    /**
     * 終了期限
     * 
     * @return deadline
     **/
    @ApiModelProperty(example = "2021-08-31", value = "終了期限")

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public UpdateTodoBody done(Boolean done) {
        this.done = done;
        return this;
    }

    /**
     * 完了済みかどうか
     * 
     * @return done
     **/
    @ApiModelProperty(value = "完了済みかどうか")

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
        UpdateTodoBody updateTodoBody = (UpdateTodoBody) o;
        return Objects.equals(this.title, updateTodoBody.title)
                && Objects.equals(this.description, updateTodoBody.description)
                && Objects.equals(this.deadline, updateTodoBody.deadline)
                && Objects.equals(this.done, updateTodoBody.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, deadline, done);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateTodoBody {\n");

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
