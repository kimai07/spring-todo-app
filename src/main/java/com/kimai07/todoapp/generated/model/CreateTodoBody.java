package com.kimai07.todoapp.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateTodoBody
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CreateTodoBody implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("deadline")
    private LocalDate deadline = null;

    public CreateTodoBody title(String title) {
        this.title = title;
        return this;
    }

    /**
     * タイトル
     * 
     * @return title
     */
    @ApiModelProperty(example = "ショッピング", required = true, value = "タイトル")
    @NotNull

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CreateTodoBody description(String description) {
        this.description = description;
        return this;
    }

    /**
     * 説明
     * 
     * @return description
     */
    @ApiModelProperty(example = "PCを買う", value = "説明")

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreateTodoBody deadline(LocalDate deadline) {
        this.deadline = deadline;
        return this;
    }

    /**
     * 終了期限
     * 
     * @return deadline
     */
    @ApiModelProperty(example = "2021-08-31", value = "終了期限")

    @Valid

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateTodoBody createTodoBody = (CreateTodoBody) o;
        return Objects.equals(this.title, createTodoBody.title)
                && Objects.equals(this.description, createTodoBody.description)
                && Objects.equals(this.deadline, createTodoBody.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, deadline);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateTodoBody {\n");

        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
