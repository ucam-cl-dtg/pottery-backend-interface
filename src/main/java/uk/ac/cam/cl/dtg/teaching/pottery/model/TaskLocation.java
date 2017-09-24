package uk.ac.cam.cl.dtg.teaching.pottery.model;

public class TaskLocation {

  private String taskId;

  private String remote;

  public TaskLocation() {}

  public TaskLocation(String taskId, String remote) {
    this.taskId = taskId;
    this.remote = remote;
  }

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getRemote() {
    return remote;
  }

  public void setRemote(String remote) {
    this.remote = remote;
  }
}
