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
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Date;

public class RepoInfo {

  public static final String REMOTE_UNSET = "";

  private String repoId;
  private String taskId;
  private boolean usingTestingVersion;
  private Date expiryDate;

  private String variant;

  /** If this value is set then indicates that this repo is hosted remotely. */
  private String remote;

  private int mutation;
  private JsonNode parameters;

  @JsonCreator
  public RepoInfo(
      @JsonProperty("repoId") String repoId,
      @JsonProperty("taskId") String taskId,
      @JsonProperty("usingTestingVersion") boolean usingTestingVersion,
      @JsonProperty("expiryDate") Date expiryDate,
      @JsonProperty("variant") String variant,
      @JsonProperty("remote") String remote,
      @JsonProperty("mutation") int mutation,
      @JsonProperty("parameters") JsonNode parameters
      ) {
    super();
    this.repoId = repoId;
    this.taskId = taskId;
    this.usingTestingVersion = usingTestingVersion;
    this.expiryDate = expiryDate;
    this.variant = variant;
    this.remote = remote;
    this.mutation = mutation;
    this.parameters = parameters;
  }

  public Date getExpiryDate() {
    return expiryDate;
  }

  public String getRepoId() {
    return repoId;
  }

  public String getTaskId() {
    return taskId;
  }

  public boolean isUsingTestingVersion() {
    return usingTestingVersion;
  }

  public String getVariant() {
    return variant;
  }

  public String getRemote() {
    return remote;
  }

  public boolean isRemote() {
    return !remote.equals(REMOTE_UNSET);
  }

  public int getMutation() {
    return mutation;
  }

  public JsonNode getParameters() {
    return parameters;
  }
}
