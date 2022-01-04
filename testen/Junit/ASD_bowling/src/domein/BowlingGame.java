package domein;

public class BowlingGame {
	
	private int rolls[] = new int[21];
	private int currentRoll = 0;
	
	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}
	
	public int score() {
		int score = 0;
		for (int frameIndex= 0, frame = 0; frame < 10; frameIndex+= 2, frame++)
			if(IsStrike(frameIndex)) {
				score += 10 + StrikeBonus(frameIndex);
				frameIndex--;
			}
			else if (isSpare(frameIndex))
				score += 10 + spareBonus(frameIndex);
			else
				score += sumOfPinsInFrame(frameIndex);
		return score;
	}
	
	private boolean isSpare(int frameIndex) {
		return rolls[frameIndex] +    rolls[frameIndex+ 1] == 10;
	}
	
	private boolean IsStrike(int frameIndex) {
		return rolls[frameIndex] == 10;
	}
	
	private int sumOfPinsInFrame(int frameIndex) {
		return rolls[frameIndex]+ rolls[frameIndex+1];
	}
	
	private int spareBonus(int frameIndex) {
		return rolls[frameIndex+2];
	}
	
	private int StrikeBonus(int frameIndex) {
		return rolls[frameIndex+1]+ rolls[frameIndex+2];
	}
	
	
}
