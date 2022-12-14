package barracksWars.interfaces;

import barracksWars.models.units.AbstractUnit;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public interface UnitFactory {

    Unit createUnit(String unitType);

}