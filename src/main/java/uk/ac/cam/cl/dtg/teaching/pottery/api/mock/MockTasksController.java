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

package uk.ac.cam.cl.dtg.teaching.pottery.api.mock;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import uk.ac.cam.cl.dtg.teaching.pottery.api.TasksController;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RetiredTaskException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.TaskMissingVariantException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.TaskNotFoundException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.TaskStorageException;
import uk.ac.cam.cl.dtg.teaching.pottery.model.BuilderInfo;
import uk.ac.cam.cl.dtg.teaching.pottery.model.TaskInfo;
import uk.ac.cam.cl.dtg.teaching.pottery.model.TaskLocation;
import uk.ac.cam.cl.dtg.teaching.pottery.model.TaskStatus;

public class MockTasksController implements TasksController {
  @Override
  public Collection<TaskInfo> listRegistered() {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public Collection<String> listAll() {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public Collection<String> listRetired() {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public Collection<TaskInfo> listTesting() {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public TaskLocation create(UriInfo uriInfo) throws TaskStorageException {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public TaskLocation createRemote(String remote) throws TaskStorageException {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public TaskInfo getTask(String taskId) throws TaskNotFoundException {
    return new TaskInfo(
        taskId,
        "Mock Task",
        "Mock Task " + taskId,
        ImmutableSet.of(),
        "Hard",
        0,
        "Test problem statement " + taskId,
        0,
        ImmutableList.of(),
        ImmutableSet.of("java"),
        ImmutableSet.of("firstAction"),
        ImmutableMap.of());
  }

  @Override
  public TaskStatus getStatus(String taskId) throws TaskNotFoundException, TaskStorageException {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public Response retireTask(String taskId)
      throws TaskNotFoundException, TaskStorageException, RetiredTaskException {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public Response unretireTask(String taskId)
      throws TaskNotFoundException, TaskStorageException, RetiredTaskException {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public BuilderInfo scheduleTaskRegistration(String taskId, String sha1)
      throws TaskNotFoundException, RetiredTaskException {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public BuilderInfo pollTaskRegistrationStatus(String taskId) throws TaskNotFoundException {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public BuilderInfo scheduleTaskTesting(String taskId)
      throws TaskNotFoundException, RetiredTaskException {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public BuilderInfo pollTaskTestingStatus(String taskId) throws TaskNotFoundException {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public List<String> listSkeletonFiles(String taskId, String variant, Boolean usingTestingVersion)
      throws TaskNotFoundException, TaskMissingVariantException, TaskStorageException {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public Response readSkeletonFile(
      String taskId,
      String variant,
      String fileName,
      String altFileName,
      Boolean usingTestingVersion)
      throws TaskNotFoundException, TaskMissingVariantException {
    throw new IllegalArgumentException("Unimplemented");
  }

  @Override
  public Map<String, String> listTypes() {
    throw new IllegalArgumentException("Unimplemented");
  }
}
