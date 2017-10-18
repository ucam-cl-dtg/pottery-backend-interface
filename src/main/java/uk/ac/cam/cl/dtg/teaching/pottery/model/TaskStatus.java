/*
 * pottery-backend - Backend API for testing programming exercises
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

public class TaskStatus {

  private String headSha;

  private String testingStatus;

  private String testingSha;

  private String registeredStatus;

  private String registeredSha;

  @JsonCreator
  public TaskStatus(
      @JsonProperty("headSha") String headSha,
      @JsonProperty("testingStatus") String testingStatus,
      @JsonProperty("testingSha") String testingSha,
      @JsonProperty("registeredStatus") String registeredStatus,
      @JsonProperty("registeredSha") String registeredSha) {
    this.headSha = headSha;
    this.testingStatus = testingStatus;
    this.testingSha = testingSha;
    this.registeredStatus = registeredStatus;
    this.registeredSha = registeredSha;
  }

  public String getHeadSha() {
    return headSha;
  }

  public String getTestingSha() {
    return testingSha;
  }

  public String getRegisteredSha() {
    return registeredSha;
  }

  public String getTestingStatus() {
    return testingStatus;
  }

  public String getRegisteredStatus() {
    return registeredStatus;
  }
}
