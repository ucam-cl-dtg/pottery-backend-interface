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

package uk.ac.cam.cl.dtg.teaching.pottery.api;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoExpiredException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoNotFoundException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoStorageException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.SubmissionAlreadyScheduledException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.SubmissionNotFoundException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.SubmissionStorageException;
import uk.ac.cam.cl.dtg.teaching.pottery.model.Submission;

@Produces("application/json")
@Path("/submissions")
@Api(value = "/submissions", description = "Manages requests for testing", position = 2)
public interface SubmissionsController {
  @POST
  @Path("/{repoId}/{tag}/{action}")
  @ApiOperation(
    value = "Schedules an action by creating a submission",
    notes = "An action is run for a tag in the code repository used by the candidate.",
    position = 0
  )
  Submission scheduleTest(@PathParam("repoId") String repoId, @PathParam("tag") String tag,
                          @PathParam("action") String action)
      throws RepoStorageException, RepoExpiredException, SubmissionStorageException,
          RepoNotFoundException;

  @GET
  @Path("/{repoId}/{tag}/{action}")
  @ApiOperation(
    value = "Poll the action information",
    notes = "Use this call to poll for the results of an action.",
    position = 1
  )
  Submission getSubmission(@PathParam("repoId") String repoId, @PathParam("tag") String tag,
                           @PathParam("action") String action)
      throws SubmissionNotFoundException, RepoStorageException, SubmissionStorageException,
          RepoNotFoundException;

  @GET
  @Path("/{repoId}/{tag}/{action}/output/{step}")
  @ApiOperation(
      value = "Poll the output from a particular action step",
      position = 2
  )
  @Produces("text/plain")
  String getOutput(@PathParam("repoId") String repoId, @PathParam("tag") String tag,
                   @PathParam("action") String action, @PathParam("step") String step)
      throws SubmissionNotFoundException, RepoStorageException, SubmissionStorageException,
      RepoNotFoundException;
}
