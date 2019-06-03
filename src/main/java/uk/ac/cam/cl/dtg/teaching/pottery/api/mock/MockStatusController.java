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

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import uk.ac.cam.cl.dtg.teaching.pottery.api.StatusController;

public class MockStatusController implements StatusController {

  @Override
  public Map<String, String> getStatus() {
    return ImmutableMap.of(
        "Worker.numThreads", String.valueOf(1),
        "Worker.queueSize", String.valueOf(10),
        "Worker.smoothedWaitTime", String.valueOf(13),
        "ContainerManager.smoothedCallTime", String.valueOf(15),
        "ContainerManager.apiStatus", "OK");
  }

  @Override
  public String checkDockerVersion() {
    return "TEST-VERSION";
  }

  @Override
  public String publicKey() {
    throw new RuntimeException("Unimplemented");
  }
}
