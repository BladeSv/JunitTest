package by.htp.test;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.drozdovskaya.oracle.entity.Answer;
import by.drozdovskaya.oracle.entity.Prediction;
import by.drozdovskaya.oracle.entity.Predictor;

public class TestgetPredictionBase {

	Predictor testPredictor;
	Prediction pre;
	@Before
	public void inicilize() {
		testPredictor=new Predictor();
		pre =new Prediction();
		pre.setTypeOfPrediction("Love");
		Queue<Answer> answers = new LinkedList<>();
			
		answers.add(new Answer("встреча"));
		answers.add(new Answer("расстование"));
		answers.add(new Answer("новые отношения"));
		answers.add(new Answer("измена"));
		answers.add(new Answer("любовь"));
		testPredictor.mapOfAnswers.put(pre, answers);
		
	}
	
	@Test
	public void testgetPredictionNull() {
		Prediction  testP=testPredictor.getPrediction(1);
		Assert.assertNotNull("Null, bad idea)", testP);
	
		
		
	}
	@Test
public void testgetPredictionEqual() {
	Prediction  testP=testPredictor.getPrediction(1);
	
	Assert.assertEquals("Equal", "Love", testP.getTypeOfPrediction());

}

	@Test
	public void testgetPredictionEqualClass() {
		Prediction test=new Prediction();
		Prediction  testP=testPredictor.getPrediction(1);
		
		Assert.assertNotEquals("Same class",test, testP);

	}
	@Test
	public void testgetAnswerOfPredictionNoNull() {
	Answer testAnset=	testPredictor.getAnswerOfPrediction(pre);

	Assert.assertNotNull("Null", testAnset);
		
	} 
	@Test
	public void testgetAnswerOfPredictionEqual() {
	Answer testAnset=	testPredictor.getAnswerOfPrediction(pre);

	Assert.assertEquals("No equal", "встреча", testAnset.getAnswer());
	}
}
