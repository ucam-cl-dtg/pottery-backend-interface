package uk.ac.cam.cl.dtg.teaching.pottery.api.mock;

import uk.ac.cam.cl.dtg.teaching.pottery.api.PotteryBackend;
import uk.ac.cam.cl.dtg.teaching.pottery.api.RepoController;
import uk.ac.cam.cl.dtg.teaching.pottery.api.StatusController;
import uk.ac.cam.cl.dtg.teaching.pottery.api.SubmissionsController;
import uk.ac.cam.cl.dtg.teaching.pottery.api.TasksController;
import uk.ac.cam.cl.dtg.teaching.pottery.api.WorkerController;

public class PotteryBackendMock implements PotteryBackend {

  @Override
  public RepoController getRepoController() {
    return new MockRepoController();
  }

  @Override
  public StatusController getStatusController() {
    throw new Error("StatusController is unimplemented");
  }

  @Override
  public SubmissionsController getSubmissionsController() {
    throw new Error("SubmissionsController is unimplemented");
  }

  @Override
  public TasksController getTasksController() {
    throw new Error("TasksController is unimplemented");
  }

  @Override
  public WorkerController getWorkerController() {
    throw new Error("WorkedController is unimplemented");
  }
}
