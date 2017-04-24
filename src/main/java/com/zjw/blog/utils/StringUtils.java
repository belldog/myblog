package com.zjw.blog.utils;

import java.math.BigDecimal;
import java.util.*;


/**
 * Miscellaneous {@link String} utility methods.
 * <p>
 * Mainly for internal use within the framework;
 * <p>
 * This class delivers some simple functionality that should really be provided
 * by the core Java <code>String</code> and {@link StringBuffer} classes, such
 * as the ability to {@link #replace} all occurrences of a given substring in a
 * target string. It also provides easy-to-use methods to convert between
 * delimited strings, such as CSV strings, and collections and arrays.
 */
public final class StringUtils {

    private StringUtils() {
    }

    private static final String FOLDER_SEPARATOR = "/";

    private static final String WINDOWS_FOLDER_SEPARATOR = "\\";

    private static final String TOP_PATH = "..";

    private static final String CURRENT_PATH = ".";

    private static final char EXTENSION_SEPARATOR = '.';

    // ---------------------------------------------------------------------
    // General convenience methods for working with Strings
    // ---------------------------------------------------------------------

    /**
     * Check that the given CharSequence is neither <code>null</code> nor of
     * length 0. Note: Will return <code>true</code> for a CharSequence that
     * purely consists of whitespace.
     * <p>
     * <p>
     * <pre>
     * StringUtils.hasLength(null) = false
     * StringUtils.hasLength(&quot;&quot;) = false
     * StringUtils.hasLength(&quot; &quot;) = true
     * StringUtils.hasLength(&quot;Hello&quot;) = true
     * </pre>
     *
     * @param str the CharSequence to check (may be <code>null</code>)
     * @return <code>true</code> if the CharSequence is not null and has length
     * @see #hasText(String)
     */
    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    /**
     * Check that the given String is neither <code>null</code> nor of length 0.
     * Note: Will return <code>true</code> for a String that purely consists of
     * whitespace.
     *
     * @param str the String to check (may be <code>null</code>)
     * @return <code>true</code> if the String is not null and has length
     * @see #hasLength(CharSequence)
     */
    public static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    /**
     * Check whether the given CharSequence has actual text. More specifically,
     * returns <code>true</code> if the string not <code>null</code>, its length
     * is greater than 0, and it contains at least one non-whitespace character.
     * <p>
     * <p>
     * <pre>
     * StringUtils.hasText(null) = false
     * StringUtils.hasText(&quot;&quot;) = false
     * StringUtils.hasText(&quot; &quot;) = false
     * StringUtils.hasText(&quot;12345&quot;) = true
     * StringUtils.hasText(&quot; 12345 &quot;) = true
     * </pre>
     *
     * @param str the CharSequence to check (may be <code>null</code>)
     * @return <code>true</code> if the CharSequence is not <code>null</code>,
     * its length is greater than 0, and it does not contain whitespace
     * only
     * @see Character#isWhitespace
     */
    public static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the given String has actual text. More specifically,
     * returns <code>true</code> if the string not <code>null</code>, its length
     * is greater than 0, and it contains at least one non-whitespace character.
     *
     * @param str the String to check (may be <code>null</code>)
     * @return <code>true</code> if the String is not <code>null</code>, its
     * length is greater than 0, and it does not contain whitespace only
     * @see #hasText(CharSequence)
     */
    public static boolean hasText(String str) {
        return hasText((CharSequence) str);
    }

    /**
     * Check whether the given CharSequence contains any whitespace characters.
     *
     * @param str the CharSequence to check (may be <code>null</code>)
     * @return <code>true</code> if the CharSequence is not empty and contains
     * at least 1 whitespace character
     * @see Character#isWhitespace
     */
    public static boolean containsWhitespace(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the given String contains any whitespace characters.
     *
     * @param str the String to check (may be <code>null</code>)
     * @return <code>true</code> if the String is not empty and contains at
     * least 1 whitespace character
     * @see #containsWhitespace(CharSequence)
     */
    public static boolean containsWhitespace(String str) {
        return containsWhitespace((CharSequence) str);
    }

    /**
     * 去除字符串前后的空白字符，返回一个新的字符串
     *
     * @param str the String to check
     * @return the trimmed String
     * @see Character#isWhitespace
     */
    public static String trimWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuffer buf = new StringBuffer(str);
        while (buf.length() > 0 && Character.isWhitespace(buf.charAt(0))) {
            buf.deleteCharAt(0);
        }
        while (buf.length() > 0 && Character.isWhitespace(buf.charAt(buf.length() - 1))) {
            buf.deleteCharAt(buf.length() - 1);
        }
        return buf.toString();
    }

    /**
     * 去除字符串中所有的空白的字符，返回一个新的字符串
     *
     * @param str the String to check
     * @return the trimmed String
     * @see Character#isWhitespace
     */
    public static String trimAllWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuffer buf = new StringBuffer(str);
        int index = 0;
        while (buf.length() > index) {
            if (Character.isWhitespace(buf.charAt(index))) {
                buf.deleteCharAt(index);
            } else {
                index++;
            }
        }
        return buf.toString();
    }

    /**
     * 去除字符串开头的空白字符，返回一个新的字符串
     *
     * @param str the String to check
     * @return the trimmed String
     * @see Character#isWhitespace
     */
    public static String trimLeadingWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuffer buf = new StringBuffer(str);
        while (buf.length() > 0 && Character.isWhitespace(buf.charAt(0))) {
            buf.deleteCharAt(0);
        }
        return buf.toString();
    }

    /**
     * 去除字符串后面的空白字符，返回一个新的字符串
     *
     * @param str the String to check
     * @return the trimmed String
     * @see Character#isWhitespace
     */
    public static String trimTrailingWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuffer buf = new StringBuffer(str);
        while (buf.length() > 0 && Character.isWhitespace(buf.charAt(buf.length() - 1))) {
            buf.deleteCharAt(buf.length() - 1);
        }
        return buf.toString();
    }

    /**
     * 去除字符串开头是以leadingCharacter字符开头的leadingCharacter字符，得到一个新的字符串，StringUtils.trimLeadingCharacter(" A",'A')为" A",
     * StringUtils.trimLeadingCharacter("A",'A')为"".
     *
     * @param str              the String to check
     * @param leadingCharacter the leading character to be trimmed
     * @return the trimmed String
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuffer buf = new StringBuffer(str);
        while (buf.length() > 0 && buf.charAt(0) == leadingCharacter) {
            buf.deleteCharAt(0);
        }
        return buf.toString();
    }

    /**
     * 去除字符串结尾是以trailingCharacter字符结尾的trailingCharacter字符，得到一个新的字符串
     *
     * @param str               the String to check
     * @param trailingCharacter the trailing character to be trimmed
     * @return the trimmed String
     */
    public static String trimTrailingCharacter(String str, char trailingCharacter) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuffer buf = new StringBuffer(str);
        while (buf.length() > 0 && buf.charAt(buf.length() - 1) == trailingCharacter) {
            buf.deleteCharAt(buf.length() - 1);
        }
        return buf.toString();
    }

    /**
     * 判断字符串str是否是以字符串prefix开头，忽略大小写
     *
     * @param str    the String to check
     * @param prefix the prefix to look for
     * @see String#startsWith
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        if (str == null || prefix == null) {
            return false;
        }
        if (str.startsWith(prefix)) {
            return true;
        }
        if (str.length() < prefix.length()) {
            return false;
        }
        String lcStr = str.substring(0, prefix.length()).toLowerCase();
        String lcPrefix = prefix.toLowerCase();
        return lcStr.equals(lcPrefix);
    }

    /**
     * 判断字符串str是否是以字符串prefix结尾，忽略大小写
     *
     * @param str    the String to check
     * @param suffix the suffix to look for
     * @see String#endsWith
     */
    public static boolean endsWithIgnoreCase(String str, String suffix) {
        if (str == null || suffix == null) {
            return false;
        }
        if (str.endsWith(suffix)) {
            return true;
        }
        if (str.length() < suffix.length()) {
            return false;
        }

        String lcStr = str.substring(str.length() - suffix.length()).toLowerCase();
        String lcSuffix = suffix.toLowerCase();
        return lcStr.equals(lcSuffix);
    }

    /**
     * 字符串str从索引index开始匹配substring,只有全部匹配匹配才返回true
     *
     * @param str       the original string (or StringBuffer)
     * @param index     the index in the original string to start matching against
     * @param substring the substring to match at the given index
     */
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        for (int j = 0; j < substring.length(); j++) {
            int i = index + j;
            if (i >= str.length() || str.charAt(i) != substring.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 统计字符串str中包含了几个字符串sub.
     *
     * @param str string to search in. Return 0 if this is null.
     * @param sub string to search for. Return 0 if this is null.
     */
    public static int countOccurrencesOf(String str, String sub) {
        if (str == null || sub == null || str.length() == 0 || sub.length() == 0) {
            return 0;
        }
        int count = 0, pos = 0, idx = 0;
        while ((idx = str.indexOf(sub, pos)) != -1) {
            ++count;
            pos = idx + sub.length();
        }
        return count;
    }

    /**
     * 把字符串inString中所有的子字符串oldPattern替换成newPattern，返回一个新的字符串
     *
     * @param inString   String to examine
     * @param oldPattern String to replace
     * @param newPattern String to insert
     * @return a String with the replacements
     */
    public static String replace(String inString, String oldPattern, String newPattern) {
        if (inString == null) {
            return null;
        }
        if (oldPattern == null || newPattern == null) {
            return inString;
        }

        StringBuffer sbuf = new StringBuffer();
        // output StringBuffer we'll build up
        int pos = 0; // our position in the old string
        int index = inString.indexOf(oldPattern);
        // the index of an occurrence we've found, or -1
        int patLen = oldPattern.length();
        while (index >= 0) {
            sbuf.append(inString.substring(pos, index));
            sbuf.append(newPattern);
            pos = index + patLen;
            index = inString.indexOf(oldPattern, pos);
        }
        sbuf.append(inString.substring(pos));

        // remember to append any characters to the right of a match
        return sbuf.toString();
    }

    /**
     * 去除inString字符串中的所有子字符串pattern,返回一个新的字符串
     *
     * @param inString the original String
     * @param pattern  the pattern to delete all occurrences of
     * @return the resulting String
     */
    public static String delete(String inString, String pattern) {
        return replace(inString, pattern, "");
    }

    /**
     * 去除字符串inString中所有字符串charsToDelete中有的字符，例如deleteAny("abcd","ac"),得到新字符串"bd"
     *
     * @param inString      the original String
     * @param charsToDelete a set of characters to delete. E.g. "az\n" will delete 'a's,
     *                      'z's and new lines.
     * @return the resulting String
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (!hasLength(inString) || !hasLength(charsToDelete)) {
            return inString;
        }
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < inString.length(); i++) {
            char c = inString.charAt(i);
            if (charsToDelete.indexOf(c) == -1) {
                out.append(c);
            }
        }
        return out.toString();
    }

    // ---------------------------------------------------------------------
    // Convenience methods for working with formatted Strings
    // ---------------------------------------------------------------------

    /**
     * 给字符串加单引号，并返回这个新字符串，例如quote("abcd")得到字符串"'abcd'"
     *
     * @param str the input String (e.g. "myString")
     * @return the quoted String (e.g. "'myString'"), or
     * <code>null<code> if the input was <code>null</code>
     */
    public static String quote(String str) {
        return (str != null ? "'" + str + "'" : null);
    }

    /**
     * 如果对象是个字符串，给他加上单引号，并返回这个新字符串，否则返回这个对象
     *
     * @param obj the input Object (e.g. "myString")
     * @return the quoted String (e.g. "'myString'"), or the input object as-is
     * if not a String
     */
    public static Object quoteIfString(Object obj) {
        return (obj instanceof String ? quote((String) obj) : obj);
    }

    /**
     * 从字符串qualifiedName的最后开始查找字符'.'，并截取这个字符之后的字符组成新的字符串返回，例如unquelify("this.name.is.qualified")
     * 返回"qualified"
     * Unqualify a string qualified by a '.' dot character. For example,
     * "this.name.is.qualified", returns "qualified".
     *
     * @param qualifiedName the qualified name
     */
    public static String unqualify(String qualifiedName) {
        return unqualify(qualifiedName, '.');
    }

    /**
     * 从字符串qualifiedName的最后开始查找字符separator，并截取这个字符之后的字符组成新的字符串返回，例如unquelify("this:name:is:qualified",':')
     * 返回"qualified"
     * <p>
     * Unqualify a string qualified by a separator character. For example,
     * "this:name:is:qualified" returns "qualified" if using a ':' separator.
     *
     * @param qualifiedName the qualified name
     * @param separator     the separator
     */
    public static String unqualify(String qualifiedName, char separator) {
        return qualifiedName.substring(qualifiedName.lastIndexOf(separator) + 1);
    }

    /**
     * 把字符串的首字符换成大写，返回这个新的字符串
     * Capitalize a <code>String</code>, changing the first letter to upper case
     * as per {@link Character#toUpperCase(char)}. No other letters are changed.
     *
     * @param str the String to capitalize, may be <code>null</code>
     * @return the capitalized String, <code>null</code> if null
     */
    public static String capitalize(String str) {
        return changeFirstCharacterCase(str, true);
    }

    /**
     * 把字符串的首字符换成小写，返回这个新的字符串
     * Uncapitalize a <code>String</code>, changing the first letter to lower
     * case as per {@link Character#toLowerCase(char)}. No other letters are
     * changed.
     *
     * @param str the String to uncapitalize, may be <code>null</code>
     * @return the uncapitalized String, <code>null</code> if null
     */
    public static String uncapitalize(String str) {
        return changeFirstCharacterCase(str, false);
    }

    /**
     * true,把字符串str的第一个字符换成大写，false,把字符串的第一个字符换成小写。返回这个新的字符串
     *
     * @param str
     * @param capitalize
     * @return
     */
    private static String changeFirstCharacterCase(String str, boolean capitalize) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuffer buf = new StringBuffer(str.length());
        if (capitalize) {
            buf.append(Character.toUpperCase(str.charAt(0)));
        } else {
            buf.append(Character.toLowerCase(str.charAt(0)));
        }
        buf.append(str.substring(1));
        return buf.toString();
    }

    /**
     * 从字符串path的最后开始查找字符'/'，并截取这个字符之后的字符组成新的字符串返回，例如getFilename("mypath/myfile.txt")
     * 返回"myfile.txt",就是得到文件名
     * <p>
     * Extract the filename from the given path, e.g. "mypath/myfile.txt" ->
     * "myfile.txt".
     *
     * @param path the file path (may be <code>null</code>)
     * @return the extracted filename, or <code>null</code> if none
     */
    public static String getFilename(String path) {
        if (path == null) {
            return null;
        }
        int separatorIndex = path.lastIndexOf(FOLDER_SEPARATOR);
        return (separatorIndex != -1 ? path.substring(separatorIndex + 1) : path);
    }

    /**
     * 从字符串path的最后开始查找字符'.'，并截取这个字符之后的字符组成新的字符串返回，例如getFilename("mypath/myfile.txt")
     * 返回"txt",就是得到文件的后缀名
     * Extract the filename extension from the given path, e.g.
     * "mypath/myfile.txt" -> "txt".
     *
     * @param path the file path (may be <code>null</code>)
     * @return the extracted filename extension, or <code>null</code> if none
     */
    public static String getFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        int sepIndex = path.lastIndexOf(EXTENSION_SEPARATOR);
        return (sepIndex != -1 ? path.substring(sepIndex + 1) : null);
    }

    /**
     * 从字符串path的最后开始查找字符'.'，并去除这个字符之后的字符组成新的字符串返回，例如stripFilenameExtension("mypath/myfile.txt")
     * 返回"mypath/myfile"
     * Strip the filename extension from the given path, e.g.
     * "mypath/myfile.txt" -> "mypath/myfile".
     *
     * @param path the file path (may be <code>null</code>)
     * @return the path with stripped filename extension, or <code>null</code>
     * if none
     */
    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        int sepIndex = path.lastIndexOf(EXTENSION_SEPARATOR);
        return (sepIndex != -1 ? path.substring(0, sepIndex) : path);
    }

    /**
     * 例如applyRelativePath("aa/bb/cc","dd"),得到"aa/bb/dd"
     * applyRelativePath("aa/bb/cc","/dd"),得到"aa/bb/dd"
     * applyRelativePath("cc","/dd"),得到"/dd"
     * applyRelativePath("cc","dd"),得到"dd"
     * Apply the given relative path to the given path, assuming standard Java
     * folder separation (i.e. "/" separators);
     *
     * @param path         the path to start from (usually a full file path)
     * @param relativePath the relative path to apply (relative to the full file path
     *                     above)
     * @return the full file path that results from applying the relative path
     */
    public static String applyRelativePath(String path, String relativePath) {
        int separatorIndex = path.lastIndexOf(FOLDER_SEPARATOR);
        if (separatorIndex != -1) {
            String newPath = path.substring(0, separatorIndex);
            if (!relativePath.startsWith(FOLDER_SEPARATOR)) {
                newPath += FOLDER_SEPARATOR;
            }
            return newPath + relativePath;
        } else {
            return relativePath;
        }
    }

    /**
     * 貌似是例如cleanPath("192.168.0.62:8080/haha/../login.shtml")得到"192.168.0.62:8080/login.shtml"
     * cleanPath("192.168.0.62:8080/haha/.././login.shtml")得到192.168.0.62:8080/login.shtml
     * cleanPath("192.168.0.62:8080/haha/.././../login.shtml")得到192.168.0.62:login.shtml
     * Normalize the path by suppressing sequences like "path/.." and inner
     * simple dots.
     * <p>
     * The result is convenient for path comparison. For other uses, notice that
     * Windows separators ("\") are replaced by simple slashes.
     *
     * @param path the original path
     * @return the normalized path
     */
    public static String cleanPath(String path) {
        //把字符串中所有的"\\"换成"/"
        String pathToUse = replace(path, WINDOWS_FOLDER_SEPARATOR, FOLDER_SEPARATOR);

        // Strip prefix from path to analyze, to not treat it as part of the
        // first path element. This is necessary to correctly parse paths like
        // "file:core/../core/io/Resource.class", where the ".." should just
        // strip the first "core" directory while keeping the "file:" prefix.
        int prefixIndex = pathToUse.indexOf(":");
        String prefix = "";
        //用出现的第一个":"把字符串pathToUse拆成两个字符串
        if (prefixIndex != -1) {
            //:之前的字符串
            prefix = pathToUse.substring(0, prefixIndex + 1);
            //:之后的字符串
            pathToUse = pathToUse.substring(prefixIndex + 1);
        }

        //把:之后的字符串根据/拆成一个String数组
        String[] pathArray = delimitedListToStringArray(pathToUse, FOLDER_SEPARATOR);
        List<String> pathElements = new LinkedList<String>();
        int tops = 0;

        for (int i = pathArray.length - 1; i >= 0; i--) {
            if (CURRENT_PATH.equals(pathArray[i])) {
                // Points to current directory - drop it.
            } else if (TOP_PATH.equals(pathArray[i])) {
                // Registering top path found.
                tops++;
            } else {
                if (tops > 0) {
                    // Merging path element with corresponding to top path.
                    tops--;
                } else {
                    // Normal path element found.
                    pathElements.add(0, pathArray[i]);
                }
            }
        }

        // Remaining top paths need to be retained.
        for (int i = 0; i < tops; i++) {
            pathElements.add(0, TOP_PATH);
        }

        return prefix + collectionToDelimitedString(pathElements, FOLDER_SEPARATOR);
    }

    /**
     * cleanPath过后，比较两个路径是否一样
     *
     * @param path1 first path for comparison
     * @param path2 second path for comparison
     * @return whether the two paths are equivalent after normalization
     */
    public static boolean pathEquals(String path1, String path2) {
        return cleanPath(path1).equals(cleanPath(path2));
    }

    /**
     * 根据字符串localeString,把他解析成一个Locale并返回
     * Parse the given <code>localeString</code> into a {@link Locale}.
     * <p>
     * This is the inverse operation of {@link Locale#toString Locale's
     * toString}.
     *
     * @param localeString the locale string, following <code>Locale's</code>
     *                     <code>toString()</code> format ("en", "en_UK", etc); also
     *                     accepts spaces as separators, as an alternative to underscores
     * @return a corresponding <code>Locale</code> instance
     */
    public static Locale parseLocaleString(String localeString) {
        String[] parts = tokenizeToStringArray(localeString, "_ ", false, false);
        String language = (parts.length > 0 ? parts[0] : "");
        String country = (parts.length > 1 ? parts[1] : "");
        String variant = "";
        if (parts.length >= 2) {
            // There is definitely a variant, and it is everything after the
            // country
            // code sans the separator between the country code and the variant.
            int endIndexOfCountryCode = localeString.indexOf(country) + country.length();
            // Strip off any leading '_' and whitespace, what's left is the
            // variant.
            variant = trimLeadingWhitespace(localeString.substring(endIndexOfCountryCode));
            if (variant.startsWith("_")) {
                variant = trimLeadingCharacter(variant, '_');
            }
        }
        return (language.length() > 0 ? new Locale(language, country, variant) : null);
    }

    // ---------------------------------------------------------------------
    // Convenience methods for working with String arrays
    // ---------------------------------------------------------------------

    /**
     * 把字符串数组array里的元素拿出来，与字符串str组成一个新的字符串数组，并返回
     * Append the given String to the given String array, returning a new array
     * consisting of the input array contents plus the given String.
     *
     * @param array the array to append to (can be <code>null</code>)
     * @param str   the String to append
     * @return the new array (never <code>null</code>)
     */
    public static String[] addStringToArray(String[] array, String str) {
        if (array == null || array.length == 0) {
            return new String[]{str};
        }
        String[] newArr = new String[array.length + 1];
        System.arraycopy(array, 0, newArr, 0, array.length);
        newArr[array.length] = str;
        return newArr;
    }

    /**
     * 把两个字符串数组合并成一个新的字符串数组
     * Concatenate the given String arrays into one, with overlapping array
     * elements included twice.
     * <p>
     * The order of elements in the original arrays is preserved.
     *
     * @param array1 the first array (can be <code>null</code>)
     * @param array2 the second array (can be <code>null</code>)
     * @return the new array (<code>null</code> if both given arrays were
     * <code>null</code>)
     */
    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        if (array1 == null || array1.length == 0) {
            return array2;
        }
        if (array2 == null || array2.length == 0) {
            return array1;
        }
        String[] newArr = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, newArr, 0, array1.length);
        System.arraycopy(array2, 0, newArr, array1.length, array2.length);
        return newArr;
    }
    // ContainsNone
    //-----------------------------------------------------------------------

    /**
     * 检查cs是否不包含字符searchChars,不包含返回true,包含返回false
     * <p>Checks that the CharSequence does not contain certain characters.</p>
     * <p>
     * <p>A {@code null} CharSequence will return {@code true}.
     * A {@code null} invalid character array will return {@code true}.
     * An empty CharSequence (length()=0) always returns true.</p>
     * <p>
     * <pre>
     * StringUtils.containsNone(null, *)       = true
     * StringUtils.containsNone(*, null)       = true
     * StringUtils.containsNone("", *)         = true
     * StringUtils.containsNone("ab", '')      = true
     * StringUtils.containsNone("abab", 'xyz') = true
     * StringUtils.containsNone("ab1", 'xyz')  = true
     * StringUtils.containsNone("abz", 'xyz')  = false
     * </pre>
     *
     * @param cs          the CharSequence to check, may be null
     * @param searchChars an array of invalid chars, may be null
     * @return true if it contains none of the invalid chars, or is null
     * @since 3.0 Changed signature from containsNone(String, char[]) to containsNone(CharSequence, char...)
     */
    public static boolean containsNone(CharSequence cs, char... searchChars) {
        if (cs == null || searchChars == null) {
            return true;
        }
        int csLen = cs.length();
        int csLast = csLen - 1;
        int searchLen = searchChars.length;
        int searchLast = searchLen - 1;
        for (int i = 0; i < csLen; i++) {
            char ch = cs.charAt(i);
            for (int j = 0; j < searchLen; j++) {
                if (searchChars[j] == ch) {
                    if (Character.isHighSurrogate(ch)) {
                        if (j == searchLast) {
                            // missing low surrogate, fine, like String.indexOf(String)
                            return false;
                        }
                        if (i < csLast && searchChars[j + 1] == cs.charAt(i + 1)) {
                            return false;
                        }
                    } else {
                        // ch is in the Basic Multilingual Plane
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 检查cs是否不包含字符串invalidChars里的字符,不包含返回true,包含返回false
     * <p>Checks that the CharSequence does not contain certain characters.</p>
     * <p>
     * <p>A {@code null} CharSequence will return {@code true}.
     * A {@code null} invalid character array will return {@code true}.
     * An empty String ("") always returns true.</p>
     * <p>
     * <pre>
     * StringUtils.containsNone(null, *)       = true
     * StringUtils.containsNone(*, null)       = true
     * StringUtils.containsNone("", *)         = true
     * StringUtils.containsNone("ab", "")      = true
     * StringUtils.containsNone("abab", "xyz") = true
     * StringUtils.containsNone("ab1", "xyz")  = true
     * StringUtils.containsNone("abz", "xyz")  = false
     * </pre>
     *
     * @param cs           the CharSequence to check, may be null
     * @param invalidChars a String of invalid chars, may be null
     * @return true if it contains none of the invalid chars, or is null
     * @since 3.0 Changed signature from containsNone(String, String) to containsNone(CharSequence, String)
     */
    public static boolean containsNone(CharSequence cs, String invalidChars) {
        if (cs == null || invalidChars == null) {
            return true;
        }
        return containsNone(cs, invalidChars.toCharArray());
    }

    /**
     * 看字符串数组array2哪些元素是字符串数组array1没有的，把这些没有的与字符串数组array1结合组成一个新的字符串数组
     * Merge the given String arrays into one, with overlapping array elements
     * only included once.
     * <p>
     * The order of elements in the original arrays is preserved (with the
     * exception of overlapping elements, which are only included on their first
     * occurence).
     *
     * @param array1 the first array (can be <code>null</code>)
     * @param array2 the second array (can be <code>null</code>)
     * @return the new array (<code>null</code> if both given arrays were
     * <code>null</code>)
     */
    public static String[] mergeStringArrays(String[] array1, String[] array2) {
        if (array1 == null || array1.length == 0) {
            return array2;
        }
        if (array2 == null || array2.length == 0) {
            return array1;
        }
        List<String> result = new ArrayList<String>();
        result.addAll(Arrays.asList(array1));
        for (int i = 0; i < array2.length; i++) {
            String str = array2[i];
            if (!result.contains(str)) {
                result.add(str);
            }
        }
        return toStringArray(result);
    }

    /**
     * 给字符串数组元素排序，返回数组
     *
     * @param array the source array
     * @return the sorted array (never <code>null</code>)
     */
    public static String[] sortStringArray(String[] array) {
        if (array == null || array.length == 0) {
            return new String[0];
        }
        Arrays.sort(array);
        return array;
    }

    /**
     * 把集合collection转换成字符串数组，这个集合必须只包含String元素
     * Copy the given Collection into a String array. The Collection must
     * contain String elements only.
     *
     * @param collection the Collection to copy
     * @return the String array (<code>null</code> if the passed-in Collection
     * was <code>null</code>)
     */
    public static String[] toStringArray(Collection<?> collection) {
        if (collection == null) {
            return null;
        }
        return (String[]) collection.toArray(new String[collection.size()]);
    }

    /**
     * 把Enumeration转换成字符串数组，这个Enumeration必须只包含String元素
     * Copy the given Enumeration into a String array. The Enumeration must
     * contain String elements only.
     *
     * @param enumeration the Enumeration to copy
     * @return the String array (<code>null</code> if the passed-in Enumeration
     * was <code>null</code>)
     */
    public static String[] toStringArray(Enumeration<?> enumeration) {
        if (enumeration == null) {
            return null;
        }
        List<?> list = Collections.list(enumeration);
        return (String[]) list.toArray(new String[list.size()]);
    }

    /**
     * 对字符串数组array里的每个元素进行trim,再返回这个新的字符串数组
     * Trim the elements of the given String array, calling
     * <code>String.trim()</code> on each of them.
     *
     * @param array the original String array
     * @return the resulting array (of the same size) with trimmed elements
     */
    public static String[] trimArrayElements(String[] array) {
        if (array == null || array.length == 0) {
            return new String[0];
        }
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            String element = array[i];
            result[i] = (element != null ? element.trim() : null);
        }
        return result;
    }

    /**
     * 去除字符串数组array中重复的元素，并排序，返回一个新的字符串数组
     * Remove duplicate Strings from the given array. Also sorts the array, as
     * it uses a TreeSet.
     *
     * @param array the String array
     * @return an array without duplicates, in natural sort order
     */
    public static String[] removeDuplicateStrings(String[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        Set<String> set = new TreeSet<String>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        return toStringArray(set);
    }

    /**
     * 字符串toSplit根据字符串delimiter，把它拆分成两个字符串，并把这两个字符串组成字符串数组返回
     * Split a String at the first occurrence of the delimiter. Does not include
     * the delimiter in the result.
     *
     * @param toSplit   the string to split
     * @param delimiter to split the string up with
     * @return a two element array with index 0 being before the delimiter, and
     * index 1 being after the delimiter (neither element includes the
     * delimiter); or <code>null</code> if the delimiter wasn't found in
     * the given input String
     */
    public static String[] split(String toSplit, String delimiter) {
        if (!hasLength(toSplit) || !hasLength(delimiter)) {
            return null;
        }
        int offset = toSplit.indexOf(delimiter);
        if (offset < 0) {
            return null;
        }
        String beforeDelimiter = toSplit.substring(0, offset);
        String afterDelimiter = toSplit.substring(offset + delimiter.length());
        return new String[]{beforeDelimiter, afterDelimiter};
    }

    /**
     * 把字符串数组array里的每个元素通过delimiter拆成两份或多份，每个
     * 拆分出来的第一个元素和第二个元素，组成Properties的一对键值对，并返回这个Properties
     * Take an array Strings and split each element based on the given
     * delimiter. A <code>Properties</code> instance is then generated, with the
     * left of the delimiter providing the key, and the right of the delimiter
     * providing the value.
     * <p>
     * Will trim both the key and value before adding them to the
     * <code>Properties</code> instance.
     *
     * @param array     the array to process
     * @param delimiter to split each element using (typically the equals symbol)
     * @return a <code>Properties</code> instance representing the array
     * contents, or <code>null</code> if the array to process was null
     * or empty
     */
    public static Properties splitArrayElementsIntoProperties(String[] array, String delimiter) {
        return splitArrayElementsIntoProperties(array, delimiter, null);
    }

    /**
     * 先把字符串数组array里的每个元素删掉字符串charsToDelete有的字符，再把这些元素通过delimiter拆成两份或多份，每个
     * 拆分出来的第一个元素和第二个元素，组成Properties的一对键值对，并返回这个Properties
     * Take an array Strings and split each element based on the given
     * delimiter. A <code>Properties</code> instance is then generated, with the
     * left of the delimiter providing the key, and the right of the delimiter
     * providing the value.
     * <p>
     * Will trim both the key and value before adding them to the
     * <code>Properties</code> instance.
     *
     * @param array         the array to process
     * @param delimiter     to split each element using (typically the equals symbol)
     * @param charsToDelete one or more characters to remove from each element prior to
     *                      attempting the split operation (typically the quotation mark
     *                      symbol), or <code>null</code> if no removal should occur
     * @return a <code>Properties</code> instance representing the array
     * contents, or <code>null</code> if the array to process was
     * <code>null</code> or empty
     */
    public static Properties splitArrayElementsIntoProperties(String[] array, String delimiter, String charsToDelete) {

        if (array == null || array.length == 0) {
            return null;
        }
        Properties result = new Properties();
        for (int i = 0; i < array.length; i++) {
            String element = array[i];
            if (charsToDelete != null) {
                element = deleteAny(array[i], charsToDelete);
            }
            String[] splittedElement = split(element, delimiter);
            if (splittedElement == null) {
                continue;
            }
            result.setProperty(splittedElement[0].trim(), splittedElement[1].trim());
        }
        return result;
    }

    /**
     * 把字符串str根据字符串delimiters里有的字符拆分，再对拆分过后的字符串trim,对空白字符串忽略
     * 最后返回一个字符串数组
     * Tokenize the given String into a String array via a StringTokenizer.
     * Trims tokens and omits empty tokens.
     * <p>
     * The given delimiters string is supposed to consist of any number of
     * delimiter characters. Each of those characters can be used to separate
     * tokens. A delimiter is always a single character; for multi-character
     * delimiters, consider using <code>delimitedListToStringArray</code>
     *
     * @param str        the String to tokenize
     * @param delimiters the delimiter characters, assembled as String (each of those
     *                   characters is individually considered as delimiter).
     * @return an array of the tokens
     * @see StringTokenizer
     * @see String#trim()
     * @see #delimitedListToStringArray
     */
    public static String[] tokenizeToStringArray(String str, String delimiters) {
        return tokenizeToStringArray(str, delimiters, true, true);
    }

    /**
     * 把字符串str根据字符串delimiters里有的字符拆分，再根据trimTokens的值是否对拆分过后的字符串trim,根据ignoreEmptyTokens的值是否对空白字符串忽略
     * 最后返回一个字符串数组
     * Tokenize the given String into a String array via a StringTokenizer.
     * <p>
     * The given delimiters string is supposed to consist of any number of
     * delimiter characters. Each of those characters can be used to separate
     * tokens. A delimiter is always a single character; for multi-character
     * delimiters, consider using <code>delimitedListToStringArray</code>
     *
     * @param str               the String to tokenize
     * @param delimiters        the delimiter characters, assembled as String (each of those
     *                          characters is individually considered as delimiter)
     * @param trimTokens        trim the tokens via String's <code>trim</code>     是否trim拆分的token
     * @param ignoreEmptyTokens omit empty tokens from the result array (only applies to
     *                          tokens that are empty after trimming; StringTokenizer will not
     *                          consider subsequent delimiters as token in the first place).
     * @return an array of the tokens (<code>null</code> if the input String was
     * <code>null</code>)
     * @see StringTokenizer
     * @see String#trim()
     * @see #delimitedListToStringArray
     */
    public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens,
                                                 boolean ignoreEmptyTokens) {

        if (str == null) {
            return null;
        }

        StringTokenizer st = new StringTokenizer(str, delimiters);
        List<String> tokens = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (trimTokens) {
                token = token.trim();
            }
            if (!ignoreEmptyTokens || token.length() > 0) {
                tokens.add(token);
            }
        }
        return toStringArray(tokens);
    }

    /**
     * 字符串str根据子字符串delimiter拆分成String数组，并返回这个数组
     * Take a String which is a delimited list and convert it to a String array.
     * <p>
     * A single delimiter can consists of more than one character: It will still
     * be considered as single delimiter string, rather than as bunch of
     * potential delimiter characters - in contrast to
     * <code>tokenizeToStringArray</code>.
     *
     * @param str       the input String
     * @param delimiter the delimiter between elements (this is a single delimiter,
     *                  rather than a bunch individual delimiter characters)
     * @return an array of the tokens in the list
     * @see #tokenizeToStringArray
     */
    public static String[] delimitedListToStringArray(String str, String delimiter) {
        return delimitedListToStringArray(str, delimiter, null);
    }

    /**
     * 字符串str根据子字符串delimiter拆分成String数组,再去除数组里每个元素里所有charsToDelete字符串里有的字符，返回这个
     * 字符数组
     * Take a String which is a delimited list and convert it to a String array.
     * <p>
     * A single delimiter can consists of more than one character: It will still
     * be considered as single delimiter string, rather than as bunch of
     * potential delimiter characters - in contrast to
     * <code>tokenizeToStringArray</code>.
     *
     * @param str           the input String
     * @param delimiter     the delimiter between elements (this is a single delimiter,
     *                      rather than a bunch individual delimiter characters)
     * @param charsToDelete a set of characters to delete. Useful for deleting unwanted
     *                      line breaks: e.g. "\r\n\f" will delete all new lines and line
     *                      feeds in a String.
     * @return an array of the tokens in the list
     * @see #tokenizeToStringArray
     */
    public static String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete) {
        if (str == null) {
            return new String[0];
        }
        if (delimiter == null) {
            return new String[]{str};
        }
        List<String> result = new ArrayList<String>();
        if ("".equals(delimiter)) {
            for (int i = 0; i < str.length(); i++) {
                result.add(deleteAny(str.substring(i, i + 1), charsToDelete));
            }
        } else {
            int pos = 0;
            int delPos = 0;
            while ((delPos = str.indexOf(delimiter, pos)) != -1) {
                result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
                pos = delPos + delimiter.length();
            }
            if (str.length() > 0 && pos <= str.length()) {
                // Add rest of String, but not in case of empty input.
                result.add(deleteAny(str.substring(pos), charsToDelete));
            }
        }
        return toStringArray(result);
    }

    /**
     * 字符串str根据“，”拆分成字符串数组
     * Convert a CSV list into an array of Strings.
     *
     * @param str the input String
     * @return an array of Strings, or the empty array in case of empty input
     */
    public static String[] commaDelimitedListToStringArray(String str) {
        return delimitedListToStringArray(str, ",");
    }

    /**
     * 字符串str根据“，”拆分成字符串数组，比把这个数组的每个元素装进一个TreeSet里面，返回这个Set
     * Convenience method to convert a CSV string list to a set. Note that this
     * will suppress duplicates.
     *
     * @param str the input String
     * @return a Set of String entries in the list
     */
    public static Set<String> commaDelimitedListToSet(String str) {
        Set<String> set = new TreeSet<String>();
        String[] tokens = commaDelimitedListToStringArray(str);
        for (int i = 0; i < tokens.length; i++) {
            set.add(tokens[i]);
        }
        return set;
    }

    /**
     * 集合coll里每个元素都要加上前缀prefix和后缀suffix,如果不是最后一个元素还要加上字符串delim,最后把这个字符串全部连起来返回一个新的字符串
     * Convenience method to return a Collection as a delimited (e.g. CSV)
     * String. E.g. useful for <code>toString()</code> implementations.
     *
     * @param coll   the Collection to display
     * @param delim  the delimiter to use (probably a ",")
     * @param prefix the String to start each element with
     * @param suffix the String to end each element with
     * @return the delimited String
     */
    public static String collectionToDelimitedString(Collection<?> coll, String delim, String prefix, String suffix) {
        if (coll == null || coll.isEmpty()) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Iterator<?> it = coll.iterator();
        while (it.hasNext()) {
            sb.append(prefix).append(it.next()).append(suffix);
            if (it.hasNext()) {
                sb.append(delim);
            }
        }
        return sb.toString();
    }

    /**
     * 集合coll里每个元素如果不是最后一个元素都要加上字符串delim,最后把他们连起来返回一个新的字符串
     * Convenience method to return a Collection as a delimited (e.g. CSV)
     * String. E.g. useful for <code>toString()</code> implementations.
     *
     * @param coll  the Collection to display
     * @param delim the delimiter to use (probably a ",")
     * @return the delimited String
     */
    public static String collectionToDelimitedString(Collection<?> coll, String delim) {
        return collectionToDelimitedString(coll, delim, "", "");
    }

    // ContainsAny
    //-----------------------------------------------------------------------

    /**
     * 检查cs里是否包含了searchChars里有的字符，有返回true,没有返回false
     * <p>Checks if the CharSequence contains any character in the given
     * set of characters.</p>
     * <p>
     * <p>A {@code null} CharSequence will return {@code false}.
     * A {@code null} or zero length search array will return {@code false}.</p>
     * <p>
     * <pre>
     * StringUtils.containsAny(null, *)                = false
     * StringUtils.containsAny("", *)                  = false
     * StringUtils.containsAny(*, null)                = false
     * StringUtils.containsAny(*, [])                  = false
     * StringUtils.containsAny("zzabyycdxx",['z','a']) = true
     * StringUtils.containsAny("zzabyycdxx",['b','y']) = true
     * StringUtils.containsAny("aba", ['z'])           = false
     * </pre>
     *
     * @param cs          the CharSequence to check, may be null
     * @param searchChars the chars to search for, may be null
     * @return the {@code true} if any of the chars are found,
     * {@code false} if no match or null input
     * @since 3.0 Changed signature from containsAny(String, char[]) to containsAny(CharSequence, char...)
     */
    public static boolean containsAny(CharSequence cs, char... searchChars) {
        if (Validators.isEmpty(cs) || Validators.isEmpty(searchChars)) {
            return false;
        }
        int csLength = cs.length();
        int searchLength = searchChars.length;
        int csLast = csLength - 1;
        int searchLast = searchLength - 1;
        for (int i = 0; i < csLength; i++) {
            char ch = cs.charAt(i);
            for (int j = 0; j < searchLength; j++) {
                if (searchChars[j] == ch) {
                    if (Character.isHighSurrogate(ch)) {
                        if (j == searchLast) {
                            // missing low surrogate, fine, like String.indexOf(String)
                            return true;
                        }
                        if (i < csLast && searchChars[j + 1] == cs.charAt(i + 1)) {
                            return true;
                        }
                    } else {
                        // ch is in the Basic Multilingual Plane
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 检查cs里是否包含了searchChars里有的字符，有返回true,没有返回false
     * <p>
     * Checks if the CharSequence contains any character in the given set of characters.
     * </p>
     * <p>
     * <p>
     * A {@code null} CharSequence will return {@code false}. A {@code null} search CharSequence will return
     * {@code false}.
     * </p>
     * <p>
     * <pre>
     * StringUtils.containsAny(null, *)            = false
     * StringUtils.containsAny("", *)              = false
     * StringUtils.containsAny(*, null)            = false
     * StringUtils.containsAny(*, "")              = false
     * StringUtils.containsAny("zzabyycdxx", "za") = true
     * StringUtils.containsAny("zzabyycdxx", "by") = true
     * StringUtils.containsAny("aba","z")          = false
     * </pre>
     *
     * @param cs          the CharSequence to check, may be null
     * @param searchChars the chars to search for, may be null
     * @return the {@code true} if any of the chars are found, {@code false} if no match or null input
     * @since 3.0 Changed signature from containsAny(String, String) to containsAny(CharSequence, CharSequence)
     */
    public static boolean containsAny(CharSequence cs, CharSequence searchChars) {
        if (searchChars == null) {
            return false;
        }
        return containsAny(cs, CharSequenceUtils.toCharArray(searchChars));
    }

    /**
     * 集合coll里每个元素如果不是最后一个元素都要加上字符串",",最后把他们连起来返回一个新的字符串
     * Convenience method to return a Collection as a CSV String. E.g. useful
     * for <code>toString()</code> implementations.
     *
     * @param coll the Collection to display
     * @return the delimited String
     */
    public static String collectionToCommaDelimitedString(Collection<?> coll) {
        return collectionToDelimitedString(coll, ",");
    }

    /**
     * 把数组arr里的元素，除了第一个元素，每个元素前都加上字符串delim,再把他们相连组成一个新的字符串返回
     * Convenience method to return a String array as a delimited (e.g. CSV)
     * String. E.g. useful for <code>toString()</code> implementations.
     *
     * @param arr   the array to display
     * @param delim the delimiter to use (probably a ",")
     * @return the delimited String
     */
    public static String arrayToDelimitedString(Object[] arr, String delim) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(delim);
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    /**
     * 把数组arr里的元素，除了第一个元素，每个元素前都加上",",再把他们相连组成一个新的字符串返回
     * Convenience method to return a String array as a CSV String. E.g. useful
     * for <code>toString()</code> implementations.
     *
     * @param arr the array to display
     * @return the delimited String
     */
    public static String arrayToCommaDelimitedString(Object[] arr) {
        return arrayToDelimitedString(arr, ",");
    }

    /**
     * 把一个字符串str解析成int,如果解析不了，返回0
     * Converts a String object to Integer value.
     *
     * @param str The String to be converted.
     * @return Value of Integer.
     */
    public static int parseInteger(String str) {
        return parseInteger(str, 0);
    }

    /**
     * 把一个字符串str解析成int,如果解析不了，返回param
     * Parse a string object to integer
     *
     * @param str The String to be converted.
     * @return Value of Integer.
     */
    public static int parseInteger(String str, int param) {
        int i = param;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            //
        }
        return i;
    }

    /**
     * 把一个字符串str解析成Long,如果解析不了，返回defaultValue
     * Parse a string object to Long
     */
    public static long parseLong(String str, long defaultValue) {
        long i = defaultValue;
        try {
            i = Long.parseLong(str);
        } catch (Exception e) {
            //
        }
        return i;
    }

    /**
     * 把一个字符串str解析成long,如果解析不了，返回0
     * Parse a string object to Long
     */
    public static long parseLong(String str) {
        return parseLong(str, 0);
    }

    /**
     * 把一个字符串str解析成short,如果解析不了，返回defaultValue
     * Parse a string object to Short
     */
    public static short parseShort(String str, short defaultValue) {
        short i = defaultValue;
        try {
            i = Short.parseShort(str);
        } catch (Exception e) {
            //
        }
        return i;
    }

    /**
     * 把一个字符串str解析成short,如果解析不了，返回(short) 0
     * Parse a string object to Short
     */
    public static short parseShort(String str) {
        return parseShort(str, (short) 0);
    }

    /**
     * 把一个字符串str解析成short,如果解析不了，返回defaultValue
     * Parse a string object to Byte
     */
    public static byte parseByte(String str, byte defaultValue) {
        byte i = defaultValue;
        try {
            i = Byte.parseByte(str);
        } catch (Exception e) {
            //
        }
        return i;
    }

    /**
     * 把一个字符串str解析成byte,如果解析不了，返回(byte) 0
     * Parse a string object to Byte
     */
    public static byte parseByte(String str) {
        return parseByte(str, (byte) 0);
    }

    /**
     * 把一个字符串str解析成boolean,如果解析不了，返回defaultValue
     * Parse a string object to Byte
     */
    public static boolean parseBoolean(String str, boolean defaultValue) {
        boolean i = defaultValue;
        try {
            i = Boolean.parseBoolean(str);
        } catch (Exception e) {
            //
        }
        return i;
    }

    /**
     * 把一个字符串str解析成boolean,如果解析不了，返回false
     * Parse a string object to Byte
     */
    public static boolean parseBoolean(String str) {
        return parseBoolean(str, false);
    }

    /**
     *  把一个字符串str解析成double,如果解析不了，返回defaultValue
     * @param str
     * @param defaultValue
     * @return
     */
    public static double parseDouble(String str, double defaultValue) {
        double i = defaultValue;
        try {
            i = Double.parseDouble(str);
        } catch (Exception e) {
            //
        }
        return i;
    }

    /**
     * 把一个字符串str解析成double,如果解析不了，返回0
     * @param str
     * @return
     */
    public static double parseDouble(String str) {
        return parseDouble(str, 0);
    }

    /**
     * 把一个字符串str解析成BigDecimal,如果解析不了，返回defaultValue
     * @param str
     * @param defaultValue
     * @return
     */
    public static BigDecimal parseBigDecimal(String str, BigDecimal defaultValue) {
        BigDecimal i = defaultValue;
        try {
            i = new BigDecimal(str);
        } catch (Exception e) {
            //
        }
        return i;
    }

    /**
     * 把一个字符串str解析成BigDecimal,如果解析不了，返回BigDecimal.ZERO
     * @param str
     * @return
     */
    public static BigDecimal parseBigDecimal(String str) {
        return parseBigDecimal(str, BigDecimal.ZERO);
    }

    /**
     *得到一个不以0开头的，随机的六位整数字符串
     * @return
     */
    public static String getNo() {
        String str = "";
        str += (int) (Math.random() * 9 + 1);
        for (int i = 0; i < 5; i++) {
            str += (int) (Math.random() * 10);
        }
        return str;
    }

    /**
     * 参数是否是有效整数
     *
     * @param obj 参数（对象将被调用string()转为字符串类型）
     * @return 是否是整数
     */
    public static boolean isInt(Object obj) {
        if (hasLength(obj.toString()))
            return false;
        if (obj instanceof Integer)
            return true;
        return obj.toString().matches("[-+]?\\d+");
    }
}
