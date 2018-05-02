/*
 * pottery-backend-interface - Backend API for testing programming exercises
 * Copyright © 2015-2018 Andrew Rice (acr31@cam.ac.uk), BlueOptima Limited
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

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import uk.ac.cam.cl.dtg.teaching.pottery.model.RepoInfo;

class RepoData {

  private static AtomicInteger repoIdCounter = new AtomicInteger(0);

  final RepoInfo repoInfo;
  final List<String> tags = new LinkedList<>();
  final List<String> files = new LinkedList<>();
  final AtomicInteger tagCounter = new AtomicInteger(0);

  RepoData(String taskId, boolean usingTestingVersion, Integer validityMinutes, String variant,
           String remote) {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.MINUTE, validityMinutes);
    this.repoInfo =
        new RepoInfo(
            String.format("Mock%03d", repoIdCounter.incrementAndGet()),
            taskId,
            usingTestingVersion,
            cal.getTime(),
            variant,
            remote);
  }

  String addTag() {
    String tag = String.format("Tag%03d", tagCounter.incrementAndGet());
    tags.add(tag);
    return tag;
  }
}
