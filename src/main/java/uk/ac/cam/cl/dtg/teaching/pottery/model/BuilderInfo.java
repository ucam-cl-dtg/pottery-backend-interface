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

import java.util.concurrent.ConcurrentLinkedDeque;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Joiner;
import uk.ac.cam.cl.dtg.teaching.exceptions.SerializableException;

/**
 * DTO for tracking information about the progress of creating a TaskCopy.
 *
 * @author acr31
 */
public class BuilderInfo {

  public static final String STATUS_NOT_STARTED = "NOT_STARTED";
  public static final String STATUS_SCHEDULED = "SCHEDULED";
  public static final String STATUS_COPYING_FILES = "COPYING_FILES";

  /** The compile section of task.json is executing.
   *
   * Typically, this would compile the tests and do any other preparation work required to test
   * the built-in solutions or user-submitted code.
   */
  public static final String STATUS_COMPILING_TESTS = "COMPILING_TESTS";

  /** The solutions in task.json are being tested.
   *
   * Typically, this would compile and run the solutions, checking each one succeeds or fails as
   * expected.
   */
  public static final String STATUS_TESTING_SOLUTIONS = "TESTING_SOLUTIONS";
  public static final String STATUS_SUCCESS = "SUCCESS";
  public static final String STATUS_FAILURE = "FAILURE";

  /** The SHA1 from the parent repo that we are copying. */
  private final String sha1;

  /** The status of the copy. This is updated and read from multiple threads so its volatile. */
  private volatile String status;

  /**
   * Will contain an exception object if a problem occurred during building. This is updated and
   * read from multiple threads so its volatile.
   */
  private volatile SerializableException exception;

  private ConcurrentLinkedDeque<String> testCompileResponse = new ConcurrentLinkedDeque<>();

  private ConcurrentLinkedDeque<String> solutionTestingResponse = new ConcurrentLinkedDeque<>();

  public BuilderInfo(String sha1) {
    super();
    this.sha1 = sha1;
    this.status = BuilderInfo.STATUS_NOT_STARTED;
    this.exception = null;
  }

  @JsonCreator
  public BuilderInfo(
      @JsonProperty("sha1") String sha1,
      @JsonProperty("status") String status,
      @JsonProperty("exception") SerializableException exception,
      @JsonProperty("testCompileResponse") String testCompileResponse,
      @JsonProperty("solutionCompileResponse") String solutionTestingResponse) {
    this.sha1 = sha1;
    this.status = status;
    this.exception = exception;
    this.testCompileResponse.add(testCompileResponse);
    this.solutionTestingResponse.add(solutionTestingResponse);
  }

  public static int statusToInt(String status) {
    if (STATUS_NOT_STARTED.equals(status)) {
      return 0;
    }
    if (STATUS_SCHEDULED.equals(status)) {
      return 1;
    }
    if (STATUS_COPYING_FILES.equals(status)) {
      return 2;
    }
    if (STATUS_COMPILING_TESTS.equals(status)) {
      return 3;
    }
    if (STATUS_TESTING_SOLUTIONS.equals(status)) {
      return 4;
    }
    if (STATUS_SUCCESS.equals(status)) {
      return 5;
    }
    if (STATUS_FAILURE.equals(status)) {
      return 5;
    }
    return -1;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public SerializableException getException() {
    return exception;
  }

  public void setException(Exception exception) {
    this.exception = new SerializableException(exception);
    this.status = BuilderInfo.STATUS_FAILURE;
  }

  public String getSha1() {
    return sha1;
  }

  public String getTestCompileResponse() {
    return Joiner.on("\r\n").join(testCompileResponse);
  }

  public void addTestCompileResponse(String response) {
    this.testCompileResponse.add(response);
  }

  public String getSolutionTestingResponse() {
    return Joiner.on("\r\n").join(solutionTestingResponse);
  }

  public void addSolutionTestingResponse(String response) {
    this.solutionTestingResponse.add(response);
  }

  @Override
  public String toString() {
    return "BuilderInfo{"
        + "sha1='"
        + sha1
        + '\''
        + ", status='"
        + status
        + '\''
        + ", exception="
        + exception
        + ", testCompileResponse='"
        + getTestCompileResponse()
        + '\''
        + ", solutionTestingResponse='"
        + getSolutionTestingResponse()
        + '\''
        + '}';
  }

}
