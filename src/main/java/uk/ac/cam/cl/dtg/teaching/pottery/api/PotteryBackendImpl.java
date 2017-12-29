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

package uk.ac.cam.cl.dtg.teaching.pottery.api;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;

public class PotteryBackendImpl implements PotteryBackend {

  private ResteasyWebTarget webTarget;

  private RepoController repoController;
  private StatusController statusController;
  private SubmissionsController submissionsController;
  private TasksController tasksController;
  private WorkerController workerController;

  public PotteryBackendImpl(String url, int maxConnections) {
    PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
    cm.setDefaultMaxPerRoute(maxConnections);
    cm.setMaxTotal(maxConnections);
    HttpClient httpClient = new DefaultHttpClient(cm);
    ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);
    ResteasyClient c =
        new ResteasyClientBuilder().maxPooledPerRoute(maxConnections).httpEngine(engine).build();
    webTarget = c.target(url);
    repoController = webTarget.proxy(RepoController.class);
    statusController = webTarget.proxy(StatusController.class);
    submissionsController = webTarget.proxy(SubmissionsController.class);
    tasksController = webTarget.proxy(TasksController.class);
    workerController = webTarget.proxy(WorkerController.class);
  }

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
    return tasksController;
  }

  @Override
  public WorkerController getWorkerController() {
    return workerController;
  }
}
