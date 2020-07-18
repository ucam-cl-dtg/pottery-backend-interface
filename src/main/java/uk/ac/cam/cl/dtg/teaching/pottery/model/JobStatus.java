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
import java.util.concurrent.atomic.AtomicLong;

public class JobStatus implements Comparable<JobStatus> {

  public static final String STATUS_WAITING = "WAITING";
  public static final String STATUS_RUNNING = "RUNNING";
  private static AtomicLong counter = new AtomicLong(0);
  private String description;
  private String workerName;
  private volatile String status;
  private long jobId;

  public JobStatus(String description, String workerName) {
    this.description = description;
    this.workerName = workerName;
    this.status = STATUS_WAITING;
    this.jobId = counter.getAndIncrement();
  }

  @JsonCreator
  public JobStatus(
      @JsonProperty("description") String description,
      @JsonProperty("workerName") String workerName,
      @JsonProperty("status") String status,
      @JsonProperty("jobId") long jobId) {
    this.description = description;
    this.workerName = workerName;
    this.status = status;
    this.jobId = jobId;
  }

  public static AtomicLong getCounter() {
    return counter;
  }

  public String getDescription() {
    return description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public long getJobId() {
    return jobId;
  }

  public String getWorkerName() {
    return workerName;
  }

  @Override
  public int compareTo(JobStatus o) {
    return Long.compare(jobId, o.jobId);
  }
}
