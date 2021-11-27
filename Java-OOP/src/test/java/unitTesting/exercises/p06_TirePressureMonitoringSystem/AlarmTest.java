package unitTesting.exercises.p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {
    private Sensor fakeSensor;

    @Before
    public void setUp() {
        fakeSensor = Mockito.mock(Sensor.class);
    }

    @Test
    public void testAlarmOnForLowTirePressure() {
        Mockito.when(fakeSensor.popNextPressurePsiValue())
                .thenReturn(16.0);
        Alarm alarm = new Alarm(fakeSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmOnForHighTirePressure() {
        Mockito.when(fakeSensor.popNextPressurePsiValue())
                .thenReturn(22.0);
        Alarm alarm = new Alarm(fakeSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmOffForNormalTirePressure() {
        Mockito.when(fakeSensor.popNextPressurePsiValue())
                .thenReturn(18.0);
        Alarm alarm = new Alarm(fakeSensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}