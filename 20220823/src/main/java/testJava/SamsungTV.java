package testJava;

public class SamsungTV implements TV {
	private Speaker speaker;
	@Override
	public void powerOn() {
		System.out.println("삼성TV 전원을 켭니다.");
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void powerOff() {
		System.out.println("삼성TV 전원을 끕니다.");
	}

	@Override
	public void volumeUp() {
		speaker.model();
		System.out.println("삼성TV 소리를 올립니다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("삼성TV 소리를 줄입니다.");
	}

}
