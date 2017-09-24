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

  RepoData(String taskId, boolean usingTestingVersion, Integer validityMinutes) {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.MINUTE, validityMinutes);
    this.repoInfo =
        new RepoInfo(
            String.format("Mock%03d", repoIdCounter.incrementAndGet()),
            taskId,
            usingTestingVersion,
            cal.getTime());
  }

  String addTag() {
    String tag = String.format("Tag%03d", tagCounter.incrementAndGet());
    tags.add(tag);
    return tag;
  }
}
