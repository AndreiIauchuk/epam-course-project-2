package test.by.epamtc.iovchuk.service;

import by.epamtc.iovchuk.characteristic.Color;
import by.epamtc.iovchuk.characteristic.Material;
import by.epamtc.iovchuk.entity.Basket;
import by.epamtc.iovchuk.exception.NullException;
import by.epamtc.iovchuk.exception.OverCapacityException;
import by.epamtc.iovchuk.service.BallsWeightCalculator;
import org.junit.Before;
import org.junit.Test;

import static by.epamtc.iovchuk.creator.BallCreatorUtil.*;
import static org.junit.Assert.assertEquals;

public class BallsWeightCalculatorTest {

    BallsWeightCalculator ballsWeightCalculator = new BallsWeightCalculator();
    Basket basket;

    @Before
    public void before() throws NullException, OverCapacityException {
        basket = new Basket(3);
        basket.putBall(createBall(1, Color.GREEN, (byte) 1));
        basket.putBall(createBall(2, Color.BLUE));
        basket.putBall(createBall(3, Color.BLUE, Material.SYNTHETIC, (byte) 3));
    }

    @Test
    public void testCalculate_whenBasketIsNull() {
        double expected = -1;
        double actual = ballsWeightCalculator.calculate(null);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCalculate() {
        double expected = 6;
        double actual = ballsWeightCalculator.calculate(basket);
        assertEquals(expected, actual, 0.01);
    }

} 
