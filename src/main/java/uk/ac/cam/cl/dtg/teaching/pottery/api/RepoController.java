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
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoExpiredException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoFileNotFoundException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoNotFoundException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoStorageException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoTagNotFoundException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RetiredTaskException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.TaskMissingVariantException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.TaskNotFoundException;
import uk.ac.cam.cl.dtg.teaching.pottery.model.FileData;
import uk.ac.cam.cl.dtg.teaching.pottery.model.RepoInfoWithStatus;
import uk.ac.cam.cl.dtg.teaching.pottery.model.RepoTag;

@Produces("application/json")
@Path("/repo")
@Api(value = "/repo", description = "Manages the candidates attempt at the task", position = 1)
public interface RepoController {
  @POST
  @Path("/")
  @ApiOperation(
      value = "Start a new repository",
      notes = "Starts a new repository for solving the specified task",
      position = 0)
  RepoInfoWithStatus makeRepo(
      @FormParam("taskId") String taskId,
      @FormParam("usingTestingVersion") Boolean usingTestingVersion,
      @FormParam("validityMinutes") Integer validityMinutes,
      @FormParam("variant") String variant,
      @FormParam("seed") Integer seed)
      throws TaskNotFoundException, RepoExpiredException, RepoStorageException,
          RetiredTaskException, RepoNotFoundException, TaskMissingVariantException;

  @POST
  @Path("/remote")
  @ApiOperation(
      value = "Start a new remote repository",
      notes = "Starts a new repository for solving the specified task that is hosted remotely",
      position = 1)
  RepoInfoWithStatus makeRemoteRepo(
      @FormParam("taskId") String taskId,
      @FormParam("usingTestingVersion") Boolean usingTestingVersion,
      @FormParam("validityMinutes") Integer validityMinutes,
      @FormParam("variant") String variant,
      @FormParam("remote") String remote,
      @FormParam("seed") Integer seed)
      throws TaskNotFoundException, RepoExpiredException, RepoStorageException,
          RetiredTaskException, RepoNotFoundException, TaskMissingVariantException;

  @GET
  @Path("/{repoId}/status")
  @ApiOperation(
      value = "Get the status of a repository")
  RepoInfoWithStatus getStatus(@PathParam("repoId") String repoId)
      throws RepoStorageException, RepoNotFoundException;

  @GET
  @Path("/{repoId}")
  @ApiOperation(
      value = "List all the tags in repository",
      response = String.class,
      responseContainer = "List")
  List<String> listTags(@PathParam("repoId") String repoId)
      throws RepoStorageException, RepoNotFoundException;

  @GET
  @Path("/{repoId}/{tag}")
  @ApiOperation(
      value = "List all the files in the repository",
      response = String.class,
      responseContainer = "List",
      position = 1)
  List<String> listFiles(@PathParam("repoId") String repoId, @PathParam("tag") String tag)
      throws RepoStorageException, RepoNotFoundException, RepoTagNotFoundException;

  @GET
  @Path("/{repoId}/{tag}/{fileName:.+}")
  @Produces("application/octet-stream")
  @ApiOperation(
      value = "Read a file from the repository",
      notes = "Returns the file contents directly",
      position = 2)
  Response readFile(
      @PathParam("repoId") String repoId,
      @PathParam("tag") String tag,
      @PathParam("fileName") String fileName)
      throws RepoStorageException, RepoFileNotFoundException, RepoNotFoundException,
          RepoTagNotFoundException;

  @POST
  @Consumes("multipart/form-data")
  @Path("/{repoId}/{tag}/{fileName:.+}")
  @ApiOperation(
      value = "Update (or create) a file in the repository",
      notes =
          "Any required directories will be created automatically. The new contents of the file "
              + "should be submitted as a multipart form request",
      position = 3)
  Response updateFile(
      @PathParam("repoId") String repoId,
      @PathParam("tag") String tag,
      @PathParam("fileName") String fileName,
      @MultipartForm FileData file)
      throws RepoStorageException, RepoExpiredException, RepoFileNotFoundException,
          RepoNotFoundException;

  @DELETE
  @Path("/{repoId}/{tag}/{fileName:.+}")
  @ApiOperation(value = "Delete a file from the repository", position = 4)
  Response deleteFile(
      @PathParam("repoId") String repoId,
      @PathParam("tag") String tag,
      @PathParam("fileName") String fileName)
      throws RepoStorageException, RepoExpiredException, RepoFileNotFoundException,
          RepoNotFoundException;

  @POST
  @Path("/{repoId}/reset/{tag}")
  @ApiOperation(
      value = "Set the contents of the repository to be what it was at this particular tag",
      position = 5)
  Response reset(@PathParam("repoId") String repoId, @PathParam("tag") String tag)
      throws RepoStorageException, RepoExpiredException, RepoTagNotFoundException,
          RepoNotFoundException;

  @POST
  @Path("/{repoId}")
  @ApiOperation(
      value = "Create a tag in the repository",
      notes = "Submissions (for testing) are created with reference to tags in the repository")
  RepoTag tag(@PathParam("repoId") String repoId)
      throws RepoStorageException, RepoExpiredException, RepoNotFoundException;
}
