package test.tic.tac.toe;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.GameException;
import exceptions.InvalidConfigurationException;
import exceptions.InvalidInputException;
import move.Move;
import players.AIPlayer;
import players.HumanPlayer;
import players.PLAYERTYPE;
import players.Player;
import tic.tac.toe.GameMaster;

public class PlayerTest extends BaseTest{

	HashMap<Integer, Player> playersMap = new HashMap<Integer, Player>();			
	HumanPlayer humanPlayer = null;
	AIPlayer aiPlayer = null;

	@Before
	public void setUpPlayer() throws InvalidConfigurationException {
		humanPlayer = new HumanPlayer(1, 'X', PLAYERTYPE.HUMAN);
		aiPlayer = new AIPlayer(2, 'O', PLAYERTYPE.AI);
		this.playersMap.put(1, humanPlayer);
		this.playersMap.put(2, aiPlayer);
		new GameMaster(3, this.playersMap, 2);
	}

	@Test
	public void testValidateIsNumber() {
		try{
			humanPlayer.validateIsNumber("xyz");
			Assert.fail("Invalid value") ;
		}catch(InvalidInputException ex){
			Assert.assertEquals(ex.getMessage(), "les données doivent être correct");
		}
	}

	@Test
	public void testValidateMoveNoComma() {
		try{
			humanPlayer.validateMove("xyz");
			Assert.fail("les données doivent être correct") ;
		}catch(GameException ex){
			Assert.assertEquals(ex.getMessage(), "Un mouvement correct doit avoir 2 coordonés");
		}
	}
	
	@Test
	public void testValidateMoveDash() {
		try{
			humanPlayer.validateMove("1-3");
			Assert.fail("les données doivent être correct") ;
		}catch(GameException ex){
			Assert.assertEquals(ex.getMessage(), "Un mouvement correct doit avoir 2 coordonés");
		}
	}

	@Test
	public void testGetAnyAvailableMove() {
		Move move = aiPlayer.getAnyAvailableMove();
		Assert.assertEquals(move.getX(), 0);
		Assert.assertEquals(move.getY(), 0);
		
		aiPlayer.getGm().doMove(new Move(1,1, aiPlayer));
		aiPlayer.getGm().doMove(new Move(1,2, aiPlayer));
		move = aiPlayer.getAnyAvailableMove();
		Assert.assertEquals(move.getX(), 0);
		Assert.assertEquals(move.getY(), 2);

		aiPlayer.getGm().doMove(new Move(1,3, aiPlayer));
		move = aiPlayer.getAnyAvailableMove();
		Assert.assertEquals(move.getX(), 1);
		Assert.assertEquals(move.getY(), 0);

	}

	@Test
	public void testGetRandomMove() {
		Move move;
		try {
			move = aiPlayer.getRandomMove();
			Assert.assertTrue(move.getX() < 10 && move.getX() > -1);
			Assert.assertTrue(move.getY() < 10 && move.getY() > -1);
		} catch (GameException e) {
			Assert.fail("Ne drevrais pas faire d'exeption");
			e.printStackTrace();
		}
	}


}