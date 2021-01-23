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
