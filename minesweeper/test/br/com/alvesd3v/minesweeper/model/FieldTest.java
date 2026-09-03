package br.com.alvesd3v.minesweeper.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alvesd3v.minesweeper.exception.ExplosionException;

public class FieldTest {
	
	private Field field = new Field (3,3);
	
	@BeforeEach
	void startField() {
		field = new Field(3,3);
	}
	
	@Test
	void neighborDistancePerpendicularLeftTest() {
		Field neighbor = new Field(3,2);
		boolean result = field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void neighborDistancePerpendicularRightTest() {
		Field neighbor = new Field(3,4);
		boolean result = field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void neighborDistancePerpendicularOnTopTest() {
		Field neighbor = new Field(2,3);
		boolean result = field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void neighborDistancePerpendicularDownTest() {
		Field neighbor = new Field(4,3);
		boolean result = field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void neighborDistanceDiagonalLeftOnTopTest() {
		Field neighbor = new Field(2,2);
		boolean result = field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void neighborDistanceDiagonalRightOnTopTest() {
		Field neighbor = new Field(2,4);
		boolean result = field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void neighborDistanceDiagonalLeftDownTest() {
		Field neighbor = new Field(4,2);
		boolean result = field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void neighborDistanceDiagonalRightDownTest() {
		Field neighbor = new Field(4,4);
		boolean result = field.addNeighbors(neighbor);
		assertTrue(result);
	}
	
	@Test
	void noNeighborTest() {
		Field neighbor = new Field(1,1);
		boolean result = field.addNeighbors(neighbor);
		assertFalse(result);
	}
	
	@Test
	void assignedDefaultValueMarkedTest (){
		assertFalse(field.isMarked());
	}
	
	@Test
	void toggleSelectionTest() {
		field.toggleSelection();
		assertTrue(field.isMarked());
	}
	
	@Test
	void toggleSelection2CallsTest() {
		field.toggleSelection();
		field.toggleSelection();
		assertFalse(field.isMarked());
	}

	@Test
	void openNoUnderminedNoMarkedTest() {
		assertTrue(field.toOpen());
	}
	
	@Test
	void openNoUnderminedMarkedTest() {
		field.toggleSelection();
		assertFalse(field.toOpen());
	}
	
	@Test
	void openUnderminedMarkedTest() {
		field.toggleSelection();
		field.mine();
		assertFalse(field.toOpen());
	}
	
	@Test
	void openUnderminedNoMarkedTest() {
		field.mine();
		
		assertThrows(ExplosionException.class, () -> {
			field.toOpen();
		});
	}
	
	@Test
	void toOpenWithNeighbors1() {
		
		Field field11 = new Field(1,1);
		
		Field field22 = new Field(2,2);
		field22.addNeighbors(field11);
		
		field.addNeighbors(field22);
		field.toOpen();
		
		assertTrue(field22.isOpen() && field11.isOpen());
	}
	
	@Test
	void toOpenWithNeighbors2() {
		
		Field field11 = new Field(1,1);
		Field field12 = new Field(1,1);
		field12.mine();
		
		Field field22 = new Field(2,2);
		field22.addNeighbors(field11);
		field22.addNeighbors(field12);
		
		field.addNeighbors(field22);
		field.toOpen();
		
		assertTrue(field22.isOpen() && field11.isClosed());
	}
}