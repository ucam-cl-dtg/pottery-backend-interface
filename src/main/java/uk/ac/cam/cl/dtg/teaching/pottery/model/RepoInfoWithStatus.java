package uk.ac.cam.cl.dtg.teaching.pottery.model;

import java.util.Calendar;
import java.util.Date;

public class RepoInfoWithStatus {

  private RepoInfo repoInfo;
  private RepoStatus status;

  public RepoInfoWithStatus(
      RepoInfo repoInfo,
      boolean ready) {
    this.repoInfo = repoInfo;
    this.status = ready ?
        (Calendar.getInstance().getTime().before(repoInfo.getExpiryDate()) ?
            RepoStatus.READY : RepoStatus.EXPIRED)
        : RepoStatus.CREATING;
  }

  public Date getExpiryDate() {
    return repoInfo.getExpiryDate();
  }

  public String getRepoId() {
    return repoInfo.getRepoId();
  }

  public String getTaskId() {
    return repoInfo.getTaskId();
  }

  public boolean isUsingTestingVersion() {
    return repoInfo.isUsingTestingVersion();
  }

  public RepoStatus getStatus() {
    return status;
  }

  public String getVariant() {
    return repoInfo.getVariant();
  }

  public String getRemote() {
    return repoInfo.getRemote();
  }
}
