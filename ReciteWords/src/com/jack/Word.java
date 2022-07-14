package com.jack;

public class Word {
    private String key;
    private String definition;
    private String speech;
    private String sentence;

    public Word() {
    }

    public Word(String key, String definition, String speech, String sentence) {
        this.key = key;
        this.definition = definition;
        this.speech = speech;
        this.sentence = sentence;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "Word{" +
                "key='" + key + '\'' +
                ", definition='" + definition + '\'' +
                ", speech='" + speech + '\'' +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
