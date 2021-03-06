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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaskInfo {

  /**
   * Algorithms &amp; Data Structures: Tests the ability of the developer to compose algorithms and
   * design appropriate data structures to solve the problem set out in the test.
   */
  public static final String TYPE_ALGORITHM = "ALGORITHMS";

  /**
   * Design Approaches: Evaluates the logical flow of solution code and appropriate design features
   * of the solution (e.g. ???)
   */
  public static final String TYPE_DESIGN = "DESIGN";

  /**
   * Black Box Testing: Tests the developer's ability to test a solution without knowing or being
   * able to review the underlying source code.
   */
  public static final String TYPE_BLACKBOX = "BLACKBOX";

  /**
   * Unit Testing: Assesses the ability of the developer to write unit tests on pre-existing source
   * code and or source code that they have themselves written.
   */
  public static final String TYPE_UNITTEST = "UNITTEST";

  /**
   * I/O Management: Evaluates the developers ability to implement strategies that result in
   * appropriate I/O activity in a test solution.
   */
  public static final String TYPE_IO = "IO";

  /**
   * Cache &amp; Memory Management: Evaluates the developers ability to implement strategies that
   * result in appropriate cache and memory usage approaches in a test solution.
   */
  public static final String TYPE_MEMORY = "MEMORY";

  /**
   * Using Existing APIs &amp; Libraries: Test the ability of a developer to appropriately exploit
   * existing libraries and APIs to achieve the required test solution.
   */
  public static final String TYPE_LIBRARY = "LIBRARY";

  /**
   * Debugging: Assesses a developers ability in debugging existing code that has a series of known
   * issues that must be fixed for it to function correctly.
   */
  public static final String TYPE_DEBUGGING = "DEBUGGING";

  @ApiModelProperty("The unique identifier for this task")
  private String taskId;

  @ApiModelProperty("The primary skill tested by this task")
  private String type;

  @ApiModelProperty("User readable name for the test")
  private String name;

  @ApiModelProperty("The set of types of result that will come back from testing this task")
  private Set<String> criteria;

  @ApiModelProperty("Test difficulty (values to be determined)")
  private String difficulty;

  @ApiModelProperty("The recommended time in minutes to allocate to this task")
  private int recommendedTimeMinutes;

  @ApiModelProperty(
      "The problem statement as an HTML fragment. Use /n to delimit new line characters if needed")
  private String problemStatement;

  @ApiModelProperty(
      "The number of parameterisations available for this task, or zero if this task is not"
          + "parameterised.")
  private int parameterisationCount;

  @ApiModelProperty("List of questions to ask the candidate about the task")
  private List<String> questions;

  @ApiModelProperty("Variants supported by this task")
  private Set<String> variants;

  @ApiModelProperty("Actions that can be requested for this task")
  private Set<String> actions;

  @ApiModelProperty("Freeform set of properties to pass to frontend")
  private Map<String, String> properties;

  @JsonCreator
  public TaskInfo(
      @JsonProperty("taskId") String taskId,
      @JsonProperty("type") String type,
      @JsonProperty("name") String name,
      @JsonProperty("criteria") Set<String> criteria,
      @JsonProperty("difficulty") String difficulty,
      @JsonProperty("recommendedTimeMinutes") int recommendedTimeMinutes,
      @JsonProperty("problemStatement") String problemStatement,
      @JsonProperty("parameterisationCount") int parameterisationCount,
      @JsonProperty("questions") List<String> questions,
      @JsonProperty("variants") Set<String> variants,
      @JsonProperty("actions") Set<String> actions,
      @JsonProperty("properties") Map<String, String> properties) {
    this.taskId = taskId;
    this.type = type;
    this.name = name;
    this.criteria = criteria;
    this.difficulty = difficulty;
    this.recommendedTimeMinutes = recommendedTimeMinutes;
    this.problemStatement = problemStatement;
    this.parameterisationCount = parameterisationCount;
    this.questions = questions;
    this.variants = variants;
    this.actions = actions;
    this.properties = properties;
  }

  public String getTaskId() {
    return taskId;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public Set<String> getCriteria() {
    return criteria;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public int getRecommendedTimeMinutes() {
    return recommendedTimeMinutes;
  }

  public String getProblemStatement() {
    return problemStatement;
  }

  public int getParameterisationCount() {
    return parameterisationCount;
  }

  public List<String> getQuestions() {
    return questions;
  }

  public Set<String> getVariants() {
    return variants;
  }

  public Set<String> getActions() {
    return actions;
  }

  public Map<String, String> getProperties() {
    return properties;
  }
}
