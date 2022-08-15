package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
@Test
    public void testSettingJobId (){
    Job job1 = new Job();
    Job job2 = new Job();
    assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
    Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob1.equals(testJob2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
    Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    char firstCharacter = testJob.toString().charAt(0);
    char lastCharacter = testJob.toString().charAt(testJob.toString().length()-1);
    assertEquals('\n', firstCharacter);
    assertEquals('\n', lastCharacter);
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
    Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertEquals("\nID: "+testJob.getId()+"\nName: "+testJob.getName()+
            "\nEmployer: "+testJob.getEmployer()+"\nLocation: "+testJob.getLocation()+"\nPosition Type: "+testJob.getPositionType()+
            "\nCore Competency: "+testJob.getCoreCompetency()+"\n", testJob.toString());
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: "+testJob.getId()+"\nName: "+testJob.getName()+
                "\nEmployer: Data not available"+"\nLocation: "+testJob.getLocation()+"\nPosition Type: "+testJob.getPositionType()+
                "\nCore Competency: "+testJob.getCoreCompetency()+"\n", testJob.toString());
    }
}
