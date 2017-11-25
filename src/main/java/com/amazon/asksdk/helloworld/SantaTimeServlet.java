package com.amazon.asksdk.helloworld;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;

public class SantaTimeServlet extends SpeechletServlet{
	public SantaTimeServlet() {
		this.setSpeechlet(new HelloWorldSpeechlet());
	}
}
