package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

  @Test
  void fire_Success(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    // Act
    boolean result = store.fire(1);

    // Assert
    assertEquals(true, result);
  }
  @Test
  void fire_DecrementRemaining(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    // Act
    store.fire(1);

    // Assert
    assertEquals(0, store.getTorpedoCount());
  }
  @Test
  void fire_Fails(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1,100);

    // Act
    boolean result = store.fire(1);

    // Assert
    assertEquals(false, result);
  }
  @Test
  void fire_TooMuchFired(){
    // Arrange
    TorpedoStore store = new TorpedoStore(2);
    boolean didThrow = false;
    // Act
    try{
      store.fire(3);
    }catch(Exception e){
      didThrow = true;
    }

    // Assert
    if (!didThrow)
      fail();
  }
}
