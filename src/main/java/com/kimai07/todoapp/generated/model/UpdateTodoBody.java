package com.kimai07.todoapp.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UpdateTodoBody
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UpdateTodoBody  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("title")
  private String title;

  @JsonProperty("description")
  private String description;

  @JsonProperty("deadline")
  private String deadline;

  @JsonProperty("done")
  private Boolean done;

  public UpdateTodoBody title(String title) {
    this.title = title;
    return this;
  }

  /**
   * タイトル
   * @return title
  */
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
   * @return description
  */
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
   * @return deadline
  */
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
   * @return done
  */
  @ApiModelProperty(value = "完了済みかどうか")


  public Boolean getDone() {
    return done;
  }

  public void setDone(Boolean done) {
    this.done = done;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateTodoBody updateTodoBody = (UpdateTodoBody) o;
    return Objects.equals(this.title, updateTodoBody.title) &&
        Objects.equals(this.description, updateTodoBody.description) &&
        Objects.equals(this.deadline, updateTodoBody.deadline) &&
        Objects.equals(this.done, updateTodoBody.done);
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
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

