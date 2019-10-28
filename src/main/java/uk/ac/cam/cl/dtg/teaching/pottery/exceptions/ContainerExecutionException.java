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

package uk.ac.cam.cl.dtg.teaching.pottery.exceptions;

public class ContainerExecutionException extends Exception {

  private static final long serialVersionUID = 1L;

  private final String containerName;

  public ContainerExecutionException(String message, String containerName) {
    super(message);
    this.containerName = containerName;
  }

  public ContainerExecutionException(String message, String containerName, Throwable cause) {
    super(message, cause);
    this.containerName = containerName;
  }

  public String getContainerName() {
    return containerName;
  }
}
