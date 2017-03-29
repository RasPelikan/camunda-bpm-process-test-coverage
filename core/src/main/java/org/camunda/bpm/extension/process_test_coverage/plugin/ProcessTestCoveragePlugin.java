package org.camunda.bpm.extension.process_test_coverage.plugin;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.ProcessCoverageConfigurator;

/**
 * @author Martin Schimak <martin.schimak@plexiti.com>
 */
public class ProcessTestCoveragePlugin implements ProcessEnginePlugin {

  @Override
  public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
    ProcessCoverageConfigurator.initializeProcessCoverageExtensions(processEngineConfiguration);
  }

  @Override
  public void postInit(ProcessEngineConfigurationImpl processEngineConfiguration) {

  }

  @Override
  public void postProcessEngineBuild(ProcessEngine processEngine) {

  }

}
