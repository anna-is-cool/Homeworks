public class Base64 {
    private final char[][] BYTE_ARRAYS;
    private final char[] BASE64_SYMBOLS_CHARARRAY = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public static void main(String[] args) {
        Base64 a = new Base64("Anna");
        System.out.println(a.encode());
    }
  
    public Base64(String string) {
        this.BYTE_ARRAYS = getByteArrays(string);
    }
  
    private char getBase64SymbolsChar(int symbolIndex) {
        return BASE64_SYMBOLS_CHARARRAY[symbolIndex];
    }

    private int getNumOfBinArray(char[] symbols) {
        int bin = 0;
        for (int i = 0; i < symbols.length; ++i) {
            if (symbols[i] == '1') {
                bin += (int) Math.pow(2, symbols.length - i - 1);
            }
        }
        return bin;
    }
  
    private char[][] getByteArrays(String string) {
        char[][] byteArrays = new char[string.length()][8];
        int countByteArrays = 0;
        for (int i = 0; i < string.length(); ++i) {
            char symbol = string.charAt(i);
            char[] symbolBin = getBin(symbol);
            byteArrays[countByteArrays++] = symbolBin;
        }
        return byteArrays;
    }

    public String encode() {
        int totalBits = BYTE_ARRAYS.length * 8;
        int totalChars = (totalBits + 5) / 6;
        int paddingCount = (4 - totalChars % 4) % 4; // Вычисление количества символов равенства
        char[] encodingCharArray = new char[totalChars + paddingCount];

        int countToByteArrays = 0;
        int countToCharArray = 0;
        char[] nowSymbols = new char[6];
        for (char[] byteArrays : BYTE_ARRAYS) {
            for (char bit : byteArrays) {
                nowSymbols[countToByteArrays++] = bit;
                if (countToByteArrays == 6) {
                    encodingCharArray[countToCharArray++] = getBase64SymbolsChar(getNumOfBinArray(nowSymbols));
                    countToByteArrays = 0;
                    nowSymbols = new char[6];
                }
            }
        }

        if (countToByteArrays > 0) { // Обработка последнего блока
            for (int i = countToByteArrays; i < 6; ++i) {
                nowSymbols[i] = '0';
            }
            encodingCharArray[countToCharArray++] = getBase64SymbolsChar(getNumOfBinArray(nowSymbols));
        }

        for (int i = 0; i < paddingCount; ++i) {
            encodingCharArray[countToCharArray++] = '='; // Добавление символов равенства
        }

        return new String(encodingCharArray);
    }

  
    private char[] getBin(int num) {
        char[] bin = new char[8];
        int b;
        int count = 7;
        while (num != 0) {
            b = num % 2;
            num /= 2;
            bin[count--] = (char) (b + '0');
        }
        for(int i = 0; i < 8; ++i) {
            if (bin[i] == 0) {
                bin[i] = '0';
            }
        }
        return bin;
    }

}
