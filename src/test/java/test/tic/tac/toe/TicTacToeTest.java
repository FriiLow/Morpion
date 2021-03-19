package test.tic.tac.toe;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import tic.tac.toe.TicTacToe;

public class TicTacToeTest extends BaseTest
{
	
	final String prefix = "src/test/java/test/resources/" ;
	final String simple_2_players = "config_simple_2_players.properties";
	
	public void feedStringToSystemIn(String s){
	    InputStream in = new ByteArrayInputStream(s.getBytes());
	    System.setIn(in);
	}
	
	@After
	public void restoreSystemIn() {
		System.setIn(System.in) ;
	}
	
	
    @Test
    public void testPlayer1WinsVertical() {
    	String[] args = {prefix+simple_2_players} ;
    	feedStringToSystemIn("1,1\n1,2\n2,1\n2,2\n3,1\n") ;
    	TicTacToe.main(args);
    	String output = outContent.toString() ;
    	String[] lines = output.split("\n");
    	Assert.assertEquals(lines[lines.length-1], "Victoire P1");
    }

    @Test
    public void testPlayer1WinsDiagonal() {
    	String[] args = {prefix+simple_2_players} ;
    	feedStringToSystemIn("1,1\n1,2\n2,2\n2,1\n3,3\n") ;
    	TicTacToe.main(args);
    	String output = outContent.toString() ;
    	String[] lines = output.split("\n");
    	Assert.assertEquals(lines[lines.length-1], "Victoire P1");
    }

    @Test
    public void testPlayer2WinsHorizontal() {
    	String[] args = {prefix+simple_2_players} ;
    	feedStringToSystemIn("1,1\n2,1\n1,2\n2,2\n3,3\n2,3\n") ;
    	TicTacToe.main(args);
    	String output = outContent.toString() ;
    	String[] lines = output.split("\n");
    	Assert.assertEquals(lines[lines.length-1], "Victoir P2");
    }
    
    @Test
    public void testPlayer2WinsDiagonal() {
    	String[] args = {prefix+simple_2_players} ;
    	feedStringToSystemIn("1,1\n1,3\n1,2\n2,2\n3,3\n3,1\n") ;
    	TicTacToe.main(args);
    	String output = outContent.toString() ;
    	String[] lines = output.split("\n");
    	Assert.assertEquals(lines[lines.length-1], "Victoire P2");
    }
    
    @Test
    public void testInvalidMove() {
    	String[] args = {prefix+simple_2_players} ;
    	feedStringToSystemIn("1-1\n1+1\n1,1\n1,2\n3$2\n2,1\n2,2\n5,5\n3,1\n") ;
    	TicTacToe.main(args);
    	String output = outContent.toString() ;
    	String[] lines = output.split("\n");
    	Assert.assertEquals(lines[lines.length-1], "Victoire P1");    }


}
