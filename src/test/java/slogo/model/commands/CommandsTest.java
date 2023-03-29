package slogo.model.commands;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import slogo.model.Environment;
import slogo.model.Turtle;
import slogo.model.commands.allcommands.*;
import slogo.model.commands.allcommands.Home;

import static org.junit.jupiter.api.Assertions.*;


public class CommandsTest {

    private Commands home;
    private Commands clear;
    private Commands forward;
    private Commands back;
    private Commands PenUp;
    private Commands PenDown;
    private Commands Right;
    private Commands Left;
    private Commands SH90;
    private Commands SH180;

    @BeforeEach
    void setUp() {
        home = new Home();
        clear = new ClearScreen();
        forward = new Forward(List.of("20"));
        back = new Backward(List.of("20"));
        PenUp = new PenUp();
        PenDown = new PenDown();
        Right = new Right(List.of("90"));
        Left = new Left(List.of("90"));
        SH90 = new SetHeading(List.of("90"));
        SH180 = new SetHeading(List.of("180"));
    }

    @Test
    void testHome() {
        assertEquals(50, home.execute(new Turtle(30, 40)));
        assertFalse(50 != home.execute(new Turtle(30, 40)));
        assertEquals(50, clear.execute(new Turtle(30, 40)));
        assertFalse(50 != clear.execute(new Turtle(30, 40)));
    }

    @Test
    void testMovement() {
        assertEquals(20, forward.execute(new Turtle()));
        assertFalse(20 != forward.execute(new Turtle()));
        assertEquals(20, back.execute(new Turtle()));
        assertFalse(20 != back.execute(new Turtle()));
    }

    @Test
    void testPenControl() {
        assertEquals(0, PenUp.execute(new Turtle()));
        assertFalse(0 != PenUp.execute(new Turtle()));
        assertEquals(1, PenDown.execute(new Turtle()));
        assertFalse(1 != PenDown.execute(new Turtle()));
    }

    @Test
    void testRotate() {
        assertEquals(90, Right.execute(new Turtle()));
        assertFalse(90 != Right.execute(new Turtle()));
        assertEquals(90, Left.execute(new Turtle()));
        assertFalse(90 != Left.execute(new Turtle()));
    }

    @Test
    void testSetHeading() {
        assertEquals(90, SH90.execute(new Turtle()));
        assertFalse(90 != SH90.execute(new Turtle()));
        assertEquals(180, SH180.execute(new Turtle()));
        assertFalse(180 != SH180.execute(new Turtle()));
    }

    @Test
    public void testForward() throws Exception {
        List<String> params = new ArrayList<>();
        params.add("50");
        Forward cmd = new Forward(params);
        Turtle turtle = new Turtle();
        Environment env = new Environment();
        double result = cmd.execute(turtle);
        assertEquals(50, result);
    }

    @Test
    public void testBackward() throws Exception {
        List<String> params = new ArrayList<>();
        params.add("50");
        Backward cmd = new Backward(params);
        Turtle turtle = new Turtle();
        Environment env = new Environment();
        double result = cmd.execute(turtle);
        assertEquals(50, result);
    }

    @Test
    public void testLeft() throws Exception {
        List<String> params = new ArrayList<>();
        params.add("90");
        Left cmd = new Left(params);
        Turtle turtle = new Turtle();
        Environment env = new Environment();
        double result = cmd.execute(turtle);
        assertEquals(90, result);
    }

    @Test
    public void testRight() throws Exception {
        List<String> params = new ArrayList<>();
        params.add("90");
        Right cmd = new Right(params);
        Turtle turtle = new Turtle();
        Environment env = new Environment();
        double result = cmd.execute(turtle);
        assertEquals(90, result);
    }

    @Test
    public void testSH() throws Exception {
        List<String> params = new ArrayList<>();
        params.add("-180");
        SetHeading cmd = new SetHeading(params);
        Turtle turtle = new Turtle();
        Environment env = new Environment();
        double result = cmd.execute(turtle);
        assertEquals(180, result);
    }
}