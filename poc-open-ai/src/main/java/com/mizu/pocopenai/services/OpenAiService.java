package com.mizu.pocopenai.services;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenAiService {

    private final ChatClient client;

    @Autowired
    public OpenAiService(OpenAiChatClient client) {
        this.client = client;
    }
	
	public String getTravelReasons(int count, String location) {
        final String promptText = """
                Write {count} reasons why people should consider travel to {location}.
                These reasons need to be short, so they fit on a poster.
                """;

        final PromptTemplate promptTemplate = new PromptTemplate(promptText);
        promptTemplate.add("count", count);
        promptTemplate.add("location", location);

        ChatResponse response = client.call(promptTemplate.create());
        return response.getResult().getOutput().getContent();
    }
}
