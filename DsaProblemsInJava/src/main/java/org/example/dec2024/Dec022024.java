package org.example.dec2024;

public class Dec022024 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if (
                sentence == null ||
                        searchWord == null ||
                        searchWord.length() > sentence.length()
        ) {
            return -1;
        }

        int wordIndex = 1;
        int indexInSentence = 0;
        int sentenceLength = sentence.length();

        while (indexInSentence < sentenceLength) {
            while (
                    indexInSentence < sentenceLength &&
                            sentence.charAt(indexInSentence) == ' '
            ) {
                wordIndex++;
                while (
                        indexInSentence < sentenceLength &&
                                sentence.charAt(indexInSentence) == ' '
                ) {
                    indexInSentence++;
                }
            }

            int matchLength = 0;
            while (
                    indexInSentence < sentenceLength &&
                            matchLength < searchWord.length() &&
                            sentence.charAt(indexInSentence) == searchWord.charAt(matchLength)
            ) {
                indexInSentence++;
                matchLength++;
            }

            if (matchLength == searchWord.length()) {
                return wordIndex;
            }

            while (
                    indexInSentence < sentenceLength &&
                            sentence.charAt(indexInSentence) != ' '
            ) {
                indexInSentence++;
            }
        }

        return -1;
    }
}
