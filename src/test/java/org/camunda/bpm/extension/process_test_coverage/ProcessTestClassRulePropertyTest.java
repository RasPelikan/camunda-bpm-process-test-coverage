package org.camunda.bpm.extension.process_test_coverage;

import static org.camunda.bpm.extension.process_test_coverage.ProcessTestCoverageProcessConstants.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.ProcessDeploymentRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test case starting an in-memory database-backed Process Engine.<br>
 * In your tests don't set the property using <code>System.setProperty</code>
 * - use your runtime environment to do that.  
 */
public class ProcessTestClassRulePropertyTest {
    
    static final double EXPECTED = PATH_B_ELEMENTS.length;
    static final double ALL = ALL_ELEMENTS.length;
    static final double EXPECTED_COVERAGE = EXPECTED / ALL;   

    @BeforeClass
    public static void setSysProperty() {
        System.setProperty(TestCoverageProcessEngineRuleBuilder.DEFAULT_ASSERT_AT_LEAST_PROPERTY,
                "" + EXPECTED_COVERAGE);
    }

    @AfterClass
    public static void delSysProperty() {
        System.clearProperty(TestCoverageProcessEngineRuleBuilder.DEFAULT_ASSERT_AT_LEAST_PROPERTY);
    }
    
    @ClassRule
    public static TestCoverageProcessEngineRule classRule = TestCoverageProcessEngineRuleBuilder.createClassRule()
        .assertCoverage(lessThan(EXPECTED_COVERAGE + 0.0001))
        .build();

    @Rule // Method rule does the deployment ATM
    public ProcessDeploymentRule deployRule = TestCoverageProcessEngineRuleBuilder.buildDeployRule();

    @Test
    @Deployment(resources = BPMN_PATH)
    public void testPathB() {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("path", "B");
        classRule.getRuntimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);
    }


}