/*
 * pottery-backend - Backend API for testing programming exercises
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

package uk.ac.cam.cl.dtg.teaching.pottery.api.mock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import uk.ac.cam.cl.dtg.teaching.pottery.api.RepoController;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoExpiredException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoFileNotFoundException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoNotFoundException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoStorageException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RepoTagNotFoundException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.RetiredTaskException;
import uk.ac.cam.cl.dtg.teaching.pottery.exceptions.TaskNotFoundException;
import uk.ac.cam.cl.dtg.teaching.pottery.model.FileData;
import uk.ac.cam.cl.dtg.teaching.pottery.model.RepoInfo;
import uk.ac.cam.cl.dtg.teaching.pottery.model.RepoTag;

public class MockRepoController implements RepoController {

  private Map<String, RepoData> mockRepos = new HashMap<>();

  @Override
  public RepoInfo makeRepo(String taskId, Boolean usingTestingVersion, Integer validityMinutes)
      throws TaskNotFoundException, RepoExpiredException, RepoStorageException,
          RetiredTaskException, RepoNotFoundException {
    RepoData repoData = new RepoData(taskId, usingTestingVersion, validityMinutes);
    mockRepos.put(repoData.repoInfo.getRepoId(), repoData);
    return repoData.repoInfo;
  }

  @Override
  public List<String> listTags(String repoId) throws RepoStorageException, RepoNotFoundException {
    return mockRepos.get(repoId).tags;
  }

  @Override
  public List<String> listFiles(String repoId, String tag)
      throws RepoStorageException, RepoNotFoundException, RepoTagNotFoundException {
    return mockRepos.get(repoId).files;
  }

  @Override
  public Response readFile(String repoId, String tag, String fileName)
      throws RepoStorageException, RepoFileNotFoundException, RepoNotFoundException,
          RepoTagNotFoundException {
    throw new Error("readFile is unimplemented");
  }

  @Override
  public Response updateFile(String repoId, String tag, String fileName, FileData file)
      throws RepoStorageException, RepoExpiredException, RepoFileNotFoundException,
          RepoNotFoundException {
    throw new Error("updateFile is unimplemented");
  }

  @Override
  public Response deleteFile(String repoId, String tag, String fileName)
      throws RepoStorageException, RepoExpiredException, RepoFileNotFoundException,
          RepoNotFoundException {
    throw new Error("deleteFile is unimplemented");
  }

  @Override
  public Response reset(String repoId, String tag)
      throws RepoStorageException, RepoExpiredException, RepoTagNotFoundException,
          RepoNotFoundException {
    throw new Error("reset is unimplemented");
  }

  @Override
  public RepoTag tag(String repoId)
      throws RepoStorageException, RepoExpiredException, RepoNotFoundException {
    String tag = mockRepos.get(repoId).addTag();
    return new RepoTag(tag);
  }
}
