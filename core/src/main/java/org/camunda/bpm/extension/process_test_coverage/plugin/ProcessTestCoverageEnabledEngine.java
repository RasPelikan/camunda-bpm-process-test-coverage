package org.camunda.bpm.extension.process_test_coverage.plugin;

import org.camunda.bpm.engine.ProcessEngine;

/**
 * @author Martin Schimak <martin.schimak@plexiti.com>
 */
public class ProcessTestCoverageEnabledEngine {

  static ProcessEngine processEngine;

  public static ProcessEngine getProcessEngine() {
    return processEngine;
  }

}
