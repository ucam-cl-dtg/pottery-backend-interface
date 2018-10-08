/*
 * pottery-backend-interface - Backend API for testing programming exercises
 * Copyright © 2015-2018 BlueOptima Limited, Andrew Rice (acr31@cam.ac.uk)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package uk.ac.cam.cl.dtg.teaching.pottery.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/** A Parameterisation represents the instructions for parameterising a task. */
public class Parameterisation {
  @ApiModelProperty("Values that are used for parameterisation.")
  private final Map<String, List<JsonNode>> values;

  @ApiModelProperty("Parameters that are used for parameterisation.")
  private final List<MutationParameter> parameters;

  @ApiModelProperty("Templated problem statement that takes the parameters.")
  private final String problemStatement;

  @JsonCreator
  public Parameterisation(@JsonProperty("values") Map<String, List<JsonNode>> values,
                          @JsonProperty("parameters") List<MutationParameter> parameters,
                          @JsonProperty("problemStatement") String problemStatement) {
    this.values = values;
    this.parameters = parameters;
    this.problemStatement = problemStatement;
  }

  public Map<String, List<JsonNode>> getValues() {
    return values;
  }

  public List<MutationParameter> getParameters() {
    return parameters;
  }

  public String getProblemStatement() {
    return problemStatement;
  }
}
