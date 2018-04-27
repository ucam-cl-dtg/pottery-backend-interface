/*
 * pottery-backend-interface - Backend API for testing programming exercises
 * Copyright © 2015 Andrew Rice (acr31@cam.ac.uk)
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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.Map;

public class Step {
  @ApiModelProperty("Name of this step")
  String name;
  @ApiModelProperty("Map from variants to execution to run for this step")
  Map<String, Execution> execution;

  @JsonCreator
  public Step(
      @JsonProperty("name") String name,
      @JsonProperty("execution") Map<String, Execution> execution) {
    this.name = name;
    this.execution = execution;
  }

  public String getName() {
    return name;
  }

  public Map<String, Execution> getExecution() {
    return execution;
  }

  void setDefaultContainerRestriction(ContainerRestrictions defaultRestrictions) {
    this.execution.values().forEach(execution ->
        execution.setDefaultContainerRestriction(defaultRestrictions));
  }
}
