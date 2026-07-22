class Solution {

    public StringBuilder format(StringBuilder line, int gaps, int maxWidth) {

        int remainingNeededSpaces = maxWidth - line.length();
        int totalSpaces = gaps + remainingNeededSpaces;

        String[] words = line.toString().split(" ");

        StringBuilder ans = new StringBuilder();

        // Only one word in the line
        if (gaps == 0) {
            ans.append(words[0]);

            while (ans.length() < maxWidth)
                ans.append(" ");

            return ans;
        }

        int i = 0;

        while (gaps > 0) {

            int inbetweenSpaces =
                    (int) Math.ceil((double) totalSpaces / gaps);

            ans.append(words[i]);

            for (int j = 0; j < inbetweenSpaces; j++)
                ans.append(" ");

            totalSpaces -= inbetweenSpaces;
            gaps--;
            i++;
        }

        ans.append(words[i]);

        return ans;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> lines = new ArrayList<>();

        StringBuilder currentLine = new StringBuilder();

        int currentLineLength = 0;
        int currentLineSpaces = 0;

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            if (currentLineLength + word.length() <= maxWidth) {

                currentLine.append(word);
                currentLine.append(" ");

                currentLineLength += word.length() + 1;
                currentLineSpaces++;

            } else {

                currentLine.deleteCharAt(currentLine.length() - 1);

                currentLine = format(currentLine,
                                     currentLineSpaces - 1,
                                     maxWidth);

                lines.add(currentLine.toString());

                currentLine = new StringBuilder();
                currentLineLength = 0;
                currentLineSpaces = 0;

                i--;
            }
        }

        // Last line (left justified)
        if (currentLine.length() > 0) {

            currentLine.deleteCharAt(currentLine.length() - 1);

            while (currentLine.length() < maxWidth)
                currentLine.append(" ");

            lines.add(currentLine.toString());
        }

        return lines;
    }
}