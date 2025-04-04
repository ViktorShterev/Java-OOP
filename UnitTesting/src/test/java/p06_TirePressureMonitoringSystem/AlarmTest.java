package UnitTesting.src.test.java.p06_TirePressureMonitoringSystem;

import UnitTesting.src.main.java.p06_TirePressureMonitoringSystem.Alarm;
import UnitTesting.src.main.java.p06_TirePressureMonitoringSystem.Sensor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    private static final double LOW_PRESSURE = 12.0;
    private static final double HIGH_PRESSURE = 25.0;
    private static final double NORMAL_PRESSURE = 18.0;

    @Test
    public void testIfAlarmIsOnWhenPressureIsLow() {
        Sensor fakeBelowSensor = Mockito.mock(Sensor.class);
        Mockito.when(fakeBelowSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE);
        Alarm alarm = new Alarm(fakeBelowSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testIfAlarmIsOnWhenPressureIsHigh() {
        Sensor fakeBelowSensor = Mockito.mock(Sensor.class);
        Mockito.when(fakeBelowSensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE);
        Alarm alarm = new Alarm(fakeBelowSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testIfAlarmIsOffWhenPressureIsNormal() {
        Sensor fakeBelowSensor = Mockito.mock(Sensor.class);
        Mockito.when(fakeBelowSensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE);
        Alarm alarm = new Alarm(fakeBelowSensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}