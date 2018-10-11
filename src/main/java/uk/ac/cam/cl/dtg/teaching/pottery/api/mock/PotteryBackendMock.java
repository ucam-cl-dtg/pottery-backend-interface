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

import uk.ac.cam.cl.dtg.teaching.pottery.api.PotteryBackend;
import uk.ac.cam.cl.dtg.teaching.pottery.api.RepoController;
import uk.ac.cam.cl.dtg.teaching.pottery.api.StatusController;
import uk.ac.cam.cl.dtg.teaching.pottery.api.SubmissionsController;
import uk.ac.cam.cl.dtg.teaching.pottery.api.TasksController;
import uk.ac.cam.cl.dtg.teaching.pottery.api.WorkerController;

public class PotteryBackendMock implements PotteryBackend {

  private final MockSubmissionsController submissionsController = new MockSubmissionsController();
  private final MockRepoController repoController = new MockRepoController();
  private final MockStatusController statusController = new MockStatusController();

  @Override
  public RepoController getRepoController() {
    return repoController;
  }

  @Override
  public StatusController getStatusController() {
    return statusController;
  }

  @Override
  public SubmissionsController getSubmissionsController() {
    return submissionsController;
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
