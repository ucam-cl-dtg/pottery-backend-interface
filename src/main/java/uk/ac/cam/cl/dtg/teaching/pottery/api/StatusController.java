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
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Produces("application/json")
@Path("/status")
@Api(value = "/status", description = "Server status", position = 0)
public interface StatusController {
  @GET
  @Path("/")
  @ApiOperation(
      value = "Get server status",
      response = String.class,
      responseContainer = "Map",
      position = 0)
  Map<String, String> getStatus();

  @GET
  @Path("/dockerVersion")
  @Produces("text/plain")
  @ApiOperation(
      value = "Query the docker api for the version number",
      response = String.class,
      position = 1)
  String checkDockerVersion();

  @GET
  @Path("/publicKey")
  @Produces("text/plain")
  @ApiOperation(
      value =
          "Return the public key (OpenSSL format) that the server will use when connecting to "
              + "remote Git repositories",
      response = String.class,
      position = 2)
  String publicKey();
}
