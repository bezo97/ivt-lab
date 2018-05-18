package hu.bme.mit.spaceship;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GT4500Test {

  private GT4500 ship;//mock
TorpedoStore t1;
TorpedoStore t2;

  @Before
  public void init(){
	   t1 = mock(TorpedoStore.class);
	   t2 = mock(TorpedoStore.class);
     ship=new GT4500();
	   ship=new GT4500(t1, t2);
  }

  @Test
  public void fireLaser(){
    boolean result = ship.fireLaser(FiringMode.ALL);
    assertEquals(false,result);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
	   when(t1.fire(1)).thenReturn(true);
	   when(t2.fire(1)).thenReturn(true);

    // Act
    ship.fireTorpedo(FiringMode.SINGLE);
    ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    //assertEquals(true, result);
    verify(t1, times(1)).fire(1);
    verify(t2, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
	when(t1.fire(1)).thenReturn(true);
	when(t2.fire(1)).thenReturn(true);

    // Act
    /*boolean result = */ship.fireTorpedo(FiringMode.ALL);

    // Assert
    //assertEquals(true, result);
    verify(t1, times(1)).fire(1);
    verify(t2, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_11(){
    // Arrange
     when(t1.fire(1)).thenReturn(false);
     when(t2.fire(1)).thenReturn(false);

    // Act
    for(int i=0;i<11;i++)
      ship.fireTorpedo(FiringMode.ALL);

    // Assert
    //assertEquals(true, result);
    verify(t1, times(11)).fire(1);
    verify(t1, times(11)).fire(1);
    //verify(t2, times(1)).fire(1);
  }



}
